/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import model.Artikel;
import model.Bestellung;
import model.Hose.hosenGroesse;
import model.HoseKurz;
import model.HoseLang;
import model.Kunde;
import model.Muetze;
import model.Schal;
import model.Stirnband;
import model.Waehrung;
import java.time.LocalDate;
import java.time.Month;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nagy
 */
public class KlassenTest {
    
//    public KlassenTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    
//    @Test
//    public void kundenTests(){
//        Kunde kunde = new Kunde();
//        kunde.setName("Testing");
//        kunde.setAdresse("Abcd 123. 98652 Stadt");
//        
//        assertEquals("Testing", kunde.getName());
//        assertEquals("Abcd 123. 98652 Stadt", kunde.getAdresse());
//        assertEquals(null, kunde.getTelefon());
//        assertEquals(null, kunde.getId());
//        
//        kunde.setId(345);
//        kunde.setTelefon("9876");
//        kunde.setName("Neuer");
//        
//        assertEquals(Integer.valueOf(345), kunde.getId());
//        assertEquals("9876", kunde.getTelefon());
//        assertEquals("Neuer", kunde.getName());
//        
//        Kunde kunde2 = new Kunde("Alexander", "Kirchgasse 1. 9876 Berlin", "1234567");
//        assertEquals("Alexander", kunde2.getName());
//        assertEquals("Kirchgasse 1. 9876 Berlin", kunde2.getAdresse());
//        assertEquals("1234567", kunde2.getTelefon());
//        assertEquals(null, kunde2.getId());       
//    }
//    
//    @Test
//    public void schalTest(){
//        Artikel a = new Schal(145, 556677, "35", Waehrung.EUR, "test");
//        
//        assertEquals("Schal", a.getName());
//        assertEquals(Integer.valueOf(145), a.getId());
//        assertEquals(Integer.valueOf(556677), a.getBestellung_ID());
//        assertEquals("35", a.getGroesse());
//        assertEquals(Waehrung.EUR, a.getWaehrung());
//        assertEquals("test", a.getAnmerkung());
//        assertEquals(15, a.getPreis(), 0.001);
//        
//        a.setId(null);
//        a.setBestellung_ID(null);
//        a.setGroesse("klein");
//        a.setWaehrung(Waehrung.HUF);
//        a.setAnmerkung("geändert");
//        
//        assertEquals(null, a.getId());
//        assertEquals(null, a.getBestellung_ID());
//        assertEquals("klein", a.getGroesse());
//        assertEquals(Waehrung.HUF, a.getWaehrung());
//        assertEquals("geändert", a.getAnmerkung());
//        assertEquals(5000, a.getPreis(), 0.001);
//    }
//    
//    @Test
//    public void muetzeTest(){
//        Artikel a = new Muetze(4433, 123456, "90", Waehrung.EUR, "test");
//        
//        assertEquals("Mütze", a.getName());
//        assertEquals(Integer.valueOf(4433), a.getId());
//        assertEquals(Integer.valueOf(123456), a.getBestellung_ID());
//        assertEquals("90", a.getGroesse());
//        assertEquals(Waehrung.EUR, a.getWaehrung());
//        assertEquals("test", a.getAnmerkung());
//        assertEquals(12, a.getPreis(), 0.001);
//        
//        a.setId(null);
//        a.setBestellung_ID(null);
//        a.setGroesse("klein");
//        a.setWaehrung(Waehrung.HUF);
//        a.setAnmerkung("geändert");
//        
//        assertEquals(null, a.getId());
//        assertEquals(null, a.getBestellung_ID());
//        assertEquals("klein", a.getGroesse());
//        assertEquals(Waehrung.HUF, a.getWaehrung());
//        assertEquals("geändert", a.getAnmerkung());
//        assertEquals(4000, a.getPreis(), 0.001);
//    }
//    
////    @Test
////    public void stirnbandTest(){
////        Artikel a = new Stirnband(4433, 123456, "90", Waehrung.EUR, "test");
////        
////        assertEquals("Stirnband", a.getName());
////        assertEquals(Integer.valueOf(4433), a.getId());
////        assertEquals(Integer.valueOf(123456), a.getBestellung_ID());
////        assertEquals("90", a.getGroesse());
////        assertEquals(Waehrung.EUR, a.getWaehrung());
////        assertEquals("test", a.getAnmerkung());
////        assertEquals(9, a.getPreis(), 0.001);
////        
////        a.setId(null);
////        a.setBestellung_ID(null);
////        a.setGroesse("klein");
////        a.setWaehrung(Waehrung.HUF);
////        a.setAnmerkung("geändert");
////        
////        assertEquals(null, a.getId());
////        assertEquals(null, a.getBestellung_ID());
////        assertEquals("klein", a.getGroesse());
////        assertEquals(Waehrung.HUF, a.getWaehrung());
////        assertEquals("geändert", a.getAnmerkung());
////        assertEquals(3000, a.getPreis(), 0.001);
////    }
//    
//    @Test
//    public void hosenTest(){
//        Artikel a = new HoseKurz(4433, 123456, "A", Waehrung.EUR, "test");
//        
//        assertEquals("Hose kurz", a.getName());
//        assertEquals(Integer.valueOf(4433), a.getId());
//        assertEquals(Integer.valueOf(123456), a.getBestellung_ID());
//        assertEquals(hosenGroesse.A, hosenGroesse.valueOf(a.getGroesse()));
//        assertEquals(Waehrung.EUR, a.getWaehrung());
//        assertEquals("test", a.getAnmerkung());
//        assertEquals(8.5, a.getPreis(), 0.001);
//        
//        a.setId(null);
//        a.setBestellung_ID(null);
//        a.setGroesse("F");
//        a.setWaehrung(Waehrung.HUF);
//        a.setAnmerkung("geändert");
//        
//        assertEquals(null, a.getId());
//        assertEquals(null, a.getBestellung_ID());        
//        assertEquals(hosenGroesse.F, hosenGroesse.valueOf(a.getGroesse()));
//        assertEquals(Waehrung.HUF, a.getWaehrung());
//        assertEquals("geändert", a.getAnmerkung());
//        assertEquals(3550, a.getPreis(), 0.001);
//        
//        HoseLang lang = new HoseLang(99, 12, hosenGroesse.H.toString(), Waehrung.HUF, "schön");
//        
//        assertEquals(Integer.valueOf(99), lang.getId());
//        assertEquals(Integer.valueOf(12), lang.getBestellung_ID());        
//        assertEquals("H", lang.getGroesse());
//        assertEquals(Waehrung.HUF, lang.getWaehrung());
//        assertEquals("schön", lang.getAnmerkung());
//        assertEquals(4750, lang.getPreis(), 0.001);
//        
//        assertEquals("98-110", hosenGroesse.H.getMitZahlen());        
//    }
//    
//    @Test
//    public void bestellungTest(){
//        Bestellung best = new Bestellung(808, 789, LocalDate.of(2020, Month.MARCH, 12), 100, 
//            800, 10000, Waehrung.HUF, true, true);
//        
//        assertEquals(Integer.valueOf(808), best.getId());
//        assertEquals(Integer.valueOf(789), best.getKunden_ID());
//        assertEquals(LocalDate.of(2020, Month.MARCH, 12), best.getDatum());
//        assertEquals(100, best.getRabatt(), 0.0001);
//        assertEquals(800, best.getVersandkosten(), 0.0001);
//        assertEquals(Waehrung.HUF, best.getWaehrung());
//        assertTrue(best.isBezahlt());
//        assertTrue(best.isVersendet());   
//        
//        best.setId(1000);
//        best.setKunden_ID(1000);
//        best.setDatum(LocalDate.now());
//        best.setEndsumme(9000);
//        best.setVersandkosten(1000);
//        best.setRabatt(0);
//        best.setVersendet(false);
//        best.setWaehrung(Waehrung.EUR);
//        best.setBezahlt(false);
//        
//        assertEquals(Integer.valueOf(1000), best.getId());
//        assertEquals(Integer.valueOf(1000), best.getKunden_ID());
//        assertEquals(LocalDate.now(), best.getDatum());
//        assertEquals(0, best.getRabatt(), 0.0001);
//        assertEquals(1000, best.getVersandkosten(), 0.0001);
//        assertEquals(Waehrung.EUR, best.getWaehrung());
//        assertFalse(best.isBezahlt());
//        assertFalse(best.isVersendet());        
//    }
}
