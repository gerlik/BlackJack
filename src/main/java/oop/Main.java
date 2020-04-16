package oop;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;


public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        GridPane grid = new GridPane();
        VBox introduction = new VBox();
        introduction.setSpacing(10);

        // Add background image or color
        Image img = new Image(new File("background-image.jpg").toURI().toString());
//        Image img = new Image("file:background-image.jpg", 320, 320, false, true);
        BackgroundImage bg_img = new BackgroundImage(img, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

        BackgroundFill bg_fill = new BackgroundFill(Color.FORESTGREEN, CornerRadii.EMPTY, Insets.EMPTY);
//        Background bg = new Background(bg_img);
        Background bg = new Background(bg_fill);
        introduction.setBackground(bg);

        Text askName = new Text("Hello, what is your name? ");
        TextField name = new TextField("Enter name");
        Text askMoneyAmount = new Text("How much cash you have today? ");
        TextField money = new TextField("0.00");

//        Text sayHello = new Text("Hello, " + name + " we hope you are ready to play some blackjack.");
        // Add introduction text to pane
        introduction.getChildren().addAll(askName, name, askMoneyAmount, money);
        grid.getChildren().add(introduction);

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

        Scene scene = new Scene(grid, 500, 500);
        stage.setTitle("Blackjack");
        stage.setScene(scene);
        stage.show();
    }

}