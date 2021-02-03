/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.dao.jpa;

import database.connections.EntityManagerFactoryUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import model.Kunde;
import database.dao.interfaces.DAO;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * DAO Klasse für JPA Abfragen der SQL Tabelle 'kunde'
 */
public class KundenRepositoryJPA implements DAO<Kunde>{
    private EntityManagerFactory emf; 
    
    public KundenRepositoryJPA(){
        this.emf = EntityManagerFactoryUtil.getEntityManagerFactory("kmanager");
    }

    @Override
    public List<Kunde> findAll() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Kunde> query = builder.createQuery(Kunde.class);
        query.from(Kunde.class); 
        List<Kunde> lista = em.createQuery(query).getResultList();
        em.close();
        return lista;
    }

    @Override
    public void save(Kunde k) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();        
        em.merge(k);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Kunde k = em.getReference(Kunde.class, id);
        em.remove(k);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void close() {
        EntityManagerFactoryUtil.close();
    }
}
