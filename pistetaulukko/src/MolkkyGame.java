import java.util.Scanner;

public class MolkkyGame {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
          Scoreboard scoreboard = new Scoreboard();

          // Pelaajien lisääminen
          System.out.print("Montako pelaajaa? ");
          int numPlayers = scanner.nextInt();
          scanner.nextLine();
          for (int i = 1; i <= numPlayers; i++) {
              System.out.print("Pelaaja " + i + ": ");
              String name = scanner.nextLine();
              Player player = new Player(name);
              scoreboard.addPlayer(player);
          }

          // Pisteiden kirjaaminen
          while (true) {
              System.out.print("Kenen vuoro? ");
              String name = scanner.nextLine();
              Player player = scoreboard.getPlayerByName(name);
              if (player == null) {
                  System.out.println("Virhe: Pelaajaa ei löytynyt!");
                  continue;
              }
              System.out.print("Montako pistettä? ");
              int points = scanner.nextInt();
              scanner.nextLine();
              if (points < 1 || points > 12) {
                  System.out.println("Virhe: Anna pistemäärä väliltä 1-12!");
                  continue;
              }
              player.addScore(points);
              System.out.println("Pelaajan " + player.getName() + " pistemäärä: " + player.getScore());

              // Peli päättyy, kun joku pelaaja saavuttaa 50 pistettä tai enemmän
              if (player.getScore() >= 50) {
                  System.out.println("Peli päättyi!");
                  System.out.println("Voittaja on " + player.getName() + "!");
                  break;
              }
          }
        }
    }
}
