/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.models;

import java.text.Collator;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import model.Kunde;

/**
 *
 * @author Nagy
 */

/**
 *
 * Comparator für die richtige Sortierung in der Tabelle der Bestellungen
 */
public class NameComparator implements Comparator<Integer>{
    private List<Kunde> list;
    
    public NameComparator(List<Kunde> list){
        this.list = list;
    }
    
    
    @Override
    public int compare(Integer o1, Integer o2) {
        Collator col = Collator.getInstance(new Locale("hu","HU"));
        String name1 = "";
        String name2 = "";
        
        for (Kunde kunde : list){
            if (kunde.getId().equals(o1)){
                name1 = kunde.getName();
            } else if ( kunde.getId().equals(o2)){
                name2 = kunde.getName();
            }
        }
        
        return col.compare(name1, name2);
    }
    
}
