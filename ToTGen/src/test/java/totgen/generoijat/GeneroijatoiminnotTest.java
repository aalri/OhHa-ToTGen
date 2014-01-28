package totgen.generoijat;

import junit.framework.TestCase;
import totgen.lauseenkomponentit.Komponentti;
import totgen.taulut.Propositiotaulu;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Riku
 */
public class GeneroijatoiminnotTest extends TestCase {
    Generoijatoiminnot A = new Generoijatoiminnot();

    public void testlauseSisaltaaVainYhdenProposition() {        
        assertEquals(true, Generoijatoiminnot.lauseSisaltaaVainYhdenProposition("auto"));
        assertEquals(false, Generoijatoiminnot.lauseSisaltaaVainYhdenProposition("auto and auto"));
    }

    public void testkyseessaPropositio() {
        assertEquals(true, Generoijatoiminnot.kyseessaPropositio("auto ) ooh lala"));
        assertEquals(true, Generoijatoiminnot.kyseessaPropositio("A"));
        assertEquals(false, Generoijatoiminnot.kyseessaPropositio(") ooh lala"));
        assertEquals(false, Generoijatoiminnot.kyseessaPropositio(""));
    }
    
    public void testkomponenttiOnNegaatio() {
        assertEquals(true, Generoijatoiminnot.komponenttiOnNegaatio("not auto"));
        assertEquals(true, Generoijatoiminnot.komponenttiOnNegaatio("not A"));
        assertEquals(false, Generoijatoiminnot.komponenttiOnNegaatio("auto"));
        assertEquals(false, Generoijatoiminnot.komponenttiOnNegaatio("no"));
    }
    
    public void testkomponenttiKoostuuSulkeidenSisallaOlevastaKokonaisuudesta() {
        assertEquals(true, Generoijatoiminnot.komponenttiKoostuuSulkeidenSisallaOlevastaKokonaisuudesta("(not auto)"));
        assertEquals(false, Generoijatoiminnot.komponenttiKoostuuSulkeidenSisallaOlevastaKokonaisuudesta("auto"));
        assertEquals(false, Generoijatoiminnot.komponenttiKoostuuSulkeidenSisallaOlevastaKokonaisuudesta("("));
    }
    
    public void testmuutaNegaatioKomponentiksiSekaPalautaMuuLause() {
        Propositiotaulu taulu = new Propositiotaulu();
        Komponentti[] komponentit = new Komponentti[2];
        assertEquals("and B", Generoijatoiminnot.muutaNegaatioKomponentiksiSekaPalautaMuuLause("not A and B", komponentit, 1, taulu));
        assertEquals("or C", Generoijatoiminnot.muutaNegaatioKomponentiksiSekaPalautaMuuLause("not (A and B) or C", komponentit, 1, taulu));
    }
    
    public void testmuutaKomponentiksiSekaPalautaMuuLause() {
        Propositiotaulu taulu = new Propositiotaulu();
        Komponentti[] komponentit = new Komponentti[2];
        assertEquals("and B", Generoijatoiminnot.muutaKomponentiksiSekaPalautaMuuLause("A and B", komponentit, 1, taulu));
        assertEquals("or C", Generoijatoiminnot.muutaKomponentiksiSekaPalautaMuuLause("(A and B) or C", komponentit, 1, taulu));
    }
    
    public void testhyppaaSana(){
        assertEquals("and B", Generoijatoiminnot.hyppaaSana("A and B"));
        assertEquals("enpäs hyppää", Generoijatoiminnot.hyppaaSana(" enpäs hyppää"));
    }
    
    public void testhyppaaTyhja(){
        assertEquals("i", Generoijatoiminnot.hyppaaTyhja("     i"));
        assertEquals("i     i", Generoijatoiminnot.hyppaaTyhja("i     i"));
    }
    
    public void testannaTulevaSana(){
        assertEquals("Olen", Generoijatoiminnot.annaTulevaSana("Olen paras"));
    }
    
    public void testannaSulkeidenSisainenAlue(){
        assertEquals(" A and B )", Generoijatoiminnot.annaSulkeidenSisainenAlue(" A and B ) or C"));
    }
    
    public void testhyppaaSulkeet() {
        assertEquals("or C", Generoijatoiminnot.hyppaaSulkeet(" A and B ) or C"));
    }
    
    public void testhyppaaYksi() {
        assertEquals(" A and B ) or C", Generoijatoiminnot.hyppaaYksi("( A and B ) or C"));
    }
}
