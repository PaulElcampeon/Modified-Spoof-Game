import java.util.concurrent.ThreadLocalRandom;

public class SpoofAI implements Player {

    public static int pickCoins(int numOfCoinsOnTable) {
        if (numOfCoinsOnTable == 0) return 0;

        if (numOfCoinsOnTable == 10 || numOfCoinsOnTable == 1) return 1;

        if (numOfCoinsOnTable == 8 || numOfCoinsOnTable == 7 || numOfCoinsOnTable == 6) return numOfCoinsOnTable - 5;

        if (numOfCoinsOnTable< 5 && numOfCoinsOnTable > 1) return numOfCoinsOnTable - 1;

        return ThreadLocalRandom.current().nextInt(1,4);
    }

    @Override
    public int Play(Spoof game) {
       return pickCoins(game.getNumberOfCoins());
    }
}
