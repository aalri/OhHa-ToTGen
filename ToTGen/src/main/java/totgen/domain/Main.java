package totgen.domain;

import java.util.ArrayList;
import totgen.lauseenkomponentit.Disjunktio;
import totgen.lauseenkomponentit.Komponentti;
import totgen.lauseenkomponentit.Konjunktio;
import totgen.lauseenkomponentit.Propositio;

/**
 * Hello world!
 *
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Propositio> propositiot = new ArrayList<Propositio>();
        Propositio a = new Propositio();
        Propositio b = new Propositio();
        propositiot.add(a);
        propositiot.add(b);
        int[] totuusarvot;
        Lause lause = new Lause(new Disjunktio(a, b), propositiot);
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                totuusarvot = new int[]{i, j};
                System.out.println(lause.muodostaTotuusrivi(totuusarvot));
            }
        }
    }
}