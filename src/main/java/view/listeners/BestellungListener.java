/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.listeners;

import model.Bestellung;

/**
 *
 * Listener Klasse für die Kommunikation zw. BestellungRepository und Swing Komponenten
 */
public interface BestellungListener {
    public void bestellungWeitergegeben(Bestellung b);
    public void deleteSelected(int id);
}
