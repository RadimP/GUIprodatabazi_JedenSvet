/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiprodatabazi_jedensvet;

import java.awt.Component;
import java.sql.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author RadimP
 */
public class DateCellRenderer extends DefaultTableCellRenderer {
        public DateCellRenderer() {
            super();
        }

        @Override
        public void setValue(final Object value) {
            final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

            String strValue = "";
            if(value != null && value instanceof Date){
               strValue = sdf.format(value);
            }
            super.setText(strValue);
        }
    }
