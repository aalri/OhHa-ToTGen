/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totgen.lauseenkomponentit;

/**
 *
 * @author alrial@cs
 */
/**
 *
 *
 *
 *
 *
 * Propositio luokka, jonka tarkoituksena on simuloida logiikan propositiota.
 *
 *
 */
public class Propositio implements Komponentti {

    /**
     * proposition totuus
     */
    private boolean totuus;

    public Propositio() {

    }

    /**
     * Metodi asettaa proposition totuuden totuusarvon mukaiseksi.
     *
     * @param i totuusarvo
     */
    public void asetaTotuus(int i) {
        if (i == 1) {
            this.totuus = true;
        } else {
            this.totuus = false;
        }
    }

    /**
     * Metodi palauttaa logiikan mukaisen totuuden komponentista.
     *
     * @return proposition totuus
     */
    @Override
    public boolean totuus() {
        return this.totuus;
    }
}
