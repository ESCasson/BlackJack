import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card>  cards;

    public Deck() {
        this.cards = new ArrayList<Card>();
        populateDeck();
        shuffleDeck();
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public int countCards() {

        return this.cards.size();
    }

    public void populateDeck(){
        for (SuitType suit : SuitType.values()){
            for(RankType rank : RankType.values()){
                Card card = new Card(suit, rank);
                addCard(card);
            }
        }
    }

    public void shuffleDeck(){
        Collections.shuffle(cards);
    }

    public Card dealCard() {
        return this.cards.remove(0);
    }
}
