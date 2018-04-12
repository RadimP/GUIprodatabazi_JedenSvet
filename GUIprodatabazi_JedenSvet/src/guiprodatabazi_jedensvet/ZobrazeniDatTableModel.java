/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiprodatabazi_jedensvet;


import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author RadimP
 */
public class ZobrazeniDatTableModel extends AbstractTableModel {

    Vector<Object> col; //column names from database
    Vector<Vector<Object>> data; //vector to populate table with data from database 
    DataFromDatabase datafromdtb = new DataFromDatabase();

    ZobrazeniDatTableModel() {
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

    ZobrazeniDatTableModel(String sqldotaz) {
        col = datafromdtb.getColumnNamesFromSQLDatabase(sqldotaz);
        data = datafromdtb.getDataFromSQLDatabase(sqldotaz);
    }

    /**
     *
     * @param sqldotaz
     * @param conversion
     */
  /*  ZobrazeniDatTableModel(String sqldotaz, int conversion) {
        col = datafromdtb.getColumnNamesFromSQLDatabase(sqldotaz);
        data = datafromdtb.getDataFromSQLDatabaseWithDatesStringConvertedToCzechFormat(sqldotaz);
    }*/

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
        return false;
    }

}
