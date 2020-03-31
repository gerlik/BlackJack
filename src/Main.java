import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello, what is your name? ");
        String name = scan.nextLine();

        System.out.println("How much cash you have today? ");
        double money = scan.nextDouble();

        // New player
        Player player = new Player(name, money);
        System.out.println("Hello, " + name + " we hope you are ready to play some blackjack.\n");

        // Gameplay loop
        while (money > 0) {
            System.out.println("Insert your bet amount: ");
            double bet = scan.nextDouble();

            Blackjack game = new Blackjack();
            game.startPlay();

            System.out.println("Continue playing?");
            String answer = scan.nextLine().toLowerCase();

            // Yes/No
            if (answer.equals("no")) {
                System.out.printf("Thank you for playing!");
                break;
            }
        }

        if (money == 0) {
            System.out.println("Unfortunately you do not have enough funds to play more.");
            System.out.println("You won X ");
        } else {
            System.out.println("You won X , have a great night.");
        }
    }
}