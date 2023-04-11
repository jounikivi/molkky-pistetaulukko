public class Pelaaja {
  private String nimi;
  private int pisteet;
  
  // konstruktori
  public Pelaaja(String nimi) {
      this.nimi = nimi;
      this.pisteet = 0;
  }

  // getterit ja setterit
  public String getNimi() {
      return this.nimi;
  }

  public void setNimi(String nimi) {
      this.nimi = nimi;
  }

  public int getPisteet() {
      return this.pisteet;
  }

  public void setPisteet(int pisteet) {
      this.pisteet = pisteet;
  }
}

