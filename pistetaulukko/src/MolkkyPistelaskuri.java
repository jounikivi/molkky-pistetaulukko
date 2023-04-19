import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

/**
 * MolkkyPistelaskuri on JFrame-luokka, joka toimii Mölkky-pelin pistelaskurina.
 * Käyttöliittymässä on mahdollisuus syöttää pelaajien nimet ja pelin aikana lisätä pisteitä
 * pelaajille. Peli päättyy, kun joku pelaaja saavuttaa 50 pistettä.
 */

public class MolkkyPistelaskuri extends JFrame {
    private HashMap<String, Integer> pelaajat = new HashMap<String, Integer>();
    private String[] pelaajaNimet;
    private int nykyinenPelaajaIndex = 0;

    private JLabel pelaajaLabel;
    private JLabel pisteetLabel;
    private JTextField pisteetTextField;
    private JButton lisaaPisteetButton;
    private JTable taulukko;

    /**
     * Konstruktori, jossa kysytään pelaajien nimet ja luodaan käyttöliittymä.
     */

    public MolkkyPistelaskuri() {
        super("Mölkky Pistelaskuri");

        // Kysy pelaajien lukumäärä ja nimet
        int pelaajienLkm = Integer.parseInt(JOptionPane.showInputDialog("Anna pelaajien lukumäärä:"));
        for (int i = 1; i <= pelaajienLkm; i++) {
            String nimi = JOptionPane.showInputDialog("Anna pelaajan " + i + " nimi:");
            pelaajat.put(nimi, 0);
        }
        pelaajaNimet = pelaajat.keySet().toArray(new String[0]);

        // Luodaan käyttöliittymäkomponentit
        pelaajaLabel = new JLabel(pelaajaNimet[0]);
        pisteetLabel = new JLabel("Kuinka monta pistettä lisätään? (1-12):");
        pisteetTextField = new JTextField();
        lisaaPisteetButton = new JButton("Lisää pisteet");
        lisaaPisteetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lisaaPisteet();
            }
        });

        // Luodaan taulukko pelaajien pistetilanteille
        String[] otsikot = {"Pelaaja", "Pisteet"};
        Object[][] data = new Object[pelaajat.size()][2];
        int i = 0;
        for (String pelaaja : pelaajat.keySet()) {
            data[i][0] = pelaaja;
            data[i][1] = pelaajat.get(pelaaja);
            i++;
        }
        taulukko = new JTable(data, otsikot);

        // Muokataan pisteetTextFieldin kokoa
        pisteetTextField.setPreferredSize(new Dimension(15, 20));

        // Asetetaan käyttöliittymäkomponentit ikkunaan
          
                setLayout(new BorderLayout());
                JPanel ylaPaneeli = new JPanel(new FlowLayout());
                ylaPaneeli.add(pelaajaLabel);
                ylaPaneeli.add(pisteetLabel);
                ylaPaneeli.add(pisteetTextField);
                ylaPaneeli.add(lisaaPisteetButton);
                add(ylaPaneeli, BorderLayout.NORTH);
                JScrollPane taulukkoPaneeli = new JScrollPane(taulukko);
                add(taulukkoPaneeli, BorderLayout.CENTER);
        
                // Asetetaan ikkunan koko ja näkyvyys
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setSize(400, 300);
                setLocationRelativeTo(null);
                setVisible(true);
            }
        
            private void lisaaPisteet() {
                try {
                    int pisteet = Integer.parseInt(pisteetTextField.getText());
                    pisteetTextField.setText("");
            
                    String nykyinenPelaaja = pelaajaNimet[nykyinenPelaajaIndex];
                    int vanhatPisteet = pelaajat.get(nykyinenPelaaja);
                    int uudetPisteet = vanhatPisteet + pisteet;
            
                    if (uudetPisteet > 50) {
                        JOptionPane.showMessageDialog(this, "Liikaa pisteitä! " + nykyinenPelaaja + " tippuu takaisin 25 pisteeseen.");
                        pelaajat.put(nykyinenPelaaja, 25);
                    } else {
                        pelaajat.put(nykyinenPelaaja, uudetPisteet);
                    }
            
                    nykyinenPelaajaIndex = (nykyinenPelaajaIndex + 1) % pelaajat.size();
                    pelaajaLabel.setText(pelaajaNimet[nykyinenPelaajaIndex]);
                    for (int i = 0; i < pelaajat.size(); i++) {
                        taulukko.setValueAt(pelaajat.get(pelaajaNimet[i]), i, 1);
                    }
            
                    if (pelaajat.containsValue(50)) {
                        JOptionPane.showMessageDialog(this, "Peli päättyi! " + nykyinenPelaaja + " voitti.");
                        System.exit(0);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Syöte ei ole kelvollinen kokonaisluku!");
                }
            }
            
        
            public static void main(String[] args) {
                new MolkkyPistelaskuri();
            }
        }
        
       
