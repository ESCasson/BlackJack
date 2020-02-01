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

//end of class
}
