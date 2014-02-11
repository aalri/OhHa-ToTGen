/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package totgen.domain;

import junit.framework.TestCase;

/**
 *
 * @author Riku
 */
public class PaattelynTarkistajaTest extends TestCase {
    
    public void testPaatellaA() {
        PaattelynTarkistaja tarkistaja = new PaattelynTarkistaja("A", "A");
        assertEquals("" + true ,tarkistaja.tarkistaSyntaksi1());
        assertEquals("" + true ,tarkistaja.tarkistaSyntaksi2());
        tarkistaja.Generoi();
        assertEquals(true ,tarkistaja.voidaanPaatella());
    }
    
    public void testPaatellaB() {
        PaattelynTarkistaja tarkistaja = new PaattelynTarkistaja("A)", "A()");
        assertEquals("Virhe suluissa/niiden määrässä. Tarkista sulut.",tarkistaja.tarkistaSyntaksi1());
        assertEquals("Jotkut sulut eivät sisällä mitään.",tarkistaja.tarkistaSyntaksi2());
    }
    
    public void testPaatellaC() {
        PaattelynTarkistaja tarkistaja = new PaattelynTarkistaja("A", "B");
        assertEquals("" + true ,tarkistaja.tarkistaSyntaksi1());
        assertEquals("" + true ,tarkistaja.tarkistaSyntaksi2());
        tarkistaja.Generoi();
        assertEquals(false ,tarkistaja.voidaanPaatella());
    }
}
