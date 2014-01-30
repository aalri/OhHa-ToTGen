/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totgen.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import totgen.domain.Totuustaulu;

/**
 *
 * @author Riku
 */
public class GeneroiTotuustaulu implements ActionListener {

    private JTextField syoteAlue;
    private JTable totuustaulu;
    private Container container;
    private TableModel totuustaulunData;
    private JFrame frame;
    private JTextArea virheilmoitus;

    public GeneroiTotuustaulu(JTextField syoteAlue, JTable totuustaulu, TableModel totuustaulunData, Container container, JFrame frame) {
        this.syoteAlue = syoteAlue;
        this.totuustaulu = totuustaulu;
        this.container = container;
        this.totuustaulunData = totuustaulunData;
        this.frame = frame;
        this.virheilmoitus = new JTextArea();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String syote = this.syoteAlue.getText();        
        Totuustaulu taulu = new Totuustaulu(syote);
        String syntaksi = taulu.tarkistaSyntaksi();
        
        this.container.remove(this.totuustaulu.getTableHeader());
        this.container.remove(this.totuustaulu);
        this.container.remove(this.virheilmoitus);
        
        if (syntaksi.contentEquals("true")){
        taulu.luoTotuustaulu();
        String[] propositiot = taulu.getPropositiot();
        String[][] totuudet = taulu.getTotuudet();        
        this.totuustaulunData = new DefaultTableModel(totuudet, propositiot);
        this.totuustaulu = new JTable(this.totuustaulunData);
        this.container.add(this.totuustaulu);
        this.container.add(this.totuustaulu.getTableHeader());
        this.totuustaulu.setBounds(50, 200, 75 * propositiot.length +60, totuudet.length * 16);
        this.totuustaulu.getTableHeader().setBounds(50, 170, 75 * propositiot.length +60, 30);
        this.totuustaulu.setRowMargin(0);
        this.totuustaulu.setEnabled(false);
        this.totuustaulu.setGridColor(Color.LIGHT_GRAY);
        this.totuustaulu.setBackground(Color.WHITE);
        //this.totuustaulu.getTableHeader().setEnabled(false);
        this.frame.repaint();
        }else{
            this.virheilmoitus = new JTextArea(syntaksi);
            this.container.add(this.virheilmoitus);
            this.virheilmoitus.setBounds(50, 200, 300, 30);
            this.frame.repaint();
        }
    }
}
