/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * Klasse für Kundendaten
 */
@Entity
@Table(name="kunde")
public class Kunde implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String name; 
    private String adresse;
    private String telefon;
    
    @OneToMany(mappedBy="kunde", fetch = FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Bestellung> bestellungen = new ArrayList<>();
    
    public Kunde(){
    }
    
    public Kunde(String name){
        this.name = name;              
    }
    
    public Kunde(String name, String adresse, String telefon){
        this.name = name;  
        this.adresse = adresse;
        this.telefon = telefon;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    
    public String getName() {
        return name;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTelefon() {
        return telefon;
    }
    
    public Integer getId(){
        return id;
    }

    public void setBestellungen(List<Bestellung> bestellungen) {
        this.bestellungen = bestellungen;
    }

    public List<Bestellung> getBestellungen() {
        return bestellungen;
    }       
    
    @Override
    public String toString(){
        return id + "; " + name + "; " + adresse + "; " + telefon;
    }
}
