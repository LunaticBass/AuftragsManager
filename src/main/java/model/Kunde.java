/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * Klasse für Kundendaten
 */
public class Kunde {
    private Integer id;
    private String name;
    private String adresse;
    private String telefon;
    
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
    
    @Override
    public String toString(){
        return id + "; " + name + "; " + adresse + "; " + telefon;
    }
}
