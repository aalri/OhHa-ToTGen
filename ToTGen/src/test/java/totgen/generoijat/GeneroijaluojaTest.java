/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package totgen.generoijat;

import junit.framework.TestCase;
import totgen.lauseenkomponentit.Disjunktio;
import totgen.lauseenkomponentit.Ekvivalenssi;
import totgen.lauseenkomponentit.Implikaatio;
import totgen.lauseenkomponentit.Komponentti;
import totgen.lauseenkomponentit.Konjunktio;
import totgen.lauseenkomponentit.Negaatio;
import totgen.lauseenkomponentit.Propositio;

/**
 *
 * @author Riku
 */
public class GeneroijaluojaTest extends TestCase {

    public void testLuomiset() {
        Generoijaluoja L = new Generoijaluoja();
        Komponentti[] komponentit = new Komponentti[2];
        komponentit[0] = new Propositio(); 
        assertEquals(Konjunktio.class, L.luo("and", komponentit).getClass());
        assertEquals(Disjunktio.class, L.luo("or", komponentit).getClass());
        assertEquals(Negaatio.class, L.luo("not", komponentit).getClass());
        assertEquals(Implikaatio.class, L.luo("imp", komponentit).getClass());
        assertEquals(Ekvivalenssi.class, L.luo("ekv", komponentit).getClass());
        assertEquals(Propositio.class, L.luo("SUPEROP", komponentit).getClass());
    }
}