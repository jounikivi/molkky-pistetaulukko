import java.util.ArrayList;

public class Pistelaskuri {
    private ArrayList<Pelaaja> pelaajat;
    private int nykyinenPelaajaIndex;

    public Pistelaskuri(ArrayList<Pelaaja> pelaajat) {
        this.pelaajat = pelaajat;
        this.nykyinenPelaajaIndex = 0;
    }

    public Pelaaja getNykyinenPelaaja() {
        return pelaajat.get(nykyinenPelaajaIndex);
    }

    public void lisaaPisteet(Pelaaja pelaaja, int pisteet) {
        int vanhatPisteet = pelaaja.getPisteet();
        int uudetPisteet = vanhatPisteet + pisteet;

        if (uudetPisteet > 50) {
            System.out.println("Liikaa pisteitä! " + pelaaja.getNimi() + " tippuu takaisin 25 pisteeseen.");
            pelaaja.setPisteet(25);
        } else {
            pelaaja.setPisteet(uudetPisteet);
        }

        siirrySeuraavaanPelaajaan();
    }

    private void siirrySeuraavaanPelaajaan() {
        nykyinenPelaajaIndex = (nykyinenPelaajaIndex + 1) % pelaajat.size();
    }

    public boolean onkoJokuVoittanut() {
        for (Pelaaja pelaaja : pelaajat) {
            if (pelaaja.getPisteet() >= 50) {
                return true;
            }
        }
        return false;
    }

    public Pelaaja kukaVoitti() {
        if (!onkoJokuVoittanut()) {
            return null;
        }

        Pelaaja voittaja = pelaajat.get(0);
        for (int i = 1; i < pelaajat.size(); i++) {
            if (pelaajat.get(i).getPisteet() > voittaja.getPisteet()) {
                voittaja = pelaajat.get(i);
            }
        }
        return voittaja;
    }

    public void seuraavaPelaaja() {
    }

    public boolean onkoJollainPelaajalla50Pistetta() {
      return false;
    }
}
