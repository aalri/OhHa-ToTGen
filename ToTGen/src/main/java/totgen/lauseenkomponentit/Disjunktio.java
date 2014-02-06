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
 * Disjunktio luokka, jonka tarkoituksena on simuloida logiikan disjunktiota.
 *
 *
 */
public class Disjunktio implements Komponentti {
    
    /**
     * disjunktiomerkkiä edeltävä komponentti
     */
    private Komponentti k1;
    
    /**
     * disjunktiomerkin jälkeen tuleva komponentti
     */
    private Komponentti k2;

    public Disjunktio(Komponentti k1, Komponentti k2) {
        this.k1 = k1;
        this.k2 = k2;
    }
    
    /**
     * Metodi palauttaa logiikan mukaisen totuuden komponenteista.
     *
     * @return disjunktion totuus
     */

    public boolean totuus() {
        return k1.totuus() == true || k2.totuus() == true;
    }
}
