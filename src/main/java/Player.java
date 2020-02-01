import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand;
    private String name;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public int getCardValue(Card card){
        return card.getValueFromCard();
    }


    public int countHand(){
        return hand.size();
    }

    public void addCard(Card card)
    {
        hand.add(card);
    }


    public int getValueOfHand() {
        int total = 0;
        for (Card card : hand){
            total += card.getValueFromCard();
        }
        return total;
    }

    public boolean handContainsAce() {
        boolean result = false;
        for(Card card : hand){
            if (card.getRank() == RankType.ACE){
                result = true;
            }
        }
        return result;
    }
}
