import java.util.ArrayList;

public class Pelisessio {

  private ArrayList<Pelaaja> pelaajat; // ArrayList, joka sisältää kaikki pelaajat
    
    public Pelisessio() {
        this.pelaajat = new ArrayList<Pelaaja>(); // alustetaan pelaajat-lista
    }
    
    // Lisää uuden pelaajan pelaajat-listaan
    public void lisaaPelaaja(String nimi) {
        Pelaaja uusiPelaaja = new Pelaaja(nimi); // luodaan uusi pelaaja-olio annetulla nimellä
        pelaajat.add(uusiPelaaja); // lisätään uusi pelaaja pelaajat-listaan
    }
    
    // Poistaa pelaajan pelaajat-listasta
    public void poistaPelaaja(String nimi) {
        for (int i = 0; i < pelaajat.size(); i++) { // käydään läpi kaikki pelaajat
            Pelaaja pelaaja = pelaajat.get(i);
            if (pelaaja.getNimi().equals(nimi)) { // etsitään pelaaja, jonka nimi on sama kuin annettu nimi
                pelaajat.remove(i); // poistetaan pelaaja pelaajat-listasta
                break; // lopetetaan looppi kun pelaaja on poistettu
            }
        }
    }
    
    // Aloittaa uuden pelisession
    public void aloitaSession() {
        // TODO: kirjaa aloitusaika tms.
    }
    
    // Lopettaa nykyisen pelisession
    public void lopetaSession() {
        // TODO: kirjaa lopetusaika tms.
    }
    
    // Lisää uuden heiton tietyn pelaajan pistemäärään
    public void lisaaHeitto(String pelaajaNimi, int pisteet) {
        for (Pelaaja pelaaja : pelaajat) { // käydään läpi kaikki pelaajat
            if (pelaaja.getNimi().equals(pelaajaNimi)) { // etsitään pelaaja, jonka nimi on sama kuin annettu nimi
                int uudetPisteet = pelaaja.getPisteet() + pisteet; // lisätään annetut pisteet pelaajan nykyiseen pistemäärään
                pelaaja.lisaaPisteet(uudetPisteet); // tallennetaan uusi pistemäärä pelaaja-olioon
                break; // lopetetaan looppi kun pelaaja on löydetty ja pisteet lisätty
            }
        }
    }
    
    // Palauttaa voittajan nimen
    public void ilmoitaVoittaja() {
        Pelaaja voittaja = pelaajat.get(0); // asetetaan voittajaksi ensimmäinen pelaaja pelaajat-listassa
        for (Pelaaja pelaaja : pelaajat) { // käydään läpi kaikki pelaajat
            if (pelaaja.getPisteet() > voittaja.getPisteet()) { // etsitään pelaaja, jolla on suurin pistemäärä
                voittaja = pelaaja; // päivitetään voittaja
            }
        }
      }
}
    
