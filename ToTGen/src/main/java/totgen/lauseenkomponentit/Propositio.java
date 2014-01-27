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
public class Propositio implements Komponentti {

    private boolean totuus;

    public Propositio() {

    }

    public void asetaTotuus(int i) {
        if (i == 1) {
            this.totuus = true;
        } else {
            this.totuus = false;
        }
    }

    public boolean totuus() {
        return this.totuus;
    }
}
