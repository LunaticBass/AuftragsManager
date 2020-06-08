/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.connections;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * generiert ein EntityManagerFactory Objekt
 */
public class EntityManagerFactoryUtil {
    private static EntityManagerFactory emf;
    
    public static EntityManagerFactory getEntityManagerFactory(String persistenceUnitName) {
        emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        return emf;
    }
    
    public static void close(){
        emf.close();
    }
}
