package com.example.td1.Pendu;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.ArrayList;

public class PenduCode extends Application {
    private final Dico dico = new Dico();
    private String mot;
    private ArrayList<Integer> positions;
    private int vies;
    private boolean gameEnded;

    private Label motLabel;
    private Label viesLabel;
    private ArrayList<Button> lettreButtons;

    private ImageView imageView;
    private Image[] viesImages;

    @Override
    public void start(Stage primaryStage) {
        mot = dico.getMot();
        positions = new ArrayList<>();
        vies = 7;
        gameEnded = false;

        motLabel = new Label(hideWord(mot));
        motLabel.setStyle("-fx-font-size: 24");
        viesLabel = new Label("Vies restantes : " + vies);
        viesLabel.setStyle("-fx-font-size: 18");

        HBox inputBox = createInputBox();

        VBox mainBox = new VBox(20);
        mainBox.setAlignment(Pos.CENTER);
        mainBox.setPadding(new Insets(20));
        mainBox.getChildren().addAll(motLabel, viesLabel, inputBox);

        Scene scene = new Scene(mainBox, 400, 300);
        primaryStage.setTitle("Jeu du Pendu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private HBox createInputBox() {
        HBox inputBox = new HBox(10);
        inputBox.setAlignment(Pos.CENTER);

        lettreButtons = new ArrayList<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            Button button = new Button(String.valueOf(c));
            button.setDisable(false);
            char finalC = c;
            button.setOnAction(e -> {
                if (!gameEnded) {
                    button.setDisable(true);
                    checkLetter(finalC);
                    checkGameStatus();
                }
            });
            lettreButtons.add(button);
        }

        Button restartButton = new Button("Recommencer");
        restartButton.setOnAction(e -> restartGame());

        inputBox.getChildren().addAll(lettreButtons);
        inputBox.getChildren().add(restartButton);

        return inputBox;
    }

    private void checkLetter(char letter) {
        ArrayList<Integer> newPositions = dico.getPositions(letter, mot);
        if (newPositions.isEmpty()) {
            vies--;
            updateViesLabel();
        } else {
            positions.addAll(newPositions);
            updateMotLabel();
        }
    }

    private void checkGameStatus() {
        if (positions.size() == mot.length()) {
            gameEnded = true;
            showEndMessage("Vous avez gagné !");
        } else if (vies == 0) {
            gameEnded = true;
            showEndMessage("Vous avez perdu ! Le mot était : " + mot);
        }
    }

    private void restartGame() {
        mot = dico.getMot();
        positions.clear();
        vies = 7;
        gameEnded = false;

        updateMotLabel();
        updateViesLabel();
        resetButtons();
        clearEndMessage();
    }

    private void updateMotLabel() {
        StringBuilder hiddenWord = new StringBuilder();
        for (int i = 0; i < mot.length(); i++) {
            if (positions.contains(i)) {
                hiddenWord.append(mot.charAt(i)).append(" ");
            } else {
                hiddenWord.append("_ ");
            }
        }
        motLabel.setText(hiddenWord.toString());
    }
    private void updateViesLabel() {
        viesLabel.setText("Vies restantes : " + vies);
    }

    private void resetButtons() {
        for (Button button : lettreButtons) {
            button.setDisable(false);
        }
    }

    private void clearEndMessage() {
        motLabel.setText("");
    }

    private void showEndMessage(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Fin de jeu");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private String hideWord(String word) {
        StringBuilder hiddenWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            hiddenWord.append("_ ");
        }
        return hiddenWord.toString();
    }

}
