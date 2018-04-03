/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiprodatabazi_jedensvet;

import static guiprodatabazi_jedensvet.JFrameJedenSvet.JDBC_DRIVER;
import static guiprodatabazi_jedensvet.JFrameJedenSvet.PROPERTIES;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RadimP
 */
public class PrepareStatement {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/jeden_svet";
    static final Properties PROPERTIES = new Properties();

    public static String executeSelectDatabySelectedValue(String[] namesofcolumnsDTBtable, String nameofDTBtable, String columnnameDTBtable, Object value) throws SQLException {
        PreparedStatement st = null;
        Connection connection = null;
        String querry = null;
        String sql0_dotaz = "select " + HelperMethods.normalizeArrayOfColumnNamesForSQLQuerry(namesofcolumnsDTBtable, nameofDTBtable) + " from " + nameofDTBtable + " where " + columnnameDTBtable + " = ?;";
        try {

            connection = HelperMethods.getDBConnection();
            st = connection.prepareStatement(sql0_dotaz);
            st.setObject(1, value);
            querry = st.toString().split(": ")[1];
            System.out.println(querry);
            st.execute();
            st.closeOnCompletion();

        } catch (SQLException ex) {
            Logger.getLogger(JFrameJedenSvet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (st != null) {
                st.close();
            }

            if (connection != null) {
                connection.close();
            }
        }
        return querry;
    }

    public static String selectDatabySelectedValue(String[] namesofcolumnsDTBtable, String nameofDTBtable, String columnnameDTBtable, Object value) {
        String sql0_dotaz = "select " + HelperMethods.normalizeArrayOfColumnNamesForSQLQuerry(namesofcolumnsDTBtable, nameofDTBtable) + " from " + nameofDTBtable + " where " + columnnameDTBtable + " = "
                + "\"" + value + "\"" + ";";

        return sql0_dotaz;
    }

    public static String executeSelectDatabySelectedValueUsingOneInnerJoin(String[] namesofcolumnsDTBtable_1, String nameofDTBtable_1, String nameofDTBtable_2, String columnnameDTBtable_1, String columnnameDTBtable_2, String conditioncolumnname, Object value) throws SQLException {
        PreparedStatement st = null;
        Connection connection = null;
        String querry = null;
        if ("Datum".equals(conditioncolumnname)) {
            value = HelperMethods.convertDateStringWithPointsToDatabaseFormat(value.toString());
        }
        String sql1_dotaz = "select " + HelperMethods.normalizeArrayOfColumnNamesForSQLQuerry(namesofcolumnsDTBtable_1, nameofDTBtable_1) + " from "
                + nameofDTBtable_1 + " inner join " + nameofDTBtable_2 + " on " + nameofDTBtable_1 + "." + columnnameDTBtable_1 + " = "
                + nameofDTBtable_2 + "." + columnnameDTBtable_2 + " where " + nameofDTBtable_2 + "." + conditioncolumnname + " = ?;";
        try {

            connection = HelperMethods.getDBConnection();
            st = connection.prepareStatement(sql1_dotaz);
            st.setObject(1, value);
            querry = st.toString().split(": ")[1];
            System.out.println(querry);
            st.execute();
            st.closeOnCompletion();

        } catch (SQLException ex) {
            Logger.getLogger(JFrameJedenSvet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (st != null) {
                st.close();
            }

            if (connection != null) {
                connection.close();
            }
        }

        return querry;
    }

   /* public static String selectDatabySelectedValueUsingOneInnerJoin(String[] namesofcolumnsDTBtable_1, String nameofDTBtable_1, String nameofDTBtable_2, String columnnameDTBtable_1, String columnnameDTBtable_2, String conditioncolumnname, Object value) {
        if ("Datum".equals(conditioncolumnname)) {
            value = HelperMethods.convertDateStringWithPointsToDatabaseFormat(value.toString());
        }
        String sql1_dotaz = "select " + HelperMethods.normalizeArrayOfColumnNamesForSQLQuerry(namesofcolumnsDTBtable_1, nameofDTBtable_1) + " from "
                + nameofDTBtable_1 + " inner join " + nameofDTBtable_2 + " on " + nameofDTBtable_1 + "." + columnnameDTBtable_1 + " = "
                + nameofDTBtable_2 + "." + columnnameDTBtable_2 + " where " + nameofDTBtable_2 + "." + conditioncolumnname + " = "
                + "\"" + value + "\"" + ";";

        return sql1_dotaz;
    }*/
    public static String executeSelectDatabySelectedValueUsingOneInnerJoinThreeColumns (Object value) throws SQLException {
    PreparedStatement st = null;
        Connection connection = null;
        String querry = null;
    String sql2_dotaz = "select predstaveni.idPredstaveni, film.JmenoF, predstaveni.idFilm from film inner join predstaveni on predstaveni.idFilm=film.idFilm where predstaveni.idFilm = ?;";
     try {

            connection = HelperMethods.getDBConnection();
            st = connection.prepareStatement(sql2_dotaz);
            st.setObject(1, value);
            querry = st.toString().split(": ")[1];
            System.out.println(querry);
            st.execute();
            st.closeOnCompletion();

        } catch (SQLException ex) {
            Logger.getLogger(JFrameJedenSvet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (st != null) {
                st.close();
            }

            if (connection != null) {
                connection.close();
            }
        }

        return querry;                   
    
    
    }
    public static String executeUpdateEditedValueInDTB(String nameofDTBtable, String nameofupdatedcolumn, Object newvalue, String nameofconditioncolumn, Object valueofcondition) throws SQLException {
     PreparedStatement st = null;
        Connection connection = null;
        String querry = null;
        if ("Datum".equals(nameofupdatedcolumn)) {
            newvalue = HelperMethods.convertDateStringWithPointsToDatabaseFormat(newvalue.toString());
        }        
        String sql_dotaz = "UPDATE " + nameofDTBtable + " SET " + nameofupdatedcolumn + " = ? WHERE " + nameofconditioncolumn + " = ?;";
        try {

            connection = HelperMethods.getDBConnection();
            st = connection.prepareStatement(sql_dotaz);
            st.setObject(1, newvalue);
             st.setObject(2, valueofcondition);
            querry = st.toString().split(": ")[1];
            System.out.println(querry);
            st.execute();
            st.closeOnCompletion();

        } catch (SQLException ex) {
            Logger.getLogger(JFrameJedenSvet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (st != null) {
                st.close();
            }

            if (connection != null) {
                connection.close();
            }
        }

        return querry;                
    
    }
    
    public static String executeInsertNewItemIntoPredstaveniTable(String date, String idFilm) throws SQLException {
    PreparedStatement st = null;
        Connection connection = null;
        String querry = null;
        date = HelperMethods.convertDateStringWithPointsToDatabaseFormat(date);
        String sql_dotaz = "INSERT INTO predstaveni (Datum, idFilm) values (?, ?);";
        try {

            connection = HelperMethods.getDBConnection();
            st = connection.prepareStatement(sql_dotaz);
            st.setObject(1, date);
             st.setObject(2, idFilm);
            querry = st.toString().split(": ")[1];
            System.out.println(querry);
            st.execute();
            st.closeOnCompletion();

        } catch (SQLException ex) {
            Logger.getLogger(JFrameJedenSvet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (st != null) {
                st.close();
            }

            if (connection != null) {
                connection.close();
            }
        }

        return querry;         
    
    
    }

    public static String updateEditedValueInDTB(String nameofDTBtable, String nameofupdatedcolumn, Object newvalue, String nameofconditioncolumn, Object valueofcondition) {
        if ("Datum".equals(nameofupdatedcolumn)) {
            newvalue = HelperMethods.convertDateStringWithPointsToDatabaseFormat(newvalue.toString());
        }
        
        String sql_dotaz = "UPDATE " + nameofDTBtable + " SET " + nameofupdatedcolumn + " = " + "\"" + newvalue + "\"" + " WHERE " + nameofconditioncolumn + " = " + "\"" + valueofcondition + "\"" + ";";

        return sql_dotaz;
    }

    public static String executeSearchDataFullfilingQuantitativeRelation(String[] namesofcolumnsDTBtable, String nameofDTBtable, String columnnameDTBtable, String relation, Object value) throws SQLException {
    PreparedStatement st = null;
        Connection connection = null;
        String querry = null;
        if (columnnameDTBtable == "Datum") {
            value = HelperMethods.convertDateStringWithPointsToDatabaseFormat(value.toString());
        }
       String sql_relation = "select " + HelperMethods.normalizeArrayOfColumnNamesForSQLQuerry(namesofcolumnsDTBtable, nameofDTBtable) + " from " + nameofDTBtable + " where " + columnnameDTBtable + relation
                + "?;"; 
     try {

            connection = HelperMethods.getDBConnection();
            st = connection.prepareStatement(sql_relation);
            st.setObject(1, value);
            querry = st.toString().split(": ")[1];
            System.out.println(querry);
            st.execute();
            st.closeOnCompletion();

        } catch (SQLException ex) {
            Logger.getLogger(JFrameJedenSvet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (st != null) {
                st.close();
            }

            if (connection != null) {
                connection.close();
            }
        }

        return querry;      
    }
    
    public static String SearchDataFullfilingQuantitativeRelation(String[] namesofcolumnsDTBtable, String nameofDTBtable, String columnnameDTBtable, String relation, Object value) {
        if (columnnameDTBtable == "Datum") {
            value = HelperMethods.convertDateStringWithPointsToDatabaseFormat(value.toString());
        }
        String sql_relation = "select " + HelperMethods.normalizeArrayOfColumnNamesForSQLQuerry(namesofcolumnsDTBtable, nameofDTBtable) + " from " + nameofDTBtable + " where " + columnnameDTBtable + relation
                + "\"" + value + "\";";
        return sql_relation;
    }

    public static String DeleteSelectedRows(String nameofDTBtable, String condition_columnnameDTBtable, Object condition_value) {
        String sqldotaz_delete = "DELETE FROM " + nameofDTBtable + " WHERE " + condition_columnnameDTBtable + "=" + condition_value + ";";
        return sqldotaz_delete;
    }
    
    public static String executeDeleteSelectedRows(String nameofDTBtable, String condition_columnnameDTBtable, Object condition_value) throws SQLException {
    PreparedStatement st = null;
        Connection connection = null;
        String querry = null;
    String sql_delete = "DELETE FROM " + nameofDTBtable + " WHERE " + condition_columnnameDTBtable + " = ?;";
     try {

            connection = HelperMethods.getDBConnection();
            st = connection.prepareStatement(sql_delete);
            st.setObject(1, condition_value);
            querry = st.toString().split(": ")[1];
            System.out.println(querry);
            st.execute();
            st.closeOnCompletion();

        } catch (SQLException ex) {
            Logger.getLogger(JFrameJedenSvet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (st != null) {
                st.close();
            }

            if (connection != null) {
                connection.close();
            }
        }

        return querry;      
    
    }

}
