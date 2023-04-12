import java.util.ArrayList;

public class Scoreboard {
    private ArrayList<Player> players;

    public Scoreboard() {
        this.players = new ArrayList<Player>();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Player getPlayerByName(String name) {
        for (Player player : this.players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }
}

