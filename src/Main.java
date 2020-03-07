import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Name: ");
        String name = scan.nextLine();
        Player player = new Player(name);
        System.out.println("Hello, " + name + " we hope you are ready to play some blackjack");

//        System.out.println("Insert the number of other players (1-6): ");
//        int players = scan.nextInt();
//        GeneratePlayers


    }
}