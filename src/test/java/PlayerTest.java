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
        card2 = new Card(SuitType.HEARTS, RankType.ACE);
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
        player.addCard(card);
        player.addCard(card2);
        assertEquals(21, player.getValueOfHand());
    }
    @Test
    public void canDetectNumberAceInHand(){
        Card card3 = new Card(SuitType.CLUBS, RankType.ACE);
        player.addCard(card);
        player.addCard(card2);
        player.addCard(card3);
        assertEquals(2, player.numberOfAces());

    }
    @Test
    public void canDetectAceIsNotThere(){
        Card card3 = new Card(SuitType.HEARTS, RankType.TWO);
        player.addCard(card);
        player.addCard(card3);
        assertEquals(0, player.numberOfAces());

    }

    @Test
    public void canDetectIfOver21True(){
        Card card3 = new Card(SuitType.CLUBS, RankType.ACE);
        player.addCard(card2);
        player.addCard(card3);
        assertEquals(true, player.isOver21());
    }

    @Test
    public void canDetectIfOver21False(){
        player.addCard(card);
        player.addCard(card2);
        assertEquals(false, player.isOver21());
    }

    @Test
    public void canDetectIfHandValue21True(){
        player.addCard(card);
        player.addCard(card2);
        assertEquals(true, player.is21());
    }

    @Test
    public void canDetectIfHandValue21False(){
        player.addCard(card);
        player.addCard(card);
        assertEquals(false, player.is21());
    }

    @Test
    public void canChangeAceReset(){
        player.addCard(card);
        player.addCard(card2);
        player.addCard(card2);
        player.changeAceReset();
        assertEquals(-20, player.getAceReset());
    }


}
