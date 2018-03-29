/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiprodatabazi_jedensvet;

/**
 *
 * @author RadimP
 */
public class PrepareStatement {
    
public static String selectDatabySelectedValue(String[] namesofcolumnsDTBtable, String nameofDTBtable, String columnnameDTBtable, Object value) {
        String sql0_dotaz = "select " + HelperMethods.normalizeArrayOfColumnNamesForSQLQuerry(namesofcolumnsDTBtable, nameofDTBtable) + " from " + nameofDTBtable + " where " + columnnameDTBtable +" = "
                + "\"" + value + "\"" + ";";

        return sql0_dotaz;
    }

public static String selectDatabySelectedValueUsingOneInnerJoin(String[] namesofcolumnsDTBtable_1, String nameofDTBtable_1, String nameofDTBtable_2, String columnnameDTBtable_1, String columnnameDTBtable_2, String conditioncolumnname, Object value) {
if("Datum".equals(conditioncolumnname)) {value = HelperMethods.convertDateStringWithPointsToDatabaseFormat(value.toString());}
    String sql1_dotaz = "select " + HelperMethods.normalizeArrayOfColumnNamesForSQLQuerry(namesofcolumnsDTBtable_1, nameofDTBtable_1) + " from "
        + nameofDTBtable_1 +  " inner join " + nameofDTBtable_2 + " on " + nameofDTBtable_1 +"." +columnnameDTBtable_1 + " = "
        + nameofDTBtable_2 +"." +columnnameDTBtable_2 + " where " + nameofDTBtable_2 + "." + conditioncolumnname + " = " 
        + "\"" +value + "\"" + ";";

return sql1_dotaz;
}    

public static String updateEditedValueInDTB(String nameofDTBtable, String nameofupdatedcolumn, Object newvalue, String nameofconditioncolumn, Object valueofcondition) {
    if("Datum".equals(nameofupdatedcolumn)) {newvalue = HelperMethods.convertDateStringWithPointsToDatabaseFormat(newvalue.toString());}
String sql_dotaz = "UPDATE " + nameofDTBtable +" SET " + nameofupdatedcolumn + " = " + "\"" + newvalue + "\"" + " WHERE " + nameofconditioncolumn + " = " + "\"" + valueofcondition + "\"" + ";";


return sql_dotaz;
}

public static String SearchDataFullfilingQuantitativeRelation(String[] namesofcolumnsDTBtable, String nameofDTBtable, String columnnameDTBtable, String relation, Object value){
    if(columnnameDTBtable == "Datum") {value = HelperMethods.convertDateStringWithPointsToDatabaseFormat(value.toString());}
        String sql_relation = "select " + HelperMethods.normalizeArrayOfColumnNamesForSQLQuerry(namesofcolumnsDTBtable, nameofDTBtable)  + " from " + nameofDTBtable + " where " + columnnameDTBtable + relation
                + "\"" +value + "\";";
    return sql_relation;
    }

 public static String DeleteSelectedRows(String nameofDTBtable, String condition_columnnameDTBtable, Object condition_value) {
    String sqldotaz_delete = "DELETE FROM " + nameofDTBtable + " WHERE " +condition_columnnameDTBtable+ "=" + condition_value+ ";";
    return sqldotaz_delete;
    }

}
