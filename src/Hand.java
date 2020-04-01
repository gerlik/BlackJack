import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cardsInHand = new ArrayList<>();
    private int value;

    public int calculateHandValue() {
        int acesCount = 0;
        int sum = 0;
        for (Card card : cardsInHand) {
            String cardValue = card.getValue();

            if (cardValue.equals("A")) {
                acesCount += 1;
            } else if (cardValue.equals("J") || cardValue.equals("Q") || cardValue.equals("K")) {
                sum += 10;
            } else {
                sum += Integer.parseInt(cardValue);
            }
        }

        // Search best value for hand with ace or aces
        if (acesCount > 0) {
            int bestValue = sum + acesCount;
            int distance = Math.abs(21 - bestValue);
            for (int i = 1; i <= acesCount; i++) {
                int temp_value = sum + i * 11 + (acesCount - i);
                int temp_distance = Math.abs(21 - temp_value);
                if (temp_value <= 21 && temp_distance < distance) {
                    distance = temp_distance;
                    bestValue = temp_value;
                }
            }
            this.value = bestValue;
            return bestValue;
        } else
            this.value = sum;
        return sum;
    }

    public void addCardsToHand(Card card) {
        this.cardsInHand.add(card);
    }

    public boolean pushCheck() {
        return value >= 10;
    }

    public boolean bustCheck() {
        return value > 21;
    }

    public boolean hasBlackjack() {
        return value == 21;
    }

    public boolean hasOnlyAce() {
        return value == 11 && cardsInHand.size() == 1;
    }
}
