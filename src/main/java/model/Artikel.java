/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * abtstracte Klasse für Artikel
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="artikel")
public abstract class Artikel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    
    @ManyToOne
    @JoinColumn(name="bestellung_ID", referencedColumnName = "id")
    protected Bestellung bestellung;    

    protected String name;
    protected String groesse;
    protected String anmerkung;
    protected Waehrung waehrung;  

    public Artikel(Integer id, Integer bestellung_ID, String groesse, Waehrung waehrung, 
            String anmerkung){
        this.id = id;       
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

    public void setName(String name) {
        this.name = name;
    }

    public void setGroesse(String groesse) {
        this.groesse = groesse;
    }
    
    public Integer getId() {
        return id;
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

    public void setBestellung(Bestellung bestellung) {
        this.bestellung = bestellung;
    }

    public Bestellung getBestellung() {
        return bestellung;
    }
    
    
    @Override
    public String toString(){
        return String.format("%s, %s, %.2f %s/Stk: %s", name, groesse, getPreis(), waehrung, anmerkung);
    }
    
}
