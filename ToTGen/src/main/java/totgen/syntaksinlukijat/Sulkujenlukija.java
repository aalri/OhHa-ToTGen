/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totgen.syntaksinlukijat;

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
 * Sulkujenlukija luokka, jonka tarkoituksena on tarkistaa sulkujen oikea maara.
 *
 *
 */
public class Sulkujenlukija implements Syntaksinlukija {

    
    /**
     * Metodi tarkistaa syotteessa olevien sulkujen maaran, 
     * ja jos niita on tasan niin true muuten false.
     *
     * 
     * @param syote Kutsujan syote
     * @return oli tasan
     */
    @Override
    public boolean lue(String syote) {
        int sulut = 0;
        for (int i = 0; i < syote.length(); i++) {            
            if (syote.substring(i, i + 1).contentEquals("(")) {
                sulut++;
            } else if (syote.substring(i, i + 1).contentEquals(")")) {
                sulut--;
            }
            if (sulut < 0){
                return false;
            }
        }
        if (sulut == 0) {
            return true;
        }
        return false;
    }

    /**
     * Metodi palauttaa virheilmoituksen.
     */
    @Override
    public String virheilmoitus() {
        return "Virhe suluissa/niiden määrässä. Tarkista sulut.";
    }

}
