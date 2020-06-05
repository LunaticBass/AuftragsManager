/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.models;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * custom CellRenderer, um statt kunden_ID den Kundennamen in der Bestellungtabelle anzuzeigen
 */
public class NameRenderer extends DefaultTableCellRenderer  {
    private BestellungTableModel tableModel;   
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {        
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (column == 0){           
            Integer customer_ID = (Integer) value;
            String name = tableModel.getKundenName(customer_ID);
            if (name != null){                   
                super.setText(name);
                this.setFont(new java.awt.Font("Dialog", 0, 12));
                return this;
            }
        }          
        return this;
    }

    public BestellungTableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(BestellungTableModel tableModel) {
        this.tableModel = tableModel;
    }
    
    
}
