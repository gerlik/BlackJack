import java.util.Scanner;

public class Blackjack {
    private Deck deck = new Deck();
    private Hand dealer = new Hand();
    private Hand player = new Hand();
    private Scanner sc = new Scanner(System.in);

    public double startPlay(double bet) {
        double new_bet = bet;

        // generate deck
        deck.generateDecks(4);

        // player draws
        System.out.println("\nYour cards are: ");
        deck.drawCards(2, player);

        // dealer draws
        System.out.println("\nDealer card is: ");
        deck.drawCards(1, dealer);

        // Check for BlackJack
        if (player.hasBlackjack()) {
            if (dealer.pushCheck()) {
                if (dealer.hasOnlyAce()) {
                    // ask player what he prefers: take his win or play
                    // if player chooses money give him twice his bet
                    System.out.println("Money or play?");
                    String ans = sc.nextLine();
                    if (ans.toLowerCase().equals("money")) {
                        return 2.5 * bet;
                    }
                }
                // if player choose to play, start dealer's turn
                dealerTurnPlayerHasBlackJack();
                // if dealer also has BlackJack then it's a draw and player will receive his bet
                if (dealer.hasBlackjack()) {
                    return bet;
                }
            }
            // if dealer doesn't have BlackJack then player receives 3/2 of his bet
            else {
                return 3 * bet;
            }
        }

        // If player doesn't have BlackJack he needs to choose to hit or stand
        else {
            System.out.println("\nHit or stand?");
            String ans = sc.nextLine();
            System.out.println();
            if (ans.toLowerCase().equals("hit")) {
                // if player hits, bet will change
                System.out.println("What's your bet?");
                new_bet = Integer.parseInt(sc.nextLine());
                betCheck(bet, new_bet);
                new_bet += new_bet;
                deck.drawCards(1, player);
                System.out.println();
                if (player.bustCheck())
                    return 0;
            }

            // this procedure can be done multiple times
            while (ans.equals("hit") && player.calculateHandValue() <= 21) {
                System.out.println("\nHit or stand?");
                ans = sc.nextLine();
                System.out.println();
                if (ans.toLowerCase().equals("hit")) {
                    System.out.println("What's your bet?");
                    new_bet = Integer.parseInt(sc.nextLine());
                    betCheck(bet, new_bet);
                    new_bet += new_bet;
                    deck.drawCards(1, player);
                    System.out.println();
                    if (player.bustCheck()) {
                        return 0;
                    }
                }
            }

            // after player's turn dealer's turn starts
            dealerTurn();
            if (dealer.bustCheck())
                return 2 * new_bet;
            else if (player.calculateHandValue() > dealer.calculateHandValue())
                return 2 * new_bet;
            else if (player.calculateHandValue() == dealer.calculateHandValue())
                return new_bet;
        }
        return 0;
    }

    private void dealerTurnPlayerHasBlackJack() {
        while (dealer.calculateHandValue() < 21) {
            System.out.print("Dealer draws: ");
            deck.drawCards(1, dealer);
        }
    }

    private void dealerTurn() {
        while (dealer.calculateHandValue() < 17) {
            System.out.print("Dealer draws: ");
            deck.drawCards(1, dealer);
        }
    }

    // First bet has to be the biggest
    public void betCheck(double bet, double new_bet) {
        Scanner scan = new Scanner(System.in);
        if (bet > 0) {
            while (new_bet > bet) {
                System.out.println("Current bet cannot be bigger than your very first bet. What's your bet? ");
                new_bet = Double.parseDouble(scan.nextLine());
            }
        }
    }

}
