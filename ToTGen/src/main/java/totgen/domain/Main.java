package totgen.domain;


import totgen.generoijat.Alilausegeneroija;


/**
 * Hello world!
 *
 */
public class Main {

    public static void main(String[] args) {
        Generaattori generaattori = new Generaattori();
        Lause lause = generaattori.generoi("( A and B ) imp ( B and ( A or C ) )");
        int[] totuusarvot = new int[] {1, 1, 0, 0};
        System.out.println(lause.muodostaTotuusrivi(totuusarvot));
    }
}