import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Spoof {

    private int numberOfCoins;
    private Scanner in;
    private Map<String, Player> players;
    private String winner;

    public Spoof(int numberOfCoins, Player... players) throws Exception {
        if (numberOfCoins <= 0) throw new Exception("The game has to start with 1 of more coins");
        this.orderPlayers(players);
        this.numberOfCoins = numberOfCoins;
        this.in = new Scanner(System.in);
    }

    public void Start() {
        boolean player1Turn = flipCoin();

        while(true) {
            if (player1Turn) {
                System.out.printf("%nPlayer 1 turn");
                int numberOfCoinsToTake = players.get("Player 1").Play(this);
                this.numberOfCoins -= numberOfCoinsToTake;
                System.out.printf("%nPlayer 1 removed %d coins%nNumber of coins remaining: %d", numberOfCoinsToTake, this.numberOfCoins);
                player1Turn = false;
            } else {
                System.out.printf("%nPlayer 2 turn");
                int numberOfCoinsToTake = players.get("Player 2").Play(this);
                this.numberOfCoins -= numberOfCoinsToTake;
                System.out.printf("%nPlayer 2 removed %d coins%nNumber of coins remaining: %d", numberOfCoinsToTake, this.numberOfCoins);
                player1Turn = true;
            }

            if (this.checkIfGameOver()) {
                if (player1Turn) {
                    winner = "Player 1";
                } else {
                    winner = "Player 2";
                }
                break;
            }
        }

        System.out.printf("%nThe winner of this game is %s", winner);
    }

    public void orderPlayers(Player... players) {
        HashMap<String, Player> playersMap = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            playersMap.put("Player " + (i + 1), players[i]);
        }
        this.players = playersMap;
    }

    public boolean checkIfGameOver() {
        return this.numberOfCoins <= 0;
    }

    public boolean flipCoin() {
        return ThreadLocalRandom.current().nextDouble() > 0.5;
    }

    public int getNumberOfCoins() {
        return numberOfCoins;
    }

    public Map<String, Player> getPlayers() {
        return players;
    }
}
