package model;

import java.util.Map;

/** Unterklasse der Klasse Artikel */
public class Muetze extends Artikel{
    private static Map<Waehrung, Double> PRICELIST = 
            PriceListManager.readMützeSchalStirnband("PreisListe.csv", Muetze.class);   
 
    public Muetze(){
        this.name = "Mütze";
    }
    
    public Muetze(Integer id, Integer bestellung_ID, String groesse, Waehrung waehrung, 
            String anmerkung){
        super(id, bestellung_ID, groesse, waehrung, anmerkung);
        this.name = "Mütze";
    }
    
    /** anhand der Währung wird der Preis widergegeben */    
    @Override
    public double getPreis(){        
        return PRICELIST.get(this.waehrung);       
    }   
    
}
