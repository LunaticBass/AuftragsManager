/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;


/**
 *
 * Klasse für Bestellungen mit Kunden_ID Referenz
 */
public class Bestellung {
    private Integer id;
    private Integer kunden_ID;
    private LocalDate datum;    
    private double rabatt;
    private double versandkosten;
    private double endsumme;
    private Waehrung waehrung;
    private boolean bezahlt;    
    private boolean versendet;    

    public Bestellung(Integer id, Integer kunden_ID, LocalDate datum, double rabatt, 
            double versandkosten, double endsumme, Waehrung waehrung, 
            boolean bezahlt, boolean versendet){
        this.id = id;
        this.kunden_ID = kunden_ID;
        this.datum = datum;        
        this.rabatt = rabatt;
        this.versandkosten = versandkosten;
        // inklusive Rabatt u. Versandkosten
        this.endsumme = endsumme;
        this.waehrung = waehrung;
        this.bezahlt = bezahlt;
        this.versendet = versendet;
    }
    
    public Bestellung(){        
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public void setKunden_ID(Integer kunden_ID) {
        this.kunden_ID = kunden_ID;
    }

    public void setEndsumme(double endsumme) {
        this.endsumme = endsumme;
    }

    public void setWaehrung(Waehrung waehrung) {
        this.waehrung = waehrung;
    }

    public void setBezahlt(boolean bezahlt) {
        this.bezahlt = bezahlt;
    }

    public void setVersendet(boolean versendet) {
        this.versendet = versendet;
    }

    public Integer getId() {
        return id;
    }

    public Integer getKunden_ID() {
        return kunden_ID;
    }

    public double getEndsumme() {
        return endsumme;
    }

    public Waehrung getWaehrung() {
        return waehrung;
    }

    public boolean isBezahlt() {
        return bezahlt;
    }

    public boolean isVersendet() {
        return versendet;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }
   
    public void setRabatt(double rabatt) {
        this.rabatt = rabatt;
    }

    public void setVersandkosten(double versandkosten) {
        this.versandkosten = versandkosten;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public double getRabatt() {
        return rabatt;
    }

    public double getVersandkosten() {
        return versandkosten;
    }
}
