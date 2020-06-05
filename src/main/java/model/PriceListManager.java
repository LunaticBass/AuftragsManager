/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * liest die Preisliste aus einer Datei
 */
public class PriceListManager {
        
    public static Map<Waehrung,Double> readMützeSchalStirnband(String filename, Class c){
        Map<Waehrung,Double> priceList = new HashMap<>();        
        String abkuerzung = "";

        if (c.equals(Stirnband.class)){
            abkuerzung = "SB";
        }else if (c.equals(Muetze.class)){
            abkuerzung = "MÜ";
        }else if (c.equals(Schal.class)){
            abkuerzung = "S";
        }       
        
        try (BufferedReader br = new BufferedReader(new FileReader("PreisListe.csv"))){
                String line;            
            while ((line = br.readLine()) != null) {  
                String[] values = line.split(";'"); 
                if (values[0].equals(abkuerzung)){   
                    priceList.put(Waehrung.HUF, Double.parseDouble(values[2]));
                    priceList.put(Waehrung.EUR, Double.parseDouble(values[3]));                                        
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return priceList;
    }
    
    public static Map<Waehrung, Map<Hose.hosenGroesse, Double>> readHose(String filename, Class c){
        Map<Waehrung, Map<Hose.hosenGroesse, Double>> listComplete = new HashMap<>();
        Map<Hose.hosenGroesse, Double> listaHUF = new HashMap<>();
        Map<Hose.hosenGroesse, Double> listaEUR = new HashMap<>();     
        String abkuerzung = "";
        
        if (c.equals(HoseKurz.class)){
            abkuerzung = "HK";
        }else if (c.equals(HoseLang.class)){
            abkuerzung = "HL";
        }
                
        try (BufferedReader br = new BufferedReader(new FileReader("PreisListe.csv"))){
                String line;            
            while ((line = br.readLine()) != null) {  
                String[] values = line.split(";'"); 
                if (values[0].equals(abkuerzung)){   
                    listaHUF.put(Hose.hosenGroesse.zahlenAufBuchstabe(values[1]), Double.parseDouble(values[2]));
                    listaEUR.put(Hose.hosenGroesse.zahlenAufBuchstabe(values[1]), Double.parseDouble(values[3]));
                }
            }
            
            listComplete.put(Waehrung.HUF, listaHUF);
            listComplete.put(Waehrung.EUR, listaEUR);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return listComplete;
    }
}
