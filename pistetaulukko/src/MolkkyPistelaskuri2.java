import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MolkkyPistelaskuri2 extends JFrame implements ActionListener {

    private JLabel otsikko;
    private JLabel tulosLabel;
    private JTextField tulosKentta;
    private JButton lisaaPisteButton;
    private JButton nollaaButton;

    private int tulos = 0;

    public MolkkyPistelaskuri2() {
        super("Mölkyn pistelaskuri");

        // Luodaan komponentit
        otsikko = new JLabel("Tulos:");
        tulosLabel = new JLabel("0");
        tulosKentta = new JTextField(5);
        lisaaPisteButton = new JButton("Lisää piste");
        nollaaButton = new JButton("Nollaa");

        // Asetetaan tapahtumankuuntelijat
        lisaaPisteButton.addActionListener(this);
        nollaaButton.addActionListener(this);

        // Asetetaan layout
        setLayout(new FlowLayout());

        // Lisätään komponentit ikkunaan
        add(otsikko);
        add(tulosLabel);
        add(tulosKentta);
        add(lisaaPisteButton);
        add(nollaaButton);

        // Asetetaan ikkunan koko ja näkyvyys
        setSize(200, 120);
        setVisible(true);
    }

    // Käsitellään napin painallus
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == lisaaPisteButton) {
            int uusiTulos = tulos + Integer.parseInt(tulosKentta.getText());
            tulosLabel.setText(Integer.toString(uusiTulos));
            tulos = uusiTulos;
            tulosKentta.setText("");
        } else if (e.getSource() == nollaaButton) {
            tulosLabel.setText("0");
            tulos = 0;
        }
    }

    public static void main(String[] args) {
        MolkkyPistelaskuri2 pistelaskuri = new MolkkyPistelaskuri2();
        pistelaskuri.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

