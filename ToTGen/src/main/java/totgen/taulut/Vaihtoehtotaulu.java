/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package totgen.taulut;

import java.util.ArrayList;

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
 * Vaihtoehtotaulu luokka, jonka tarkoituksena on tarjota julkinen ArrayList
 * vaihtoehtojen säilömiseen. Pääosin Totuustaulu luokan luoVaihtoehdot metodin käytössä.
 *
 */
public class Vaihtoehtotaulu {
    private ArrayList <int[]> taulu;
    
    public Vaihtoehtotaulu(){
        this.taulu = new ArrayList <int[]>();
    }
    
    public ArrayList <int[]> getTaulu() {
        return this.taulu;
    }
}
