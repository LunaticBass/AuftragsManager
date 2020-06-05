package model;

import java.util.Map;


/** Unterklasse der Klasse Artikel */
public class Schal extends Artikel{
    private static Map<Waehrung, Double> PRICELIST = 
            PriceListManager.readMützeSchalStirnband("PreisListe.csv", Schal.class);   
 
    public Schal(){
        this.name = "Schal";
    }
    
    public Schal(Integer id, Integer bestellung_ID, String groesse, Waehrung waehrung, 
            String anmerkung){
        super(id, bestellung_ID, groesse, waehrung, anmerkung);
        this.name = "Schal";        
    }
    
    /** anhand der Währung wird der Preis widergegeben */    
    @Override
    public double getPreis(){       
        return PRICELIST.get(this.waehrung);       
    }     
    
}
