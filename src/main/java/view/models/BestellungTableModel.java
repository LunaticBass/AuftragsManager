/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.models;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Bestellung;
import model.Kunde;

/**
 *
 * @author Nagy
 */
public class BestellungTableModel extends AbstractTableModel{
    
    final String[] columnNames = {"Name", "Gesamtsumme", "Währung", "Bezahlt", "Versendet"};    
    private List<Bestellung> bestList;
    private List<Kunde> kundeList;
    
    private final Class[] columnClass = new Class[] {
        Integer.class, Double.class, model.Waehrung.class, Boolean.class, Boolean.class
    };

    public BestellungTableModel(List<Bestellung> bestList, List<Kunde> kundeList){
        this.bestList = bestList;
        this.kundeList = kundeList;        
    }
    
    
    @Override
    public Class getColumnClass(int columnIndex){
        return columnClass[columnIndex];
    }
    
    @Override
    public boolean isCellEditable(int row, int col) {        
        return false;
    }
    
    @Override
    public String getColumnName(int col) {
      return columnNames[col];
    }
    
    @Override
    public int getRowCount() {
        if (bestList == null) {
            return 0;
        } else {
            return bestList.size();
        } 
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Bestellung bestellung = bestList.get(rowIndex);
    
        switch (columnIndex){
            case 0:
                return bestellung.getKunden_ID();
            case 1:
                return bestellung.getEndsumme();
            case 2:
                return bestellung.getWaehrung();
            case 3:
                return bestellung.isBezahlt();
            case 4:
                return bestellung.isVersendet();            
            default:
                return null;
       }       
    }
    
   
    public String getKundenName(int kunde_ID){
        for(Kunde kunde : kundeList){
            if (kunde_ID == kunde.getId()){                
                return kunde.getName();
            }
        }
        return null;
    }   
    
    public void setKundeList(List<Kunde> list){
        this.kundeList = list;
    }
    
    public void setBestList(List<Bestellung> list){
        this.bestList = list;
    }
    
    public Bestellung getBestellungFrom(int rowIndex){
        return bestList.get(rowIndex);
    }
  
}
