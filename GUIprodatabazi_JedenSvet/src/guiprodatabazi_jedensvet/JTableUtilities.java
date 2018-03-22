/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiprodatabazi_jedensvet;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author RadimP
 */
public class JTableUtilities {
    public static void setCellsAlignment(JTable table, int alignment)
    {
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(alignment);

        TableModel tableModel = table.getModel();

        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
        {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
    }
public static void setColumnWidths(JTable table, int... widths) {
    TableColumnModel columnModel = table.getColumnModel();
    for (int i = 0; i < widths.length; i++) {
        if (i < columnModel.getColumnCount()) {
            columnModel.getColumn(i).setMaxWidth(widths[i]);
        }
        else break;
    }
    
} }
