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
public class AlilauseNegaatiogeneroijaTest extends TestCase {

    public void testgeneroiYksipropositio() {
        AlilauseNegaatiogeneroija A = new AlilauseNegaatiogeneroija("not a");
        Propositiotaulu taulu = new Propositiotaulu();
        taulu.LisaaPropositio("a");
        taulu.getPropositioTaulu().get("a").asetaTotuus(1);
        assertEquals(false, A.generoi(taulu).totuus());
    }

    public void testgeneroiSuljekokonaisuusTrue() {
        AlilauseNegaatiogeneroija A = new AlilauseNegaatiogeneroija("not ( a and b )");
        Propositiotaulu taulu = new Propositiotaulu();
        asetaTotuudetAB(1, 1, taulu);
        assertEquals(false, A.generoi(taulu).totuus());
    }

    public void testgeneroiSuljekokonaisuusFalse() {
        AlilauseNegaatiogeneroija A = new AlilauseNegaatiogeneroija("not ( a and b )");
        Propositiotaulu taulu = new Propositiotaulu();
        asetaTotuudetAB(0, 1, taulu);
        assertEquals(true, A.generoi(taulu).totuus());
    }
    
    public void asetaTotuudetAB(int a, int b,Propositiotaulu taulu){
        taulu.LisaaPropositio("a");
        taulu.LisaaPropositio("b");
        taulu.getPropositioTaulu().get("a").asetaTotuus(a);
        taulu.getPropositioTaulu().get("b").asetaTotuus(b);
    }
}