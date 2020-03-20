import java.util.Scanner;

public class SpoofHumanPlayer implements Player {
    private Scanner in;

    public SpoofHumanPlayer() {
        this.in = new Scanner(System.in);
    }

    @Override
    public int Play(Spoof game) {
        System.out.printf("%nThere are %d coins left, how many coins do you want to take", game.getNumberOfCoins());

        while (true) {
            try {
                int numberOfCoinsToTake = this.in.nextInt();
                if (numberOfCoinsToTake <= 0 || numberOfCoinsToTake > 3 || numberOfCoinsToTake > game.getNumberOfCoins()) throw new Exception();
                return numberOfCoinsToTake;
            } catch (Exception e) {
                System.out.println("There was something wrong with your input, make sure to insert a number".toUpperCase());
                System.out.printf("%nThere are %d coins left, how many coins do you want to take", game.getNumberOfCoins());
            }
        }
    }
}
