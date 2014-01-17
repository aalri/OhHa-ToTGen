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
public class ImplikaatioTest extends TestCase {

    private Propositio a = new Propositio();
    private Propositio b = new Propositio();
    private Implikaatio c = new Implikaatio(a, b);

    public void testImplikaatioTotuudet11() {
        a.asetaTotuus(1);
        b.asetaTotuus(1);
        assertEquals(true, c.totuus());
    }

    public void testImplikaatioTotuudet01() {
        a.asetaTotuus(0);
        b.asetaTotuus(1);
        assertEquals(true, c.totuus());
    }

    public void testImplikaatioTotuudet10() {
        a.asetaTotuus(1);
        b.asetaTotuus(0);
        assertEquals(false, c.totuus());
    }

    public void testImplikaatioTotuudet00() {
        a.asetaTotuus(0);
        b.asetaTotuus(0);
        assertEquals(true, c.totuus());
    }
}
