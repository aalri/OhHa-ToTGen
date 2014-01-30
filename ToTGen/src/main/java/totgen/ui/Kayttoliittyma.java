/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totgen.ui;

/**
 *
 * @author Riku
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;

    public Kayttoliittyma() {
    }

    @Override
    public void run() {
        frame = new JFrame("ToTGen - Totuustaulu Generaattori");
        frame.setPreferredSize(new Dimension(600, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.setBackground(Color.DARK_GRAY);
        container.setLayout(new GroupLayout(container));
        JTextField syotealue = new JTextField("(A and B) or not C");        
        JButton generoiNappi = new JButton("Generoi totuustaulu.");        
        JButton konjunktioNappi = new JButton("∧");    
        JButton disjunktioNappi = new JButton("∨"); 
        JButton negaatioNappi = new JButton("¬"); 
        JButton implikaatioNappi = new JButton("→");         
        String[][] rivit = new String[][]{{}};
        String[] nimet = new String[]{};
        TableModel totuustaulunData = new DefaultTableModel(rivit, nimet);
        JTable totuustaulu = new JTable(totuustaulunData);
        LisaaMerkki konjunktio = new LisaaMerkki(syotealue, "∧");
        LisaaMerkki disjunktio = new LisaaMerkki(syotealue, "∨");
        LisaaMerkki negaatio = new LisaaMerkki(syotealue, "¬");
        LisaaMerkki implikaatio = new LisaaMerkki(syotealue, "→");
        GeneroiTotuustaulu generoitotuustaulu = new GeneroiTotuustaulu(syotealue, totuustaulu, totuustaulunData, container, frame);
        generoiNappi.addActionListener(generoitotuustaulu);
        konjunktioNappi.addActionListener(konjunktio);
        disjunktioNappi.addActionListener(disjunktio);
        negaatioNappi.addActionListener(negaatio);
        implikaatioNappi.addActionListener(implikaatio);
        
        container.add(implikaatioNappi);
        container.add(disjunktioNappi);
        container.add(konjunktioNappi);
        container.add(negaatioNappi);
        container.add(syotealue);
        container.add(generoiNappi);
        container.add(totuustaulu.getTableHeader());
        container.add(totuustaulu);
        
        syotealue.setBounds(50, 70, 300, 30);
        generoiNappi.setBounds(50, 100, 300, 50);
        konjunktioNappi.setBounds(400, 70, 70, 50);
        disjunktioNappi.setBounds(470, 70, 70, 50);
        negaatioNappi.setBounds(470, 120, 70, 50);
        implikaatioNappi.setBounds(400, 120, 70, 50);

    }

    public JFrame getFrame() {
        return frame;
    }
}
