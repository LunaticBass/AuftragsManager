/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * anhand der "db.ini" Datei wird ein Connection Objekt erstellt
 */
public class ConnectionConfig {
    
    public static Connection getConnection() throws SQLException{
         Properties prop = new Properties();
        try {
            prop.load(ConnectionConfig.class.getResourceAsStream("/db.ini"));
            String url = prop.getProperty("db.url");
            String user = prop.getProperty("db.user");
            String pass = prop.getProperty("db.pass");  
            return DriverManager.getConnection(url, user, pass);
        } catch (IOException ex) {
            Logger.getLogger(ConnectionConfig.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return null;
    }
}
