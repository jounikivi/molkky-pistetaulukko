import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Pistetaulukko {
    private ArrayList<Pelaaja> pelaajat;

    // Konstruktori, joka luo uuden pelaajien ArrayList-olion
    public Pistetaulukko() {
        this.pelaajat = new ArrayList<Pelaaja>();
    }

    // Metodi pelaajan lisäämiseksi ArrayList-olioon
    public void lisaaPelaaja(Pelaaja pelaaja) {
        this.pelaajat.add(pelaaja);
    }

    // Metodi pelaajan poistamiseksi ArrayList-oliosta
    public void poistaPelaaja(Pelaaja pelaaja) {
        this.pelaajat.remove(pelaaja);
    }

    // Metodi ranking-järjestyksen laskemiseksi ArrayList-olion pelaajille
    public ArrayList<Pelaaja> laskeRanking() {
        // Järjestetään pelaajat pistemäärän mukaan laskevassa järjestyksessä
        Collections.sort(pelaajat, new Comparator<Pelaaja>() {
            public int compare(Pelaaja pelaaja1, Pelaaja pelaaja2) {
                return pelaaja2.getPisteet() - pelaaja1.getPisteet();
            }
        });

        return pelaajat;
    }

    // Getteri pelaajien ArrayList-oliolle
    public ArrayList<Pelaaja> getPelaajat() {
        return this.pelaajat;
    }
}
