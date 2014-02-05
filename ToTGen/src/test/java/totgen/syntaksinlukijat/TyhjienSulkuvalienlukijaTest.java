/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package totgen.syntaksinlukijat;

import junit.framework.TestCase;

/**
 *
 * @author alrial@cs
 */
public class TyhjienSulkuvalienlukijaTest extends TestCase {
        public void testLuomiset() {
        TyhjienSulkuvalienLukija lukija = new TyhjienSulkuvalienLukija();
        assertEquals(true,lukija.lue("A and C ( D or F )"));
        assertEquals(false,lukija.lue(")("));
        assertEquals(false,lukija.lue(") ("));
        assertEquals(true,lukija.lue(") A ("));
        assertEquals(true,lukija.lue(")or("));
        assertEquals("Joidenkin sulkujen ulkopuolten välissä ei ole mitään.",lukija.virheilmoitus());
    }
}
