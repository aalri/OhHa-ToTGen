/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package totgen.domain;

import junit.framework.TestCase;
import totgen.taulut.Propositiotaulu;

/**
 *
 * @author alrial@cs
 */
public class GeneraattoriTest extends TestCase {
     
    public void testGeneroi() {
        Propositiotaulu propositiotaulu = new Propositiotaulu();
        Generaattori generaattori = new Generaattori(propositiotaulu);
        Lause lause = generaattori.generoi("a or b");
        int[] arvot = {1, 0};
        assertEquals("" + true + " " + false + " " + true, lause.muodostaTotuusrivi(arvot));

    }
}
