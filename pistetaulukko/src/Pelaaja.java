public class Pelaaja {
  private String nimi;
  private int pisteet;

  public Pelaaja(String nimi) {
      this.nimi = nimi;
      this.pisteet = 0;
  }

  public String getNimi() {
      return nimi;
  }

  public int getPisteet() {
      return pisteet;
  }

  public void setPisteet(int pisteet) {
      this.pisteet = pisteet;
  }

  public void nollaaPisteet() {
      this.pisteet = 0;
  }

  public void lisaaPisteet(int pisteet) {
      this.pisteet += pisteet;
  }
}

