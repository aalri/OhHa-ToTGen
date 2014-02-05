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
import totgen.syntaksinlukijat.TyhjienSulkuvalienLukija;
import totgen.taulut.Propositiotaulu;

/**
 *
 * @author alrial@cs
 */
public class Totuustaulu {

    private String syote;
    private ArrayList<Syntaksinlukija> syntaksinlukijat;
    private Propositiotaulu propositiotaulu;
    private String[] propositiot;
    private String[][] totuudet;    
    private Lause lause;

    public Totuustaulu(String syote) {
        this.syntaksinlukijat = new ArrayList<Syntaksinlukija>();
        this.syntaksinlukijat.add(new Sulkujenlukija());
        this.syntaksinlukijat.add(new TyhjienSulkujenlukija());
        this.syntaksinlukijat.add(new TyhjienSulkuvalienLukija());
        this.syote = syote;
        this.propositiotaulu = new Propositiotaulu();
    }
    
    public Totuustaulu(String syote, Propositiotaulu propositiotaulu) {
        this.syntaksinlukijat = new ArrayList<Syntaksinlukija>();
        this.syntaksinlukijat.add(new Sulkujenlukija());
        this.syntaksinlukijat.add(new TyhjienSulkujenlukija());
        this.syntaksinlukijat.add(new TyhjienSulkuvalienLukija());
        this.syote = syote;
        this.propositiotaulu = propositiotaulu;
    }

    public String tarkistaSyntaksi() {
        for (Syntaksinlukija s : this.syntaksinlukijat) {
            if (!s.lue(this.syote)) {
                return s.virheilmoitus();
            }
        }
        return "true";
    }

    public void luoLause() {

        Generaattori generaattori = new Generaattori(this.propositiotaulu);
        this.lause = generaattori.generoi(this.syote);
    }
    
    public void luoTotuustaulu() {
        ArrayList<Propositio> lista = this.lause.getPropositiolista();
        int[] taulu = new int[lista.size()];
        Vaihtoehtotaulu vaihtoehtotaulu = new Vaihtoehtotaulu();
        ArrayList<int[]> vaihtoehdot = luovaihtoehdot(lista.size(), taulu, vaihtoehtotaulu);
        int propositiotaulukoko = this.lause.getPropositiotaulu().keySet().size() + 1;
        this.propositiot = new String[propositiotaulukoko];
        ArrayList<String> proposit = new ArrayList<String>(this.lause.getPropositiotaulu().keySet());
        Collections.sort(proposit);
        int pituus = 0;
        for (String p : proposit) {
            this.propositiot[pituus] = p;
            System.out.print(" " + p + " | ");
            pituus++;
        }
        System.out.print(this.syote);
        this.propositiot[pituus] = this.syote;
        System.out.println("");
        this.totuudet = new String[vaihtoehdot.size()][vaihtoehdot.get(0).length];
        for (int i = 0; i < vaihtoehdot.size(); i++) {
            System.out.println(this.lause.muodostaTotuusrivi(vaihtoehdot.get(i)));
            String[] rivi = this.lause.muodostaTotuusrivilista(vaihtoehdot.get(i));
            this.totuudet[i] = rivi;
        }
    }

    public ArrayList<int[]> luovaihtoehdot(int pituus, int[] taulu, Vaihtoehtotaulu vaihtoehtotaulu) {
        if (pituus > 0) {
            for (int i = 1; i >= 0; i--) {
                taulu[taulu.length - pituus] = i;
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
