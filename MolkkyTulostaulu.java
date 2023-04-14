import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MolkkyTulostaulu extends JFrame implements ActionListener {
    
    private JLabel[] pelaajaNimet;
    private JLabel[] pelaajaPisteet;
    private JButton[] lisaaPisteet;
    private int[] pisteet;
    public MolkkyTulostaulu(int pelaajienMaara) {
        // Luodaan pelinäkymän komponentit
        pelaajaNimet = new JLabel[pelaajienMaara];
        pelaajaPisteet = new JLabel[pelaajienMaara];
        lisaaPisteet = new JButton[pelaajienMaara];
        pisteet = new int[pelaajienMaara];
        
        for (int i = 0; i < pelaajienMaara; i++) {
            pelaajaNimet[i] = new JLabel("Pelaaja " + (i+1));
            pelaajaPisteet[i] = new JLabel("0");
            lisaaPisteet[i] = new JButton("+1 piste");
            lisaaPisteet[i].setActionCommand(Integer.toString(i));
            lisaaPisteet[i].addActionListener(this);
        }
        
        // Luodaan pelinäkymän layout ja asetetaan komponentit siihen
        setLayout(new GridLayout(pelaajienMaara, 3));
        
        for (int i = 0; i < pelaajienMaara; i++) {
            add(pelaajaNimet[i]);
            add(pelaajaPisteet[i]);
            add(lisaaPisteet[i]);
        }
        
        // Asetetaan pelinäkymän ominaisuudet
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Mölkky Tulostaulu");
        setSize(400, 300);
        setVisible(true);
    }
    
    // Käsitellään painikkeiden klikkaukset
    public void actionPerformed(ActionEvent e) {
        int pelaajanIndeksi = Integer.parseInt(e.getActionCommand());
        pisteet[pelaajanIndeksi]++;
        pelaajaPisteet[pelaajanIndeksi].setText(Integer.toString(pisteet[pelaajanIndeksi]));
    }
    
    public static void main(String[] args) {
        new MolkkyTulostaulu(4);
    }
}

