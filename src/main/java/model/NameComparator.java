/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

/**
 *
 * @author Nagy
 */
public class NameComparator implements Comparator<Kunde>{

    @Override
    public int compare(Kunde o1, Kunde o2) {
        Collator col = Collator.getInstance(new Locale("hu","HU"));
        return col.compare(o1.getName(), o2.getName());
    }
    
}
