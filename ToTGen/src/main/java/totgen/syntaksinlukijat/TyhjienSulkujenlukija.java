/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package totgen.syntaksinlukijat;

import totgen.laskurit.Tyhjahyppyri;

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
 * Sulkujenlukija luokka, jonka tarkoituksena on tarkistaa ettei sulkujen sisalla ole tyhjaa.
 *
 *
 */
public class TyhjienSulkujenlukija implements Syntaksinlukija{

    /**
     * Metodi tarkistaa tyhjähyppyrin avulla että sulun alun,
     * ja tulevan lopun välissä ei ole pelkästään tyhjää.
     *
     * 
     * @param syote Kutsujan syote
     * @return ei tyhjaa
     */
    @Override
    public boolean lue(String syote) {
        Tyhjahyppyri tyhjahyppyri = new Tyhjahyppyri();
        
        int osoitin = 0;
        while(osoitin < syote.length()){
            if(syote.substring(osoitin, osoitin+1).contentEquals("(")){
                osoitin += tyhjahyppyri.hyppaaTyhja(syote.substring(osoitin+1));
                if (syote.substring(osoitin).length() >= 2 && syote.substring(osoitin+1, osoitin+2).contentEquals(")")){
                    return false;
                }
            }
            osoitin ++;
        }
        return true;
    }
    
    /**
     * Metodi palauttaa virheilmoituksen.
     */
    @Override
    public String virheilmoitus() {
        return "Jotkut sulut eivät sisällä mitään.";
    }
    
}
