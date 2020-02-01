import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DealerTest

{
    private Dealer dealer;
    private Card card;

    @Before
    public void before(){
        dealer = new Dealer();
    }

    @Test
    public void canAddCardToDealer(){
        card = new Card(SuitType.CLUBS, RankType.JACK);
        dealer.addCard(card);
        assertEquals(1, dealer.countHand());
    }

    @Test
    public void canGetetDealerTopCard(){
        card = new Card(SuitType.CLUBS, RankType.JACK);
        dealer.addCard(card);
        assertNotNull(dealer.getTopCard());
    }

    @Test
    public void canGetTopCardInfo(){
        card = new Card(SuitType.CLUBS, RankType.JACK);
        dealer.addCard(card);
        assertEquals("JACK of CLUBS", dealer.getTopCardInfo());
    }


}
