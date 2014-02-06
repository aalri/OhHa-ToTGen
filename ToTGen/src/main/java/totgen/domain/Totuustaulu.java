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
/**
 *
 *
 *
 *
 *
 * Totuustaulu luokka, jonka tarkoituksena on tarkistaa syotteen oikeellisuus, 
 * luoda vaihtoehdot, seka palauttaa totuustaulukko data.
 *
 *
 */
public class Totuustaulu {

    /**
     * Totuustaulun totuustaulutettava syote.
     */
    private String syote;
    
    /**
     * Totuustaulun tarkistuksessa käytettävät syntaksinlukijat.
     */
    private ArrayList<Syntaksinlukija> syntaksinlukijat;
    
    /**
     * Totuustaulun vaihtoehtojen luonnissa käyttämä propositiotaulu.
     */
    private Propositiotaulu propositiotaulu;
    
    /**
     * Totuustaulun propositiot.
     */
    private String[] propositiot;
    
    /**
     * Totuustaulun totuudet taulussa.
     */
    private String[][] totuudet;  
    
    /**
     * Totuustaulun totuuksien muodostamiseen käyttämä syötteestä muodostettu komponentti-puu lause.
     */
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
    
   /**
     * Metodi tulkitsee syötettä,ja tarkistaa sen oikeellisuuden kyselemällä siitä syntaksinlukijoilta,
     *
     *
     *
     * @return String oikeellisuus.
     *
     */

    public String tarkistaSyntaksi() {
        for (Syntaksinlukija s : this.syntaksinlukijat) {
            if (!s.lue(this.syote)) {
                return s.virheilmoitus();
            }
        }
        return "true";
    }
    
   /**
     * Metodi käskee Generaattoria luomaan lauseen, ja asettamaan sen Totuustaulu olion lauseeksi.
     *
     *
     *
     *
     */

    public void luoLause() {

        Generaattori generaattori = new Generaattori(this.propositiotaulu);
        this.lause = generaattori.generoi(this.syote);
    }
    
   /**
     * Metodi luo totuudet ja propositiot,
     * ja asettaa ne olion totuudet ja propositiot muuttujiin.
     *
     *
     *
     *
     */
    
    public void luoTotuustaulu() {
        ArrayList<String> lista = this.lause.getPropositioNimetlista();
        int[] taulu = new int[lista.size()];
        Vaihtoehtotaulu vaihtoehtotaulu = new Vaihtoehtotaulu();
        ArrayList<int[]> vaihtoehdot = luovaihtoehdot(lista.size(), taulu, vaihtoehtotaulu);
        int propositiotaulukoko = this.lause.getPropositiotaulu().keySet().size() + 1;
        this.propositiot = new String[propositiotaulukoko];
        int pituus = 0;
        for (String p : lista) {
            this.propositiot[pituus] = p;
            pituus++;
        }
        this.propositiot[pituus] = this.syote;
        this.totuudet = new String[vaihtoehdot.size()][vaihtoehdot.get(0).length];
        for (int i = 0; i < vaihtoehdot.size(); i++) {
            String[] rivi = this.lause.muodostaTotuusrivilista(vaihtoehdot.get(i));
            this.totuudet[i] = rivi;
        }
    }

   /**
     * Metodi luo kaikki mahdolliset totuusvaihtoehdot, 
     * ja asettaa ne parametrina annettuun vaihtoehtotauluun
     *
     *
     *
     *
     * @param pituus ilmaisee vaihtoehto rivin pituutta
     * @param vaihtoehtorivi listaa vaihtoehtorivin sisällön
     * @param vaihtoehtotaulu listaa vaihtoehtorivit
     * @return vaihtoehtotaulu joka siäsältää kaikki mahdolliset totuusvaihtoehdot
     */
    public ArrayList<int[]> luovaihtoehdot(int pituus, int[] vaihtoehtorivi, Vaihtoehtotaulu vaihtoehtotaulu) {
        if (pituus > 0) {
            for (int i = 1; i >= 0; i--) {
                vaihtoehtorivi[vaihtoehtorivi.length - pituus] = i;
                int[] uusi = new int[vaihtoehtorivi.length];
                for (int j = 0; j < vaihtoehtorivi.length; j++) {
                    uusi[j] = vaihtoehtorivi[j];
                }
                luovaihtoehdot(pituus - 1, uusi, vaihtoehtotaulu);
            }
        } else {
            int[] uusi = new int[vaihtoehtorivi.length + 1];
            for (int i = 0; i < vaihtoehtorivi.length; i++) {
                uusi[i] = vaihtoehtorivi[i];
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
