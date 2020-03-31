import java.util.List;

public class Hand extends Blackjack {

    private String ace = "ACE";

    public int calculateHandValue(List<Card> cards) {
        int sum = 0;
        for (Card card : cards) {
            if (card.equals(ace)) {

            } else if (card.equals("JACK") || card.equals("QUEEN") || card.equals("KING")) {
                sum = sum + 10;
            } else {
                // TODO get card 2,3, ..10 int value or make a list somewhere
            }
        }
        return sum;
    }

    public boolean hasBlackjack(int value) {
        if (value == 21) {
            return true;
        }
        return false;
    }


}
