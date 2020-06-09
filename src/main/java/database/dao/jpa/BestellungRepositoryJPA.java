/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.dao.jpa;

import database.connections.EntityManagerFactoryUtil;
import database.dao.interfaces.DAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import model.Bestellung;
import model.Kunde;

/**
 *
 * DAO Klasse für JPA Abfragen der SQL Tabelle 'bestellung'
 */
public class BestellungRepositoryJPA implements DAO<Bestellung>{

    private EntityManagerFactory emf;
     
    public BestellungRepositoryJPA(){
        this.emf = EntityManagerFactoryUtil.getEntityManagerFactory("kmanager");
    }

    @Override
    public List<Bestellung> findAll() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT b FROM Bestellung b");
        List<Bestellung> list = q.getResultList();
        em.close();
        return list;
    }
    
    public Bestellung findOne(int id){
        EntityManager em = emf.createEntityManager();
        Bestellung b = em.find(Bestellung.class, id);
        em.close();
        return b;
    }

    @Override
    public void save(Bestellung b) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();        
        em.merge(b);
        em.getTransaction().commit();        
        em.close();
    }

    @Override
    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Bestellung b = em.getReference(Bestellung.class, id);
        Kunde k = em.getReference(Kunde.class, b.getKunde().getId());
        k.getBestellungen().remove(b);
        em.remove(b);        
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void close() {
        EntityManagerFactoryUtil.close();
    }
    
}
