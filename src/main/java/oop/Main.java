package oop;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.MalformedURLException;


public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        GridPane grid = new GridPane();
        grid.setStyle("-fx-background-color: #5ead5e;");  // Set intro panel bg to green
        VBox introductionVBox = new VBox();
        introductionVBox.setSpacing(10);

        Text helloText = new Text("Hello, we hope you are ready to play some blackjack.\n\r");
        Text nameText = new Text("What is your name?");
        TextField name = new TextField("Enter name");
        Text askMoneyText = new Text("How much cash you have today?");
        TextField money = new TextField("100.00");
        Text gameInfoText = new Text("\n\rGame starts after you press Enter");

        // Add introduction text to pane and set alignment
        introductionVBox.getChildren().addAll(helloText, nameText, name, askMoneyText, money, gameInfoText); // Add all text and textboxes
        grid.getChildren().add(introductionVBox);
        grid.setAlignment(Pos.CENTER);
        introductionVBox.setAlignment(Pos.CENTER);
        introductionVBox.setStyle("-fx-font: 18 arial;"); // Change fot of VBox
        // TODO Rule page maybe

        // Make gameplay window
        money.setOnKeyPressed(key -> { // If enter pressed open game window
            if (key.getCode().equals(KeyCode.ENTER)) {
                // TODO Erinditöötluse abil tagada, et toimuks mõistlik reageerimine (vähemalt mõnedele) kasutaja ekslikele tegevustele (nt. sisestustele).
                try {
                    if (name.getText().equals("")) {
                        throw new NoNameException("There was no name inserted.");
                    }
                } catch (NoNameException e) {
                    System.out.println(e.getMessage());
                }

                double wallet = Double.parseDouble(money.getText());
                VBox gameWindowVBox = new VBox();
                Text dealerText = new Text("Dealer");
                Text playerText = new Text("You (" + (name.getText()) + ")");
                Text walletText = new Text("Wallet " + wallet);
                gameWindowVBox.getChildren().addAll(dealerText, playerText, walletText);
                gameWindowVBox.setAlignment(Pos.CENTER);
                gameWindowVBox.setStyle("-fx-background-color: #5ead5e;");
                double startMoney = wallet;

                int games_played = 0;
                // Gameplay loop
                while (wallet > 0) {
                    if (games_played != 0) {
                        HBox endGameWindowHBox = new HBox();
                        Text continuePlayTxt = new Text("Continue playing?");
                        Button continuePlayBtn = new Button("Yes");
                        Button cancelPlayBtn = new Button("Cancel");
                        endGameWindowHBox.getChildren().addAll(continuePlayTxt, continuePlayBtn, cancelPlayBtn);
                        endGameWindowHBox.setAlignment(Pos.CENTER);
                        endGameWindowHBox.setStyle("-fx-background-color: #5ead5e;");

                        // Yes/No
                        cancelPlayBtn.setOnAction(k -> { // Close window when Cancel pressed
                            stage.hide();
                        });
                    }

                    Text insertBetText = new Text("Bet amount: ");
                    TextField betField = new TextField("5.00");
                    gameWindowVBox.getChildren().addAll(insertBetText, betField);
                    double bet = Double.parseDouble(betField.getText());
                    while (bet > wallet) {
                        Text playerBetLargerThanWalletText = new Text("You do not have that much money. Insert your bet amount: ");
                        Text insertNewBetText = new Text("Bet amount: ");
                        TextField newBetField = new TextField("5.00");
                        gameWindowVBox.getChildren().addAll(playerBetLargerThanWalletText, insertNewBetText, newBetField);
                        bet = Double.parseDouble(newBetField.getText());
                    }
                    wallet = wallet - bet;

                    Blackjack game = new Blackjack();
                    double difference = 0;
                    try {
                        difference = game.startPlay(bet, gameWindowVBox);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    wallet += difference;
                    if (difference > 0) {
                        Text playerWonText = new Text("You won!");
                        gameWindowVBox.getChildren().add(playerWonText);
                    } else if (difference == 0) {
                        Text drawText = new Text("Draw");
                        gameWindowVBox.getChildren().add(drawText);
                    } else {
                        Text playerLostText = new Text("Unfortunately you lose :(\n better luck next time");
                        gameWindowVBox.getChildren().add(playerLostText);
                    }
                    System.out.printf("\nYour balance now: %s\n", wallet);
                    games_played++;
                }

                double difference = wallet - startMoney;
                if (wallet == 0) {
                    Text notEnoughFundsText = new Text("Unfortunately you do not have enough funds to play more.");
                    gameWindowVBox.getChildren().add(notEnoughFundsText);
                } else if (difference > 0) {
                    Text playerWonText = new Text("You won %s, thank you for playing." + difference); // TODO fix
                    gameWindowVBox.getChildren().add(playerWonText);
                } else {
                    Text playerLostText = new Text("You lost %s, thank you for playing." + difference);
                    gameWindowVBox.getChildren().add(playerLostText);
                }

                Scene gameScene = new Scene(gameWindowVBox, 900, 600);
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