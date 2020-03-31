public class Blackjack {

    Deck d = new Deck();
    Dealer dealer = new Dealer();
    Hand hand = new Hand();

    public void startPlay() {

        // Usually there is at least 4 decks
        d.generateDecks(4);
        d.drawOneCard();


    }


}
