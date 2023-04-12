public class Pelaaja {
    private String nimi;
    private int pisteet;

    // Konstruktori, joka luo uuden pelaajan annetulla nimellä ja aloituspisteillä
    public Pelaaja(String nimi, int pisteet) {
        this.nimi = nimi;
        this.pisteet = pisteet;
    }

    // Getteri pelaajan nimelle
    public String getNimi() {
        return nimi;
    }

    // Setteri pelaajan nimelle
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    // Getteri pelaajan pisteille
    public int getPisteet() {
        return pisteet;
    }

    // Setteri pelaajan pisteille
    public void setPisteet(int pisteet) {
        this.pisteet = pisteet;
    }
}
