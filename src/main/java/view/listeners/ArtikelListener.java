/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.listeners;

import java.util.List;
import model.Artikel;

/**
 *
 * Listener Klasse für die Kommunikation zw. ArtikelRepository und Swing Komponenten
 */
public interface ArtikelListener {
    public void artikelListWeitergegeben(List<Artikel> list);
    public List<Artikel> bestellung_IDArtikel(Integer bestellung_ID);
}
