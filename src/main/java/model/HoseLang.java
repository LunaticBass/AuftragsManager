/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Map;
import javax.persistence.Entity;

/**
 *
 * @author Nagy
 */

/** Unterklasse der Klasse Hose */
@Entity
public class HoseLang extends Hose{
    
    private static Map<Waehrung, Map<hosenGroesse, Double>> PRICELIST = 
            PriceListManager.readHose("PreisListe.csv", HoseLang.class);
            
    public HoseLang(){
        this.name = "Hose lang";
    }
    
    public HoseLang(Integer id, Integer bestellung_ID, String groesse, Waehrung waehrung, 
            String anmerkung){
        super(id, bestellung_ID, groesse, waehrung, anmerkung);
        this.name = "Hose lang";
    }
    
    @Override
    public double getPreis(){      
        return PRICELIST.get(this.waehrung).get(hosenGroesse.valueOf(this.groesse));
    }
}
