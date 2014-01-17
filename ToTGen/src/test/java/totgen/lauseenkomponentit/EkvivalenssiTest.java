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
public class EkvivalenssiTest extends TestCase {

    private Propositio a = new Propositio();
    private Propositio b = new Propositio();
    private Ekvivalenssi c = new Ekvivalenssi(a, b);

    public void testEkvivalenssiTotuudet11() {
        a.asetaTotuus(1);
        b.asetaTotuus(1);
        assertEquals(true, c.totuus());
    }

    public void testEkvivalenssiTotuudet01() {
        a.asetaTotuus(0);
        b.asetaTotuus(1);
        assertEquals(false, c.totuus());
    }

    public void testEkvivalenssiTotuudet10() {
        a.asetaTotuus(1);
        b.asetaTotuus(0);
        assertEquals(false, c.totuus());
    }

    public void testEkvivalenssiTotuudet00() {
        a.asetaTotuus(0);
        b.asetaTotuus(0);
        assertEquals(true, c.totuus());
    }
}   
