package oop;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        GridPane grid = new GridPane();

        Text askName = new Text("Hello, what is your name? ");
        grid.getChildren().add(askName);
        int games_played = 0;
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Hello, what is your name? ");
//        String name = "hey";

//        System.out.println("How much cash you have today? ");
//        double money = Double.parseDouble(scan.nextLine());
//        double startMoney = money;

//        System.out.println("Hello, " + name + " we hope you are ready to play some blackjack.\n");

        // Gameplay loop
//        while (money > 0) {
//            if (games_played != 0) {
//                System.out.println("Continue playing?");
//                String answer = scan.nextLine();
//
//                // Yes/No
//                if (answer.toLowerCase().equals("no")) {
//                    break;
//                }
//            }
//
//            System.out.println("Insert your bet amount: ");
//            double bet = Double.parseDouble(scan.nextLine());
//            while (bet > money) {
//                System.out.println("You do not have that much money. Insert your bet amount: ");
//                bet = Double.parseDouble(scan.nextLine());
//            }
//            money -= bet;
//
//            Blackjack game = new Blackjack();
//            double difference = game.startPlay(bet);
//            money += difference;
//            if (difference > 0)
//                System.out.println("You won!");
//            else if (difference == 0)
//                System.out.println("Draw");
//            else
//                System.out.println("Unfortunately you lose :(\n better luck next time");
//            System.out.printf("\nYour balance now: %s\n", money);
//            games_played++;
//        }

//        double difference = money - startMoney;
//        if (money == 0) {
//            System.out.println("Unfortunately you do not have enough funds to play more.");
//        } else if (difference > 0) {
//            System.out.printf("You won %s, thank you for playing.", difference);
//        } else {
//            System.out.printf("You lost %s, thank you for playing.", difference);
//        }

        Scene scene = new Scene(grid, 500, 650, Color.SNOW);  // luuakse stseen
        stage.setTitle("Blackjack");
        stage.setScene(scene);
        stage.show();
    }
}