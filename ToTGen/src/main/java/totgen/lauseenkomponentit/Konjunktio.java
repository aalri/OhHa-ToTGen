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
 * Konjunktio luokka, jonka tarkoituksena on simuloida logiikan konjunktiota.
 *
 *
 */
public class Konjunktio implements Komponentti {

    /**
     * konjunktiomerkkiä edeltävä komponentti
     */
    private Komponentti k1;

    /**
     * konjunktiomerkin jälkeen tuleva komponentti
     */
    private Komponentti k2;

    public Konjunktio(Komponentti k1, Komponentti k2) {
        this.k1 = k1;
        this.k2 = k2;
    }

    /**
     * Metodi palauttaa logiikan mukaisen totuuden komponenteista.
     *
     * @return konjunktion totuus
     */
    public boolean totuus() {
        return k1.totuus() == true && k2.totuus() == true;
    }
}
