/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totgen.generoijat;

import totgen.laskurit.Sanahyppyri;
import totgen.laskurit.Suljelaskuri;
import totgen.laskurit.Tyhjahyppyri;
import totgen.lauseenkomponentit.Komponentti;
import totgen.taulut.Propositiotaulu;

/**
 *
 * @author alrial@cs
 */
public class AlilauseNegaatiogeneroija {

    private String syote;
    private Komponentti[] komponentit;

    public AlilauseNegaatiogeneroija(String syote) {
        this.syote = syote;
        this.komponentit = new Komponentti[2];
    }

    public Komponentti generoi(Propositiotaulu propositiot) {
        Suljelaskuri suljelaskuri = new Suljelaskuri();
        Tyhjahyppyri tyhjahyppyri = new Tyhjahyppyri();
        
        
        
        String omaKomponenttiSana = this.syote.substring(0, 3);
        this.syote = this.syote.substring(3);
        this.syote = Generoijatoiminnot.hyppaaTyhja(this.syote);
        if (this.syote.substring(0, 1).contentEquals("(")) {
            this.syote = Generoijatoiminnot.hyppaaYksi(this.syote);
            this.syote = Generoijatoiminnot.annaSulkeidenSisainenAlue(this.syote);
            Alilausegeneroija generoija1 = new Alilausegeneroija(this.syote);
            this.komponentit[0] = generoija1.generoi(propositiot);
        }else{
                
        Alilausegeneroija generoija1 = new Alilausegeneroija(this.syote);
        this.komponentit[0] = generoija1.generoi(propositiot);
        
        }
        
        Generoijaluoja generoijaluoja = new Generoijaluoja();
        Komponentti komponentti = generoijaluoja.luo(omaKomponenttiSana, this.komponentit);
        

        return komponentti;
    }
}
