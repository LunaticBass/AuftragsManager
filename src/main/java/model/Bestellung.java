/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Type;


/**
 *
 * Klasse für Bestellungen mit Kunden_ID Referenz
 */
@Entity
@Table(name="bestellung")
public class Bestellung implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name="kunden_ID", referencedColumnName = "id")
    private Kunde kunde;
   
    private LocalDate datum;    
    private double rabatt;
    private double versandkosten;
    private double endsumme;
    private Waehrung waehrung;
    
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean bezahlt;    
    
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean versendet;
    
    @OneToMany(mappedBy="bestellung", fetch = FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Artikel> artikelListe = new ArrayList<>();

    public Bestellung(Integer id, Kunde kunde, LocalDate datum, double rabatt, 
            double versandkosten, double endsumme, Waehrung waehrung, 
            boolean bezahlt, boolean versendet){
        this.id = id;
        this.kunde = kunde;
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
        this.endsumme += this.rabatt;
        this.rabatt = rabatt;
        this.endsumme -= rabatt;
    }

    public void setVersandkosten(double versandkosten) {
        this.endsumme -= this.versandkosten;
        this.versandkosten = versandkosten;
        this.endsumme += versandkosten;
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

    public void setArtikelListe(List<Artikel> artikelListe) {
        this.artikelListe = artikelListe;
    }

    public List<Artikel> getArtikelListe() {
        return artikelListe;
    }    

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public Kunde getKunde() {
        return kunde;
    }   
    
}
