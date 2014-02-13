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
 * Generoijatoiminnot luokka, joka sisältää staattisia metodeja pääosin
 * generoijat pakkauksen luokkien käyttöön.
 *
 */
public class Generoijatoiminnot {

    /**
     * Metodi selvittaa että syote sisaltaa vain tyhjaa, merkkijonon ja tyhjaa,
     *
     *
     * @param syote Kutsujan syote
     *
     * @return boolean onko tyhja.
     *
     */
    public static boolean lauseSisaltaaVainYhdenProposition(String syote) {

        String yhdenPropositionTarkistaja = syote;
        yhdenPropositionTarkistaja = hyppaaSana(yhdenPropositionTarkistaja);
        return (yhdenPropositionTarkistaja.isEmpty());
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
        return (syote.length() == 0 || (syote.length() >= 1 && 0 == tyhjahyppyri.hyppaaTyhja(syote) && (!syote.substring(0, 1).contentEquals(")"))));
    }

    /**
     * Metodi selvittaa että onko syotteessa seuraavana oleva merkkijono
     * negaatiota ilmaiseva, ja onko sen jälkeen vielä syotetta;
     *
     *
     * @param syote Kutsujan syote
     *
     * @return boolean onko negaatiota ilmaiseva.
     *
     */
    public static boolean komponenttiOnNegaatio(String syote) {

        return ((syote.length() >= 5 && annaTulevaSana(syote).contentEquals("not")) || (syote.length() >= 3 && annaTulevaSana(syote).contentEquals("¬")));

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

        String negaatiolause = syote;
        syote = hyppaaSana(syote);

        if (komponenttiKoostuuSulkeidenSisallaOlevastaKokonaisuudesta(syote)) {
            syote = hyppaaYksi(syote);
            syote = hyppaaSulkeet(syote);
            syote = hyppaaTyhja(syote);
            AlilauseNegaatiogeneroija generoija1 = new AlilauseNegaatiogeneroija(negaatiolause);
            komponentit[paikka] = generoija1.generoi(propositiot);

        } else {
            AlilauseNegaatiogeneroija generoija1 = new AlilauseNegaatiogeneroija(negaatiolause);
            komponentit[paikka] = generoija1.generoi(propositiot);
            syote = hyppaaSana(syote);
        }

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

        if (komponenttiKoostuuSulkeidenSisallaOlevastaKokonaisuudesta(syote)) {
            syote = hyppaaYksi(syote);
            String muuttosyote = annaSulkeidenSisainenAlue(syote);
            syote = hyppaaSulkeet(syote);
            Alilausegeneroija generoija2 = new Alilausegeneroija(muuttosyote);
            komponentit[paikka] = generoija2.generoi(propositiot);

        } else {
            syote = hyppaaTyhja(syote);
            komponentit[paikka] = propositiot.lisaaPropositio(annaTulevaSana(syote));
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
     * Metodi palauttaa parametrina annetusta Syoteesta merkkijonon ennen tyhjaa
     * tai suljetta.
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
     * Metodi palauttaa parametrina annetusta Syoteesta tulevan sulkeiden
     * sisaisen alueen merkkijonon.
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
     * Metodi hyppaa parametrina annetusta Syoteesta tulevan sulkeiden sisaisen
     * alueen merkkijonon ja antaa loput.
     *
     *
     * @param syote Kutsujan syote
     *
     * @return String hypatysta tulevasta sulkeiden sisaisen alueen
     * merkkijonosta loput.
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

    /**
     * Metodi tarkistaa että syöte sisältää vain kaksi komponenttia, joista
     * ensimmäinen on negaatiota ilmaiseva sana, ja jälkimmäinen on joko
     * yksittäinen propositio, tai sulkeiden sisäinen alue. Eikä ole mitään
     * muuta.
     *
     *
     * @param syote Kutsujan syote
     *
     * @return boolean ei ollut muuta.
     *
     */
    public static boolean lauseSisaltaaVainYhdenNegaatioKomponentin(String syote) {
        if (annaTulevaSana(syote).contentEquals("not") || annaTulevaSana(syote).contentEquals("¬")) {
            syote = hyppaaSana(syote);
            if (komponenttiKoostuuSulkeidenSisallaOlevastaKokonaisuudesta(syote)) {
                syote = hyppaaYksi(syote);
                syote = hyppaaSulkeet(syote);
                syote = hyppaaTyhja(syote);
                return syote.length() == 0;
            } else {
                syote = hyppaaSana(syote);
                return syote.length() == 0;
            }
        }
        return false;
    }

    /**
     * Metodi kutsuu muutaNegaatioKomponentiksiSekaPalautaMuuLause metodia, ja
     * palauttaa kutsutulle metodille parametrina annetun komponenttitaulun
     * ainoan komponentin. Tällä kierretään metodin
     * muutaNegaatioKomponentiksiSekaPalautaMuuLause rajoitus tarjota pelkästään
     * loput syötteestä.
     *
     * @param syote Kutsujan syote.
     * @param propositiot Kutsujan kayttama julkinen propositiotaulu.
     *
     * @return Negaatio komponentti.
     *
     */
    public static Komponentti palautaNegaatioKomponentti(String syote, Propositiotaulu propositiot) {
        Komponentti[] komponentit = new Komponentti[1];
        muutaNegaatioKomponentiksiSekaPalautaMuuLause(syote, komponentit, 0, propositiot);
        return komponentit[0];
    }

    /**
     * Metodi tarkistaa että syöte sisältää vain sulje alueen. Eikä ole mitään
     * muuta.
     *
     *
     * @param syote Kutsujan syote
     *
     * @return boolean ei ollut muuta.
     *
     */
    public static boolean lauseSisaltaaVainYhdenSuljeKomponentin(String syote) {
        if (syote.substring(0, 1).contentEquals("(")) {
            syote = hyppaaYksi(syote);
            syote = hyppaaSulkeet(syote);
            return syote.length() == 0;
        }
        return false;
    }

    /**
     * Metodi kutsuu muutaKomponentiksiSekaPalautaMuuLause metodia, ja
     * palauttaa kutsutulle metodille parametrina annetun komponenttitaulun
     * ainoan komponentin. Tällä kierretään metodin
     * muutaKomponentiksiSekaPalautaMuuLause rajoitus tarjota pelkästään
     * loput syötteestä.
     *
     * @param syote Kutsujan syote.
     * @param propositiot Kutsujan kayttama julkinen propositiotaulu.
     *
     * @return Komponentti komponentti.
     *
     */
    public static Komponentti palautaKomponentti(String syote, Propositiotaulu propositiot) {
        Komponentti[] komponentit = new Komponentti[1];
        muutaKomponentiksiSekaPalautaMuuLause(syote, komponentit, 0, propositiot);
        return komponentit[0];
    }
}
