/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totgen.generoijat;

import java.util.HashMap;
import totgen.domain.Propositiotaulu;
import totgen.laskurit.Sanahyppyri;
import totgen.laskurit.Suljelaskuri;
import totgen.laskurit.Tyhjahyppyri;
import totgen.lauseenkomponentit.Komponentti;
import totgen.lauseenkomponentit.Propositio;

/**
 *
 * @author alrial@cs
 */
public class Alilausegeneroija {

    private String syote;
    private String alisyote;
    private Komponentti[] komponentit;

    public Alilausegeneroija(String syote) {
        this.syote = syote;
        this.alisyote = syote;
        this.komponentit = new Komponentti[2];

    }

    public Komponentti generoi(Propositiotaulu propositiot) {   
        
        Suljelaskuri suljelaskuri = new Suljelaskuri();
        Sanahyppyri sanahyppyri = new Sanahyppyri();
        Tyhjahyppyri tyhjahyppyri = new Tyhjahyppyri();
        
        int alku = tyhjahyppyri.hyppaaTyhja(this.syote);
        this.syote = this.syote.substring(alku);
        if (this.syote.substring(0, 1).contentEquals("(")) {
            this.syote = this.syote.substring(1);
            this.alisyote = this.syote;
            alku = suljelaskuri.kunnesAliSulkeetLoppuu(this.syote);
            this.alisyote = this.alisyote.substring(0, alku);
            this.syote = this.syote.substring(alku);
            Alilausegeneroija generoija1 = new Alilausegeneroija(this.alisyote);
            this.komponentit[0] = generoija1.generoi(propositiot);
        } else {
            this.alisyote = this.syote.substring(0, sanahyppyri.hyppaaTulevaSana(this.syote));
            propositiot.LisaaPropositio(this.alisyote);
            System.out.println("LöytyPropositio1: " + this.alisyote);
            this.syote = this.syote.substring(sanahyppyri.hyppaaTulevaSana(this.syote));
            this.komponentit[0] = propositiot.getPropositioTaulu().get(this.alisyote);
        }
        alku = tyhjahyppyri.hyppaaTyhja(this.syote);
        this.syote = this.syote.substring(alku);
        this.alisyote = this.syote.substring(alku);
        this.alisyote = this.alisyote.substring(sanahyppyri.hyppaaTulevaSana(this.alisyote));
        this.alisyote = this.alisyote.substring(tyhjahyppyri.hyppaaTyhja(this.alisyote));
        if (this.alisyote.substring(0, 1).contentEquals("(")) {
            alku = suljelaskuri.kunnesAliSulkeetLoppuu(this.alisyote);
            this.alisyote = this.alisyote.substring(1, alku);
            this.syote = this.syote.substring(0, sanahyppyri.hyppaaTulevaSana(this.syote));
            Alilausegeneroija generoija2 = new Alilausegeneroija(this.alisyote);
            this.komponentit[1] = generoija2.generoi(propositiot);
        } else {
            alku = tyhjahyppyri.hyppaaTyhja(this.alisyote);
            this.alisyote = this.alisyote.substring(alku, sanahyppyri.hyppaaTulevaSana(alisyote));
            propositiot.LisaaPropositio(this.alisyote);
            System.out.println("LöytyPropositio2: " + this.alisyote);
            this.syote = this.syote.substring(0, sanahyppyri.hyppaaTulevaSana(this.syote));
            this.komponentit[1] = propositiot.getPropositioTaulu().get(this.alisyote);
        }
        Generoijaluoja generoijaluoja = new Generoijaluoja();
        Komponentti komponentti = generoijaluoja.luo(this.syote, this.komponentit);

        return komponentti;
    }
}
