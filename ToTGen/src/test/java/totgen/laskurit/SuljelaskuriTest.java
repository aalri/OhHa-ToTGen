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
public class SuljelaskuriTest extends TestCase {

    public void testSuljehyppyriHyppaa() {
        String sana = "(aivo )mies) alsaldlsg";
        Suljelaskuri laskuri = new Suljelaskuri();
        assertEquals(13, laskuri.kunnesAliSulkeetLoppuu(sana));
    }
    
    public void testSuljehyppyriHyppaaeisulkeita() {
        String sana = "alsaldlsg";
        Suljelaskuri laskuri = new Suljelaskuri();
        assertEquals(9, laskuri.kunnesAliSulkeetLoppuu(sana));
    }

}
