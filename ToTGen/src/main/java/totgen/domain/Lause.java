/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package totgen.domain;

import java.util.ArrayList;
import totgen.lauseenkomponentit.Komponentti;
import totgen.lauseenkomponentit.Propositio;

/**
 *
 * @author alrial@cs
 */
public class Lause {
    Komponentti paakonnektiivi;
    private ArrayList <Propositio> propositiot;
    
    public Lause (Komponentti paakonnektiivi, ArrayList <Propositio> propositiot){
        this.paakonnektiivi = paakonnektiivi;
        this.propositiot = propositiot;
    }
    
    public String muodostaTotuusrivi(int[] totuusarvot){
        String rivi = "";
        for (int i = 0; i < this.propositiot.size(); i++) {
            this.propositiot.get(i).asetaTotuus(totuusarvot[i]);
            rivi += this.propositiot.get(i).totuus() + " ";
        }
        return rivi + this.paakonnektiivi.totuus();
    }
}
