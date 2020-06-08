/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.dao.jdbc;

import database.dao.interfaces.DAO;
import model.Muetze;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Stirnband;
import model.HoseLang;
import model.Waehrung;
import model.HoseKurz;
import model.Schal;
import model.Artikel;


/**
 *
 * DAO Klasse für JDBC Abfragen der SQL Tabelle 'artikel'
 */
public class ArtikelRepositoryJDBC implements DAO<Artikel>{
    private Connection conn;
    private PreparedStatement findAll, findByOrder_ID, insert, update, delete;
    
    public ArtikelRepositoryJDBC(Connection conn){
        try {
            this.conn = conn;
            this.findAll = conn.prepareStatement("SELECT * FROM kmanager.artikel");
            this.findByOrder_ID = conn.prepareStatement("SELECT * FROM kmanager.artikel "
                    + "INNER JOIN kmanager.bestellung ON bestellung.id = artikel.bestellung_ID "
                    + "WHERE bestellung_ID = ? ");
            this.insert = conn.prepareStatement("INSERT INTO kmanager.artikel "
                    + "(bestellung_ID, name, groesse, anmerkung) VALUES (?, ?, ?, ?)");
            this.update = conn.prepareStatement("UPDATE kmanager.artikel SET "
                    + "bestellung_ID = ?, name = ?, groesse = ?, anmerkung = ? WHERE id = ?");
            this.delete = conn.prepareStatement("DELETE FROM kmanager.artikel WHERE bestellung_ID = ?");
        } catch (SQLException ex) {
            Logger.getLogger(ArtikelRepositoryJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Artikel> findByOrder_ID(int order_ID){
//        try {
//            this.findByOrder_ID.setInt(1, order_ID);
//            ResultSet all = this.findByOrder_ID.executeQuery();
//            return makeList(all);
//        } catch (SQLException ex) {
//            Logger.getLogger(ArtikelRepositoryJDBC.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return null;
    }
    
    @Override
    public void save(Artikel artikel){
//        if (artikel.getId() == null){
//            insert(artikel);
//        }else{
//            update(artikel);
//        }
    }
    
    public void insert(Artikel a){
//        try {
//            this.insert.setInt(1, a.getBestellung_ID());
//            this.insert.setString(2, a.getName());
//            this.insert.setString(3, a.getGroesse());
//            this.insert.setString(4, a.getAnmerkung());
//            this.insert.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(ArtikelRepositoryJDBC.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    public void update(Artikel a){
//        try {
//            this.update.setInt(1, a.getBestellung_ID());
//            this.update.setString(2, a.getName());
//            this.update.setString(3, a.getGroesse());
//            this.update.setString(4, a.getAnmerkung());
//            this.update.setInt(5, a.getId());
//            this.update.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(ArtikelRepositoryJDBC.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    @Override
    public void delete(int bestellung_ID){
//        try {
//            this.delete.setInt(1, bestellung_ID);
//            this.delete.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(ArtikelRepositoryJDBC.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    public Artikel makeOne(ResultSet rs){
//        try {
//            Integer id = rs.getInt("id");
//            int bestellung_ID = rs.getInt("bestellung_ID");
//            String name = rs.getString("name");
//            String groesse = String.valueOf(rs.getString("groesse"));
//            Waehrung waehrung = Waehrung.valueOf(rs.getString("waehrung"));
//            String anmerkung = rs.getString("anmerkung");
//            
//            switch (name){
//                case "Mütze":
//                    Artikel muetze = new Muetze(id, bestellung_ID, groesse, waehrung, anmerkung);
//                    return muetze;
//                case "Schal":
//                    Artikel schal = new Schal(id, bestellung_ID, groesse, waehrung, anmerkung);
//                    return schal;
//                case "Stirnband":
//                    Artikel stirnband = new Stirnband(id, bestellung_ID, groesse, waehrung, anmerkung);
//                    return stirnband;
//                case "Hose lang":
//                    Artikel hoseLang = new HoseLang(id, bestellung_ID, groesse, waehrung, anmerkung);
//                    return hoseLang;
//                case "Hose kurz":
//                    Artikel hoseKurz = new HoseKurz(id, bestellung_ID, groesse, waehrung, anmerkung);
//                    return hoseKurz;
//                default:
//                    throw new SQLException("Falscher Artikelname");     
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ArtikelRepositoryJDBC.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return null;  
    }
    
    public List<Artikel> makeList(ResultSet rs){
//        try {
//            List<Artikel> list = new ArrayList<>();
//            while(rs.next()){
//                list.add(makeOne(rs));
//            }
//            return list;
//        } catch (SQLException ex) {
//            Logger.getLogger(ArtikelRepositoryJDBC.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return null;
    }
    
    @Override
    public void close(){
//        try {
//            this.conn.close();
//            this.delete.close();
//            this.findByOrder_ID.close();
//            this.insert.close();
//            this.update.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(ArtikelRepositoryJDBC.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @Override
    public List<Artikel> findAll() {        
//        try {            
//            ResultSet all = this.findAll.executeQuery();
//            List<Artikel> lista = makeList(all); 
//            return lista; 
//        } catch (SQLException ex) {
//            Logger.getLogger(KundenRepositoryJDBC.class.getName()).log(Level.SEVERE, null, ex);
//        }  
        return null;
    }

   
}
