public class Pelaaja {
  private String nimi;
  private int pisteet;
  
  // Konstruktori, joka ottaa vastaan pelaajan nimen ja alustaa pelaajan pistemäärän nollaksi
  public Pelaaja(String nimi) {
    this.nimi = nimi;
    this.pisteet = 0;
  }
  
  // Palauttaa pelaajan nimen
  public String getNimi(){
    return nimi;
  }
  
  // Palauttaa pelaajan pistemäärän
  public int getPisteet(){
    return pisteet;
  }
  
  // Asettaa pelaajan pistemäärän
  public void lisaaPisteet(int pisteet){
    this.pisteet += pisteet;
  }
}
