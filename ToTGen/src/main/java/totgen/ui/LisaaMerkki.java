/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totgen.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

/**
 *
 * @author Riku
 */
/**
 *
 *
 *
 *
 *
 * LisaaMerkki luokka, jonka tarkoituksena on napinpainalluksesta lisata
 * parametrina annettu merkki ennaltapäätettyyn syotealueeseen
 *
 *
 */
public class LisaaMerkki implements ActionListener {

    /**
     *
     * Syötteen kirjoittamiseen tarkoitettu tekstialue
     */
    private JTextField syoteAlue;
    /**
     *
     * Lisättävä merkki
     */
    private String merkki;

    public LisaaMerkki(JTextField syoteAlue, String merkki) {
        this.syoteAlue = syoteAlue;
        this.merkki = merkki;

    }

    /**
     *
     *
     *
     *
     *
     * Metodi lisää parametrina annetun merkin syötealueeseen.
     *
     *
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.syoteAlue.setText(this.syoteAlue.getText() + this.merkki);
    }
}
