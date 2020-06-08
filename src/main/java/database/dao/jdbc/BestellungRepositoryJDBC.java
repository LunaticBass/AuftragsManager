/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.dao.jdbc;

import database.dao.interfaces.DAO;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Bestellung;
import model.Waehrung;


/**
 *
 * DAO Klasse für JDBC Abfragen der SQL Tabelle 'bestellung'
 */
public class BestellungRepositoryJDBC implements DAO<Bestellung>{
    private Connection conn;
    private PreparedStatement findAll, findByCustomer_ID, findUnsent;
    private PreparedStatement insert, update, delete;
    private int lastID = 0;
    
    public BestellungRepositoryJDBC(Connection conn){
        try {
            this.conn = conn;
            this.findAll = conn.prepareStatement("SELECT * FROM kmanager.bestellung");
            this.findByCustomer_ID = conn.prepareStatement("SELECT * FROM kmanager.bestellung "
                    + "WHERE kunden_ID = ?");
            this.findUnsent = conn.prepareStatement("SELECT * FROM kmanager.bestellung WHERE versendet = 0");
            this.insert = conn.prepareStatement("INSERT INTO kmanager.bestellung (kunden_ID, "
                    + "datum, rabatt, versandkosten, endsumme, waehrung, bezahlt, versendet)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            this.update = conn.prepareStatement("UPDATE kmanager.bestellung SET kunden_ID = ?, "
                    + "datum = ?, rabatt = ?, versandkosten = ?, endsumme = ?, "
                    + "waehrung = ?, bezahlt = ?, versendet = ?  WHERE id = ?");
            this.delete = conn.prepareStatement("DELETE kmanager.bestellung, kmanager.artikel "
                    + "FROM kmanager.bestellung LEFT JOIN kmanager.artikel "       
                    + "ON bestellung.id = artikel.bestellung_ID WHERE bestellung.id = ?");
        } catch (SQLException ex) {
            Logger.getLogger(BestellungRepositoryJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Bestellung> findAll(){
//        try {
//            ResultSet rs;        
//            rs = this.findAll.executeQuery();
//            List<Bestellung> list = makeList(rs);
//            return list;
//        } catch (SQLException ex) {
//            Logger.getLogger(BestellungRepositoryJDBC.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return null;
    }      
    
    public void save(Bestellung b){
            if (b.getId() == null){
                insert(b);
            }else{
                update(b);
            }        
    }
    
    public void insert(Bestellung b){
//        try {
//            this.insert.setInt(1, b.getKunden_ID());
//            if (b.getDatum() != null){
//                this.insert.setDate(2, Date.valueOf(b.getDatum()));
//            } else{
//                this.insert.setDate(2, null);
//            }         
//            this.insert.setDouble(3, b.getRabatt());
//            this.insert.setDouble(4, b.getVersandkosten());
//            this.insert.setDouble(5, b.getEndsumme());
//            this.insert.setString(6, b.getWaehrung().toString());
//            this.insert.setBoolean(7, b.isBezahlt());
//            this.insert.setBoolean(8, b.isVersendet());
//            this.insert.executeUpdate();    
//
//            ResultSet rs = this.insert.executeQuery("SELECT LAST_INSERT_ID()");
//            if (rs.next()) {
//                this.lastID = rs.getInt(1);            
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(BestellungRepositoryJDBC.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    public void update(Bestellung b){
//        try {
//            this.update.setInt(1, b.getKunden_ID());
//            if (b.getDatum() != null){
//                this.update.setDate(2, Date.valueOf(b.getDatum()));
//            } else{
//                this.update.setDate(2, null);
//            }        
//            this.update.setDouble(3, b.getRabatt());
//            this.update.setDouble(4, b.getVersandkosten());
//            this.update.setDouble(5, b.getEndsumme());
//            this.update.setString(6, b.getWaehrung().toString());
//            this.update.setBoolean(7, b.isBezahlt());
//            this.update.setBoolean(8, b.isVersendet());
//            this.update.setInt(9, b.getId());
//            this.update.executeUpdate();
//
//            this.lastID = b.getId();    
//        } catch (SQLException ex) {
//            Logger.getLogger(BestellungRepositoryJDBC.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    public void delete(int id){
//        try {
//            this.delete.setInt(1, id);
//            this.delete.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(BestellungRepositoryJDBC.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public Bestellung makeOne(ResultSet rs){
//        try {
//            Integer id = rs.getInt("id");
//            Integer kunden_ID = rs.getInt("kunden_ID");
//            LocalDate datum = null;
//            if (rs.getDate("datum") != null){
//                datum = rs.getDate("datum").toLocalDate();
//            }
//            Double rabatt = rs.getDouble("rabatt");
//            Double versandkosten = rs.getDouble("versandkosten");
//            double endsumme = rs.getDouble("endsumme");
//            Waehrung waehrung = Waehrung.valueOf(rs.getString("waehrung"));
//            boolean bezahlt = rs.getBoolean("bezahlt");
//            boolean versendet = rs.getBoolean("versendet");
//            
//            Bestellung b = new Bestellung();
//            b.setId(id);
//            b.setKunden_ID(kunden_ID);
//            b.setDatum(datum);
//            b.setRabatt(rabatt);
//            b.setVersandkosten(versandkosten);
//            b.setEndsumme(endsumme);
//            b.setWaehrung(waehrung);
//            b.setBezahlt(bezahlt);
//            b.setVersendet(versendet);
//            return b;
//        } catch (SQLException ex) {
//            Logger.getLogger(BestellungRepositoryJDBC.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return null;
    }
    
    public List<Bestellung> makeList(ResultSet rs){
//        try {
//            List<Bestellung> list = new ArrayList<>();
//            while(rs.next()){
//                list.add(makeOne(rs));
//            }
//            return list;
//        } catch (SQLException ex) {
//            Logger.getLogger(BestellungRepositoryJDBC.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return null;
    }

    public int getLastID() {
        return lastID;
    }
    
    public void close(){
//        try {
//            this.findAll.close();
//            this.findByCustomer_ID.close();
//            this.findUnsent.close();
//            this.insert.close();
//            this.update.close();
//            this.delete.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(BestellungRepositoryJDBC.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
}
    