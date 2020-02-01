import java.util.ArrayList;
import java.util.Scanner;



public class Helper {
    private Game game;
    private int morePlayersCheck;


    public Helper()
    {
        game = new Game();

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
        }else{
            String dealerTopCardInfo = this.game.getDealerCardInfo();
            System.out.println("The dealers top card is the " + dealerTopCardInfo);



            System.out.println("Game Continues");







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
            this.morePlayersCheck += 1 ;
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
        public void mainPlayerGame(){
            ArrayList<Player> players = game.getPlayers();
            for (Player player : players){
                //show players hand
                //ask player to twist or stick
                //if stick move to next player
                //if twist add new card to deck,
                //check if burst, with ace check,
                //if not bust ask twist/stick again
                //if burst remove player
            }
        }




    }



