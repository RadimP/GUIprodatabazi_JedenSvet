/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiprodatabazi_jedensvet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RadimP
 */
public class PridavaniDatTableModel extends AbstractTableModel {

    DataFromDatabase datafromdtb = new DataFromDatabase();
    //String[] col = {"idPredstaveni", "Datum", "idFilm"};
    String[] col; // = datafromdtb.getColumnNamesFromSQLDatabaseAsArray(JFrameJedenSvet.SQLDOTAZ_PREDSTAVENI);

    Object[][] data; // = datafromdtb.get4RowEmptyArray(JFrameJedenSvet.SQLDOTAZ_PREDSTAVENI);

    ArrayList<Integer> edited_rows = new ArrayList<Integer>();

    PridavaniDatTableModel(String SQL_Dotaz) {
col = datafromdtb.getColumnNamesFromSQLDatabaseAsArray(SQL_Dotaz);
data = datafromdtb.get4RowEmptyArray(SQL_Dotaz);
    }

    public ArrayList<Integer> getIndicesOfEditedRows() {
        return edited_rows;
    }

    @Override
    public int getRowCount() {

        return data.length;
    }

    @Override
    public int getColumnCount() {
        return col.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        return data[i][i1];
    }

    @Override
    public String getColumnName(int column) {

        return col[column];

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
        if (columnIndex != 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        data[rowIndex][columnIndex] = aValue;
        edited_rows.add(rowIndex);

    }

}
