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

    public void singleDeal(Player player){
        Card card = this.deck.dealCard();
                player.addCard(card);
    }

    public void singleDealDealer(){
        Card card = this.deck.dealCard();
        addCardDealer(card);
    }

    public void deal(int numberOfCards) {
        for (int i = 0; i < numberOfCards ; i++) {
            for (Player player : players) {
                singleDeal(player);
            }
            Card card1 = this.deck.dealCard();
            dealer.addCard(card1);
        }

    }

    public int getPlayerHandValue(Player player){
        player.changeAceReset();
        int total = player.getValueOfHand();
        return total;
    }

    public int getDealerHandValue() {
        this.dealer.changeAceReset();
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
        if (getPlayerHandValue(player) < getDealerHandValue() && getDealerHandValue() <= 21) {
            return true;
        }else{return false;}
    }

    public String winnerOverall() {
        Player player = winnerPlayer();
        String name = player.getName();
        if( isDealerWinner() == true){
            return "House wins.";
        } else if(getPlayerHandValue(player)  == getDealerHandValue()) {
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

    public String getDealerCardInfo() {
        return dealer.getTopCardInfo();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public String getPlayersHand(Player player) {
        String message =player.getName() + "'s hand is";
        ArrayList<Card> hand = player.getHand();
        int i = 1;
        for (Card card : hand){
            RankType rankType = card.getRank();
            String rank = rankType.toString();
            SuitType suitType = card.getSuit();
            String suit = suitType.toString();
            String cardInfo = " card"+ i +": " + rank + " of " + suit + ",";
            i ++;
            message = message.concat(cardInfo);
        }
        return message;
    }


    public boolean isPlayerAt21(Player player){
        return player.is21();
    }

    public void updatePlayers(ArrayList<Player> notBustPlayers) {
        this.players = notBustPlayers;
    }

    public Player getPlayerWithLargestSizeHand() {
        Player playerDraw = null;
        int playerDrawSize = 0;
        for (Player player : players){
            if (player.getValueOfHand() == getHighest() && player.countHand() >= playerDrawSize){
                if (player.countHand() == playerDrawSize){
                    playerDraw = null;
                } else {
                    playerDraw = player;
                    playerDrawSize = player.countHand();
                }
            }
        }
        return playerDraw;
    }


//end of class
}
