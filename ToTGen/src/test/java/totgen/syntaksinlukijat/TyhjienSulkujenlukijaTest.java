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
public class TyhjienSulkujenlukijaTest extends TestCase {
        public void testLuomiset() {
        TyhjienSulkujenlukija lukija = new TyhjienSulkujenlukija();
        assertEquals(true,lukija.lue("A and C ( D or F )"));
        assertEquals(true,lukija.lue("("));
        assertEquals(false,lukija.lue("()"));
        assertEquals(false,lukija.lue("( )"));
        assertEquals(true,lukija.lue("( A )"));
        assertEquals(true,lukija.lue("(A)"));
        assertEquals("Jotkut sulut eivät sisällä mitään.",lukija.virheilmoitus());
    }
}
