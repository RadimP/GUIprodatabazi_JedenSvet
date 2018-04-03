/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiprodatabazi_jedensvet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author RadimP
 */
public class DateRenderer extends DefaultTableCellRenderer {
  private static final long serialVersionUID = 1L;
private Date dateValue;
private SimpleDateFormat sdfNewValue = new SimpleDateFormat("EE MMM dd hh:mm:ss z yyyy");
private String valueToString = "";

@Override
public void setValue(Object value) {
    if ((value != null)) {
        String stringFormat = value.toString();
        System.out.println(stringFormat);
        try {
            dateValue = new SimpleDateFormat("yyyy-mm-dd", Locale.ROOT).parse(stringFormat);
            System.out.println(dateValue.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        valueToString = sdfNewValue.format(dateValue);
        System.out.println(valueToString.toString());
        value = valueToString;
        System.out.println(value);
    }
    super.setValue(value);
}  
}
