import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand;
    private String name;
    private int aceReset;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.aceReset = 0;
    }

    public int getCardValue(Card card){
        return card.getValueFromCard();
    }
    public String getName(){
        return this.name;
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

    public boolean is21() {
        int total = getValueOfHand();
        if(total == 21)
            {return true;}
        else
            {return false;}
        }

    public int getAceReset() {
        return this.aceReset;
    }

    public void changeAceReset() {
        if (isOver21() && numberOfAces()>0){
            this.aceReset = -10 * numberOfAces();
        }
    }
}

