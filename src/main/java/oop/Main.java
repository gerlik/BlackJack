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
        grid.setStyle("-fx-background-color: #5ead5e;");  // Set intro panel bg to green
        VBox introduction = new VBox();
        introduction.setSpacing(10);

        Text hello = new Text("Hello, we hope you are ready to play some blackjack.\n\r");
        Text askName = new Text("What is your name?");
        TextField name = new TextField("Enter name");
        Text askMoneyAmount = new Text("How much cash you have today?");
        TextField money = new TextField("0.00");
        Text gameInfoText = new Text("\n\rGame starts after you press Enter");

        // Add introduction text to pane and set alignment
        introduction.getChildren().addAll(hello, askName, name, askMoneyAmount, money, gameInfoText); // Add all text and textboxes
        grid.getChildren().add(introduction);
        grid.setAlignment(Pos.CENTER);
        introduction.setAlignment(Pos.CENTER);
        introduction.setStyle("-fx-font: 18 arial;"); // Change fot of VBox
        // TODO Rule page maybe

        // Make gameplay window
        money.setOnKeyPressed(key -> { // If enter pressed open game window
            if (key.getCode().equals(KeyCode.ENTER)) {
                double wallet = Double.parseDouble(money.getText());
                VBox gameWindow = new VBox();
                Text dealerText = new Text("Dealer");
                Text playerText = new Text("You (" + (name.getText()) + ")");
                Text walletText = new Text("Wallet " + wallet);
                gameWindow.getChildren().addAll(dealerText, playerText, walletText);
                gameWindow.setAlignment(Pos.CENTER);
                gameWindow.setStyle("-fx-background-color: #5ead5e;");
                double startMoney = wallet;

                int games_played = 0;
                // Gameplay loop
//                while (wallet > 0) {
//                    if (games_played != 0) {
//                        HBox endGameWindow = new HBox();
//                        Text continuePlayTxt = new Text("Continue playing?");
//                        Button continuePlayBtn = new Button("Yes");
//                        Button cancelPlayBtn = new Button("Cancel");
//                        endGameWindow.getChildren().addAll(continuePlayTxt, continuePlayBtn, cancelPlayBtn);
//                        endGameWindow.setAlignment(Pos.CENTER);
//                        endGameWindow.setStyle("-fx-background-color: #5ead5e;");
//
//                        // Yes/No
//                        cancelPlayBtn.setOnAction(k -> { // If enter pressed open game window
//                            stage.hide();
//                        });
//                    }
//
//                    Text insertBet = new Text("Bet amount: ");
//                    TextField betText = new TextField("5.00");
//                    gameWindow.getChildren().addAll(insertBet, betText);
//                    double bet = Double.parseDouble(betText.getText());
//                    while (bet > wallet) {
//                        Text playerBetLargerThanWalletText = new Text("You do not have that much money. Insert your bet amount: ");
//                        Text insertNewBet = new Text("Bet amount: ");
//                        TextField newBet = new TextField("5.00");
//                        gameWindow.getChildren().addAll(playerBetLargerThanWalletText, insertNewBet, newBet);
//                        bet = Double.parseDouble(newBet.getText());
//                    }
//                    wallet = wallet - bet;
//
//                    Blackjack game = new Blackjack();
//                    double difference = game.startPlay(bet);
//                    wallet += difference;
//                    if (difference > 0)
//                        System.out.println("You won!");
//                    else if (difference == 0)
//                        System.out.println("Draw");
//                    else
//                        System.out.println("Unfortunately you lose :(\n better luck next time");
//                    System.out.printf("\nYour balance now: %s\n", wallet);
//                    games_played++;
//                }

                double difference = wallet - startMoney;
                if (wallet == 0) {
                    Text notEnoughFundsText = new Text("Unfortunately you do not have enough funds to play more.");
                    gameWindow.getChildren().add(notEnoughFundsText);
                } else if (difference > 0) {
                    Text playerWonText = new Text("You won %s, thank you for playing." + difference); // TODO fix
                    gameWindow.getChildren().add(playerWonText);
                } else {
                    Text playerLostText = new Text("You lost %s, thank you for playing." + difference);
                    gameWindow.getChildren().add(playerLostText);
                }

                Scene gameScene = new Scene(gameWindow, 900, 600);
                stage.setTitle("Blackjack");
                stage.setScene(gameScene);
                stage.show();
            }
        });

        Scene scene = new Scene(grid, 900, 600);
        stage.setTitle("Blackjack");
        stage.setScene(scene);
        stage.show();
    }

}