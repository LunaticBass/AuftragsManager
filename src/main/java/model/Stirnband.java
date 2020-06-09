package model;

import java.io.Serializable;
import java.util.Map;
import javax.persistence.Entity;

/** Unterklasse der Klasse Artikel */
@Entity
public class Stirnband extends Artikel implements Serializable{
    private static Map<Waehrung, Double> PRICELIST = 
            PriceListManager.readMützeSchalStirnband("PreisListe.csv", Stirnband.class);  
  
    public Stirnband(){
        this.name = "Stirnband";
    }
    
    public Stirnband(Integer id, Bestellung bestellung, String groesse, String anmerkung){
        super(id, bestellung, groesse, anmerkung);
        this.name = "Stirnband";        
    }
    
    /** anhand der Währung wird der Preis widergegeben */    
    @Override
    public double getPreis(){        
        return PRICELIST.get(bestellung.getWaehrung());        
    }
}
