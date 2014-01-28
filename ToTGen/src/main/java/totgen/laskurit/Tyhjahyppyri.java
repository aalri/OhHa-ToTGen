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
public class Tyhjahyppyri {
    
    public Tyhjahyppyri(){
        
    }
    
    public int hyppaaTyhja(String syote){
        int alku = 0;
        if (syote.length() == 0){
            return 0;
        }
        while (syote.length() > alku && syote.substring(alku, alku+1).contentEquals(" ")) {
            alku++;
        }
        return alku;
    }
}
