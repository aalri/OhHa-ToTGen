/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totgen.domain;

import totgen.taulut.Propositiotaulu;
import java.util.HashMap;
import totgen.generoijat.Alilausegeneroija;
import totgen.lauseenkomponentit.Komponentti;
import totgen.lauseenkomponentit.Propositio;

/**
 * 
 *
 * @author alrial@cs
 */


public class Generaattori {

    private Propositiotaulu propositiotaulu;
    
    public Generaattori(Propositiotaulu propositiotaulu) {
        this.propositiotaulu = propositiotaulu;
    }

    public Lause generoi(String syote) {
        Alilausegeneroija generoija = new Alilausegeneroija(syote);
        return new Lause(generoija.generoi(this.propositiotaulu), this.propositiotaulu);

    }

}
