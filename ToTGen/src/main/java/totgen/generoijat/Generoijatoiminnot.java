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
/**
 *
 *
 *
 *
 *
 * Generoijatoiminnot luokka, joka sisältää metodeja pääosin generoijat
 * pakkauksen luokkien käyttöön.
 *
 */
public class Generoijatoiminnot {

    /**
     * Metodi selvittaa että syote sisaltaa vain tyhjaa merkkijonon ja tyhjaa,
     *
     *
     * @param syote Kutsujan syote
     *
     * @return boolean onko tyhja.
     *
     */
    public static boolean lauseSisaltaaVainYhdenProposition(String syote) {
        Sanahyppyri sanahyppyri = new Sanahyppyri();
        Tyhjahyppyri tyhjahyppyri = new Tyhjahyppyri();

        String yhdenPropositionTarkistaja = syote;
        yhdenPropositionTarkistaja = yhdenPropositionTarkistaja.substring(sanahyppyri.hyppaaTulevaSana(yhdenPropositionTarkistaja));
        yhdenPropositionTarkistaja = yhdenPropositionTarkistaja.substring(tyhjahyppyri.hyppaaTyhja(yhdenPropositionTarkistaja));

        return (yhdenPropositionTarkistaja.length() == 0);
    }

    /**
     * Metodi selvittaa että syotteessa seuraavana oleva merkkijono ei ole tyhja
     * tai sulje ")";
     *
     *
     * @param syote Kutsujan syote
     *
     * @return boolean onko merkkijonoa, joka ei ole tyhja tai sulje ")".
     *
     */
    public static boolean kyseessaPropositio(String syote) {
        Tyhjahyppyri tyhjahyppyri = new Tyhjahyppyri();

        return syote.length() >= 1 && 0 == tyhjahyppyri.hyppaaTyhja(syote) && (!syote.substring(0, 1).contentEquals(")"));
    }

    /**
     * Metodi selvittaa että onko syotteessa seuraavana oleva merkkijono
     * negaatiota ilmaiseva;
     *
     *
     * @param syote Kutsujan syote
     *
     * @return boolean onko negaatiota ilmaiseva.
     *
     */
    public static boolean komponenttiOnNegaatio(String syote) {

        return ((syote.length() >= 5 && syote.substring(0, 3).contentEquals("not")) || (syote.length() >= 3 && syote.substring(0, 1).contentEquals("¬")));

    }

    /**
     * Metodi selvittaa että onko syotteessa seuraavana oleva merkki alkava
     * sulje "(";
     *
     *
     * @param syote Kutsujan syote
     *
     * @return boolean onko alkava sulje.
     *
     */
    public static boolean komponenttiKoostuuSulkeidenSisallaOlevastaKokonaisuudesta(String syote) {

        return syote.length() > 1 && syote.substring(0, 1).contentEquals("(");
    }

