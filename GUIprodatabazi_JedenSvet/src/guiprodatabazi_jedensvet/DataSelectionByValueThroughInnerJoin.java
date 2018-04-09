/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiprodatabazi_jedensvet;

import java.io.Serializable;

/**
 *
 * @author RadimP
 */
public class DataSelectionByValueThroughInnerJoin implements Serializable {

 private   String[] namesofcolumnsDTBtable_1;
 private   String nameofDTBtable_1;
  private  String nameofDTBtable_2;
  private  String columnnameDTBtable_1;
 private   String columnnameDTBtable_2;
 private   String conditioncolumnname;
 private   Object value;

    DataSelectionByValueThroughInnerJoin(String[] namesofcolumnsDTBtable_1, String nameofDTBtable_1, String nameofDTBtable_2, String columnnameDTBtable_1, String columnnameDTBtable_2, String conditioncolumnname, Object value) {
        this.namesofcolumnsDTBtable_1 = namesofcolumnsDTBtable_1;
        this.nameofDTBtable_1 = nameofDTBtable_1;
        this.nameofDTBtable_2 = nameofDTBtable_2;
        this.columnnameDTBtable_1 = columnnameDTBtable_1;
        this.columnnameDTBtable_2 = columnnameDTBtable_2;
        this.conditioncolumnname = conditioncolumnname;
        this.value = value;
    }

    public String[] getNamesOfColumnsDTBtable_1() {
        return this.namesofcolumnsDTBtable_1;
    }

    public String getNameOfDTBtable_1() {
        return this.nameofDTBtable_1;
    }

    public String getNameOfDTBtable_2() {
        return this.nameofDTBtable_2;
    }

    public String getColumnnameDTBtable_1() {
        return this.columnnameDTBtable_1;
    }

    public String getColumnnameDTBtable_2() {
        return this.columnnameDTBtable_2;
    }

    public String getConditionColumnName() {
        return this.conditioncolumnname;
    }

    public Object getValue() {
        return this.value;
    }
}
