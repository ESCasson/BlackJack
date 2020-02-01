import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest

{
    private Player player;
    private Card card;

    @Before
    public void before(){
        player = new Player("Bob");
    }

    @Test
    public void canAddCardToPlayer(){
        card = new Card(SuitType.CLUBS, RankType.JACK);
        player.addCard(card);
        assertEquals(1, player.countHand());
    }


}
