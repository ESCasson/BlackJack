import java.util.ArrayList;

public class Dealer {
    private ArrayList<Card> hand;
    private int aceReset;

    public Dealer() {
        this.hand = new ArrayList<>();
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

    public int getValueOfHand() {
        int total = 0;
        for (Card card : hand){
            total += card.getValueFromCard();
        }
        return total - this.aceReset;
    }

    public Card getTopCard() {
        return getHand(0);
    }




    public String getTopCardInfo(){
        Card card = getTopCard();
        RankType ranktype = card.getRank();
        String rank = ranktype.toString();
        SuitType suittype = card.getSuit();
        String suit = suittype.toString();
        String info = rank + " of " + suit;
        return  info;
    }

    public int numberOfAces() {
        int result = 0;
        for(Card card : hand){
            if (card.getRank() == RankType.ACE){
                result += 1;
            }
        }
        return result;
    }

    public boolean isOver21() {
        int total = getValueOfHand();
        if(total > 21){
            return true;
        }else{
            return false;
        }
    }
    public int getAceReset() {
        return this.aceReset;
    }


    public void changeAceReset() {
        if (isOver21() && numberOfAces()>0){
            this.aceReset = 10 * numberOfAces();
        }
    }

}
