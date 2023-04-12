public class MolkkyPistetaulukko {
  public static void main(String[] args) {
      launch(args);
  }

  public void start(Stage primaryStage) throws Exception {
      // Luodaan pistetaulukko ja käyttöliittymä
      Pistetaulukko pistetaulukko = new Pistetaulukko();
      final Kayttoliittyma kayttoliittyma = new Kayttoliittyma(pistetaulukko);

      // Näytetään käyttöliittymä
      Scene scene = new Scene(kayttoliittyma, 800, 600);
      primaryStage.setTitle("Mölkky Pistetaulukko");
      primaryStage.setScene(scene);
      primaryStage.show();
  }
}
