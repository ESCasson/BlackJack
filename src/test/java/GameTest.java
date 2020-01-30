import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GameTest {
    private Game game;
    private Player player1;
    private Player player2;
    private Player player3;
    private Card  card1;
    private Card  card2;
    private Card  card3;

    @Before
    public void before(){
        game = new Game();
        player1 = new Player();
        player2 = new Player();
        player3 = new Player();
        card1 = new Card(SuitType.CLUBS, RankType.EIGHT);
        card2 = new Card(SuitType.CLUBS, RankType.FIVE);
        card3 = new Card(SuitType.CLUBS, RankType.TEN);
    }

    @Test
    public void canStartWithZeroPlayers(){
        assertEquals(0, game.countPlayers());
    }

    @Test
    public void canAddPlayer(){
        game.addPlayer(player1);
        assertEquals(1, game.countPlayers());
    }

    @Test
    public void canDealPlayersACard(){
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.deal();
        assertNotNull(player1.getHand());
        assertNotNull(player2.getHand());
        assertEquals(50, game.countDeck());
    }

    @Test
    public void canCheckForWinner(){
        game.addPlayer(player1);
        game.addPlayer(player2);
        player1.addCard(card1);
        player2.addCard(card2);
        assertEquals(player1, game.winner());
    }

    @Test
    public void canCheckForWinnerPlayer2(){
        game.addPlayer(player1);
        game.addPlayer(player2);
        player1.addCard(card2);
        player2.addCard(card1);
        assertEquals(player2, game.winner());
    }

    @Test
    public void canCheckForWinnerPlayer3(){
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        player1.addCard(card1);
        player2.addCard(card2);
        player3.addCard(card3);
        assertEquals(player3, game.winner());
    }





}
