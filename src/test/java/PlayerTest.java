import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PlayerTest

{
    private Player player;
    private Card card;

    @Before
    public void before(){
        player = new Player();
    }

    @Test
    public void canAddCardToPlayer(){
        card = new Card(SuitType.CLUBS, RankType.JACK);
        player.addCard(card);
        assertNotNull(player.getHand());
    }


}
