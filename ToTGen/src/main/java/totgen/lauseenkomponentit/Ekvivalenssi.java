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
 * Ekvivalenssi luokka, jonka tarkoituksena on simuloida logiikan ekvivalenssia.
 *
 *
 */
public class Ekvivalenssi implements Komponentti {

    /**
     * ekvivalenssimerkkiä edeltävä komponentti
     */
    private Komponentti k1;
    
    /**
     * ekvivalenssimerkin jälkeen tuleva komponentti
     */
    private Komponentti k2;

    public Ekvivalenssi (Komponentti k1, Komponentti k2) {
        this.k1 = k1;
        this.k2 = k2;
    }
    
    /**
     * Metodi palauttaa logiikan mukaisen totuuden komponenteista.
     *
     * @return ekvivalenssin totuus
     */

    @Override
    public boolean totuus() {
        return (k1.totuus() == k2.totuus());
    }
    
}
