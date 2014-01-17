/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totgen.lauseenkomponentit;


import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class DisjunktioTest extends TestCase {

    private Propositio a = new Propositio();
    private Propositio b = new Propositio();
    private Disjunktio c = new Disjunktio(a, b);

    public void testDisjunktioTotuudet11() {
        a.asetaTotuus(1);
        b.asetaTotuus(1);
        assertEquals(true, c.totuus());
    }

    public void testDisjunktioTotuudet01() {
        a.asetaTotuus(0);
        b.asetaTotuus(1);
        assertEquals(true, c.totuus());
    }

    public void testDisjunktioTotuudet10() {
        a.asetaTotuus(1);
        b.asetaTotuus(0);
        assertEquals(true, c.totuus());
    }

    public void testDisjunktioTotuudet00() {
        a.asetaTotuus(0);
        b.asetaTotuus(0);
        assertEquals(false, c.totuus());
    }
}

