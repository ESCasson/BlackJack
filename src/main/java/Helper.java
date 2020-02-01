import java.util.Scanner;



public class Helper {
    private Game game;
    int morePlayersCheck = 0;

    public Helper()
    {
        game = new Game();


        do {
            addPlayer();
            addPlayerCheck();
        }
        while (morePlayersCheck < 0);

        System.out.println("Initial Deal");

        this.game.deal(2);
        //if there is blackjack end game otherwise
        if (this.game.countNumberOf21() != 0) {
           thereIsBlackJack();
        }else{
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
            morePlayersCheck += 1;
        }
    }

    public void thereIsBlackJack(){
        if (this.game.countNumberOf21() == 1) {
            Player winner = this.game.winnerPlayer();
            System.out.println(winner.getName() + " is the winner.");
        } else {System.out.println("It is a draw.");}




    }


    }

