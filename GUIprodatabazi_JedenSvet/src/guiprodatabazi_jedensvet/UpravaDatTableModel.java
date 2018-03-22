/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiprodatabazi_jedensvet;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author RadimP
 */
public class UpravaDatTableModel extends AbstractTableModel {

    Vector<Object> col; //column names from database
    Vector<Vector<Object>> data; //vector to populate table with data from database 
    DataFromDatabase datafromdtb = new DataFromDatabase();
    ArrayList<ArrayList<Integer>> edited_fields = new ArrayList<ArrayList<Integer>>();

    UpravaDatTableModel() {
        String empty = "";
        col = new Vector<Object>();
        data = new Vector<Vector<Object>>();
        for (int i = 0; i < 4; i++) {
            col.addElement(empty);
        }
        for (int i = 0; i < 1; i++) {
            data.addElement(col);
        }
    }

    UpravaDatTableModel(String sqldotaz) {
        col = datafromdtb.getColumnNamesFromSQLDatabase(sqldotaz);
        data = datafromdtb.getDataFromSQLDatabase(sqldotaz);
    }

    public ArrayList<ArrayList<Integer>> getIndexesOfEditedFields() {
        return edited_fields;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return col.size();
    }

    @Override
    public Object getValueAt(int i, int i1) {
        return data.get(i).get(i1);
    }

    @Override
    public String getColumnName(int column) {
        return this.col.get(column).toString();
    }

    @Override
    public Class getColumnClass(int column) {
        for (int row = 0; row < getRowCount(); row++) {
            Object o = getValueAt(row, column);

            if (o != null) {
                return o.getClass();
            }
        }

        return Object.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        data.elementAt(rowIndex).setElementAt(aValue, columnIndex);
        indexes.add(rowIndex);
        indexes.add(columnIndex);
        edited_fields.add(indexes);
    }

}
