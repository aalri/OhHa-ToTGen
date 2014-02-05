/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package totgen.domain;

import totgen.taulut.Propositiotaulu;

/**
 *
 * @author Riku
 */
public class PaattelynTarkistaja {
    private String[][] totuudet1;
    private String[][] totuudet2;
    private Totuustaulu totuustaulu1;
    private Totuustaulu totuustaulu2;
    
    public PaattelynTarkistaja (String syote1, String syote2){        
        Propositiotaulu taulu = new Propositiotaulu();
        this.totuustaulu1 = new Totuustaulu(syote1, taulu);
        this.totuustaulu2 = new Totuustaulu(syote2, taulu);        
    }
    
    public String tarkistaSyntaksi1(){
        return this.totuustaulu1.tarkistaSyntaksi();
    }
    
    public String tarkistaSyntaksi2(){
        return this.totuustaulu2.tarkistaSyntaksi();
    }
    
    public void Generoi(){
        this.totuustaulu1.luoLause();
        this.totuustaulu2.luoLause();
        this.totuustaulu1.luoTotuustaulu();
        this.totuustaulu2.luoTotuustaulu();     
        this.totuudet1 = this.totuustaulu1.getTotuudet();
        this.totuudet2 = this.totuustaulu2.getTotuudet();
    }
    
    public boolean voidaanPaatella(){
        
        if(this.totuudet1.length == this.totuudet2.length){
            for (int i = 0; i < this.totuudet1.length; i++) {
                if (this.totuudet1[i][this.totuudet2[i].length-1].contentEquals("true")){
                    if(this.totuudet2[i][this.totuudet1[i].length-1].contentEquals("false")){
                        return false;
                    }
                }
            }
            return true;
        }
        
        return false;
    }
    
    
}
