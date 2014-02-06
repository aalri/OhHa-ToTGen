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
public class TotuustauluTest extends TestCase {
    
    public void testGeneroi(){
        Totuustaulu taulu = new Totuustaulu("A");
        taulu.luoLause();
        taulu.luoTotuustaulu();
        assertEquals("A",taulu.getPropositiot()[0]);
        assertEquals("A",taulu.getPropositiot()[1]);
        
        assertEquals("true",taulu.getTotuudet()[0][0]);
        assertEquals("true",taulu.getTotuudet()[0][1]);
        assertEquals("false",taulu.getTotuudet()[1][0]);
        assertEquals("false",taulu.getTotuudet()[1][1]);
    }
}
