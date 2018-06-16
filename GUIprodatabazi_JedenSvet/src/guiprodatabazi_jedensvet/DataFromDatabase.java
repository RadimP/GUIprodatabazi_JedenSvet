/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiprodatabazi_jedensvet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Vector;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
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
        try (Statement stmt = HelperMethods.getDBConnection().createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            crs.populate(rs);
        } catch (SQLException ex) {
            Logger.getLogger(DataFromDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return crs;
    }

    private int getColumnCount(CachedRowSet crs) throws SQLException {
        int columns;
        RowSetMetaData md = (RowSetMetaData) crs.getMetaData();
        return columns = md.getColumnCount();
    }

    private Vector<Vector<Object>> extractDataFromRowSet(CachedRowSet crs, int columncount) throws SQLException {
        while (crs.next()) {
            Vector<Object> row = new Vector<Object>(columncount);
            for (int i = 1; i <= columncount; i++) { if (crs.getObject(i) != null) {
                if (crs.getObject(i).toString().length() > 4 && crs.getObject(i).toString().charAt(4) != '-') {
                    row.addElement(crs.getObject(i));
                } else {
                    row.addElement(HelperMethods.convertDateStringWithMinusSignToStandardCzechFormat(crs.getObject(i).toString()));
                }
            } else {row.addElement(crs.getObject(i));}}
            data.addElement(row);
        }
        return data;
    }

    public Vector<Vector<Object>> getDataFromSQLDatabase(String sqldotaz) {
        String sql = sqldotaz;
        try {
            crs = client.getCachedRowset(sql);
            int columns = getColumnCount(crs);
            data = extractDataFromRowSet(crs, columns);
        } catch (SQLException ex) {
            Logger.getLogger(DataFromDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public String[] getColumnNamesFromSQLDatabaseAsArray(String sqldotaz) {
        String[] columnNamesArray = null;
        try {
            crs = client.getCachedRowset(sqldotaz);
            RowSetMetaData md = (RowSetMetaData) crs.getMetaData();
            int columns = md.getColumnCount();
            columnNamesArray = new String[columns];
            for (int i = 1; i <= columns; i++) {
                columnNamesArray[i - 1] = md.getColumnName(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataFromDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return columnNamesArray;
    }

    public Vector<Object> getColumnNamesFromSQLDatabase(String sqldotaz) {
        try {
            crs = client.getCachedRowset(sqldotaz);
            RowSetMetaData md = (RowSetMetaData) crs.getMetaData();
            int columns = md.getColumnCount();
            for (int i = 1; i <= columns; i++) {
                columnNames.addElement(md.getColumnName(i));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataFromDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return columnNames;
    }

    public Object[][] get4RowEmptyArray(String sqldotaz) {
        Object[][] emptydata = null;
        String sql = sqldotaz;
        try {
            crs = client.getCachedRowset(sql);
            int columns = getColumnCount(crs);
            emptydata = new Object[4][columns];
            for (int j = 0; j < 4; j++) {
                Object[] emptyrow = new Object[columns];
                for (int i = 0; i < columns; i++) {
                    emptyrow[i] = null;
                }
                emptydata[j] = emptyrow;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataFromDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return emptydata;
    }
}   
