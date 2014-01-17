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
public class Negaatio implements Komponentti{
    private Komponentti k1;
    
    public Negaatio (Komponentti k1){
        this.k1 = k1;
    }

    @Override
    public boolean totuus() {
        return !this.k1.totuus();
    }
    
}
