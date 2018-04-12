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
public class DeletionOfSelectedRows implements Serializable {
private String nameofDTBtable;
private String condition_columnnameDTBtable;
private Object condition_value;
 
 DeletionOfSelectedRows(String nameofDTBtable, String condition_columnnameDTBtable, Object condition_value) {
 this.nameofDTBtable = nameofDTBtable;
 this.condition_columnnameDTBtable = condition_columnnameDTBtable;
 this.condition_value = condition_value; 
 }
 
 public String getNameofDTBtable() {
 return this.nameofDTBtable;
 }

 public String getCondition_columnnameDTBtable() {
 return this.condition_columnnameDTBtable;
 } 
 
 public Object getCondition_value() {
 return this.condition_value;
 }
 
 
}
