public class Card {

    private int suit;
    private int value; // ?
    private String[] suits = {"CLUBS", "DIAMONDS", "HEARTS", "SPADES"}; // ♣ , ♦ , ♥, ♠

    public Card(int suit) {
        this.suit = suit;
    }

    public int getSuit() {
        return suit;
    }

    // TODO toString
}
