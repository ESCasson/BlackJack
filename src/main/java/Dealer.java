import java.util.ArrayList;

public class Dealer {
    private ArrayList<Card> hand;

    public Dealer() {
        this.hand = new ArrayList<>();
    }


    public Card getHand(int position){
        return hand.get(position);
    }

    public int countHand(){
        return hand.size();
    }

    public void addCard(Card card)
    {
        hand.add(card);
    }
}
