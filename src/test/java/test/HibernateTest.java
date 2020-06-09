/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.*;
import model.Hose.hosenGroesse;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nagy
 */
public class HibernateTest {
    
    public HibernateTest() {
    }
    
    protected static EntityManagerFactory emf;
    protected static EntityManager em;
    
    @BeforeClass
    public static void init() {
        System.out.println("init() started.");
        try {
            emf = Persistence.createEntityManagerFactory("kmanager-test");
            em = emf.createEntityManager();           
        } catch (Throwable th) {
            th.printStackTrace();
        } finally {
            System.out.println("init() ended.");
        }
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        em.getTransaction().begin();
        
        Kunde k1 = new Kunde("Person1", "Adresse1", "Telefon1");
        Kunde k2 = new Kunde("Person2", "Adresse2", "Telefon2");
        Kunde k3 = new Kunde("Person3", "Adresse3", "Telefon3");
        
        em.persist(k1);
        em.persist(k2);
        em.persist(k3);
        
        Bestellung b = new Bestellung();
        b.setWaehrung(Waehrung.EUR);
        b.setKunde(k1);
        b.setVersendet(false);
        b.setBezahlt(true);
        b.setRabatt(10);
        b.setDatum(LocalDate.of(2019, 10, 4));
        
        em.persist(b);
        
        Artikel m = new Muetze();
        m.setGroesse("klein");       
        m.setBestellung(b);
        
        Artikel s = new Schal();
        s.setGroesse("groß");           
        s.setBestellung(b);
        
        Artikel sb = new Stirnband();        
        sb.setGroesse("mittel");
        sb.setBestellung(b);
        
        Artikel h1 = new HoseKurz();
        h1.setAnmerkung("etwas dünner");        
        h1.setGroesse(hosenGroesse.D.toString());
        h1.setBestellung(b);
        
        Artikel h2 = new HoseLang();
        h2.setAnmerkung("länger");
        h2.setGroesse(hosenGroesse.F.toString());     
        h2.setBestellung(b);
        
        em.persist(m);
        em.persist(s);
        em.persist(sb);
        em.persist(h1);
        em.persist(h2);  
        
        em.getTransaction().commit();
    }
    
    @AfterClass
    public static void tearDown() {
        System.out.println("tearDown() started.");
        try {
            em.clear();
            em.close();
            emf.close();
        } catch (Throwable th) {
            th.printStackTrace();
        } finally {
            System.out.println("tearDown() ended.");
        }
    }

    @Test
    public void abfragenKunde(){
        Kunde k1 = em.getReference(Kunde.class, 1);
        Kunde k2 = em.getReference(Kunde.class, 2);
        Kunde k3 = em.getReference(Kunde.class, 3);       
        
        assertEquals("Falscher Name", "Person1", k1.getName());
        assertEquals("Falscher Name", "Person2", k2.getName());
        assertEquals("Falscher Name", "Person3", k3.getName());
    }
    
    @Test
    public void abfragenArtikel(){
        Artikel a1 = em.find(Artikel.class, 1);
        Artikel a2 = em.getReference(Artikel.class, 2);
        Artikel a3 = em.getReference(Artikel.class, 3);
        Artikel a4 = em.getReference(Artikel.class, 4);
        Artikel a5 = em.getReference(Artikel.class, 5);
        
        assertEquals("Falscher Name", "Mütze", a1.getName());
        assertEquals("Falsche Größe", "klein", a1.getGroesse());
        assertEquals("Falscher Preis", 12, a1.getPreis(), 0.001);
        
        assertEquals("Falscher Name", "Schal", a2.getName());
        assertEquals("Falsche Größe", "groß", a2.getGroesse());
        assertEquals("Falscher Preis", 15, a2.getPreis(), 0.001);
        
        assertEquals("Falscher Name", "Stirnband", a3.getName());
        assertEquals("Falsche Größe", "mittel", a3.getGroesse());        
        assertEquals("Falscher Preis", 9, a3.getPreis(), 0.001);
        
        assertEquals("Falscher Name", "Hose kurz", a4.getName());
        assertEquals("Falsche Größe", "D", a4.getGroesse());
        assertEquals("Anmerkung stimmt nicht", "etwas dünner", a4.getAnmerkung());        
        assertEquals("Falscher Preis", 10, a4.getPreis(), 0.001);
        
        assertEquals("Falscher Name", "Hose lang", a5.getName());
        assertEquals("Falsche Größe", "F", a5.getGroesse());
        assertEquals("Falscher Preis", 13, a5.getPreis(), 0.001);
        assertEquals("Anmerkung stimmt nicht", "länger", a5.getAnmerkung());
    }
    
    @Test
    public void abfragenBestellung(){
        Bestellung b1 = em.getReference(Bestellung.class, 1);
        
        assertEquals("kunden_ID stimmt nicht", Integer.valueOf(1), b1.getKunde().getId());
        assertEquals("Währung stimmt nicht", Waehrung.EUR, b1.getWaehrung());
        assertTrue("Sollte bezahlt sein", b1.isBezahlt());
        assertFalse("Sollte nicht versendet sein", b1.isVersendet());
        assertEquals("Rabatt stimmt nicht", 10, b1.getRabatt(), 0.001);
        assertEquals("Datum stimmt nicht", LocalDate.of(2019, 10, 4), b1.getDatum());        

        Query q = em.createQuery("SELECT a FROM Artikel a WHERE a.bestellung.id = 1");
        
        List<Artikel> artikelListe = q.getResultList();
         assertEquals("Sollte 5 Artikel enthalten", 5, artikelListe.size());        
    }

  
}
