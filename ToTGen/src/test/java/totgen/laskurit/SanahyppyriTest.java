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
public class SanahyppyriTest extends TestCase {

    public void testSanahyppyriHyppaa() {
        String sana = "aivo mies";
        Sanahyppyri hyppyri = new Sanahyppyri();
        assertEquals(4, hyppyri.hyppaaTulevaSana(sana));
    }

    public void testSanahyppyriEiHyppaa() {
        String sana = " aivo mies";
        Sanahyppyri hyppyri = new Sanahyppyri();
        assertEquals(0, hyppyri.hyppaaTulevaSana(sana));
    }

    public void testSanahyppyriEiHyppaaTyhja() {
        String sana = "";
        Sanahyppyri hyppyri = new Sanahyppyri();
        assertEquals(0, hyppyri.hyppaaTulevaSana(sana));
    }
}
