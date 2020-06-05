/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Comparator;

/**
 *
 * @author Nagy
 */
public class KundeIdComparator implements Comparator<Kunde>{

    @Override
    public int compare(Kunde o1, Kunde o2) {
        return o1.getId().compareTo(o2.getId());
    }
    
}
