import java.util.*;

public class Deck extends Blackjack {

    List<String> deck = new ArrayList<>(Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "JACK", "QUEEN", "KING", "ACE"));

    public List<String> getDeck() {
        return deck;
    }

    public void generateDecks(int nr) {
        List<String> decks = new ArrayList<>();
        for (int i = 0; i < nr; i++) {
            for (String card : deck) {
                decks.add(card);
            }
        }

        // Shuffle the deck
        Collections.shuffle(decks);
    }

    public void drawOneCard() {
        Random random = new Random();
        int nextCardToPick = random.nextInt(deck.size());
        System.out.println(deck.get(nextCardToPick));
    }

}
