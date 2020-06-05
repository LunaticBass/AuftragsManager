/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Bestellung;
import model.Waehrung;


/**
 *
 * DAO Klasse für JDBC Abfragen der SQL Tabelle 'bestellung'
 */
public class BestellungRepositoryJDBC {
    private Connection conn;
    private PreparedStatement findAll, findByCustomer_ID, findUnsent;
    private PreparedStatement insert, update, delete;
    private int lastID = 0;
    
    public BestellungRepositoryJDBC(Connection conn) throws SQLException{
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
    }
    
    public List<Bestellung> findAll() throws SQLException{
        ResultSet rs = this.findAll.executeQuery();
        List<Bestellung> list = makeList(rs);
        return list;
    }
    
    public List<Bestellung> findByCustomer_ID(int customer_ID) throws SQLException{
        this.findByCustomer_ID.setInt(1, customer_ID);
        ResultSet rs = this.findByCustomer_ID.executeQuery();
        List<Bestellung> list = makeList(rs);
        return list;
    }
    
    public List<Bestellung> findUnsent() throws SQLException{
        ResultSet rs = this.findUnsent.executeQuery();
        List<Bestellung> list = makeList(rs);
        return list;
    }
    
    public void save(Bestellung b) throws SQLException{
        if (b.getId() == null){
            insert(b);
        }else{
            update(b);
        }
    }
    
    public void insert(Bestellung b) throws SQLException{
        this.insert.setInt(1, b.getKunden_ID());
        if (b.getDatum() != null){
            this.insert.setDate(2, Date.valueOf(b.getDatum()));
        } else{
            this.insert.setDate(2, null);
        }         
        this.insert.setDouble(3, b.getRabatt());
        this.insert.setDouble(4, b.getVersandkosten());
        this.insert.setDouble(5, b.getEndsumme());
        this.insert.setString(6, b.getWaehrung().toString());
        this.insert.setBoolean(7, b.isBezahlt());
        this.insert.setBoolean(8, b.isVersendet());
        this.insert.executeUpdate();    
        
        ResultSet rs = this.insert.executeQuery("SELECT LAST_INSERT_ID()");
        if (rs.next()) {
            this.lastID = rs.getInt(1);            
        }
    }
    
    public void update(Bestellung b) throws SQLException{
        this.update.setInt(1, b.getKunden_ID());
        if (b.getDatum() != null){
            this.update.setDate(2, Date.valueOf(b.getDatum()));
        } else{
            this.update.setDate(2, null);
        }        
        this.update.setDouble(3, b.getRabatt());
        this.update.setDouble(4, b.getVersandkosten());
        this.update.setDouble(5, b.getEndsumme());
        this.update.setString(6, b.getWaehrung().toString());
        this.update.setBoolean(7, b.isBezahlt());
        this.update.setBoolean(8, b.isVersendet());
        this.update.setInt(9, b.getId());
        this.update.executeUpdate();

        this.lastID = b.getId();        
    }
    
    public void delete(int id) throws SQLException{
        this.delete.setInt(1, id);
        this.delete.executeUpdate();
    }

    public Bestellung makeOne(ResultSet rs) throws SQLException{
        Integer id = rs.getInt("id");
        Integer kunden_ID = rs.getInt("kunden_ID");
        LocalDate datum = null;
        if (rs.getDate("datum") != null){
            datum = rs.getDate("datum").toLocalDate();
        }      
        Double rabatt = rs.getDouble("rabatt");
        Double versandkosten = rs.getDouble("versandkosten");
        double endsumme = rs.getDouble("endsumme");
        Waehrung waehrung = Waehrung.valueOf(rs.getString("waehrung"));
        boolean bezahlt = rs.getBoolean("bezahlt");
        boolean versendet = rs.getBoolean("versendet");
        
        return new Bestellung(id, kunden_ID, datum, rabatt, 
                versandkosten, endsumme, waehrung, bezahlt, versendet);
    }
    
    public List<Bestellung> makeList(ResultSet rs) throws SQLException{
        List<Bestellung> list = new ArrayList<>();
        while(rs.next()){
            list.add(makeOne(rs));
        }
        return list;
    }

    public int getLastID() {
        return lastID;
    }
    
    public void close() throws SQLException{
        this.findAll.close();
        this.findByCustomer_ID.close();
        this.findUnsent.close();
        this.insert.close();
        this.update.close();
        this.delete.close();
    }
    
}
    