/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.models;

import java.awt.Component;
import javax.swing.JTable;
import static javax.swing.SwingConstants.RIGHT;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * custom CellRenderer für Formattieren der Zahlen in der Spalte Gesamtsumme
 */
public class EndsummeRenderer extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {        
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);         
        if (column == 1 && value != null){               
            if ((Double)value % 1 == 0){   
                super.setText(String.format("%,.0f", value));
                this.setHorizontalAlignment(RIGHT);
            }else{
                super.setText(String.format("%,.2f", value));
                this.setHorizontalAlignment(RIGHT);
            }
            return this;           
        }               
        return this;
    }
}
