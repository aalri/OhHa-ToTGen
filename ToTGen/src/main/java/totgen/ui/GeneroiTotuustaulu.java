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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import totgen.domain.Totuustaulu;

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
 * GeneroiTotuustaulu luokka, jonka tarkoituksena napin painalluksesta on luoda Totuustaulu olio syotealueessa olevilla syotteilla,
 * ja muokata kayttoliittymaa kyseisen olion palautusten mukaan.
 *
 *
 */
public class GeneroiTotuustaulu implements ActionListener {

    private JTextField syoteAlue;
    private JTable totuustaulu;
    private Container mappi;
    private Container container;
    private JFrame frame;
    private TableModel totuustaulunData;
    private JLabel virheilmoitus;

    public GeneroiTotuustaulu(JTextField syoteAlue, JTable totuustaulu, TableModel totuustaulunData, Container mappi, Container container, JFrame frame) {
        this.syoteAlue = syoteAlue;
        this.totuustaulu = totuustaulu;
        this.mappi = mappi;
        this.totuustaulunData = totuustaulunData;
        this.container = container;
        this.virheilmoitus = new JLabel();
        this.frame = frame;
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
        taulu.luoLause();
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
        if (this.frame.getBounds().width < this.totuustaulu.getBounds().width + 130 || this.frame.getBounds().height < this.totuustaulu.getBounds().height + 300 ){
            if (this.totuustaulu.getHeight() < 1000){
                this.mappi.setBounds(0, 0, this.totuustaulu.getBounds().width + 430,this.totuustaulu.getBounds().height + 300);
                this.frame.setBounds(this.frame.getBounds().x, this.frame.getBounds().y, this.totuustaulu.getBounds().width + 200,this.totuustaulu.getBounds().height + 300);
            }         
        }
        this.totuustaulu.setEnabled(false);
        this.totuustaulu.setGridColor(Color.LIGHT_GRAY);
        this.totuustaulu.setBackground(Color.WHITE);
        //this.totuustaulu.getTableHeader().setEnabled(false);
        this.container.repaint();
        }else{
            this.virheilmoitus = new JLabel(syntaksi);
            this.container.add(this.virheilmoitus);
            this.virheilmoitus.setBounds(50, 160, 300, 30);
            this.container.repaint();
        }
    }
}
