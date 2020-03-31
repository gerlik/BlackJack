public class Blackjack {

    /*
    start
    shuffle
    bets
    give cards
    check BlackJack
    hit or stand
    dealer plays
    settle bets
    if it's needed play again
     */

    Deck d = new Deck();
    Hand dealer = new Hand();
    Hand player = new Hand();

    public void startPlay() {

        // Because each game will start with new deck we will generate only 52 cards
        d.generateDecks(4);
        System.out.println("\nYour cards are: ");
        d.drawCards(2, player);// Dealer and player at the beginning of each game draws two cards
        System.out.println("\n\nDealer card is: ");
        d.drawCards(1, dealer);
        if (player.hasBlackjack())
            if (dealer.pushCheck())
            {

            }
            else
                // money *= 1.5;
        dealerTurn();

    }

    private void dealerTurn() {

    }


}
