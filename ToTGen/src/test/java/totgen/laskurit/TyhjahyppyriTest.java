/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package totgen.laskurit;

import junit.framework.TestCase;

/**
 *
 * @author alrial@cs
 */
public class TyhjahyppyriTest extends TestCase {

    public void testTyhjahyppyriHyppaa() {
        String sana = "  (aivo )mies) alsaldlsg";
        Tyhjahyppyri tyhjahyppyri = new Tyhjahyppyri();
        assertEquals(2, tyhjahyppyri.hyppaaTyhja(sana));
    }
    
    public void testTyhjahyppyriHyppaaTyhja() {
        String sana = "";
        Tyhjahyppyri tyhjahyppyri = new Tyhjahyppyri();
        assertEquals(0, tyhjahyppyri.hyppaaTyhja(sana));
    }
}
