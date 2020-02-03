import java.util.ArrayList;
import java.util.Scanner;



public class Helper {
    private Game game;
    private int morePlayersCheck;
    private ArrayList<Player> notBustPlayers;

    public Helper() {
        this.game = new Game();
        this.notBustPlayers = new ArrayList<>();

        this.morePlayersCheck = 0;
        do {

            addPlayer();
            addPlayerCheck();
        }
        while (this.morePlayersCheck == 0);

        System.out.println("Initial Deal");

        this.game.deal(2);
        //if there is blackjack end game otherwise
        if (this.game.countNumberOf21() != 0) {
            thereIsBlackJack();
        } else {
            String dealerTopCardInfo = this.game.getDealerCardInfo();
            System.out.println("The dealers top card is the " + dealerTopCardInfo);
            //runs through player sequence
            mainPlayerGame();
            //check if the player draw
            int numberOfDraws = game.countNumberOfHighest();
            if (numberOfDraws > 1) {
                System.out.println("Players draw.  End of Game");
            }else {
                //run dealer sequence
                dealerSequence();
                //check overall winner
                System.out.println(game.winnerOverall());
            }

        }
    }

    public void addPlayer() {
        System.out.println("What is your player name?");
        Scanner nameIn = new Scanner(System.in);
        String name = nameIn.nextLine();
        Player player = new Player(name);
        game.addPlayer(player);
    }

    public void addPlayerCheck() {
        System.out.println("Do you want to add another player? Yes/No");
        Scanner morePlayersInput = new Scanner(System.in);
        String input = morePlayersInput.nextLine();
        if (input.equals("No")) {
            this.morePlayersCheck += 1;
        }
    }

    public void thereIsBlackJack() {
        if (this.game.countNumberOf21() == 1) {
            Player winner = this.game.winnerPlayer();
            System.out.println(winner.getName() + " is the winner.");
        } else {
            System.out.println("It is a draw.");
        }
    }

    public void mainPlayerGame() {

        ArrayList<Player> players = game.getPlayers();
        for (Player player : players) {
            //show players hand
            String name = player.getName();
            System.out.println("It is " + name + "'s turn, other players look away. Press Enter to Continue ");
            Scanner enterInput = new Scanner(System.in);
            String enter = enterInput.nextLine();
            System.out.println(game.getPlayersHand(player));
            System.out.println("The value of the hand is " + game.getPlayerHandValue(player));
            //ask player to twist or stick
            //if stick move to next player
            //if twist add new card to deck,
            //check if burst, with ace check,
            //if not bust ask twist/stick again
            twistOrStick(player);
        }
        //if burst remove player
        game.updatePlayers(this.notBustPlayers);
    }

    public void twistOrStick(Player player) {
        System.out.println("Do you want to twist or Stick? Twist/Stick");
        Scanner actionInput = new Scanner(System.in);
        String action = actionInput.nextLine();
        switch (action) {
            case "Stick":
                notBustPlayers.add(player);
                break;
            case "Twist":
                game.singleDeal(player);

                System.out.println(game.getPlayersHand(player));
                int value = game.getPlayerHandValue(player);
                System.out.println("The value of the hand is " + value);

                if (value == 21) {
                    this.notBustPlayers.add(player);
                    System.out.println("You are at 21.  Next player");
                } else if (value > 21) {
                    System.out.println("Bust.  You lose!");
                } else {
                    twistOrStick(player);
                }
                break;
            default:
                twistOrStick(player);
        }
    }

    public void dealerSequence(){
        do {
            game.singleDealDealer();
        }
        while(game.getDealerHandValue() < 17);
    }
//end of class
}




