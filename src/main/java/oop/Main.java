package oop;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        GridPane grid = new GridPane();
        grid.setStyle("-fx-background-color: #228B22;");  // Set intro panel bg to green
        VBox introduction = new VBox();
        introduction.setSpacing(10);

        Text hello = new Text("Hello, we hope you are ready to play some blackjack.\n\r");
        Text askName = new Text("What is your name?");
        TextField name = new TextField("Enter name");
        Text askMoneyAmount = new Text("How much cash you have today?");
        TextField money = new TextField("0.00");
        Text gameInfoText = new Text("\n\rGame starts after you press Enter");

        // Add introduction text to pane and set alignment
        introduction.getChildren().addAll(hello, askName, name, askMoneyAmount, money,gameInfoText); // Add all text and textboxes
        grid.getChildren().add(introduction);
        grid.setAlignment(Pos.CENTER);
        introduction.setAlignment(Pos.CENTER);
        introduction.setStyle("-fx-font: 18 arial;"); // Change fot of VBox
        // TODO Rule page maybe

        // Make gameplay window
        money.setOnKeyPressed(key -> { // If enter pressed open game window
            if (key.getCode().equals(KeyCode.ENTER)) {
                VBox gameWindow = new VBox();
                Text dealer = new Text("Dealer");
                Text you = new Text("You (" + (name.getText()) + ")");
                Text wallet = new Text("Wallet "+money.getText());
                gameWindow.getChildren().addAll(dealer, you,wallet);
                gameWindow.setAlignment(Pos.CENTER);
                gameWindow.setStyle("-fx-background-color: #228B22;");

                Scene gameScene = new Scene(gameWindow, 900, 600);
                stage.setTitle("Blackjack");
                stage.setScene(gameScene);
                stage.show();
            }
        });

        int games_played = 0;

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

        Scene scene = new Scene(grid, 900, 600);
        stage.setTitle("Blackjack");
        stage.setScene(scene);
        stage.show();
    }

}