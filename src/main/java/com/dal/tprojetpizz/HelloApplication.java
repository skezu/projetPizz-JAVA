package com.dal.tprojetpizz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        PizzaModel model = new PizzaModel();
        PizzaView view = new PizzaView(model);
        PizzaController controller = new PizzaController(model, view);

        // Pour l'exemple, ajoutons quelques pizzas
        controller.addPizza("Margherita personnalisé", "+ Poivrons");
        controller.addPizza("Bolognaise", "base");
        controller.addPizza("Orientale", "base");
        controller.addPizza("Fermière personnalisé", "+ Oeuf");

        primaryStage.setTitle("Liste des Pizzas");
        primaryStage.setScene(new Scene(view.asParent(), 800, 550));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}