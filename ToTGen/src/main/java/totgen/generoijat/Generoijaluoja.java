/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totgen.generoijat;

import totgen.lauseenkomponentit.Disjunktio;
import totgen.lauseenkomponentit.Ekvivalenssi;
import totgen.lauseenkomponentit.Implikaatio;
import totgen.lauseenkomponentit.Komponentti;
import totgen.lauseenkomponentit.Konjunktio;
import totgen.lauseenkomponentit.Negaatio;

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
 * Generoijaluoja luokka, jonka metodi luo soveltuvan komponentin annetusta
 * syotteesta.
 *
 */
public class Generoijaluoja {

    public Generoijaluoja() {

    }

    /**
     * Metodi luo soveltuvan komponentin annetusta syotteesta, ja liittaa siihen
     * annetut komponentit. Lopuksi palauttaa luodun komponentin
     *
     * @param syote Kutsujan syote
     *
     * @return Komponentti luotu uusi komponentti.
     *
     */
    public Komponentti luo(String syote, Komponentti[] komponentit) {
        Komponentti k1 = komponentit[0];
        if (syote.contentEquals("not") || syote.contentEquals("¬")) {
            return new Negaatio(k1);
        } else {
            Komponentti k2 = komponentit[1];
            if (syote.contentEquals("and") || syote.contentEquals("∧")) {
                return new Konjunktio(k1, k2);
            }
            if (syote.contentEquals("or") || syote.contentEquals("∨")) {
                return new Disjunktio(k1, k2);
            }
            if (syote.contentEquals("imp") || syote.contentEquals("→")) {
                return new Implikaatio(k1, k2);
            }
            if (syote.contentEquals("ekv") || syote.contentEquals("↔")) {
                return new Ekvivalenssi(k1, k2);
            }
        }

        return k1;
    }
}
