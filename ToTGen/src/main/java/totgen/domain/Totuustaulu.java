/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totgen.domain;

import totgen.taulut.Vaihtoehtotaulu;
import java.util.ArrayList;
import java.util.Collections;
import totgen.lauseenkomponentit.Propositio;
import totgen.syntaksinlukijat.Sulkujenlukija;
import totgen.syntaksinlukijat.Syntaksinlukija;
import totgen.syntaksinlukijat.TyhjienSulkujenlukija;

/**
 *
 * @author alrial@cs
 */
public class Totuustaulu {

    private String syote;
    private ArrayList<Syntaksinlukija> syntaksinlukijat;
    private String[] propositiot;
    private String[][] totuudet;

    public Totuustaulu(String syote) {
        this.syntaksinlukijat = new ArrayList<Syntaksinlukija>();
        this.syntaksinlukijat.add(new Sulkujenlukija());
        this.syntaksinlukijat.add(new TyhjienSulkujenlukija());
        this.syote = syote;
    }

    public String tarkistaSyntaksi() {
        for (Syntaksinlukija s : this.syntaksinlukijat) {
            if (!s.lue(syote)) {
                return s.virheilmoitus();
            }
        }
        return "true";
    }

    public void luoTotuustaulu() {

        Generaattori generaattori = new Generaattori();
        Lause lause = generaattori.generoi(syote);
        ArrayList<Propositio> lista = lause.getPropositiolista();
        int[] taulu = new int[lista.size()];
        Vaihtoehtotaulu vaihtoehtotaulu = new Vaihtoehtotaulu();
        ArrayList<int[]> vaihtoehdot = luovaihtoehdot(lista.size(), taulu, vaihtoehtotaulu);
        int propositiotaulukoko = lause.getPropositiotaulu().keySet().size() + 1;
        this.propositiot = new String[propositiotaulukoko];
        ArrayList <String> proposit = new ArrayList<String>();
        for (String p : lause.getPropositiotaulu().keySet()) {
            proposit.add(p);
        }
        Collections.sort(proposit);
        int pituus = 0;
        for (String p : proposit) {
            this.propositiot[pituus] = p;
            System.out.print(" " + p + " | ");
            pituus++;
        }
        System.out.print(syote);
        this.propositiot[pituus] = syote;
        System.out.println("");
        this.totuudet = new String[vaihtoehdot.size()][vaihtoehdot.get(0).length];
        for (int i = 0; i < vaihtoehdot.size(); i++) {
            System.out.println(lause.muodostaTotuusrivi(vaihtoehdot.get(i)));
            String[] rivi = lause.muodostaTotuusrivilista(vaihtoehdot.get(i));
            this.totuudet[i] = rivi;
        }
    }

    public ArrayList<int[]> luovaihtoehdot(int pituus, int[] taulu, Vaihtoehtotaulu vaihtoehtotaulu) {
        if (pituus > 0) {
            for (int i = 1; i >= 0; i--) {
                taulu[pituus - 1] = i;
                int[] uusi = new int[taulu.length];
                for (int j = 0; j < taulu.length; j++) {
                    uusi[j] = taulu[j];
                }
                luovaihtoehdot(pituus - 1, uusi, vaihtoehtotaulu);
            }
        } else {
            int[] uusi = new int[taulu.length + 1];
            for (int i = 0; i < taulu.length; i++) {
                uusi[i] = taulu[i];
            }
            vaihtoehtotaulu.getTaulu().add(uusi);
        }
        return vaihtoehtotaulu.getTaulu();
    }

    public String[] getPropositiot() {
        return this.propositiot;
    }

    public String[][] getTotuudet() {
        return this.totuudet;
    }
}
