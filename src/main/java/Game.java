import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;
    private Deck deck;
    private Dealer dealer;

    public Game() {
        this.players = new ArrayList<>();
        this.deck = new Deck();
        this.dealer = new Dealer();
    }

    public int countPlayers() {
        return this.players.size();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public int countDeck() {
        return this.deck.countCards();
    }

    public Player getPlayer(int index){
        return players.get(index);
    }

    public int countHandPlayer(int index) {
        Player player = getPlayer(index);
        int total = player.countHand();
        return total;
    }

    public int countHandDealer(){
        int total = dealer.countHand();
        return total;
    }

    public void addCardDealer(Card card){
        this.dealer.addCard(card);
    }

    public void addCardPlayer(Card card, Player player){
        player.addCard(card);
    }

    public void deal(int numberOfCards) {
        for (int i = 0; i < numberOfCards ; i++) {
            for (Player player : players) {
                Card card = this.deck.dealCard();
                player.addCard(card);
            }
            Card card1 = this.deck.dealCard();
            dealer.addCard(card1);
        }

    }

    public int getPlayerHandValue(Player player){
        int total = player.getValueOfHand();
        return total;
    }

    private int getDealerHandValue() {
        int total = this.dealer.getValueOfHand();
        return total;
    }

    public Player winnerPlayer() {
        Player winner = getPlayer(0);
        for (Player player : players) {
            if (getPlayerHandValue(player) > getPlayerHandValue(winner)) {
                winner = player;
            }
        }
        return winner;
    }

    public boolean isDealerWinner() {
        Player player = winnerPlayer();
        if (getPlayerHandValue(player) >= getDealerHandValue()) {
            return false;
        }else{return true;}
    }

    public String winnerOverall() {
        Player player = winnerPlayer();
        String name = player.getName();
        int numberOfHighest = countNumberOfHighest();
        if( isDealerWinner() == true){
            return "House wins.";
        } else if(getPlayerHandValue(player)  == getDealerHandValue() || numberOfHighest > 1) {
            return "It's a Draw.";
        }else{
            return name + " wins.";
        }
    }

    public int countNumberOfHighest() {
        int highest = getHighest();
        int total = 0;
        for (Player player: players){
            if (player.getValueOfHand() == highest){
                total += 1;
            }
        }
        return total;
    }

    public int getHighest() {
        int total = 0;
        for (Player player: players){
            int playerTotal = player.getValueOfHand();
            if( playerTotal > total){
                total = playerTotal;
            }
        }
        return total;
    }


    public int countNumberOf21() {
        int total = 0;
        for (Player player: players){
            if (player.is21()){
                total += 1;
            }
        }
        return total;
    }



//end of class
}
