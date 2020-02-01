import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GameTest {
    private Game game;
    private Player player1;
    private Player player2;
    private Player player3;
    private Dealer dealer;
    private Card card1;
    private Card card2;
    private Card card3;

    @Before
    public void before() {
        game = new Game();
        player1 = new Player("Bob");
        player2 = new Player("Tina");
        player3 = new Player("Phil");
        card1 = new Card(SuitType.CLUBS, RankType.EIGHT);
        card2 = new Card(SuitType.CLUBS, RankType.FIVE);
        card3 = new Card(SuitType.CLUBS, RankType.TEN);
    }

    @Test
    public void canStartWithZeroPlayers() {
        assertEquals(0, game.countPlayers());
    }

    @Test
    public void canAddPlayer() {
        game.addPlayer(player1);
        assertEquals(1, game.countPlayers());
    }

    @Test
    public void canDealCards() {
        this.game.addPlayer(player1);
        this.game.addPlayer(player2);
        this.game.deal(2);
        assertEquals(2, this.game.countHandPlayer(0));
        assertEquals(2, this.game.countHandPlayer(1));
        assertEquals(2, this.game.countHandDealer());
        assertEquals(46, this.game.countDeck());
    }

}


