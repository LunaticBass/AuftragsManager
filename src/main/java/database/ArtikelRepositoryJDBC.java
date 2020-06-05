/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import model.Muetze;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
public class ArtikelRepositoryJDBC {
    private Connection conn;
    private PreparedStatement findByOrder_ID;
    private PreparedStatement insert, update, deleteAll;
    
    public ArtikelRepositoryJDBC(Connection conn) throws SQLException{
        this.conn = conn;     
        this.findByOrder_ID = conn.prepareStatement("SELECT * FROM kmanager.artikel "
                + "INNER JOIN kmanager.bestellung ON bestellung.id = artikel.bestellung_ID "
                + "WHERE bestellung_ID = ? ");        
        this.insert = conn.prepareStatement("INSERT INTO kmanager.artikel "
                + "(bestellung_ID, name, groesse, anmerkung) VALUES (?, ?, ?, ?)");
        this.update = conn.prepareStatement("UPDATE kmanager.artikel SET "
                + "bestellung_ID = ?, name = ?, groesse = ?, anmerkung = ? WHERE id = ?");
        this.deleteAll = conn.prepareStatement("DELETE FROM kmanager.artikel WHERE bestellung_ID = ?");
    }
    
    public List<Artikel> findByOrder_ID(int order_ID) throws SQLException{
        this.findByOrder_ID.setInt(1, order_ID);
        ResultSet all = this.findByOrder_ID.executeQuery();
        return makeList(all);
    }
    
    public void save(Artikel artikel) throws SQLException{
        if (artikel.getId() == null){
            insert(artikel);
        }else{
            update(artikel);
        }
    }
    
    public void insert(Artikel a) throws SQLException{
        this.insert.setInt(1, a.getBestellung_ID());
        this.insert.setString(2, a.getName());
        this.insert.setString(3, a.getGroesse());
        this.insert.setString(4, a.getAnmerkung());
        this.insert.executeUpdate();
    }
    
    public void update(Artikel a) throws SQLException{
        this.update.setInt(1, a.getBestellung_ID());
        this.update.setString(2, a.getName());
        this.update.setString(3, a.getGroesse());
        this.update.setString(4, a.getAnmerkung());
        this.update.setInt(5, a.getId());
        this.update.executeUpdate();
    }
    
    public void deleteAll(int id) throws SQLException{
        this.deleteAll.setInt(1, id);
        this.deleteAll.executeUpdate();
    }
    
    public Artikel makeOne(ResultSet rs) throws SQLException{
        Integer id = rs.getInt("id");
        int bestellung_ID = rs.getInt("bestellung_ID");
        String name = rs.getString("name");
        String groesse = String.valueOf(rs.getString("groesse"));        
        Waehrung waehrung = Waehrung.valueOf(rs.getString("waehrung"));
        String anmerkung = rs.getString("anmerkung");
        
        switch (name){
            case "Mütze":
                Artikel muetze = new Muetze(id, bestellung_ID, groesse, waehrung, anmerkung);            
                return muetze;
            case "Schal":
                Artikel schal = new Schal(id, bestellung_ID, groesse, waehrung, anmerkung);
                return schal;
            case "Stirnband":
                Artikel stirnband = new Stirnband(id, bestellung_ID, groesse, waehrung, anmerkung);
                return stirnband;
            case "Hose lang":
                Artikel hoseLang = new HoseLang(id, bestellung_ID, groesse, waehrung, anmerkung);
                return hoseLang;            
            case "Hose kurz":
                Artikel hoseKurz = new HoseKurz(id, bestellung_ID, groesse, waehrung, anmerkung);
                return hoseKurz;
            default:
                throw new SQLException("Falscher Artikelname");
        }     
             
    }
    
    public List<Artikel> makeList(ResultSet rs) throws SQLException{
        List<Artikel> list = new ArrayList<>();
        while(rs.next()){
            list.add(makeOne(rs));
        }
        return list;
    }
    
    public void close() throws SQLException{
        this.conn.close();
        this.deleteAll.close();
        this.findByOrder_ID.close();
        this.insert.close();
        this.update.close();
    }
}
