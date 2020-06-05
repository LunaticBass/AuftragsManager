/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Map;

/**
 *
 * @author Nagy
 */

/** Unterklasse der Klasse Hose */
public class HoseKurz extends Hose{    
    private static Map<Waehrung, Map<hosenGroesse, Double>> PRICELIST = 
            PriceListManager.readHose("PreisListe.csv", HoseKurz.class);
    
    public HoseKurz(){
        this.name = "Hose kurz";
    }
    
    public HoseKurz(Integer id, Integer bestellung_ID, String groesse, Waehrung waehrung, 
            String anmerkung){
        super(id, bestellung_ID, groesse, waehrung, anmerkung);
        this.name = "Hose kurz";        
    }
    
    @Override
    public double getPreis(){
        return PRICELIST.get(this.waehrung).get(hosenGroesse.valueOf(this.groesse));
    }
}
