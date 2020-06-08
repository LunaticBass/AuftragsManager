package model;

import java.io.Serializable;
import java.util.Map;
import javax.persistence.Entity;

/** Unterklasse der Klasse Artikel */
@Entity
public class Schal extends Artikel implements Serializable{
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
