import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        System.out.println("Name: ");
//        String name = scan.nextLine();

//        System.out.println("Wallet: ");
//        double money = scan.nextDouble();

//        Player player = new Player(name, money);
//        System.out.println("Hello, " + name + " we hope you are ready to play some blackjack\n");

//        System.out.println("Bet amount: ");
//        double bet = scan.nextDouble();

        // Dealer events, generate other players maybe
        // Create 2 decks
        Deck d = new Deck();
        d.generateDecks(2);
        d.drawOneCard();


        // Gameplay loop


//        System.out.println("Continue playing?");
//        String answer = scan.nextLine();
//        if (answer.equals("no")){
//            System.out.printf("Thank you for playing");
//        }

    }
}