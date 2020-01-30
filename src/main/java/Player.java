public class Player {
    private Card hand;

    public Player() {
        this.hand = null;
    }

    public Card getHand() {
        return hand;
    }

    public void addCard(Card card) {
        this.hand = card;
    }


}
