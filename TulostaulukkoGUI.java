import javax.swing.*;

public class TulostaulukkoGUI extends JFrame {
    
    public TulostaulukkoGUI() {
        // Aseta ikkunan otsikko
        setTitle("Tulostaulukko");
        
        // Luo taulukko
        String[] sarakeotsikot = {"Joukkue", "Voitot", "Tasapelit", "Tappiot", "Pisteet"};
        Object[][] taulukkoData = {
            {"Joukkue 1", 3, 2, 1, 11},
            {"Joukkue 2", 2, 3, 1, 9},
            {"Joukkue 3", 1, 4, 1, 7},
            {"Joukkue 4", 0, 5, 1, 5},
        };
        JTable taulukko = new JTable(taulukkoData, sarakeotsikot);
        
        // Lisää taulukko ikkunaan
        add(new JScrollPane(taulukko));
        
        // Aseta ikkunan koko
        setSize(400, 300);
        
        // Aseta ikkunan sijainti
        setLocationRelativeTo(null);
        
        // Aseta ikkunan sulkeutumistoiminto
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        // Luo ja näytä ikkuna
        TulostaulukkoGUI ikkuna = new TulostaulukkoGUI();
        ikkuna.setVisible(true);
    }
}
