/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totgen.taulut;

import java.util.HashMap;
import totgen.lauseenkomponentit.Propositio;

/**
 *
 * @author alrial
 */
public class Propositiotaulu {
    private HashMap<String, Propositio> propositiot;

    public Propositiotaulu() {
        this.propositiot = new HashMap<String, Propositio>();
    }
    
    public Propositio LisaaPropositio(String nimi){
        if(!this.propositiot.containsKey(nimi)){
            this.propositiot.put(nimi, new Propositio());
        }  
        return this.propositiot.get(nimi);
    }
    
    public HashMap<String, Propositio> getPropositioTaulu(){
        return this.propositiot;
    }
}
