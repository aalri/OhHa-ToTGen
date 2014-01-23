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

        Suljelaskuri suljelaskuri = new Suljelaskuri();
        Sanahyppyri sanahyppyri = new Sanahyppyri();
        Tyhjahyppyri tyhjahyppyri = new Tyhjahyppyri();

        int hyppy = tyhjahyppyri.hyppaaTyhja(this.syote);
        this.syote = this.syote.substring(hyppy);

        String ekaKomponenttiSyote;
        String yhdenPropositionTarkistaja = this.syote;
        yhdenPropositionTarkistaja = yhdenPropositionTarkistaja.substring(sanahyppyri.hyppaaTulevaSana(yhdenPropositionTarkistaja));
        yhdenPropositionTarkistaja = yhdenPropositionTarkistaja.substring(tyhjahyppyri.hyppaaTyhja(yhdenPropositionTarkistaja));

        if (yhdenPropositionTarkistaja.length() == 0) {
            ekaKomponenttiSyote = this.syote;
            propositiot.LisaaPropositio(ekaKomponenttiSyote);
            System.out.println("LöytyPropositio: " + ekaKomponenttiSyote);
            return propositiot.getPropositioTaulu().get(ekaKomponenttiSyote);

        } else {
            if (this.syote.substring(0, 3).contentEquals("not")) {
                ekaKomponenttiSyote = this.syote.substring(4);
                ekaKomponenttiSyote = ekaKomponenttiSyote.substring(tyhjahyppyri.hyppaaTyhja(this.syote));
                this.syote = this.syote.substring(0, 3);

                if (ekaKomponenttiSyote.substring(0, 1).contentEquals("(")) {
                    ekaKomponenttiSyote = ekaKomponenttiSyote.substring(1, suljelaskuri.kunnesAliSulkeetLoppuu(ekaKomponenttiSyote));
                    Alilausegeneroija generoija1 = new Alilausegeneroija(ekaKomponenttiSyote);
                    this.komponentit[0] = generoija1.generoi(propositiot);
                } else {
                    System.out.println(ekaKomponenttiSyote);
                    Alilausegeneroija generoija1 = new Alilausegeneroija(ekaKomponenttiSyote);
                    this.komponentit[0] = generoija1.generoi(propositiot);
                }

            } else {

                if (this.syote.substring(0, 1).contentEquals("(")) {
                    this.syote = this.syote.substring(1);
                    hyppy = suljelaskuri.kunnesAliSulkeetLoppuu(this.syote);
                    ekaKomponenttiSyote = this.syote.substring(0, hyppy);
                    this.syote = this.syote.substring(hyppy);
                    Alilausegeneroija generoija1 = new Alilausegeneroija(ekaKomponenttiSyote);
                    this.komponentit[0] = generoija1.generoi(propositiot);

                } else {
                    ekaKomponenttiSyote = this.syote.substring(0, sanahyppyri.hyppaaTulevaSana(this.syote));
                    propositiot.LisaaPropositio(ekaKomponenttiSyote);
                    System.out.println("LöytyPropositio: " + ekaKomponenttiSyote);
                    this.syote = this.syote.substring(sanahyppyri.hyppaaTulevaSana(this.syote));
                    this.komponentit[0] = propositiot.getPropositioTaulu().get(ekaKomponenttiSyote);
                }

                hyppy = tyhjahyppyri.hyppaaTyhja(this.syote);
                this.syote = this.syote.substring(hyppy);

                String toinenKomponenttiSyote = this.syote.substring(hyppy);
                toinenKomponenttiSyote = toinenKomponenttiSyote.substring(sanahyppyri.hyppaaTulevaSana(toinenKomponenttiSyote));
                toinenKomponenttiSyote = toinenKomponenttiSyote.substring(tyhjahyppyri.hyppaaTyhja(toinenKomponenttiSyote));
                System.out.println(toinenKomponenttiSyote);
                if (toinenKomponenttiSyote.substring(0, 1).contentEquals("(")) {
                    hyppy = suljelaskuri.kunnesAliSulkeetLoppuu(toinenKomponenttiSyote);
                    toinenKomponenttiSyote = toinenKomponenttiSyote.substring(1, hyppy);
                    this.syote = this.syote.substring(0, sanahyppyri.hyppaaTulevaSana(this.syote));
                    Alilausegeneroija generoija2 = new Alilausegeneroija(toinenKomponenttiSyote);
                    this.komponentit[1] = generoija2.generoi(propositiot);

                } else {
                    hyppy = tyhjahyppyri.hyppaaTyhja(toinenKomponenttiSyote);
                    toinenKomponenttiSyote = toinenKomponenttiSyote.substring(hyppy, sanahyppyri.hyppaaTulevaSana(toinenKomponenttiSyote));
                    propositiot.LisaaPropositio(toinenKomponenttiSyote);
                    System.out.println("LöytyPropositio2: " + toinenKomponenttiSyote);
                    this.syote = this.syote.substring(0, sanahyppyri.hyppaaTulevaSana(this.syote));
                    this.komponentit[1] = propositiot.getPropositioTaulu().get(toinenKomponenttiSyote);
                }
            }
        }
        Generoijaluoja generoijaluoja = new Generoijaluoja();
        Komponentti komponentti = generoijaluoja.luo(this.syote, this.komponentit);

        return komponentti;
    }
}
