/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totgen.laskurit;

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
 * Suljelaskuri luokka, jonka metodi laskee matkan suljealueen päättymiseen.
 *
 */
public class Suljelaskuri {

    public Suljelaskuri() {

    }

    /**
     * Metodi selvittaa kuinka monta kirjainta on matkaa oman sulkualueen
     * päättymiseen syotteen alusta. Metodi aloittaa yhdellä "(" alkavalla
     * sulkeella ja laskee jokaisen uuden vastaantulevan "(" alkavan sulkeen, ja
     * päättää matkan laskennan vasta, kun päättyviä sulkeita on tullut vastaan
     * tasoittava määrä.
     *
     *
     *
     * @param syote Kutsujan syote
     *
     * @return matka palauttaa matkan sulkualueen päättymiseen.
     *
     */
    public int kunnesAliSulkeetLoppuu(String syote) {

        int Sulkeet = 1;
        int matka = 0;
        for (int j = 0; j < syote.length(); j++) {
            matka++;
            if (Sulkeet == 0) {
                break;
            }
            if (syote.substring(j, j + 1).equals("(")) {
                Sulkeet++;
            }
            if (syote.substring(j, j + 1).equals(")")) {
                Sulkeet--;
            }
        }
        return matka;
    }

}
