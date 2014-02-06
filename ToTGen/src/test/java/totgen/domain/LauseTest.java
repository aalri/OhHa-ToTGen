/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totgen.domain;

import totgen.taulut.Propositiotaulu;
import java.util.ArrayList;
import junit.framework.TestCase;
import totgen.lauseenkomponentit.Disjunktio;
import totgen.lauseenkomponentit.Ekvivalenssi;
import totgen.lauseenkomponentit.Implikaatio;
import totgen.lauseenkomponentit.Konjunktio;
import totgen.lauseenkomponentit.Propositio;

/**
 *
 * @author alrial
 */
public class LauseTest extends TestCase {

    Propositiotaulu propositiot = new Propositiotaulu();
    Propositio a = propositiot.lisaaPropositio("A");
    Propositio b = propositiot.lisaaPropositio("B");
    int[] totuusarvot;

    public void testLauseTotuudetAjaB() {

        Lause lause = new Lause(new Konjunktio(a, b), propositiot);
        totuusarvot = new int[]{1, 1};
        assertEquals("" + true + " " + true + " " + true, lause.muodostaTotuusrivi(totuusarvot));
        totuusarvot = new int[]{1, 0};
        assertEquals("" + true + " " + false + " " + false, lause.muodostaTotuusrivi(totuusarvot));
        totuusarvot = new int[]{0, 1};
        assertEquals("" + false + " " + true + " " + false, lause.muodostaTotuusrivi(totuusarvot));
        totuusarvot = new int[]{0, 0};
        assertEquals("" + false + " " + false + " " + false, lause.muodostaTotuusrivi(totuusarvot));

    }

    public void testLauseTotuudetAtaiB() {

        Lause lause = new Lause(new Disjunktio(a, b), propositiot);
        totuusarvot = new int[]{1, 1};
        assertEquals("" + true + " " + true + " " + true, lause.muodostaTotuusrivi(totuusarvot));
        totuusarvot = new int[]{1, 0};
        assertEquals("" + true + " " + false + " " + true, lause.muodostaTotuusrivi(totuusarvot));
        totuusarvot = new int[]{0, 1};
        assertEquals("" + false + " " + true + " " + true, lause.muodostaTotuusrivi(totuusarvot));
        totuusarvot = new int[]{0, 0};
        assertEquals("" + false + " " + false + " " + false, lause.muodostaTotuusrivi(totuusarvot));
    }

    public void testLauseTotuudetAniinB() {

        Lause lause = new Lause(new Implikaatio(a, b), propositiot);
        totuusarvot = new int[]{1, 1};
        assertEquals("" + true + " " + true + " " + true, lause.muodostaTotuusrivi(totuusarvot));
        totuusarvot = new int[]{1, 0};
        assertEquals("" + true + " " + false + " " + false, lause.muodostaTotuusrivi(totuusarvot));
        totuusarvot = new int[]{0, 1};
        assertEquals("" + false + " " + true + " " + true, lause.muodostaTotuusrivi(totuusarvot));
        totuusarvot = new int[]{0, 0};
        assertEquals("" + false + " " + false + " " + true, lause.muodostaTotuusrivi(totuusarvot));
    }

    public void testLauseTotuudetAjossB() {

        Lause lause = new Lause(new Ekvivalenssi(a, b), propositiot);
        totuusarvot = new int[]{1, 1};
        assertEquals("" + true + " " + true + " " + true, lause.muodostaTotuusrivi(totuusarvot));
        totuusarvot = new int[]{1, 0};
        assertEquals("" + true + " " + false + " " + false, lause.muodostaTotuusrivi(totuusarvot));
        totuusarvot = new int[]{0, 1};
        assertEquals("" + false + " " + true + " " + false, lause.muodostaTotuusrivi(totuusarvot));
        totuusarvot = new int[]{0, 0};
        assertEquals("" + false + " " + false + " " + true, lause.muodostaTotuusrivi(totuusarvot));
    }
    
    public void testLauseListaTotuudetAjossB() {
        
        Lause lause = new Lause(new Ekvivalenssi(a, b), propositiot);
        totuusarvot = new int[]{1, 1, 0};
        assertEquals("true", lause.muodostaTotuusrivilista(totuusarvot)[2]);
        totuusarvot = new int[]{1, 0, 0};
        assertEquals("false", lause.muodostaTotuusrivilista(totuusarvot)[2]);
        totuusarvot = new int[]{0, 1, 0};
        assertEquals("false", lause.muodostaTotuusrivilista(totuusarvot)[2]);
        totuusarvot = new int[]{0, 0, 0};
        assertEquals("true", lause.muodostaTotuusrivilista(totuusarvot)[2]);
    }
    
        public void testgetPropositiolista() {
        Propositio d = propositiot.lisaaPropositio("D");
        Lause lause = new Lause(new Ekvivalenssi(a, new Konjunktio(b , d)), propositiot);
        totuusarvot = new int[]{1, 1, 1, 1};
        assertEquals("true", lause.muodostaTotuusrivilista(totuusarvot)[3]);
        totuusarvot = new int[]{1, 0, 0, 0};
        assertEquals("false", lause.muodostaTotuusrivilista(totuusarvot)[3]);
        totuusarvot = new int[]{0, 1, 0, 0};
        assertEquals("true", lause.muodostaTotuusrivilista(totuusarvot)[3]);
        totuusarvot = new int[]{0, 1, 1, 0};
        assertEquals("false", lause.muodostaTotuusrivilista(totuusarvot)[3]);
    }
        
        public void testgetPropositioNimetlista() {
        Propositio d = propositiot.lisaaPropositio("D");
        Lause lause = new Lause(new Ekvivalenssi(a, new Konjunktio(b , d)), propositiot);
        ArrayList<String> lista = lause.getPropositioNimetlista();
        assertEquals("A", lista.get(0));
        assertEquals("B", lista.get(1));
        assertEquals("D", lista.get(2));
    }
                
    public void testLauseGetPropositiotaulu() {

        Lause lause = new Lause(new Ekvivalenssi(a, b), propositiot);
        lause.getPropositiotaulu();
    }
    
}
