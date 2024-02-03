package com.dal.tprojetpizz;

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

public class PizzaView {
    private VBox view = new VBox(5);
    private PizzaModel model;

    public PizzaView(PizzaModel model) {
        this.model = model;
        this.view.setStyle("-fx-background-color: #f4f4f4; -fx-padding: 10;");
        update();
    }

    public Parent asParent() {
        return view;
    }




    public void update() {
        view.getChildren().clear(); // Clear the view for redrawing
        for (Pizza pizza : model.getPizzaList()) {
            HBox pizzaBox = new HBox(10);
            pizzaBox.setAlignment(Pos.CENTER_LEFT); // Alignement des éléments à l'intérieur de la HBox
            pizzaBox.setStyle("-fx-background-color: #ff6666; -fx-border-style: solid inside; -fx-border-width: 0 0 0 5; -fx-border-color: #ff6666;");

            Label nameLabel = new Label(pizza.getName() + " : " + pizza.getIngredients());
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
    }
}
