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
    
   /**
    * 
    * 
    * 
    *
    * 
    * Tyhjahyppyri luokka, jonka metodi laskee matkan tyhjän alueen päättymiseen.
    * 
    */
    
    public Tyhjahyppyri(){
        
    }
    
  /**
    * Metodi selvittaa kuinka monta tyhjää on matkaa seuraavaan muuhun merkkiin. 
    * 
    *
    * @param   syote Kutsujan syote
    * 
    * @return matka palauttaa matkan tyhjien päättymiseen.
    * 
    */
    
    public int hyppaaTyhja(String syote){
        int matka = 0;
        if (syote.length() == 0){
            return 0;
        }
        while (syote.length() > matka && syote.substring(matka, matka+1).contentEquals(" ")) {
            matka++;
        }
        return matka;
    }
}
