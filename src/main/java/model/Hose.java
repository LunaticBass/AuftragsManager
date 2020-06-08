package model;

import java.io.Serializable;
import javax.persistence.Entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * Artikel Unterklasse, hat weitere Unterklassen
 */
@Entity
public abstract class Hose extends Artikel implements Serializable{
            
    public Hose(){
    }
    
    public Hose(Integer id, Integer bestellung_ID, String groesse, Waehrung waehrung, 
            String anmerkung){
        super(id, bestellung_ID, groesse, waehrung, anmerkung);
    }
   
    /** anhand Größe und Währung wird der Preis widergegeben */    
    public abstract double getPreis();
    
    @Override
    public void setGroesse(String sizeString){
        hosenGroesse g = hosenGroesse.valueOf(sizeString);
        this.groesse = g.toString();
    }
    
    public static enum hosenGroesse {
        A("56-68"), B("62-74"), C("68-80"), D("74-86"), E("80-92"), 
        F("86-98"), G("92-104"), H("98-110");
        
        private String mitZahlen;
        
        private hosenGroesse(String withNumbers){
            this.mitZahlen = withNumbers;
        }
        
        public String getMitZahlen(){
            return mitZahlen;
        }
        
        public static hosenGroesse zahlenAufBuchstabe(String numbers){
            for(hosenGroesse x : hosenGroesse.values()){
                if (x.getMitZahlen().equals(numbers)){
                    return x;
                }
            }
            return null;
        }
    }
    
    public String getGroesseInZahlen(){
        hosenGroesse m = hosenGroesse.valueOf(groesse);
        return m.getMitZahlen();
    }

    @Override
    public String toString(){
        return String.format("%s, %s, %.2f %s/Stk: %s", name, getGroesseInZahlen(), getPreis(), waehrung, anmerkung);
    }
   
}
