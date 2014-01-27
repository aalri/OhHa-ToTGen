/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package totgen.taulut;

import junit.framework.TestCase;

/**
 *
 * @author alrial@cs
 */
public class VaihtoehtotauluTest extends TestCase {

    public void testVaihtoehtotaulu() {
        Vaihtoehtotaulu taulu = new Vaihtoehtotaulu();
        assertEquals(true, taulu.getTaulu() == taulu.getTaulu());
    }
    
    
}
