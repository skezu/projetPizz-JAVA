package com.dal.tprojetpizz;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;


public class PizzaView {
    private VBox view = new VBox(5);
    private PizzaModel model;
    private ProduitCommandeModel modelPC;
    private Timeline everyMinuteUpdater;

    public PizzaView(PizzaModel model, ProduitCommandeModel modelPC) {
        this.model = model;
        this.modelPC = modelPC;
        this.view.setStyle("-fx-background-color: #f4f4f4; -fx-padding: 10;");
        initTimeUpdater();
        update();
    }

    public Parent asParent() {
        return view;
    }

    private void initTimeUpdater() {
        // Créez un Timeline pour appeler update() toutes les minutes
        everyMinuteUpdater = new Timeline(new KeyFrame(Duration.minutes(1), e -> update()));
        everyMinuteUpdater.setCycleCount(Timeline.INDEFINITE);
        everyMinuteUpdater.play();
    }


    public void update() {
        view.getChildren().clear(); // Clear the view for redrawing
        for (Pizza pizza : model.getPizzaList()) {
            HBox pizzaBox = new HBox(10);
            pizzaBox.setAlignment(Pos.CENTER_LEFT); // Alignement des éléments à l'intérieur de la HBox
            pizzaBox.setStyle("-fx-background-color: #ff6666; -fx-border-style: solid inside; -fx-border-width: 0 0 0 5; -fx-border-color: #ff6666;");

            Label nameLabel = new Label("N°" + pizza.getCmdId() + " - " + pizza.getName() + " : " + pizza.getIngredients());
            nameLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: black;"); // Pour le <strong> en HTML

            // Créez un Spacer pour pousser le bouton vers la droite
            Region spacer = new Region();
            HBox.setHgrow(spacer, Priority.ALWAYS); // Le spacer prendra tout l'espace horizontal disponible

            Button doneButton = new Button("Terminé");
            doneButton.setStyle("-fx-background-color: #4cae4c; -fx-text-fill: white; -fx-padding: 10 20;");
            doneButton.setOnAction(e -> {model.removePizza(pizza); update();}); // Remove pizza on button click

            pizzaBox.getChildren().addAll(nameLabel, spacer, doneButton); // Ajoutez le spacer avant le bouton
            view.getChildren().add(pizzaBox);

        }
        // Créer une vue horizontale pour afficher deux labels
        HBox footer = new HBox(10);
        footer.setAlignment(Pos.CENTER_LEFT); // Alignement des éléments à l'intérieur de la HBox
        Region spacer2 = new Region();
        HBox.setHgrow(spacer2, Priority.ALWAYS);
        // Créer un Label qui indique le temps actuel ainsi que l'action a faire "Pizza à réaliser"
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String formattedTime = currentTime.format(formatter);
        Label timeLabel = new Label("Temps actuel : " + formattedTime);
        timeLabel.setStyle("-fx-font-style: italic;");
        Label infoLabel = new Label("Pizza à réaliser");
        footer.getChildren().addAll(infoLabel, spacer2, timeLabel);
        view.getChildren().add(footer);
        //updateProduitsCommandeView(modelPC.getProduitsCommande());
    }

    // Dans votre PizzaView ou une vue similaire, ajoutez une méthode pour afficher les produits de commande
    /*public void updateProduitsCommandeView(ObservableList<ProduitCommande> produitsCommande) {
        for (ProduitCommande produit : produitsCommande) {
            HBox produitBox = new HBox(10);
            Label produitLabel = new Label("Cmd N°" + produit.getIdProduitCmd() + " - " + produit.getNom());
            // Stylez selon vos besoins, par exemple, avec une couleur différente
            produitBox.setStyle("-fx-background-color: #86C232; -fx-padding: 5;");
            produitLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: black;");
            produitBox.getChildren().add(produitLabel);
            Button doneButton = new Button("Terminé");
            doneButton.setStyle("-fx-background-color: #4cae4c; -fx-text-fill: white; -fx-padding: 10 20;");
            doneButton.setOnAction(e -> { modelPC.removeProduitCommande(produit); update();});
            produitBox.getChildren().add(doneButton);
            view.getChildren().add(produitBox);
        }
    }*/


}
