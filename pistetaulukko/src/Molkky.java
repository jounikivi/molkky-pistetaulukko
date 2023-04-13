import java.util.ArrayList;
import java.util.Scanner;

public class Molkky {
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        System.out.print("Anna pelaajien lukumäärä: ");
        int pelaajienLkm = lukija.nextInt();
        lukija.nextLine();

        ArrayList<Pelaaja> pelaajat = new ArrayList<Pelaaja>();
        for (int i = 1; i <= pelaajienLkm; i++) {
            System.out.print("Anna pelaajan " + i + " nimi: ");
            String nimi = lukija.nextLine();
            pelaajat.add(new Pelaaja(nimi));
        }

        Pistelaskuri pistelaskuri = new Pistelaskuri(pelaajat);

        while (true) {
            Pelaaja nykyinenPelaaja = pistelaskuri.getNykyinenPelaaja();
            System.out.println(nykyinenPelaaja.getNimi() + " heittää seuraavaksi.");

            System.out.print("Kuinka monta pistettä lisätään? (1-12): ");
            int pisteet = lukija.nextInt();
            lukija.nextLine();

            pistelaskuri.lisaaPisteet(nykyinenPelaaja, pisteet);

            for (Pelaaja pelaaja : pelaajat) {
                System.out.println(pelaaja.getNimi() + ": " + pelaaja.getPisteet());
            }

            if (pistelaskuri.onkoJollainPelaajalla50Pistetta()) {
                System.out.println("Peli päättyi! " + nykyinenPelaaja.getNimi() + " voitti.");
                break;
            }

            pistelaskuri.seuraavaPelaaja();
        }

        lukija.close();
    }
}
