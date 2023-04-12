/**
 * Pelaaja-luokka tallentaa pelaajan nimen ja pistemäärän.
 */
public class Pelaaja {
    private String nimi;
    private int pisteet;

    /**
     * Konstruktori luo uuden pelaajan, jolla on annettu nimi ja 0 pistettä.
     * @param nimi Pelaajan nimi.
     */
    public Pelaaja(String nimi) {
        this.nimi = nimi;
        this.pisteet = 0;
    }

    /**
     * Palauttaa pelaajan nimen.
     * @return Pelaajan nimi.
     */
    public String getNimi() {
        return nimi;
    }

    /**
     * Palauttaa pelaajan pistemäärän.
     * @return Pelaajan pistemäärä.
     */
    public int getPisteet() {
        return pisteet;
    }

    /**
     * Lisää annetun pistemäärän pelaajan kokonaispistemäärään.
     * @param pistemaara Lisättävä pistemäärä.
     */
    public void lisaaPisteet(int pistemaara) {
        pisteet += pistemaara;
    }
}
