package com.example.td1.partie1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;


public class Ex1 extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        BorderPane borderPane = new BorderPane();


        //LEFT
        VBox PrimeVBox = new VBox();
        Menu menu1 = new Menu("File");
        Menu menu2 = new Menu("Edit");
        Menu menu3 = new Menu("Help");
        MenuItem menu11 = new MenuItem("New");      // MENU DE FILE
        MenuItem menu12 = new MenuItem("Open");
        MenuItem menu13 = new MenuItem("Save");
        MenuItem menu14 = new MenuItem("Close");
        menu1.getItems().addAll(menu11, menu12, menu13, menu14);
        MenuItem menu21 = new MenuItem("Cut");  // MENU DE EDIT
        MenuItem menu22 = new MenuItem("Copy");
        MenuItem menu23 = new MenuItem("Paste");
        menu2.getItems().addAll(menu21, menu22, menu23);
        MenuBar menuBar = new MenuBar(menu1, menu2, menu3);
        PrimeVBox.getChildren().addAll(
                menuBar
        );
        borderPane.setTop(PrimeVBox);
        VBox LeftVBox = new VBox();
        Label labelBtn = new Label("Boutons : ");
        Button btn1 = new Button("Bouton 1");
        Button btn2 = new Button("Bouton 2");
        Button btn3 = new Button("Bouton 3");

        Separator sep2 = new Separator();

        LeftVBox.getChildren().addAll(
                labelBtn,
                btn1,
                btn2,
                btn3,
                sep2
        );
        LeftVBox.setAlignment(Pos.CENTER);
        borderPane.setLeft(LeftVBox);




        //MID
        VBox midVBox = new VBox();
        GridPane gridPane = new GridPane();

        Label labelName = new Label("Name:");
        gridPane.add(labelName, 0, 0);
        Label labelEmail = new Label("Email:");
        gridPane.add(labelEmail, 0, 1);
        Label labelPassword = new Label("Password:");
        gridPane.add(labelPassword, 0, 2);
        Button btn4 = new Button("Submit");
        gridPane.add(btn4, 0, 3);
        Button btn5 = new Button("Cancel");
        gridPane.add(btn5, 1, 3);
        TextField nameField = new TextField();
        gridPane.add(nameField, 1, 0);
        TextField emailField = new TextField();
        gridPane.add(emailField, 1, 1);
        TextField passField = new TextField();
        gridPane.add(passField, 1, 2);


        midVBox.getChildren().addAll(
                gridPane
        );
        midVBox.setAlignment(Pos.CENTER);
        borderPane.setCenter(midVBox);

        //BOTTOM
        VBox botVbox = new VBox();
        Label labelBottom = new Label("Ceci est un label de bas de page");
        botVbox.setAlignment(Pos.CENTER);
        botVbox.getChildren().addAll(labelBottom, sep2);
        borderPane.setBottom(botVbox);

        // Ajout du conteneur à la scene
        Scene scene = new Scene(borderPane);

        // Ajout de la scene à la fenêtre et changement de ses paramètres (dimensions et titre)
        primaryStage.setScene( scene );
        primaryStage.setWidth( 600 );
        primaryStage.setHeight( 400 );
        primaryStage.setTitle("Premier exemple manipulant les conteneurs");

        // Affichage de la fenêtre
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}

