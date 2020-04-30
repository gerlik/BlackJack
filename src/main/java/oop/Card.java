package oop;

public class Card {

    private int suit;
    private int value;
    private String[] suits = {"C", "D", "H", "S"};
    private String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    public Card(int suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public String getSuit() {
        return suits[suit];
    }

    public String getValue() {
        return values[value - 2];
    }

    @Override
    public String toString() {
        return getValue() + getSuit();
    }
}