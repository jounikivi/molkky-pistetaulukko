public class Pelinheitto {
  private String pelaajanNimi; // Pelaajan nimi
  private int pistemaara; // Heiton pistemäärä

  public Pelinheitto(String pelaajanNimi, int pistemaara) {
      this.pelaajanNimi = pelaajanNimi;
      this.pistemaara = pistemaara;
  }

  public String getPelaajanNimi() { // Palauttaa pelaajan nimen
      return pelaajanNimi;
  }

  public int getPistemaara() { // Palauttaa heiton pistemäärän
      return pistemaara;
  }
}
