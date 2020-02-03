import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GameTest {
    private Game game;
    private Game game2;
    private Game game3;

    private Player player1;
    private Player player01;
    private Player player2;
    private Player player02;
    private Player player3;
    private Dealer dealer;
    private Card card1;
    private Card card2;
    private Card card3;
    private Card card4;

    @Before
    public void before() {
        game = new Game();
        game2 = new Game();
        game3 = new Game();
        player1 = new Player("Bob");
        player2 = new Player("Tina");
        player3 = new Player("Phil");
        this.game2.addPlayer(player1);
        this.game2.addPlayer(player2);
        player01 = this.game2.getPlayer(0);
        player02 = this.game2.getPlayer(1);


        card1 = new Card(SuitType.CLUBS, RankType.EIGHT);
        card2 = new Card(SuitType.CLUBS, RankType.FIVE);
        card3 = new Card(SuitType.CLUBS, RankType.TEN);
        card4 = new Card(SuitType.DIAMONDS, RankType.ACE);

        player01.addCard(card1);
        player01.addCard(card2);
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
        this.game.addPlayer(player3);
        this.game.addPlayer(player2);
        this.game.deal(2);
        assertEquals(2, this.game.countHandPlayer(0));
        assertEquals(2, this.game.countHandPlayer(1));
        assertEquals(2, this.game.countHandDealer());
        assertEquals(46, this.game.countDeck());
    }

    @Test
    public void canGetValueOfHand() {
        assertEquals(13, this.game2.getPlayerHandValue(player01));
    }


    @Test
    public void canCompareHandsPlayer() {
        player02.addCard(card3);
        player02.addCard(card4);
        assertEquals(player02, this.game2.winnerPlayer());


    }
    @Test
    public void canTellIfDealerIsWinnerTrue(){
        Card card5 = new Card(SuitType.DIAMONDS, RankType.TWO);
        Card card6 = new Card(SuitType.DIAMONDS, RankType.THREE);
        Player player02 = this.game2.getPlayer(1);
        player02.addCard(card5);
        player02.addCard(card6);
        this.game2.addCardDealer(card3);
        this.game2.addCardDealer(card4);
        assertEquals(true, this.game2.isDealerWinner());
    }

    @Test
    public void canTellIfDealerIsWinnerFalse(){
        Card card5 = new Card(SuitType.DIAMONDS, RankType.TWO);
        Card card6 = new Card(SuitType.DIAMONDS, RankType.THREE);
        Player player02 = this.game2.getPlayer(1);
        player02.addCard(card3);
        player02.addCard(card4);
        this.game2.addCardDealer(card5);
        this.game2.addCardDealer(card6);
        assertEquals(false, this.game2.isDealerWinner());
    }

    @Test
    public void canCompareHandsPlayerDealerDealerWins(){
        Player player02 = this.game2.getPlayer(1);
        player02.addCard(card1);
        player02.addCard(card2);
        this.game2.addCardDealer(card3);
        this.game2.addCardDealer(card4);
        assertEquals("House wins.", this.game2.winnerOverall());
    }

    @Test
    public void canCompareHandsPlayerDealerPlayerWins(){
        Player player02 = this.game2.getPlayer(1);
        player02.addCard(card3);
        player02.addCard(card4);
        this.game2.addCardDealer(card1);
        this.game2.addCardDealer(card2);
        assertEquals("Tina wins.", this.game2.winnerOverall());
    }
    @Test
    public void canCompareHandsPlayerDealerDraw(){
        Player player02 = this.game2.getPlayer(1);
        player02.addCard(card3);
        player02.addCard(card4);
        this.game2.addCardDealer(card3);
        this.game2.addCardDealer(card4);
        assertEquals("It's a Draw.", this.game2.winnerOverall());
    }

    @Test
    public void canGetNumberOf21OfPlayers(){
        this.game3.addPlayer(player2);
        this.game3.addPlayer(player3);
        Player player02 = this.game3.getPlayer(0);
        Player player03 = this.game3.getPlayer(1);
        player02.addCard(card3);
        player02.addCard(card4);
        player03.addCard(card3);
        player03.addCard(card4);
        assertEquals(2, game3.countNumberOf21());

    }

    @Test
    public void canGetHightest(){
        this.game3.addPlayer(player2);
        this.game3.addPlayer(player3);
        Player player02 = this.game3.getPlayer(0);
        Player player03 = this.game3.getPlayer(1);
        player02.addCard(card3);
        player02.addCard(card4);
        player03.addCard(card3);
        player03.addCard(card4);
        assertEquals(21, game3.getHighest());
    }

    @Test
    public void canCountHightest(){
        this.game3.addPlayer(player2);
        this.game3.addPlayer(player3);
        Player player02 = this.game3.getPlayer(0);
        Player player03 = this.game3.getPlayer(1);
        player02.addCard(card3);
        player02.addCard(card4);
        player03.addCard(card3);
        player03.addCard(card4);
        assertEquals(2, game3.countNumberOfHighest());
    }

    @Test
    public void canAddCardToPlayer(){
        this.game2.addCardPlayer(card1, player01);
        assertEquals(3, game2.countHandPlayer(0));
    }

    @Test
    public void canGetDealerToCardInfo(){
        this.game2.addCardDealer(card1);
        assertEquals("EIGHT of CLUBS", this.game2.getDealerCardInfo());
    }

    @Test
    public void getPlayersCardInfo(){
        Player player02 = this.game2.getPlayer(1);
        player02.addCard(card3);
        player02.addCard(card4);
        String message = "Tina's hand is card1: TEN of CLUBS, card2: ACE of DIAMONDS,";
        assertEquals(message, game2.getPlayersHand(player02) );

    }

    @Test
    public void canUpdatePlayers(){
        ArrayList<Player> testArray = new ArrayList<>();
        testArray.add(player1);
        game.updatePlayers(testArray);
        assertEquals(1, game.countPlayers());
    }

    @Test
    public void canGetDealerValue(){
        game.addCardDealer(card1);
        assertEquals(8, game.getDealerHandValue());
    }
    @Test
    public void getPlayerWithLargestSizeOfHandOfDraw(){
        Card card07 = new Card(SuitType.HEARTS, RankType.SEVEN);
        Card card04 = new Card(SuitType.HEARTS, RankType.FOUR);
        Card card02 = new Card(SuitType.HEARTS, RankType.TWO);
        player01.addCard(card1);
        player01.addCard(card2);
        player02.addCard(card07);
        player02.addCard(card04);
        player02.addCard(card02);
        Player winningPlayer = game2.getPlayerWithLargestSizeHand();
        assertEquals(player02.getName(), winningPlayer.getName());

    }

}




