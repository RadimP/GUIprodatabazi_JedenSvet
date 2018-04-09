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
public class DataUpdate implements Serializable {
  private  String nameofDTBtable;
 private   String nameofupdatedcolumn;
 private   Object newvalue;
  private  String nameofconditioncolumn;
  private  Object valueofcondition;
    
    DataUpdate(String nameofDTBtable, String nameofupdatedcolumn, Object newvalue, String nameofconditioncolumn, Object valueofcondition) {
    this.nameofDTBtable = nameofDTBtable;
    this.nameofupdatedcolumn = nameofupdatedcolumn;
    this.newvalue = newvalue;
    this.nameofconditioncolumn = nameofconditioncolumn;
    this.valueofcondition = valueofcondition; 
    }
    
    public String getNameOfDTBtable() {
    return this.nameofDTBtable;
    }
    
    public String getNameofupdatedcolumn() {
    return this.nameofupdatedcolumn;
    }
    
   public Object getNewValue() {
    return this.newvalue;
    } 
   public String getNameofconditioncolumn() {
    return this.nameofconditioncolumn;
    } 
   public Object getValueOfCondition() {
    return this.valueofcondition;
    } 
   
   
    
}
