import java.util.ArrayList;

public class Pelisessio {
  
  private ArrayList<Pelaaja> pelaajat; // ArrayList, joka sisältää kaikki pelaajat

  
  public Pelisessio(){
    this.pelaajat = new ArrayList<Pelaaja>(); //alustetaan pelaajat-lista
  }

  // lisää uuden pelajaan pelaajat-listaan
  public void lisaaPelaaja(String nimi) {
    Pelaaja uusiPelaaja = new Pelaaja(nimi); // lisää uuden pelajaan pelaajat-listaan
    pelaajat.add(uusiPelaaja); // lisätään uusi pelaaja pelaajat-listaan
  }
  
  // Poistaa pelaajan pelaajat-listasta
  public void poistaPelaaja(String nimi){
    for (int i = 0; i < pelaajat.size(); i++){
      // käydään läpi kaikki pelaajat
      Pelaaja pelaaja = pelaajat.get(i);
      if (pelaaja.getNimi().equals(nimi)){}
    }
  }
}
