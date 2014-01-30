package totgen.domain;

/**
 * Hello world!
 *
 */
import javax.swing.SwingUtilities;
import totgen.ui.Kayttoliittyma;

public class Main {

    public static void main(String[] args) {

        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);

        //Totuustaulu totuustaulu = new Totuustaulu(" not  not    and      not B (()");
        //totuustaulu.luoTotuustaulu();
        //Generaattori generaattori = new Generaattori();
        //Lause lause = generaattori.generoi("not not ( A and B )");  
        //int[] totuusarvot = new int[] {0, 0, 0, 0, 0, 1 ,0};
        //System.out.println(lause.muodostaTotuusrivi(totuusarvot));
    }
}
