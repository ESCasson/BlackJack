import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest

{
    private Player player;
    private Card card;
    private Card card2;

    @Before
    public void before(){
        player = new Player("Bob");
        card = new Card(SuitType.CLUBS, RankType.JACK);
    }

    @Test
    public void canAddCardToPlayer(){
        player.addCard(card);
        assertEquals(1, player.countHand());
    }

    @Test
    public void canGetValue(){
        assertEquals(10, player.getCardValue(card));
    }

    @Test
    public void canGetValueOfHand(){
        card2 = new Card(SuitType.HEARTS, RankType.JACK);
        player.addCard(card);
        player.addCard(card2);
        assertEquals(20, player.getValueOfHand());
    }
    @Test
    public void canDetectAceIsThere(){
        card2 = new Card(SuitType.HEARTS, RankType.ACE);
        player.addCard(card);
        player.addCard(card2);
        assertEquals(true, player.handContainsAce());

    }
    @Test
    public void canDetectAceIsNotThere(){
        card2 = new Card(SuitType.HEARTS, RankType.TEN);
        player.addCard(card);
        player.addCard(card2);
        assertEquals(false, player.handContainsAce());

    }


}
