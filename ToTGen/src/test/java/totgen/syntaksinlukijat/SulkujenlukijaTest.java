/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totgen.syntaksinlukijat;

import junit.framework.TestCase;

/**
 *
 * @author Riku
 */
public class SulkujenlukijaTest extends TestCase {

    public void testLuomiset() {
        Sulkujenlukija lukija = new Sulkujenlukija();
        assertEquals(true,lukija.lue("A and C ( D or F )"));
        assertEquals(false,lukija.lue("A and C ( D or F ))"));
        assertEquals("Virhe sulkujen määrässä. Tarkista sulut.",lukija.virheilmoitus());
    }
}
