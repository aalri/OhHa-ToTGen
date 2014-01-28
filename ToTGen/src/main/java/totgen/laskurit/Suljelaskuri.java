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
public class Suljelaskuri {

    public Suljelaskuri() {

    }

    public int kunnesAliSulkeetLoppuu(String syote) {

        int Sulkeet = 1;
        int etaisyys = 0;
        for (int j = 0; j < syote.length(); j++) {
            etaisyys++;
            if (Sulkeet == 0) {
                break;
            }
            if (syote.substring(j, j+1).equals("(")) {
                Sulkeet++;
            }
            if (syote.substring(j, j+1).equals(")")) {
                Sulkeet--;
            }
        }
        return etaisyys;
    }

}
