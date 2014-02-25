/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totgen.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Riku
 */
/**
 *
 *
 *
 *
 *
 * Kayttoliittyma luokka luo kayttoliittyman rungon.
 *
 *
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;

    public Kayttoliittyma() {
    }

    @Override
    public void run() {
        frame = new JFrame("ToTGen - Totuustaulu Generaattori");
        frame.setPreferredSize(new Dimension(700, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {        
        
        container.setBackground(Color.DARK_GRAY);
        container.setLayout(new GroupLayout(container));
        JScrollPane rullattava = new JScrollPane();        
        JTextField syotealue = new JTextField("(A and B) or not C");        
        JButton generoiNappi = new JButton("Generoi totuustaulu.");        
        JButton konjunktioNappi = new JButton("∧");    
        JButton disjunktioNappi = new JButton("∨"); 
        JButton negaatioNappi = new JButton("¬"); 
        JButton implikaatioNappi = new JButton("→");       
        JButton ekvivalenssiNappi = new JButton("↔");  
        String[][] rivit = new String[][]{{}};
        String[] nimet = new String[]{};
        TableModel totuustaulunData = new DefaultTableModel(rivit, nimet);
        JTable totuustaulu = new JTable(totuustaulunData);
        LisaaMerkki konjunktio = new LisaaMerkki(syotealue, "∧");
        LisaaMerkki disjunktio = new LisaaMerkki(syotealue, "∨");
        LisaaMerkki negaatio = new LisaaMerkki(syotealue, "¬");
        LisaaMerkki implikaatio = new LisaaMerkki(syotealue, "→");
        LisaaMerkki ekvivalenssi = new LisaaMerkki(syotealue, "↔");
        JTabbedPane mappi = new JTabbedPane();
        Container totuusSivu = new Container();     
        
        JLabel jos = new JLabel("Jos:");
        JTextField syotealue2 = new JTextField("(Nuori imp Ulkona) and (Pekka imp Nuori) ");  
        JLabel tulostealue1 = new JLabel();
        JLabel niin = new JLabel("Niin:");
        JTextField syotealue3 = new JTextField("Pekka imp Ulkona");  
        JLabel tulostealue2 = new JLabel();
        JLabel tulostealue3 = new JLabel();
        JButton voidaankoPaatellaNappi = new JButton("Voidaanko päätellä?");   
        Container paattelynTarkistusSivu = new Container();
        GeneroiPaattelynTarkistus generoipaattelyntarkistus = new GeneroiPaattelynTarkistus(syotealue2, syotealue3, tulostealue1, tulostealue2, tulostealue3, mappi, paattelynTarkistusSivu, this.frame); 
        GeneroiTotuustaulu generoitotuustaulu = new GeneroiTotuustaulu(syotealue, totuustaulu, totuustaulunData, mappi, totuusSivu, this.frame);
        generoiNappi.addActionListener(generoitotuustaulu);
        konjunktioNappi.addActionListener(konjunktio);
        disjunktioNappi.addActionListener(disjunktio);
        negaatioNappi.addActionListener(negaatio);
        implikaatioNappi.addActionListener(implikaatio);
        ekvivalenssiNappi.addActionListener(ekvivalenssi);  
        voidaankoPaatellaNappi.addActionListener(generoipaattelyntarkistus);
          
        totuusSivu.add(implikaatioNappi);
        totuusSivu.add(disjunktioNappi);
        totuusSivu.add(konjunktioNappi);
        totuusSivu.add(negaatioNappi);
        totuusSivu.add(ekvivalenssiNappi);
        totuusSivu.add(syotealue);
        totuusSivu.add(generoiNappi);
        rullattava.add(totuustaulu.getTableHeader());
        rullattava.add(totuustaulu);
        totuusSivu.add(rullattava);
        
        paattelynTarkistusSivu.add(jos);
        paattelynTarkistusSivu.add(syotealue2);
        paattelynTarkistusSivu.add(tulostealue1);       
        paattelynTarkistusSivu.add(niin);
        paattelynTarkistusSivu.add(syotealue3);
        paattelynTarkistusSivu.add(tulostealue2); 
        paattelynTarkistusSivu.add(voidaankoPaatellaNappi);
        paattelynTarkistusSivu.add(tulostealue3);
                 
        mappi.addTab("Totuustaulu", totuusSivu); 
        mappi.addTab("PaattelynTarkistaja", paattelynTarkistusSivu); 
        mappi.setBounds(0, 0, 700, 500);
        container.add(mappi);
        
        syotealue.setBounds(50, 70, 300, 30);
        generoiNappi.setBounds(50, 100, 300, 50);
        konjunktioNappi.setBounds(400, 70, 70, 40);
        disjunktioNappi.setBounds(470, 70, 70, 40);
        negaatioNappi.setBounds(470, 110, 70, 40);
        implikaatioNappi.setBounds(400, 110, 70, 40);
        ekvivalenssiNappi.setBounds(540, 70, 70, 40);
        
        jos.setBounds(20, 70, 30, 30);
        syotealue2.setBounds(50, 70, 300, 30);        
        niin.setBounds(15, 130, 40, 30);
        syotealue3.setBounds(50, 130, 300, 30);
        voidaankoPaatellaNappi.setBounds(50, 190, 300, 30);

    }

    public JFrame getFrame() {
        return frame;
    }
}
