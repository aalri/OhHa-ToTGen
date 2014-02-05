/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totgen.generoijat;

import totgen.lauseenkomponentit.Komponentti;
import totgen.taulut.Propositiotaulu;

/**
 *
 * @author alrial@cs
 */
public class AlilauseNegaatiogeneroija {

    private String syote;
    private Komponentti[] komponentit;

    public AlilauseNegaatiogeneroija(String syote) {
        this.syote = syote;
        this.komponentit = new Komponentti[1];
    }

    public Komponentti generoi(Propositiotaulu propositiot) {
        
        
        
        String omaKomponenttiSana = Generoijatoiminnot.annaTulevaSana(this.syote);
        this.syote = Generoijatoiminnot.hyppaaSana(this.syote);
        this.syote = Generoijatoiminnot.hyppaaTyhja(this.syote);
        if (Generoijatoiminnot.komponenttiKoostuuSulkeidenSisallaOlevastaKokonaisuudesta(this.syote)) {
            this.syote = Generoijatoiminnot.hyppaaYksi(this.syote);
            this.syote = Generoijatoiminnot.annaSulkeidenSisainenAlue(this.syote);
            Alilausegeneroija generoija1 = new Alilausegeneroija(this.syote);
            this.komponentit[0] = generoija1.generoi(propositiot);
        }else{
        this.syote = Generoijatoiminnot.annaTulevaSana(this.syote);
        Alilausegeneroija generoija1 = new Alilausegeneroija(this.syote);
        this.komponentit[0] = generoija1.generoi(propositiot);
        
        }
        
        Generoijaluoja generoijaluoja = new Generoijaluoja();
        Komponentti komponentti = generoijaluoja.luo(omaKomponenttiSana, this.komponentit);
        

        return komponentti;
    }
}
