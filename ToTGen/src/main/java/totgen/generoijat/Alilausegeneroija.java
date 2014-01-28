/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totgen.generoijat;

import java.util.HashMap;
import totgen.taulut.Propositiotaulu;
import totgen.laskurit.Sanahyppyri;
import totgen.laskurit.Suljelaskuri;
import totgen.laskurit.Tyhjahyppyri;
import totgen.lauseenkomponentit.Komponentti;
import totgen.lauseenkomponentit.Propositio;

/**
 *
 * @author alrial@cs
 */
public class Alilausegeneroija {

    private String syote;
    private Komponentti[] komponentit;

    public Alilausegeneroija(String syote) {
        this.syote = syote;
        this.komponentit = new Komponentti[2];

    }

    public Komponentti generoi(Propositiotaulu propositiot) {
        

        this.syote = Generoijatoiminnot.hyppaaTyhja(this.syote);        

        String ekaKomponenttiSyote;

        if (Generoijatoiminnot.lauseSisaltaaVainYhdenProposition(this.syote)) {
            ekaKomponenttiSyote = this.syote;
            propositiot.LisaaPropositio(ekaKomponenttiSyote);
            return propositiot.getPropositioTaulu().get(ekaKomponenttiSyote);

        } else {
            if (Generoijatoiminnot.komponenttiOnNegaatio(this.syote)) {
                
                this.syote = Generoijatoiminnot.muutaNegaatioKomponentiksiSekaPalautaMuuLause(this.syote, this.komponentit, 0, propositiot);
                
            } else {
                this.syote = Generoijatoiminnot.muutaKomponentiksiSekaPalautaMuuLause(this.syote, this.komponentit, 0, propositiot);
            }
        }

        this.syote = Generoijatoiminnot.hyppaaTyhja(this.syote);
        String omaKomponenttiSana = Generoijatoiminnot.annaTulevaSana(this.syote);
        this.syote = Generoijatoiminnot.hyppaaSana(this.syote);
        
        if (Generoijatoiminnot.komponenttiOnNegaatio(this.syote)) {
            this.syote = Generoijatoiminnot.muutaNegaatioKomponentiksiSekaPalautaMuuLause(this.syote, this.komponentit, 1, propositiot);

        } else {
            this.syote = Generoijatoiminnot.muutaKomponentiksiSekaPalautaMuuLause(this.syote, this.komponentit, 1, propositiot);

        }        
     
        Generoijaluoja generoijaluoja = new Generoijaluoja();
        Komponentti komponentti = generoijaluoja.luo(omaKomponenttiSana, this.komponentit);

        return komponentti;
    }
}
