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
public class DataSearchQuantitativeRelation implements Serializable {
   private String[] namesofcolumnsDTBtable;
   private String nameofDTBtable;
   private String columnnameDTBtable;
   private String relation;
   private Object value;
 DataSearchQuantitativeRelation(String[] namesofcolumnsDTBtable, String nameofDTBtable, String columnnameDTBtable, String relation, Object value)  {
 this.namesofcolumnsDTBtable =  namesofcolumnsDTBtable;
 this.nameofDTBtable = nameofDTBtable;
 this.columnnameDTBtable = columnnameDTBtable;
 this.relation = relation;
 this.value = value; 
 }
 
 public String[] getNamesOfColumnsDTBtable() {
    return this.namesofcolumnsDTBtable;
    }
    
    public String getNameOfDTBtable() {
    return this.nameofDTBtable;
    }
    
    public String getColumnnameDTBtable() {
    return this.columnnameDTBtable;
    }
    
    public String getRelation() {
    return this.relation;
    }
    
    public Object getValue() {
    return this.value;
    }
    
    public void setValue(Object newvalue) {this.value = newvalue;}
 
 
}
