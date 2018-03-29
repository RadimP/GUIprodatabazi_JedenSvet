/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiprodatabazi_jedensvet;

import java.util.Arrays;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author RadimP
 */
public class HelperMethods {
    
public static void clearTableWithVyhledavaniDatTableModel(javax.swing.JTable table, String sqldotaz) {
    table.setModel(new  VyhledavaniDatTableModel(sqldotaz, ""));
    } 

public static void updateTableWithVyhledavaniDatTableModel(javax.swing.JTable table, String sql_dotaz) {
table.setModel(new VyhledavaniDatTableModel(sql_dotaz, 1));
        JTableUtilities.setCellsAlignment(table, SwingConstants.CENTER);
      /*  ((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(SwingConstants.CENTER);*/
}
    
public static void setTableCellsAndHeaderCenterHorizontalAlignment(javax.swing.JTable table) {
        JTableUtilities.setCellsAlignment(table, SwingConstants.CENTER);
        ((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(SwingConstants.CENTER);
    }     
    
public static void updateDisplayedDataInTableWithZobrazeniDatTableModel(javax.swing.JTable table, String sql_dotaz) {
        table.setModel(new ZobrazeniDatTableModel(sql_dotaz, 1));
        JTableUtilities.setCellsAlignment(table, SwingConstants.CENTER);
      /*  ((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(SwingConstants.CENTER);*/

    }
    
    public static String convertDateStringWithPointsToDatabaseFormat(String date) { 
        String date_splitted[] = date.split("[\\p{Punct}]"); //pro případ překlepů ošetřeno dělení libovolným intepunkčním znakem
        if (date_splitted.length == 3 && date_splitted[0].length()!=4) { //druhá podmínka je zde proto, aby nebylo děleno datum, které bude zadáno již v cílovém formátu
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
        if (date_splitted.length == 3 && date_splitted[0].length()>2) { //druhá podmínka je zde proto, aby nebylo děleno datum, které bude zadáno již v cílovém formátu
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
  return Arrays.toString(namesofcolumns).replace("[", nameofDTBtable +".").replace("]", "").replaceAll(", ", ", " +nameofDTBtable +".");
 
 }
}
