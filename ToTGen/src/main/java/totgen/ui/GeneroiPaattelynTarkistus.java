/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totgen.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import totgen.domain.PaattelynTarkistaja;

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
 * GeneroiPaattelynTarkistus luokka, jonka tarkoituksena napin painalluksesta on luoda PaattelynTarkistus olio syotealueissa olevilla syotteilla,
 * ja muokata kayttoliittymaa kyseisen olion palautusten mukaan.
 *
 *
 */
public class GeneroiPaattelynTarkistus implements ActionListener {

    private JTextField syoteAlue1;
    private JTextField syoteAlue2;
    private JLabel virheilmoitus;
    private JLabel virheilmoitus2;
    private JLabel tulostealue;
    private Container mappi;
    private Container container;
    private JFrame frame;

    public GeneroiPaattelynTarkistus(JTextField syoteAlue1, JTextField syoteAlue2, JLabel virheilmoitus, JLabel virheilmoitus2, JLabel tulostealue, Container mappi, Container container, JFrame frame) {
        this.syoteAlue1 = syoteAlue1;
        this.syoteAlue2 = syoteAlue2;
        this.virheilmoitus = virheilmoitus;
        this.virheilmoitus2 = virheilmoitus2;
        this.tulostealue = tulostealue;
        this.mappi = mappi;
        this.container = container;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String syote1 = this.syoteAlue1.getText();
        String syote2 = this.syoteAlue2.getText();

        PaattelynTarkistaja paattelyntarkistaja = new PaattelynTarkistaja(syote1, syote2);

        this.container.remove(this.virheilmoitus);
        this.container.remove(this.virheilmoitus2);
        this.container.remove(this.tulostealue);

        String syntaksi1 = paattelyntarkistaja.tarkistaSyntaksi1();
        String syntaksi2 = paattelyntarkistaja.tarkistaSyntaksi2();

        if (syntaksi1.contentEquals("true") && syntaksi2.contentEquals("true")) {
            paattelyntarkistaja.Generoi();
            if (paattelyntarkistaja.voidaanPaatella()){
                this.tulostealue = new JLabel("Spock: That is quite logical, captain. (true)");
            }else{
                this.tulostealue = new JLabel("<html><body>Spock: That is illogical, Ensign. Odors cannot travel<br>through the vacuum of space. (false)</body></html>");
            }
            this.container.add(this.tulostealue);
            this.tulostealue.setBounds(50, 220, 380, 100);
            
        } else {
            if (!syntaksi1.contentEquals("true")) {
                this.virheilmoitus = new JLabel(syntaksi1);
                this.container.add(this.virheilmoitus);
                this.virheilmoitus.setBounds(50, 100, 300, 30);
            }
            if (!syntaksi2.contentEquals("true")) {
                this.virheilmoitus2 = new JLabel(syntaksi2);
                this.container.add(this.virheilmoitus2);
                this.virheilmoitus2.setBounds(50, 160, 300, 30);
            }
            
        }
        this.container.repaint();
    }
}
