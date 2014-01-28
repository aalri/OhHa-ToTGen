package totgen.domain;


/**
 * Hello world!
 *
 */
public class Main {

    public static void main(String[] args) {
        
<<<<<<< HEAD
        Totuustaulu totuustaulu = new Totuustaulu("not(not A or not(not(D and B)and(C)))");
=======
        Totuustaulu totuustaulu = new Totuustaulu("not(not A or not(not(D and B)and( C ) ) )");
>>>>>>> d29e3ea482af2753bdfc7416814134be19dd5a9d
        totuustaulu.luoTotuustaulu();
        //Generaattori generaattori = new Generaattori();
        //Lause lause = generaattori.generoi("not not ( A and B )");  
        //int[] totuusarvot = new int[] {0, 0, 0, 0, 0, 1 ,0};
        //System.out.println(lause.muodostaTotuusrivi(totuusarvot));
    }
}