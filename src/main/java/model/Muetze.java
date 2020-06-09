package model;

import java.util.Map;
import javax.persistence.Entity;

/** Unterklasse der Klasse Artikel */
@Entity
public class Muetze extends Artikel{
    private static Map<Waehrung, Double> PRICELIST = 
            PriceListManager.readMützeSchalStirnband("PreisListe.csv", Muetze.class);   
 
    public Muetze(){
        this.name = "Mütze";
    }
    
    public Muetze(Integer id, Bestellung bestellung, String groesse, String anmerkung){
        super(id, bestellung, groesse, anmerkung);
        this.name = "Mütze";
    }
    
    /** anhand der Währung wird der Preis widergegeben */    
    @Override
    public double getPreis(){        
        return PRICELIST.get(bestellung.getWaehrung());       
    }   
    
}
