/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totgen.lauseenkomponentit;

import junit.framework.TestCase;

/**
 *
 * @author alrial
 */
public class PropositioTest extends TestCase {

    private Propositio a = new Propositio();

    public void testPropositioTotuus1() {
        a.asetaTotuus(1);
        assertEquals(true, a.totuus());
    }

    public void testPropositioTotuus0() {
        a.asetaTotuus(0);
        assertEquals(false, a.totuus());
    }
}
