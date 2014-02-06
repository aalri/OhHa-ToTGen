/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totgen.taulut;

import junit.framework.TestCase;
import totgen.lauseenkomponentit.Propositio;

/**
 *
 * @author alrial@cs
 */
public class PropositiotauluTest extends TestCase {

    public void testPropositiotauluEiLisaaSamallaNimellaUutta() {
        Propositiotaulu taulu = new Propositiotaulu();
        taulu.lisaaPropositio("Mikko");
        Propositio mikko = taulu.getPropositioTaulu().get("Mikko");
        taulu.lisaaPropositio("Mikko");
        assertEquals(true, mikko == taulu.getPropositioTaulu().get("Mikko"));
    }
}
