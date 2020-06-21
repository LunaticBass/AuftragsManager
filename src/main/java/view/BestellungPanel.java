/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import view.models.BestellungTableModel;
import view.models.EndsummeRenderer;
import view.listeners.BestellungListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import model.Bestellung;
import model.Waehrung;
import model.Kunde;

/**
 *
 * window for displaying and editing orders
 */
public class BestellungPanel extends javax.swing.JPanel {
    private BestellungListener bestellungListener;
    private List<Bestellung> bestList;    
    private Bestellung selectedBestellung;   
    private BestellungTableModel myTableModel;    
    
    /**
     * Fenster für die Bestellungen
     */
    public BestellungPanel(List<Bestellung> bestList) {
        myTableModel = new BestellungTableModel(bestList);
        initComponents();            
      
        this.bestList = bestList;
        tableFuellen(bestList);        

        TableRowSorter sorter = new TableRowSorter(myTableModel);
        bestellungJTable.setRowSorter(sorter); 
        EndsummeRenderer rendererAmount = new EndsummeRenderer();
        bestellungJTable.setDefaultRenderer(Double.class, rendererAmount);        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        deleteBtn = new javax.swing.JButton();
        exportBtn = new javax.swing.JButton();
        aendernBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        bestellungJTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        summeEURLb = new javax.swing.JLabel();
        summeHUFLb = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(759, 386));

        jLabel1.setText("Bestellungen");

        deleteBtn.setText("Löschen");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        exportBtn.setText("Kundendaten exportieren");
        exportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportBtnActionPerformed(evt);
            }
        });

        aendernBtn.setText("Ändern");
        aendernBtn.setMaximumSize(new java.awt.Dimension(59, 32));
        aendernBtn.setMinimumSize(new java.awt.Dimension(59, 32));
        aendernBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aendernBtnActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bilder/book.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        bestellungJTable.setModel(myTableModel);
        bestellungJTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        bestellungJTable.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        bestellungJTable.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane2.setViewportView(bestellungJTable);
        bestellungJTable.getTableHeader().setReorderingAllowed(false);

        TableColumnModel columnModel = bestellungJTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(400);
        columnModel.getColumn(1).setPreferredWidth(160);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(150);
        columnModel.getColumn(4).setPreferredWidth(150);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gesamtumsatz", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12))); // NOI18N

        summeEURLb.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        summeEURLb.setText("0");

        summeHUFLb.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        summeHUFLb.setText("0");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel6.setText("Ft");

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel7.setText("€");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(summeEURLb, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(summeHUFLb, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(summeHUFLb)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(summeEURLb)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(aendernBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(exportBtn))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(75, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(aendernBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteBtn)
                        .addGap(35, 35, 35)
                        .addComponent(exportBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void exportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportBtnActionPerformed
        String filename = JOptionPane.showInputDialog(null, "Dateiname: ", 
                        "Daten exportieren", JOptionPane.QUESTION_MESSAGE);
        
        if (filename != null && Pattern.matches("[^<>:\"/\\\\|?* ]+", filename)){      
            int[] array = bestellungJTable.getSelectedRows();
            if (array.length != 0){
                ArrayList<Integer> goodSequence = new ArrayList<>();
                for (int i = 0; i < array.length; i++) {
                    goodSequence.add(bestellungJTable.convertRowIndexToModel(array[i]));
                }

                List<Kunde> list = new ArrayList<>();
                for (int i = 0; i < goodSequence.size(); i++) {   
                    Kunde k = myTableModel.getBestellungFrom(goodSequence.get(i)).getKunde();
                    list.add(k);
                }        
                speichernAlsDatei(list, filename);
            }
        } else{
            JOptionPane.showMessageDialog(null, "Falsche Eingabe!", 
                        "Fehler", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_exportBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int id = bestellungJTable.getSelectedRow();
        if (id != -1){
            int rightPlace = bestellungJTable.convertRowIndexToModel(id);
            Bestellung bestellung = myTableModel.getBestellungFrom(rightPlace);
            int input = JOptionPane.showConfirmDialog(null, "Bestellung löschen?", "Löschen",
                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (input == 0){            
                    bestellungListener.deleteSelected(bestellung.getId());
                }
        }
        myTableModel.fireTableDataChanged();
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void aendernBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aendernBtnActionPerformed
        int id = bestellungJTable.getSelectedRow();        
        
        if (id != -1){
            int rightPlace = bestellungJTable.convertRowIndexToModel(id);
            this.selectedBestellung = myTableModel.getBestellungFrom(rightPlace);   
            
            BestellungNeuAendern dialog = new BestellungNeuAendern(new javax.swing.JFrame(), 
                    selectedBestellung);

            if (selectedBestellung.isVersendet()){
                dialog.keineAenderungen();                
            }

            dialog.setVisible(true);
            if (dialog.getBestellung().isPresent()){
                Bestellung m = dialog.getBestellung().get();
                bestellungListener.bestellungWeitergegeben(m);
            }           
        }
        gesamtUmsatz();
    }//GEN-LAST:event_aendernBtnActionPerformed

    /** Tabelle mit den erhaltenen Listen auffüllen */
    public final void tableFuellen(List<Bestellung> bestList){
        this.bestList = bestList;   
        myTableModel.setBestList(bestList);        
        gesamtUmsatz();
    }
    
    public void setBestellungListener(BestellungListener listener){
        this.bestellungListener = listener;
    }
    
    
    /** Liste mit ausgewählten Kundendaten als .csv Datei speichern */
    public void speichernAlsDatei(List<Kunde> list, String filename){
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename + ".csv"))){            
            for (Kunde kunde : list){
                pw.println(kunde.toString());
            }
            JOptionPane.showMessageDialog(null, "Daten gespeichert!", 
                        "Daten speichern", JOptionPane.INFORMATION_MESSAGE);
        }   catch (IOException ex) {
            Logger.getLogger(BestellungPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public final void gesamtUmsatz(){
        Double totalHUF = 0.0;
        Double totalEUR = 0.0;        
        for (Bestellung bestellung : bestList){
            if (bestellung.getWaehrung().equals(Waehrung.EUR)){
                totalEUR += bestellung.getEndsumme();                
            }else {
                totalHUF += bestellung.getEndsumme();                
            }
        }
        summeEURLb.setText(String.format("%.2f", totalEUR));
        summeHUFLb.setText(String.format("%,.0f", totalHUF));
        myTableModel.fireTableDataChanged();
    }
    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aendernBtn;
    private javax.swing.JTable bestellungJTable;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton exportBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel summeEURLb;
    private javax.swing.JLabel summeHUFLb;
    // End of variables declaration//GEN-END:variables
}
