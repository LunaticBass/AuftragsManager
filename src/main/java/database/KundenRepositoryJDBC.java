/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Kunde;

/**
 *
 * DAO Klasse für JDBC Abfragen der SQL Tabelle 'kunde'
 */
public class KundenRepositoryJDBC {
    private Connection conn;
    private PreparedStatement findAll;
    private PreparedStatement insert, update, delete;
    
    public KundenRepositoryJDBC(Connection conn) throws SQLException{
            this.conn = conn;
            this.findAll = conn.prepareStatement("SELECT * FROM kmanager.kunde");
            this.insert = conn.prepareStatement("INSERT INTO kmanager.kunde (name, adresse, telefon) "
                    + "VALUES (?, ?, ?)");
            this.update = conn.prepareStatement("UPDATE kmanager.kunde "
                    + "SET name = ?, adresse = ?, telefon = ? WHERE id = ?");
            this.delete = conn.prepareStatement("DELETE kmanager.bestellung, kmanager.kunde, kmanager.artikel "
                    + "FROM kmanager.kunde LEFT JOIN kmanager.bestellung ON kunde.id = bestellung.kunden_ID "
                    + "LEFT JOIN kmanager.artikel ON bestellung.id = artikel.bestellung_ID WHERE kunde.id = ?");       
    }
    
    public List<Kunde> findAll() throws SQLException{
        ResultSet all = this.findAll.executeQuery();
        List<Kunde> lista = makeList(all);
        return lista;        
    }
    
    public void save(Kunde k) throws SQLException{
        if (k.getId() == null){
            insert(k);
        }else{
            update(k);
        }
    }
    
    public void insert(Kunde k) throws SQLException{
        this.insert.setString(1, k.getName());
        this.insert.setString(2, k.getAdresse());
        this.insert.setString(3, k.getTelefon());
        this.insert.executeUpdate();
    }
    
    public void update(Kunde k) throws SQLException{
        this.update.setString(1, k.getName());
        this.update.setString(2, k.getAdresse());
        this.update.setString(3, k.getTelefon());
        this.update.setInt(4, k.getId());
        this.update.executeUpdate();
    }
    
    public void delete(int id) throws SQLException{
        this.delete.setInt(1, id);
        this.delete.executeUpdate();
    }
    
    public Kunde makeOne(ResultSet rs) throws SQLException{
        Integer id = rs.getInt("id");
        String name = rs.getString("name");
        String adresse = rs.getString("adresse");
        String telefon = rs.getString("telefon");
        Kunde k = new Kunde(name, adresse, telefon);
        k.setId(id);
        return k;
    }
    
    public List<Kunde> makeList(ResultSet rs) throws SQLException{
        List <Kunde> list = new ArrayList<>();
        while (rs.next()){
            list.add(makeOne(rs));
        }
        return list;
    }  
    
    public void close() throws SQLException{
        this.conn.close();
        this.delete.close();
        this.findAll.close();
        this.insert.close();
        this.update.close();
    }
}
