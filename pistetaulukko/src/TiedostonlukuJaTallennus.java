import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TiedostonlukuJaTallennus {
    private static final String POLKU = "pistetaulukko.txt";

    public static ArrayList<Pelaaja> luePelaajatTiedostosta() {
        ArrayList<Pelaaja> pelaajat = new ArrayList<>();

        try (BufferedReader lukija = new BufferedReader(new FileReader(new File(POLKU)))) {
            String rivi;
            while ((rivi = lukija.readLine()) != null) {
                String[] tiedot = rivi.split(",");
                pelaajat.add(new Pelaaja(tiedot[0], Integer.parseInt(tiedot[1])));
            }
        } catch (IOException e) {
            System.err.println("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        return pelaajat;
    }

    public static void tallennaPelaajatTiedostoon(ArrayList<Pelaaja> pelaajat) {
        try (BufferedWriter kirjoittaja = new BufferedWriter(new FileWriter(new File(POLKU)))) {
            for (Pelaaja pelaaja : pelaajat) {
                kirjoittaja.write(pelaaja.getNimi() + "," + pelaaja.getPisteet() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Tiedoston kirjoittaminen epäonnistui: " + e.getMessage());
        }
    }
}
