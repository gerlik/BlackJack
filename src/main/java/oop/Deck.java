package oop;

import java.util.*;

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

    public void drawCards(int count, Hand whoDraws) {
        /*
            Dealer -- 0
            Player -- 1

         loop to draw multiple cards if needed
         */
        for (int i = 0; i < count; i++) {
            int nextCardIndex = random.nextInt(currentDeck.size());
            Card nextCard = currentDeck.get(nextCardIndex);
            while (indexesOfPlayedCards.contains(nextCardIndex)) {
                nextCardIndex = random.nextInt(currentDeck.size());
                nextCard = currentDeck.get(nextCardIndex);
            }
            System.out.println(nextCard.toString());
            whoDraws.addCardsToHand(nextCard);
            indexesOfPlayedCards.add(nextCardIndex);
        }
    }
}
