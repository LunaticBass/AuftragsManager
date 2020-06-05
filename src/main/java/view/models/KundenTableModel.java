/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.models;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Kunde;

/**
 *
 * custom TableModel für Kundentabelle
 */
public class KundenTableModel extends AbstractTableModel{
    
    final String[] columnNames = {"ID", "Name", "Adresse", "Telefon"};    
    private List<Kunde> list;
    final Class[] columnClasses = {Integer.class, String.class, String.class, Integer.class};    
    
    public KundenTableModel(List<Kunde> lista){
        this.list = lista;
    }
    
    @Override
    public int getRowCount() {
        if (list == null){
            return 0;
        } else{
            return list.size();
        }
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {       
       Kunde kunde = (Kunde) list.get(rowIndex);
        switch (columnIndex){
           case 0:
               return kunde.getId();
           case 1:
               return kunde.getName();
           case 2:
               return kunde.getAdresse();
           case 3:
               return kunde.getTelefon();
           default:
               return null;
       }       
    }
    
    @Override
    public Class getColumnClass(int c) {
      return columnClasses[c];
    }
    
    @Override
    public boolean isCellEditable(int row, int col) {
      return false;
    }
    
    @Override
    public String getColumnName(int col) {
      return columnNames[col];
    }    
 
    public void setList(List<Kunde> lista){
        this.list = lista;
    }
    
    public Kunde getKundeAt(int row){
        return list.get(row);
    }
   
}
