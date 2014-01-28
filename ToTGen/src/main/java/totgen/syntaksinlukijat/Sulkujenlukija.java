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
public class Sulkujenlukija implements Syntaksinlukija {

    @Override
    public boolean lue(String syote) {
        int sulut = 0;
        for (int i = 0; i < syote.length(); i++) {            
            if (syote.substring(i, i + 1).contentEquals("(")) {
                sulut++;
            } else if (syote.substring(i, i + 1).contentEquals(")")) {
                sulut--;
            }
        }
        if (sulut == 0) {
            return true;
        }
        return false;
    }

    @Override
    public String virheilmoitus() {
        return "Virhe sulkujen määrässä. Tarkista sulut.";
    }

}
