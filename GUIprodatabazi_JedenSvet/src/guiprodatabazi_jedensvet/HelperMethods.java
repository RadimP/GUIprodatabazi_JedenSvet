/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiprodatabazi_jedensvet;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Properties;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author RadimP
 */
public class HelperMethods {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/jeden_svet";
    static final Properties PROPERTIES = new Properties();

    public static Connection getDBConnection() {
        PROPERTIES.setProperty("user", "root");
        PROPERTIES.setProperty("password", "1111");
        PROPERTIES.setProperty("useSSL", "false");
        PROPERTIES.setProperty("autoReconnect", "true");

        Connection dbConnection = null;

        try {
            Class.forName(JDBC_DRIVER);

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(
                    DB_URL, PROPERTIES);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

    public static void clearTableWithVyhledavaniDatTableModel(javax.swing.JTable table, String sqldotaz) {
        table.setModel(new VyhledavaniDatTableModel(sqldotaz, ""));
       setTableCellsAndHeaderCenterHorizontalAlignment(table);                
    }

    public static void updateTableWithVyhledavaniDatTableModel(javax.swing.JTable table, String sql_dotaz) {
        table.setModel(new VyhledavaniDatTableModel(sql_dotaz, 1));
       setTableCellsAndHeaderCenterHorizontalAlignment(table);          
    }

    public static void setTableCellsAndHeaderCenterHorizontalAlignment(javax.swing.JTable table) {
        JTableUtilities.setCellsAlignment(table, SwingConstants.CENTER);
       ((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(SwingConstants.CENTER);
    }

    public static void updateDisplayedDataInTableWithZobrazeniDatTableModel(javax.swing.JTable table, String sql_dotaz) {
        table.setModel(new ZobrazeniDatTableModel(sql_dotaz, 1));
        setTableCellsAndHeaderCenterHorizontalAlignment(table);

    }

    public static String convertDateStringWithPointsToDatabaseFormat(String date) {
        String date_splitted[] = date.split("[\\p{Punct}]"); //pro případ překlepů ošetřeno dělení libovolným intepunkčním znakem
        if (date_splitted.length == 3 && date_splitted[0].length() != 4) { //druhá podmínka je zde proto, aby nebylo děleno datum, které bude zadáno již v cílovém formátu
            date = date_splitted[2] + "-" + setTwoDigitsLongDayOrMonthNumber(date_splitted[1]) + "-" + setTwoDigitsLongDayOrMonthNumber(date_splitted[0]);
        }
        // System.out.println(date_splitted[2]+dash+setTwoDigitsLongDayOrMonthNumber(date_splitted[1]) +dash +setTwoDigitsLongDayOrMonthNumber(date_splitted[0]));
        return date;
    }

    private static String setTwoDigitsLongDayOrMonthNumber(String number) {
        if (number.length() == 1) {
            number = "0" + number;
        }
        return number;
    }

    public static String convertDateStringWithMinusSignToStandardCzechFormat(String date) {
        String date_splitted[] = date.split("[\\p{Punct}&&[^.]]"); //pro případ překlepů ošetřeno dělení libovolným intepunkčním znakem kromě tečky, 
        //i když tato data se bnačítají z databáze, tak se v nich překlepy neměly vyskytovat
        if (date_splitted.length == 3 && date_splitted[0].length() > 2) { //druhá podmínka je zde proto, aby nebylo děleno datum, které bude zadáno již v cílovém formátu
            date = removeFirstZeroFromDigitsOfDayOrMonthNumber(date_splitted[2]) + "." + removeFirstZeroFromDigitsOfDayOrMonthNumber(date_splitted[1]) + "." + date_splitted[0];
        }
        // System.out.println(date_splitted[2]+dash+setTwoDigitsLongDayOrMonthNumber(date_splitted[1]) +dash +setTwoDigitsLongDayOrMonthNumber(date_splitted[0]));
        return date;
    }

    private static String removeFirstZeroFromDigitsOfDayOrMonthNumber(String number) {
        if (number.length() == 2 && number.charAt(0) == '0') {
            number = String.valueOf(number.charAt(1));
        }
        return number;
    }

    public static String normalizeArrayOfColumnNamesForSQLQuerry(String[] namesofcolumns, String nameofDTBtable) {
        return Arrays.toString(namesofcolumns).replace("[", nameofDTBtable + ".").replace("]", "").replaceAll(", ", ", " + nameofDTBtable + ".");

    }
}
