package oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    Random random = new Random();
    private List<Card> currentDeck = new ArrayList<>();
    private List<Integer> indexesOfPlayedCards = new ArrayList<>();

    public void generateDecks(int nr) {
        List<Card> deck = new ArrayList<>();
        for (int i = 0; i < nr; i++) {
            for (int j = 2; j < 15; j++) {
                deck.add(new Card(0, j));// Add clubs
                deck.add(new Card(1, j));// Add diamonds
                deck.add(new Card(2, j));// Add hearts
                deck.add(new Card(3, j));// Add spades
            }
        }

        // Shuffle the deck
        Collections.shuffle(deck);
        currentDeck = deck;
    }

    public List<String> drawCards(int count, Hand whoDraws) {
        /*
            Dealer -- 0
            Player -- 1

         loop to draw multiple cards if needed
         */
        List<String> cards = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int nextCardIndex = random.nextInt(currentDeck.size());
            Card nextCard = currentDeck.get(nextCardIndex);
            while (indexesOfPlayedCards.contains(nextCardIndex)) {
                nextCardIndex = random.nextInt(currentDeck.size());
                nextCard = currentDeck.get(nextCardIndex);
            }
            cards.add(nextCard.toString()); // Add to list
            System.out.println(nextCard.toString()); // TODO remove later
            whoDraws.addCardsToHand(nextCard);
            indexesOfPlayedCards.add(nextCardIndex);
        }
        return cards;
    }
}
