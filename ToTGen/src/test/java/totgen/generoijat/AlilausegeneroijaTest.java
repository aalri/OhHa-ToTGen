/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totgen.generoijat;

import junit.framework.TestCase;
import totgen.taulut.Propositiotaulu;

/**
 *
 * @author Riku
 */
public class AlilausegeneroijaTest extends TestCase {

    public void testgeneroiYksipropositio() {
        Alilausegeneroija A = new Alilausegeneroija("a");
        Propositiotaulu taulu = new Propositiotaulu();
        A.generoi(taulu);
        assertEquals(taulu.getPropositioTaulu().get("a"), A.generoi(taulu));
    }

    public void testgeneroiUseampipropositio() {
        Alilausegeneroija A = new Alilausegeneroija("a and b");
        Propositiotaulu taulu = new Propositiotaulu();
        asetaTotuudetAB(1, 1, taulu);;
        assertEquals(true, A.generoi(taulu).totuus());
    }

    public void testgeneroiNegNorm1() {
        Alilausegeneroija A = new Alilausegeneroija("not a and b");
        Propositiotaulu taulu = new Propositiotaulu();
        asetaTotuudetAB(1, 1, taulu);
        assertEquals(false, A.generoi(taulu).totuus());
    }

    public void testgeneroiNegNorm2() {
        Alilausegeneroija A = new Alilausegeneroija("not a and b");
        Propositiotaulu taulu = new Propositiotaulu();
        asetaTotuudetAB(0, 1, taulu);
        assertEquals(true, A.generoi(taulu).totuus());
    }

    public void testgeneroiNormNeg1() {
        Alilausegeneroija A = new Alilausegeneroija("a and not b");
        Propositiotaulu taulu = new Propositiotaulu();
        asetaTotuudetAB(1, 1, taulu);
        assertEquals(false, A.generoi(taulu).totuus());
    }

    public void testgeneroiNormNeg2() {
        Alilausegeneroija A = new Alilausegeneroija("a and not b");
        Propositiotaulu taulu = new Propositiotaulu();
        asetaTotuudetAB(1, 0, taulu);
        assertEquals(true, A.generoi(taulu).totuus());
    }

    public void testgeneroiNegNeg1() {
        Alilausegeneroija A = new Alilausegeneroija("not a and not b");
        Propositiotaulu taulu = new Propositiotaulu();
        asetaTotuudetAB(0, 0, taulu);
        assertEquals(true, A.generoi(taulu).totuus());
    }

    public void testgeneroiNegNeg2() {
        Alilausegeneroija A = new Alilausegeneroija("not a and not b");
        Propositiotaulu taulu = new Propositiotaulu();
        asetaTotuudetAB(0, 1, taulu);
        assertEquals(false, A.generoi(taulu).totuus());
    }

    public void asetaTotuudetAB(int a, int b, Propositiotaulu taulu) {
        taulu.lisaaPropositio("a");
        taulu.lisaaPropositio("b");
        taulu.getPropositioTaulu().get("a").asetaTotuus(a);
        taulu.getPropositioTaulu().get("b").asetaTotuus(b);
    }
}
