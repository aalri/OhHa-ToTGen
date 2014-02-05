/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package totgen.syntaksinlukijat;

import totgen.laskurit.Tyhjahyppyri;

/**
 *
 * @author Riku
 */
public class TyhjienSulkuvalienLukija implements Syntaksinlukija {
    
  @Override
    public boolean lue(String syote) {
        Tyhjahyppyri tyhjahyppyri = new Tyhjahyppyri();
        
        int osoitin = 0;
        while(osoitin < syote.length()){
            if(syote.substring(osoitin, osoitin+1).contentEquals(")")){
                if(syote.substring(osoitin).length() >= 2 && syote.substring(osoitin, osoitin+2).contentEquals(")(")){
                    return false;
                }
                osoitin += tyhjahyppyri.hyppaaTyhja(syote.substring(osoitin+1));
                if (syote.substring(osoitin).length() >= 2 && syote.substring(osoitin+1, osoitin+2).contentEquals("(")){
                    return false;
                }
            }
            osoitin ++;
        }
        return true;
    }

    @Override
    public String virheilmoitus() {
        return "Joidenkin sulkujen ulkopuolten välissä ei ole mitään.";
    }
    
}
