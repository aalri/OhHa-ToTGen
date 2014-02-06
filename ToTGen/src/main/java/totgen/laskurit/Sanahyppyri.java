/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totgen.laskurit;

/**
 *
 * @author alrial
 * 
 */

/**
    * 
    * 
    * 
    *
    * 
    * Sanahyppyri luokka, jonka metodi laskee matkan sanan päättymiseen.
    * 
    */

public class Sanahyppyri {

    public Sanahyppyri() {

    }
    
    /**
    * Metodi selvittaa kuinka monta kirjainta on matkaa tulevaan tyhjaan tai sulkukaareen ")" syotteen alusta.
    * 
    *
    * @param   syote Kutsujan syote
    * 
    * @return matka palauttaa matkan seuraavaan tyhjaan tai sulkukaareen ")"
    */

    public int hyppaaTulevaSana(String syote) {
        int matka = 0;
        while (matka < syote.length()&&(!syote.substring(matka, matka+1).contentEquals(" ") ) && (!syote.substring(matka, matka+1).contentEquals(")"))) {
            matka++;
        }
        return matka;
    }
}
