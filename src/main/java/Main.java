public class Main {

    public static void main(String[] args) {
        Player player1 = new SpoofHumanPlayer();
        Player player2 = new SpoofAI();
        try {
            Spoof game = new Spoof(20, player1, player2);
            game.Start();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