    /**
     * Metodi luo uuden AlilauseNegaatiogeneroijan, ja antaa sille sisällä
     * olevan merkkijonon tai yksittäisen sanan, ja propositioiden
     * kartoittamiseen kaytettava propositiotaulun. Metodi sitten palauttaa
     * Alilausenegaatiogeneroijanluoman komponentin, ja sijoittaa sen kutsujan
     * parametreissa annetussa komponentti taulussa annettuun paikkaan. Metodi
     * myös palauttaa loput syotteesta mitä ei tarkoitettu
     * AlilauseNegaatiogeneroijan käyttöön.
     *
     * @param syote Kutsujan syote
     * @param komponentit Kutsujan komponentit
     * @param paikka Kutsujan komponentti tauluun komponentin sijoituspaikka
     * @param propositiot Kutsujan kayttama julkinen propositiotaulu.
     *
     * @return String loput syotteesta.
     *
     */
    public static String muutaNegaatioKomponentiksiSekaPalautaMuuLause(String syote, Komponentti[] komponentit, int paikka, Propositiotaulu propositiot) {
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

    /**
     * Metodi luo uuden Alilausegeneroijan, ja antaa sille sisällä olevan
     * merkkijonon tai yksittäisen sanan, ja propositioiden kartoittamiseen
     * kaytettava propositiotaulun. Metodi sitten palauttaa
     * Alilausenegaatiogeneroijanluoman komponentin, ja sijoittaa sen kutsujan
     * parametreissa annetussa komponentti taulussa annettuun paikkaan. Metodi
     * myös palauttaa loput syotteesta mitä ei tarkoitettu Alilausegeneroijan
     * käyttöön.
     *
     * @param syote Kutsujan syote
     * @param komponentit Kutsujan komponentit
     * @param paikka Kutsujan komponentti tauluun komponentin sijoituspaikka
     * @param propositiot Kutsujan kayttama julkinen propositiotaulu.
     *
     * @return String loput syotteesta.
     *
     */
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
            propositiot.lisaaPropositio(annaTulevaSana(syote));
            komponentit[paikka] = propositiot.getPropositioTaulu().get(annaTulevaSana(syote));
            syote = hyppaaSana(syote);
        }
        return syote;
    }

    /**
     * Metodi palauttaa parametrina annetusta Syoteesta version, mistä on
     * hypätty tulevat muut kuin tyhjat merkit, ja tyhjää.
     *
     *
     * @param syote Kutsujan syote
     *
     * @return String loput syotteesta.
     *
     */
    public static String hyppaaSana(String syote) {
        Sanahyppyri sanahyppyri = new Sanahyppyri();
        Tyhjahyppyri tyhjahyppyri = new Tyhjahyppyri();
        syote = syote.substring(sanahyppyri.hyppaaTulevaSana(syote));
        syote = syote.substring(tyhjahyppyri.hyppaaTyhja(syote));
        return syote;
    }

    /**
     * Metodi palauttaa parametrina annetusta Syoteesta version, mistä on
     * hypätty tuleva tyhjä alue.
     *
     *
     * @param syote Kutsujan syote
     *
     * @return String loput syotteesta.
     *
     */
    public static String hyppaaTyhja(String syote) {
        Tyhjahyppyri tyhjahyppyri = new Tyhjahyppyri();

        return syote.substring(tyhjahyppyri.hyppaaTyhja(syote));
    }

    /**
     * Metodi palauttaa parametrina annetusta Syoteesta merkkijonon ennen tyhjaa tai suljetta.
     *
     *
     * @param syote Kutsujan syote
     *
     * @return String tuleva merkkijono ennen tyhjaa tai suljetta.
     *
     */
    public static String annaTulevaSana(String syote) {
        Sanahyppyri sanahyppyri = new Sanahyppyri();

        return syote.substring(0, sanahyppyri.hyppaaTulevaSana(syote));
    }
    
   /**
     * Metodi palauttaa parametrina annetusta Syoteesta tulevan sulkeiden sisaisen alueen merkkijonon.
     *
     *
     * @param syote Kutsujan syote
     *
     * @return String tuleva sulkeiden sisaisen alueen merkkijono.
     *
     */
    public static String annaSulkeidenSisainenAlue(String syote) {
        Suljelaskuri suljelaskuri = new Suljelaskuri();

        return syote.substring(0, suljelaskuri.kunnesAliSulkeetLoppuu(syote) - 1);
    }

   /**
     * Metodi hyppaa parametrina annetusta Syoteesta tulevan sulkeiden sisaisen alueen merkkijonon ja antaa loput.
     *
     *
     * @param syote Kutsujan syote
     *
     * @return String  hypatysta tulevasta sulkeiden sisaisen alueen merkkijonosta loput.
     *
     */
    public static String hyppaaSulkeet(String syote) {
        Suljelaskuri suljelaskuri = new Suljelaskuri();

        return syote.substring(suljelaskuri.kunnesAliSulkeetLoppuu(syote));
    }
    
   /**
     * Metodi hyppää syotteestä yhden merkin ja antaa loput.
     *
     *
     * @param syote Kutsujan syote
     *
     * @return String syote ilman ekaa merkkiä.
     *
     */
    public static String hyppaaYksi(String syote) {

        return syote.substring(1);
    }

}
