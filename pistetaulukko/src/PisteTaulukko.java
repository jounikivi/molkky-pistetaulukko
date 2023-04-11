import java.util.ArrayList;

public class PisteTaulukko {
   private ArrayList<Pelaaja> pelaajat;

   // konstruktori
   public PisteTaulukko(){
    this.pelaajat = new ArrayList<Pelaaja>();
   }

   // lisää uusi pelaaja taulukkoon
   public void lisaaPelaaja(Pelaaja pelaaja) {
    this.pelaajat.add(pelaaja);
   }

   // poistaa pelaaja taulukosta
   public void poistaPelaaja(Pelaaja pelaaja){
    this.pelaajat.remove(pelaaja);
   }

   // palauttaa pelaajien lukumäärän
   public int getPelaajienLkm(){
    return this.pelaajat.size();
   }
  
   // palauttaa pelaajan annetulla indeksillä
   public Pelaaja getPelaaja(int indeksi){
    return this.pelaajat.get(indeksi);
   }

   // lisää pelaajalle pisteitä
   public void lisaaPesteita(Pelaaja pelaaja, int pisteet){
    pelaaja.setPisteet(pelaaja.getPisteet() + pisteet);
   }

   // palauttaa pelaajien järjestetyt pisteet
   public ArrayList<Pelaaja> getPelaajienJarjestettyPisteidenMukaan(){
    ArrayList<Pelaaja> jarjestettyPelaajat = new ArrayList<Pelaaja>(this.pelaajat);
    jarjestettyPelaajat.sort((p1, p2) -> p2.getPisteet() - p1.getPisteet());
    return jarjestettyPelaajat;
   }
}

