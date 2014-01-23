/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totgen.generoijat;

import java.util.HashMap;
import totgen.lauseenkomponentit.Disjunktio;
import totgen.lauseenkomponentit.Ekvivalenssi;
import totgen.lauseenkomponentit.Implikaatio;
import totgen.lauseenkomponentit.Komponentti;
import totgen.lauseenkomponentit.Konjunktio;
import totgen.lauseenkomponentit.Negaatio;
import totgen.lauseenkomponentit.Propositio;

/**
 *
 * @author alrial@cs
 */
public class Generoijaluoja {

    public Generoijaluoja() {

    }

    public Komponentti luo(String syote, Komponentti[] komponentit) {
        Komponentti k1 = komponentit[0];
        System.out.println("luo: "+ syote);
        if (syote.contentEquals("not")) {
            return new Negaatio(k1);
        } else {
            Komponentti k2 = komponentit[1];            
            if (syote.contentEquals("and")) {
                return new Konjunktio(k1,k2);                
            }
            if (syote.contentEquals("or")) {
                return new Disjunktio(k1,k2);                
            }
            if (syote.contentEquals("imp")){
                return new Implikaatio(k1,k2); 
            }
            if (syote.contentEquals("ekv")){
                return new Ekvivalenssi(k1,k2); 
            }
        }

        return null;
    }
}
