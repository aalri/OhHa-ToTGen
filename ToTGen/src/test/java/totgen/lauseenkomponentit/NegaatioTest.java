/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package totgen.lauseenkomponentit;

import junit.framework.TestCase;

/**
 *
 * @author alrial@cs
 */
public class NegaatioTest extends TestCase {

    private Propositio a = new Propositio();
    private Negaatio c = new Negaatio(a);

    public void testNegaatioTotuus1() {
        a.asetaTotuus(1);
        assertEquals(false, c.totuus());
    }

    public void testNegaatioTotuus0() {
        a.asetaTotuus(0);
        assertEquals(true, c.totuus());
    }
}
