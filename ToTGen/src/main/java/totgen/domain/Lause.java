/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totgen.domain;

import totgen.taulut.Propositiotaulu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import totgen.lauseenkomponentit.Komponentti;
import totgen.lauseenkomponentit.Propositio;

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
 * Lause luokka, jonka tarkoituksena on tarjota linkki komponenttipuuhun, sekä
 * sen käyttämiin propositioihin.
 *
 *
 */
public class Lause {

    /**
     * Lauseen komponenttipuun root
     */
    private Komponentti paakonnektiivi;

    /**
     * Lauseen komponenttipuun käyttämä propositiotaulu
     */
    private HashMap<String, Propositio> propositiot;

    public Lause(Komponentti paakonnektiivi, Propositiotaulu propositiot) {
        this.paakonnektiivi = paakonnektiivi;
        this.propositiot = propositiot.getPropositioTaulu();
    }

    public HashMap<String, Propositio> getPropositiotaulu() {
        return this.propositiot;
    }

    /**
     * Metodi joka palauttaa olion propositiotaulun propositiot arraylistinä, ja
     * järjestettynä aakkosjärjestykseen.
     *
     * @return propositiotaulun propositiot arraylistinä ja järjestettynä
     */
    public ArrayList<Propositio> getPropositiolista() {
        ArrayList<Propositio> pro = new ArrayList<Propositio>();
        ArrayList<String> lista = new ArrayList<String>(this.propositiot.keySet());
        Collections.sort(lista);
        for (String p : lista) {
            pro.add(this.propositiot.get(p));
        }
        return pro;
    }
    
    /**
     * Metodi joka palauttaa olion propositiotaulun avaimet arraylistinä, ja
     * järjestettynä aakkosjärjestykseen.
     *
     * @return propositiotaulun avaimet arraylistinä ja järjestettynä
     */
    
    public ArrayList<String> getPropositioNimetlista() {
        ArrayList<String> lista = new ArrayList<String>(this.propositiot.keySet());
        Collections.sort(lista);
        return lista;
    }

    /**
     * Metodi joka palauttaa annetuilla totuusarvoilla muodostetun totuusrivi
     * merkkijonon
     *
     * @param totuusarvot annetut arvot
     * @return totuusrivi merkkijono annetuilla arvoilla
     */
    public String muodostaTotuusrivi(int[] totuusarvot) {
        String rivi = "";
        ArrayList<Propositio> pro = this.getPropositiolista();
        for (int i = 0; i < pro.size(); i++) {
            pro.get(i).asetaTotuus(totuusarvot[i]);
            rivi += pro.get(i).totuus() + " ";
        }
        return rivi + this.paakonnektiivi.totuus();
    }

    /**
     * Metodi joka palauttaa annetuilla totuusarvoilla muodostetun totuusrivi
     * listan
     *
     * @param totuusarvot annetut arvot
     * @return totuusrivi lista annetuilla arvoilla
     */
    public String[] muodostaTotuusrivilista(int[] totuusarvot) {
        String[] lista = new String[totuusarvot.length];
        ArrayList<Propositio> pro = this.getPropositiolista();
        for (int i = 0; i < pro.size(); i++) {
            pro.get(i).asetaTotuus(totuusarvot[i]);
            lista[i] = "" + pro.get(i).totuus();
        }
        lista[totuusarvot.length - 1] = "" + this.paakonnektiivi.totuus();

        return lista;
    }
}
