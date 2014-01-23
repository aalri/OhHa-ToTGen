/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totgen.domain;

import totgen.taulut.Vaihtoehtotaulu;
import java.util.ArrayList;
import totgen.lauseenkomponentit.Propositio;

/**
 *
 * @author alrial@cs
 */
public class Totuustaulu {

    private String syote;

    public Totuustaulu(String syote) {
        this.syote = syote;
    }

    public void luoTotuustaulu() {
        Generaattori generaattori = new Generaattori();
        Lause lause = generaattori.generoi(syote);
        ArrayList<Propositio> lista = lause.getPropositiolista();
        int[] taulu = new int[lista.size()];
        Vaihtoehtotaulu vaihtoehtotaulu = new Vaihtoehtotaulu();
        ArrayList<int[]> vaihtoehdot = luovaihtoehdot(lista.size(), taulu, vaihtoehtotaulu);
        for (String p:lause.getPropositiotaulu().keySet()) {
            System.out.print(" " + p + " | ");
        }
        System.out.print(syote);
        System.out.println("");
        for (int i = 0; i < vaihtoehdot.size(); i++) {
            System.out.println(lause.muodostaTotuusrivi(vaihtoehdot.get(i)));
        }
    }

    public ArrayList<int[]> luovaihtoehdot(int pituus, int[] taulu, Vaihtoehtotaulu vaihtoehtotaulu) {
        if (pituus > 0) {
            for (int i = 1; i >= 0; i--) {                            
                taulu[pituus-1] = i;
                int[] uusi = new int[taulu.length];
                for (int j = 0; j < taulu.length; j++) {
                    uusi[j] = taulu[j];
                }
                luovaihtoehdot(pituus - 1, uusi, vaihtoehtotaulu);
            }
        } else {
            int[] uusi = new int[taulu.length];
            for (int i = 0; i < taulu.length; i++) {
                uusi[i] = taulu[i];
            }
            vaihtoehtotaulu.getTaulu().add(uusi);
        }
        return vaihtoehtotaulu.getTaulu();
    }
}
