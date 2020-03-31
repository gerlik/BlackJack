import java.util.Scanner;

public class Blackjack {
    Deck d = new Deck();
    Hand dealer = new Hand();
    Hand player = new Hand();
    Scanner sc = new Scanner(System.in);

    public double startPlay(double bet) {
        double new_bet = bet;

        // generate deck
        d.generateDecks(4);

        // player draws
        System.out.println("\nYour cards are: ");
        d.drawCards(2, player);

        // dealer draw
        System.out.println("\nDealer card is: ");
        d.drawCards(1, dealer);

        // check for BlackJack
        if (player.hasBlackjack()) {
            if (dealer.pushCheck()) {
                if (dealer.hasOnlyAce()) {
                    // ask player what he prefer take his win or play
                    // if player choose money give him twice his bet
                    System.out.println("Money or play?");
                    String ans = sc.nextLine();
                    if (ans.toLowerCase().equals("money")) {
                        return 2 * bet;
                    }
                }
                // if player choose to play starts dealer's turn
                dealerTurnPlayerHasBlackJack();
                // if dealer also have BlackJack than it's draw and player will receive his bet
                if (dealer.hasBlackjack()) {
                    return bet;
                }
            }
            // if dealer doesn't have BlackJack than player receives 3/2 of his bet
            else {
                return 2.5 * bet;
            }
        }
        // if player doesn't have BlackJack he need to choose want he hit or stand
        else {
            System.out.println("Hit or stand?");
            String ans = sc.nextLine();
            if (ans.toLowerCase().equals("hit")) {
                // if player hits bet will change
                System.out.println("What's your bet?");
                new_bet += Integer.parseInt(sc.nextLine());
                d.drawCards(1, player);
                if (player.bustCheck())
                    return 0;
            }

            // this procedure can be done multiple times
            while (ans.equals("hit") && player.calculateHandValue() <= 21)
            {
                System.out.println("Hit or stand?");
                ans = sc.nextLine();
                if (ans.toLowerCase().equals("hit")) {
                    System.out.println("What's your bet?");
                    new_bet += Integer.parseInt(sc.nextLine());
                    d.drawCards(1, player);
                    if (player.bustCheck())
                        return 0;
                }
            }

            // after player's turn starts dealer's turn
            dealerTurn();
            if (dealer.bustCheck())
                return 1.7 * new_bet;
            else if (player.calculateHandValue() > dealer.calculateHandValue())
                return 1.7 * new_bet;
        }
        return 0;
    }

    private void dealerTurnPlayerHasBlackJack() {
        while (dealer.calculateHandValue() < 21) {
            System.out.print("Dealer draws: ");
            d.drawCards(1, dealer);
        }
    }

    private void dealerTurn() {
        while (dealer.calculateHandValue() < 17) {
            System.out.print("Dealer draws: ");
            d.drawCards(1, dealer);
        }
    }

    //public double
//TODO check for bet (bet > 0 and maybe new_bet < bet)
}
