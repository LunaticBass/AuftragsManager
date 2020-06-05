/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.listeners;

import model.Kunde;

/**
 *
 * Listener Klasse für die Kommunikation zw. KundenRepository und Swing Komponenten
 */
public interface KundenListener {
    public void KundeWeitergegeben(Kunde k);
    public void deleteSelected(int id);
}
