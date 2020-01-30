
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DeckTest {

    private Deck deck;
    private Card card;

    @Before
    public void before(){
        card = new Card (SuitType.CLUBS, RankType.ACE);
        deck = new Deck ();
    }

    @Test
    public void canAddCardToDeck(){
        deck.addCard(card);
        assertEquals(53, deck.countCards());
    }

    @Test
    public void canPopulateDeck(){
        assertEquals(52, deck.countCards());
    }

    @Test
    public void canDealCard(){
        assertNotNull(deck.dealCard());
        assertEquals(51, deck.countCards());
    }



}
//Card@3b95a09c