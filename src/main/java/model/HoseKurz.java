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
public class HoseKurz extends Hose{    
    private static Map<Waehrung, Map<hosenGroesse, Double>> PRICELIST = 
            PriceListManager.readHose("PreisListe.csv", HoseKurz.class);
    
    public HoseKurz(){
        this.name = "Hose kurz";
    }
    
    public HoseKurz(Integer id, Bestellung bestellung, String groesse, String anmerkung){
        super(id, bestellung, groesse, anmerkung);
        this.name = "Hose kurz";        
    }
    
    @Override
    public double getPreis(){
        return PRICELIST.get(bestellung.getWaehrung()).get(hosenGroesse.valueOf(this.groesse));
    }
}
