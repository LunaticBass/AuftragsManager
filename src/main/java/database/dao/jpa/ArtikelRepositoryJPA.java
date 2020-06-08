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
import model.Artikel;

/**
 *
 * DAO Klasse für JPA Abfragen der SQL Tabelle 'artikel'
 */
public class ArtikelRepositoryJPA implements DAO<Artikel>{
    
    private EntityManagerFactory emf;
     
    public ArtikelRepositoryJPA(){
        this.emf = EntityManagerFactoryUtil.getEntityManagerFactory("kmanager");
    }

    @Override
    public List<Artikel> findAll() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT a FROM Artikel a");
        List<Artikel> list = q.getResultList();
        em.close();
        return list;
    }

    @Override
    public void save(Artikel a) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();        
        em.merge(a);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Artikel a = em.getReference(Artikel.class, id);
        em.remove(a);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void close() {
        EntityManagerFactoryUtil.close();
    }
    
}
