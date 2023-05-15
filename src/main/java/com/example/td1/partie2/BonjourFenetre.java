package com.example.td1.partie2;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;


public class BonjourFenetre extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Création d'un conteneur VBox avec ses éléments centrés
        VBox vbox = new VBox();
        vbox.setAlignment( Pos.CENTER );

        // Création et ajout du label au conteneur
        Label helloLabel = new Label("Bonjour à tous !");
        vbox.getChildren().add( helloLabel );

        // Création de la scene
        Scene scene = new Scene( vbox );


        // Ajout de la scene à la fenêtre
        primaryStage.setScene( scene );

        // Ajout d'un champ de saisi de texte de taille 180 pixels
        TextField nameField = new TextField("Veuillez saisir un nom");
        nameField.setMaxWidth(180.0d);
        nameField.setFont( Font.font("Courier", FontWeight.NORMAL, 12) );
        vbox.getChildren().add( nameField );

        // Ajout d'un bouton avec du texte
        Button button = new Button("Dire bonjour");
        vbox.getChildren().add( button );

        primaryStage.setTitle("Hello application");
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);
        primaryStage.show();
    }
}
