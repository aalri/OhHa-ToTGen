/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totgen.domain;

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

    ArrayList<Propositio> propositiot = new ArrayList<Propositio>();
    Propositio a = new Propositio();
    Propositio b = new Propositio();
    int[] totuusarvot;

    public void testLauseTotuudetAjaB() {
        propositiot.add(a);
        propositiot.add(b);
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
        propositiot.add(a);
        propositiot.add(b);
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
        propositiot.add(a);
        propositiot.add(b);
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
        propositiot.add(a);
        propositiot.add(b);
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
}