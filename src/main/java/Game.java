import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;
    private Deck deck;

    public Game() {
        this.players = new ArrayList<>();
        this.deck = new Deck();
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

    public void deal() {
        for (Player player : players){
            Card card  = this.deck.dealCard();
            player.addCard(card);
        }
    }

    public Player winner() {
        Player winner = players.get(0);
        for(Player player : players){
            Card card = player.getHand();
                    Card winnerCard = winner.getHand();
            if(card.getValueFromCard() > winnerCard.getValueFromCard()){
                winner = player;
            }
        }
        return winner;
    }
}
