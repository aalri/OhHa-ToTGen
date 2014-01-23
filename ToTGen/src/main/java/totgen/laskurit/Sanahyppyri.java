/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totgen.laskurit;

/**
 *
 * @author alrial
 */
public class Sanahyppyri {

    public Sanahyppyri() {

    }

    public int hyppaaTulevaSana(String syote) {
        int alku = 0;
        while (alku < syote.length()&&(!syote.substring(alku, alku+1).contentEquals(" "))) {
            alku++;
        }
        return alku;
    }
}
