/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import view.listeners.BestellungListener;
import view.listeners.KundenListener;
import database.dao.jpa.*;
import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Bestellung;
import model.Kunde;


/**
 *
 * Hauptfenster, kommuniziert zw. Repositories und anderen Swing Komponenten
 */
public class HauptFenster extends javax.swing.JFrame {
    private KundenPanel kundenPanel;
    private BestellungPanel bestellungPanel;
    private KundenRepositoryJPA kundenRep;
    private BestellungRepositoryJPA bestellungRep;    
   
    /**
     * Creates new form HauptFenster
     */
    public HauptFenster() {        
       
        kundenRep = new KundenRepositoryJPA();
        bestellungRep = new BestellungRepositoryJPA();        
        List<Bestellung> orderList = alleBestellungenLaden();
        List<Kunde> customerList = kundenListeLaden();
        kundenPanel = new KundenPanel(customerList);
        bestellungPanel = new BestellungPanel(orderList);
        initComponents();
        setLocationRelativeTo(null);
        getContentPane().add(kundenPanel, "fenster");
        getContentPane().add(bestellungPanel, "fenster2");
        /** Listener setup */
        kundenPanel.setKundenListener(new KundenListener() {
            public void KundeWeitergegeben(Kunde kunde){
                saveKunde(kunde);
            }
            
            public void deleteSelected(int id){
                deleteKunde(id);
            }
        });
        kundenPanel.setBestellungListener(new BestellungListener(){
            public void bestellungWeitergegeben(Bestellung bestellung){
                saveBestellung(bestellung);
            }
            
            public void deleteSelected(int id){
                deleteBestellung(id);
            }
        });
      
        bestellungPanel.setBestellungListener(new BestellungListener(){
            public void bestellungWeitergegeben(Bestellung bestellung){
                saveBestellung(bestellung);
            }
            
            public void deleteSelected(int id){                
                deleteBestellung(id);
            }
        });
      
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                super.windowClosing(e);
                kundenRep.close();
                bestellungRep.close();                
            }
        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        kundenBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bestellungenBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bestellungMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        kundenMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        kundenBtn.setText("Kunden");
        kundenBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kundenBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Auftragsmanagement Software");

        bestellungenBtn.setText("Bestellungen");
        bestellungenBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bestellungenBtnActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bilder/book.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bilder/user.png"))); // NOI18N
        jLabel4.setText("jLabel4");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bilder/logo.png"))); // NOI18N
        jLabel5.setText("jLabel5");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(bestellungenBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(kundenBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel1))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(100, 100, 100)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bestellungenBtn)
                .addContainerGap(107, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kundenBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, "card3");

        jMenu1.setText("Ansicht");
        jMenu1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        bestellungMenuItem.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        bestellungMenuItem.setText("Bestellungen");
        bestellungMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bestellungMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(bestellungMenuItem);
        jMenu1.add(jSeparator1);

        kundenMenuItem.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        kundenMenuItem.setText("Kunden");
        kundenMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kundenMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(kundenMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kundenBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kundenBtnActionPerformed
        CardLayout cl = (CardLayout)getContentPane().getLayout();
        cl.show(getContentPane(), "fenster");
        pack();
        setTitle("Kunden");
        setLocationRelativeTo(null);
    }//GEN-LAST:event_kundenBtnActionPerformed

    private void kundenMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kundenMenuItemActionPerformed
        CardLayout cl = (CardLayout)getContentPane().getLayout();
        cl.show(getContentPane(), "fenster");
        pack();
        setTitle("Kunden");
        setLocationRelativeTo(null);
    }//GEN-LAST:event_kundenMenuItemActionPerformed

    private void bestellungenBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bestellungenBtnActionPerformed
        CardLayout cl = (CardLayout)getContentPane().getLayout();
        cl.show(getContentPane(), "fenster2");        
        pack();
        setTitle("Bestellungen");
        setLocationRelativeTo(null);
    }//GEN-LAST:event_bestellungenBtnActionPerformed

    private void bestellungMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bestellungMenuItemActionPerformed
        CardLayout cl = (CardLayout)getContentPane().getLayout();      
        cl.show(getContentPane(), "fenster2");        
        pack();
        setTitle("Bestellungen");
        setLocationRelativeTo(null);
    }//GEN-LAST:event_bestellungMenuItemActionPerformed
/** eigene Methode */
    /** Kundenliste von der Datenbank laden */
    private List<Kunde> kundenListeLaden(){
        List<Kunde> list = new ArrayList<>();        
        list = kundenRep.findAll();
        return list;          
    }
    
    /** Kunde in die Datenbank speichern und Tabelle neu laden */
    private void saveKunde(Kunde kunde){
        kundenRep.save(kunde);
        kundenPanel.reloadList(kundenRep.findAll());
        bestellungPanel.tableFuellen(bestellungRep.findAll());
    }
    
    /** Kunde von der Datenbank löschen, inkl. alle Bestellungen und Artikel, dann Tabelle neu laden */
    private void deleteKunde(int id){
        kundenRep.delete(id);
        kundenPanel.reloadList(kundenRep.findAll());
        bestellungPanel.tableFuellen(bestellungRep.findAll());
    }
    
    /** alle Bestellungen von der Datenbak laden */
    private List<Bestellung> alleBestellungenLaden(){
        List<Bestellung> list = new ArrayList<>();
        list = bestellungRep.findAll();        
        return list;
    }
    
    /** Bestellung in die Datenbank speichern, dann tabelle neu laden */
    public void saveBestellung(Bestellung bestellung){
        bestellungRep.save(bestellung);        
        bestellungPanel.tableFuellen(bestellungRep.findAll());
    }

    /** Bestellung von der Datenbank löschen, inkl. alle Artikel, dann Tabelle neu laden */
    public void deleteBestellung(int id){        
        bestellungRep.delete(id);
        bestellungPanel.tableFuellen(bestellungRep.findAll());
    }
           
  
        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws SQLException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {               
                new HauptFenster().setVisible(true);                        
            }        
        });


    
 
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem bestellungMenuItem;
    private javax.swing.JButton bestellungenBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JButton kundenBtn;
    private javax.swing.JMenuItem kundenMenuItem;
    // End of variables declaration//GEN-END:variables
}
