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
public class Generoijatoiminnot {

    public static boolean lauseSisaltaaVainYhdenProposition(String syote) {
        Sanahyppyri sanahyppyri = new Sanahyppyri();
        Tyhjahyppyri tyhjahyppyri = new Tyhjahyppyri();

        String yhdenPropositionTarkistaja = syote;
        yhdenPropositionTarkistaja = yhdenPropositionTarkistaja.substring(sanahyppyri.hyppaaTulevaSana(yhdenPropositionTarkistaja));
        yhdenPropositionTarkistaja = yhdenPropositionTarkistaja.substring(tyhjahyppyri.hyppaaTyhja(yhdenPropositionTarkistaja));

        return (yhdenPropositionTarkistaja.length() == 0);
    }

    public static boolean kyseessaPropositio(String syote) {
        Tyhjahyppyri tyhjahyppyri = new Tyhjahyppyri();

        return syote.length() >= 1 && 0 == tyhjahyppyri.hyppaaTyhja(syote) && (!syote.substring(0, 1).contentEquals(")"));
    }

    public static boolean komponenttiOnNegaatio(String syote) {

        return ((syote.length() >= 5 && syote.substring(0, 3).contentEquals("not")) || (syote.length() >= 3 && syote.substring(0, 1).contentEquals("¬")));

    }

    public static boolean komponenttiKoostuuSulkeidenSisallaOlevastaKokonaisuudesta(String syote) {

        return syote.length() > 1 && syote.substring(0, 1).contentEquals("(");
    }

    public static String muutaNegaatioKomponentiksiSekaPalautaMuuLause(String syote, Komponentti[] komponentit, int paikka, Propositiotaulu propositiot) {
        Sanahyppyri sanahyppyri = new Sanahyppyri();
        Tyhjahyppyri tyhjahyppyri = new Tyhjahyppyri();
        Suljelaskuri suljelaskuri = new Suljelaskuri();

        String tarkistin = syote.substring(3);
        int tarkistusmatka = 3;
        tarkistusmatka += tyhjahyppyri.hyppaaTyhja(tarkistin);
        tarkistin = tarkistin.substring(tyhjahyppyri.hyppaaTyhja(tarkistin));

        if (komponenttiKoostuuSulkeidenSisallaOlevastaKokonaisuudesta(tarkistin)) {
            tarkistin = hyppaaYksi(tarkistin);
            tarkistusmatka++;
            tarkistusmatka += suljelaskuri.kunnesAliSulkeetLoppuu(tarkistin);
            AlilauseNegaatiogeneroija generoija1 = new AlilauseNegaatiogeneroija(syote);
            komponentit[paikka] = generoija1.generoi(propositiot);
            syote = syote.substring(tarkistusmatka);

        } else {
            AlilauseNegaatiogeneroija generoija1 = new AlilauseNegaatiogeneroija(syote);
            komponentit[paikka] = generoija1.generoi(propositiot);
            syote = hyppaaSana(syote);
            syote = hyppaaTyhja(syote);
            syote = hyppaaSana(syote);
        }

        syote = hyppaaTyhja(syote);
        return syote;
    }

    public static String muutaKomponentiksiSekaPalautaMuuLause(String syote, Komponentti[] komponentit, int paikka, Propositiotaulu propositiot) {
        Sanahyppyri sanahyppyri = new Sanahyppyri();
        Tyhjahyppyri tyhjahyppyri = new Tyhjahyppyri();

        if (komponenttiKoostuuSulkeidenSisallaOlevastaKokonaisuudesta(syote)) {
            syote = hyppaaYksi(syote);
            String muuttosyote = annaSulkeidenSisainenAlue(syote);
            syote = hyppaaSulkeet(syote);
            Alilausegeneroija generoija2 = new Alilausegeneroija(muuttosyote);
            komponentit[paikka] = generoija2.generoi(propositiot);

        } else if (kyseessaPropositio(syote)) {
            syote = hyppaaTyhja(syote);
            propositiot.LisaaPropositio(annaTulevaSana(syote));            
            komponentit[paikka] = propositiot.getPropositioTaulu().get(annaTulevaSana(syote));
            syote = hyppaaSana(syote);
        }
        return syote;
    }

    public static String hyppaaSana(String syote) {
        Sanahyppyri sanahyppyri = new Sanahyppyri();
        Tyhjahyppyri tyhjahyppyri = new Tyhjahyppyri();
        syote = syote.substring(sanahyppyri.hyppaaTulevaSana(syote));
        syote = syote.substring(tyhjahyppyri.hyppaaTyhja(syote));
        return syote;
    }

    public static String hyppaaTyhja(String syote) {
        Tyhjahyppyri tyhjahyppyri = new Tyhjahyppyri();

        return syote.substring(tyhjahyppyri.hyppaaTyhja(syote));
    }

    public static String annaTulevaSana(String syote) {
        Sanahyppyri sanahyppyri = new Sanahyppyri();

        return syote.substring(0, sanahyppyri.hyppaaTulevaSana(syote));
    }

    public static String annaSulkeidenSisainenAlue(String syote) {
        Suljelaskuri suljelaskuri = new Suljelaskuri();

        return syote.substring(0, suljelaskuri.kunnesAliSulkeetLoppuu(syote)-1);
    }

    public static String hyppaaSulkeet(String syote) {
        Suljelaskuri suljelaskuri = new Suljelaskuri();

        return syote.substring(suljelaskuri.kunnesAliSulkeetLoppuu(syote));
    }

    public static String hyppaaYksi(String syote) {

        return syote.substring(1);
    }

}
