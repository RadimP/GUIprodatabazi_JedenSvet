/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiprodatabazi_jedensvet;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;
import static guiprodatabazi_jedensvet.JFrameJedenSvet.PROPERTIES;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.RowSetMetaData;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

/**
 *
 * @author RadimP
 */
public class DataFromDatabase {

    Client client = new Client();
    Vector<Object> columnNames = new Vector<Object>();
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    RowSetFactory factory;
    CachedRowSet crs;
    Properties properties = new Properties();

    public DataFromDatabase() {
        try {
            this.factory = RowSetProvider.newFactory();
            this.crs = factory.createCachedRowSet();
        } catch (SQLException ex) {
            Logger.getLogger(DataFromDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public CachedRowSet getCachedRowSet(String sqldotaz) {
        String sql = sqldotaz;
        try (Connection connection = HelperMethods.getDBConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            crs.populate(rs);
            rs.close();
            stmt.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return crs;

    }

    public Vector<Vector<Object>> getDataFromSQLDatabase(String sqldotaz) {
        String sql = sqldotaz;
        try {

            crs = client.getCachedRowset(sql);

            RowSetMetaData md = (RowSetMetaData) crs.getMetaData();
            int columns = md.getColumnCount();

            while (crs.next()) {
                Vector<Object> row = new Vector<Object>(columns);

                for (int i = 1; i <= columns; i++) {
                    row.addElement(crs.getObject(i));
                }

                data.addElement(row);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataFromDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    /*   public Vector<Vector<Object>> getDataFromSQLDatabase(String sqldotaz) {
        String sql = sqldotaz;
        try (Connection connection = HelperMethods.getDBConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            crs = client.getCachedRowset(sql);
            RowSetMetaData md = (RowSetMetaData)crs.getMetaData();
          //  ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
           
            while (crs.next()) {
                Vector<Object> row = new Vector<Object>(columns);

                for (int i = 1; i <= columns; i++) {
                    row.addElement(crs.getObject(i));
                }

                data.addElement(row);
            }

            rs.close();
            stmt.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return data;
    }
     */
    public String[] getColumnNamesFromSQLDatabaseAsArray(String sqldotaz) {
        String[] columnNamesArray = null;
        String sql = sqldotaz;
        try {

            crs = client.getCachedRowset(sql);

            RowSetMetaData md = (RowSetMetaData) crs.getMetaData();
            int columns = md.getColumnCount();
            columnNamesArray = new String[columns];
            //  Get column names
            for (int i = 1; i <= columns; i++) {

                columnNamesArray[i - 1] = md.getColumnName(i);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataFromDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return columnNamesArray;
    }

    /*   public String[] getColumnNamesFromSQLDatabaseAsArray(String sqldotaz) {
        String[] columnNamesArray = null;
        String sql = sqldotaz;

        try (Connection connection = HelperMethods.getDBConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
            columnNamesArray = new String[columns];
            //  Get column names
            for (int i = 1; i <= columns; i++) {

                columnNamesArray[i - 1] = md.getColumnName(i);
            }

            rs.close();
            stmt.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return columnNamesArray;

    }*/
    public Vector<Object> getColumnNamesFromSQLDatabase(String sqldotaz) {
        String sql = sqldotaz;
        try {
            crs = client.getCachedRowset(sql);

            RowSetMetaData md = (RowSetMetaData) crs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names
            for (int i = 1; i <= columns; i++) {

                columnNames.addElement(md.getColumnName(i));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataFromDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return columnNames;
    }

    /*   public Vector<Object> getColumnNamesFromSQLDatabase(String sqldotaz) {

        String sql = sqldotaz;
        try (Connection connection = HelperMethods.getDBConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names
            for (int i = 1; i <= columns; i++) {

                columnNames.addElement(md.getColumnName(i));

            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return columnNames;

    }*/
    public Object[][] get4RowEmptyArray(String sqldotaz) {
        Object[][] emptydata = null;
        String sql = sqldotaz;
        try {
            crs = client.getCachedRowset(sql);
            RowSetMetaData md = (RowSetMetaData) crs.getMetaData();
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
        } catch (SQLException ex) {
            Logger.getLogger(DataFromDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return emptydata;
    }

    /*  public Object[][] get4RowEmptyArray(String sqldotaz) {
        Object[][] emptydata = null;

        String sql = sqldotaz;

        try (Connection connection = HelperMethods.getDBConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

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

        } catch (Exception e) {
            System.out.println(e);
        }
        return emptydata;
    }*/
    public Vector<Vector<Object>> getDataFromSQLDatabaseWithDatesStringConvertedToCzechFormat(String sqldotaz) {
        String sql = sqldotaz;
        try {

            crs = client.getCachedRowset(sql);
            RowSetMetaData md = (RowSetMetaData) crs.getMetaData();
            int columns = md.getColumnCount();

            //  Get row data
            while (crs.next()) {
                Vector<Object> row = new Vector<Object>(columns);
                for (int i = 1; i <= columns; i++) {
                    if (i != 2) {
                        row.addElement(crs.getObject(i));
                    } else {
                        row.addElement(HelperMethods.convertDateStringWithMinusSignToStandardCzechFormat(crs.getObject(i).toString()));
                    }
                }
                data.addElement(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataFromDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    /*   public Vector<Vector<Object>> getDataFromSQLDatabaseWithDatesStringConvertedToCzechFormat(String sqldotaz) {
        String sql = sqldotaz;

        try (Connection connection = HelperMethods.getDBConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql);) {

            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get row data
            while (rs.next()) {
                Vector<Object> row = new Vector<Object>(columns);

                for (int i = 1; i <= columns; i++) {
                    if (i != 2) {
                        row.addElement(rs.getObject(i));
                    } else {
                        row.addElement(HelperMethods.convertDateStringWithMinusSignToStandardCzechFormat(rs.getObject(i).toString()));
                    }
                }

                data.addElement(row);
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return data;
    }*/
}
