import java.util.Scanner;

public class MolkkyGame {
   public static void main(String[] args) {
      try (Scanner input = new Scanner(System.in)) {
         System.out.print("Montako pelaajaa on mukana pelissä? ");
         int numberOfPlayers = input.nextInt();
         
         String[] playerNames = new String[numberOfPlayers];
         for (int i = 0; i < numberOfPlayers; i++) {
            System.out.print("Syötä pelaajan " + (i+1) + " nimi: ");
            playerNames[i] = input.next();
         }
         
         int[] scores = new int[numberOfPlayers];
         int currentPlayerIndex = 0;
         
         while (true) {
            System.out.print(playerNames[currentPlayerIndex] + ", syötä pisteet (0-12): ");
            int points = input.nextInt();
            
            if (points < 0 || points > 12) {
               System.out.println("Virheellinen pistemäärä, syötä uudelleen.");
               continue;
            }
            
            scores[currentPlayerIndex] += points;
            
            if (scores[currentPlayerIndex] >= 50) {
               System.out.println(playerNames[currentPlayerIndex] + " voitti!");
               break;
            }
            
            currentPlayerIndex = (currentPlayerIndex + 1) % numberOfPlayers;
         }
      }
   }
}
