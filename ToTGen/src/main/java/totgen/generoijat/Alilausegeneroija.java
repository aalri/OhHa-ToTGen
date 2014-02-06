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
/**
 *
 *
 *
 *
 *
 * Alilausegeneroija luokka, jonka metodi tulkitsee Alilausegeneroija oliolle
 * annettua syotettä ei neegatiossa käytetyn logiikan mukaan.
 *
 *
 */
public class Alilausegeneroija {

    /**
     * Alilausegeneroijan tulkittava syote
     */
    private String syote;
    /**
     * Alilausegenroijan liitettavat komponentit 
     */
    private Komponentti[] komponentit;

    public Alilausegeneroija(String syote) {
        this.syote = syote;
        this.komponentit = new Komponentti[2];

    }
    
   /**
     * Metodi tulkitsee syötettä,ja kutsuu muita metodeja luomaan syötteestä sille kuuluvat alikomponentit.
     * Sitten metodi kutsuu Generoijaluojaa luomaan oman komponenttinsa ja palauttaa sen.
     * 
     * Mutta jos syote koostuu vain yhdestä propositiosta, se yrittää lisätä sen parametrina annettuun propositiotauluun,
     * ja kutsuu propositiotaululta komponenttia ja palauttaa sen.
     *
     * @param propositiot
     *
     * @return oma paakomponentti.
     *
     */

    public Komponentti generoi(Propositiotaulu propositiot) {

        this.syote = Generoijatoiminnot.hyppaaTyhja(this.syote);

        String ekaKomponenttiSyote;

        if (Generoijatoiminnot.lauseSisaltaaVainYhdenProposition(this.syote)) {
            ekaKomponenttiSyote = this.syote;  
            return propositiot.lisaaPropositio(ekaKomponenttiSyote);            

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
