/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiprodatabazi_jedensvet;

import static guiprodatabazi_jedensvet.JFrameJedenSvet.properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

/**
 *
 * @author RadimP
 */
public class DataFromDatabase {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/jeden_svet";
    Vector<Object> columnNames = new Vector<Object>();
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    
     Properties properties = new Properties();

    public DataFromDatabase() {
        
        properties.setProperty("user", "root");
        properties.setProperty("password", "1111");
        properties.setProperty("useSSL", "false");
        properties.setProperty("autoReconnect", "true");
    }

    public Vector<Vector<Object>> getDataFromSQLDatabase(String sqldotaz) {

        try {
            //  Connect to an Access Database           
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL, properties);

            //  Read data from a table
            String sql = sqldotaz;
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get row data
            while (rs.next()) {
                Vector<Object> row = new Vector<Object>(columns);

                for (int i = 1; i <= columns; i++) {
                    row.addElement(rs.getObject(i));
                }

                data.addElement(row);
            }

            rs.close();
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return data;
    }

    public String[] getColumnNamesFromSQLDatabaseAsArray(String sqldotaz) {
        String[] columnNamesArray = null;
        try {
            //  Connect to an Access Database           
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL, properties);

            //  Read data from a table
            String sql = sqldotaz;
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
            columnNamesArray = new String[columns];
            //  Get column names
            for (int i = 1; i <= columns; i++) {

                columnNamesArray[i - 1] = md.getColumnName(i).toString();
            }

            rs.close();
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return columnNamesArray;

    }

    public Vector<Object> getColumnNamesFromSQLDatabase(String sqldotaz) {
        try {
            //  Connect to an Access Database           
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL, properties);

            //  Read data from a table
            String sql = sqldotaz;
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names
            for (int i = 1; i <= columns; i++) {

                columnNames.addElement(md.getColumnName(i));

            }

            rs.close();
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return columnNames;

    }

    public Object[][] get4RowEmptyArray(String sqldotaz) {
        Object[][] emptydata = null;
        try {
            //  Connect to an Access Database           
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL, properties);

            //  Read data from a table
            String sql = sqldotaz;
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
            emptydata = new Object[4][columns];
            //  Get row data
            for (int j = 0; j < 4; j++) {
                Object[] emptyrow = new Object[columns];

                for (int i = 0; i < columns; i++) {
                    //    row.addElement(rs.getObject(i));
                    emptyrow[i] = null;
                }

                emptydata[j] = emptyrow;
            }

            rs.close();
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return emptydata;
    }
    public Vector<Vector<Object>> getDataFromSQLDatabaseWithDatesStringConvertedToCzechFormat(String sqldotaz) {

        try {
            //  Connect to an Access Database           
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL, properties);

            //  Read data from a table
            String sql = sqldotaz;
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get row data
            while (rs.next()) {
                Vector<Object> row = new Vector<Object>(columns);

                for (int i = 1; i <= columns; i++) {
                    if(i!=2)
                    {row.addElement(rs.getObject(i));} else {row.addElement(HelperMethods.convertDateStringWithMinusSignToStandardCzechDateFormat(rs.getObject(i).toString()));}
                }

                data.addElement(row);
            }

            rs.close();
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return data;
    }
}
