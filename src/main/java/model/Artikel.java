/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * abtstracte Klasse für Artikel
 */
public abstract class Artikel {
    protected Integer id;
    protected Integer bestellung_ID;
    protected String name;
    protected String groesse;
    protected String anmerkung;
    protected Waehrung waehrung;  

    public Artikel(Integer id, Integer bestellung_ID, String groesse, Waehrung waehrung, 
            String anmerkung){
        this.id = id;
        this.bestellung_ID = bestellung_ID;        
        this.groesse = groesse;
        this.waehrung = waehrung;
        this.anmerkung = anmerkung;        
    }
    
    public Artikel(){        
    }
    
/**   Unterklassen haben unterschiedliche Methoden um den Preis wiederzugeben */
    public abstract double getPreis();
    

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBestellung_ID(Integer bestellung_ID) {
        this.bestellung_ID = bestellung_ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroesse(String groesse) {
        this.groesse = groesse;
    }
    
    public Integer getId() {
        return id;
    }

    public Integer getBestellung_ID() {
        return bestellung_ID;
    }

    public String getName() {
        return name;
    }

    public String getGroesse() {
        return groesse;
    }   

    public Waehrung getWaehrung() {
        return waehrung;
    }

    public void setWaehrung(Waehrung waehrung) {
        this.waehrung = waehrung;
    } 

    public void setAnmerkung(String anmerkung) {
        this.anmerkung = anmerkung;
    }

    public String getAnmerkung() {
        return anmerkung;
    }   
    
    @Override
    public String toString(){
        return String.format("%s, %s, %.2f %s/Stk: %s", name, groesse, getPreis(), waehrung, anmerkung);
    }
    
}
