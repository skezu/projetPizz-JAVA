package com.dal.tprojetpizz;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class CommandeView {
    private VBox view = new VBox(10);
    private CommandeModel model;

    public CommandeView(CommandeModel model) {
        this.model = model;
        update();
    }

    public Parent asParent() {
        return view;
    }

    public void update() {
        view.getChildren().clear();
        for (Commande commande : model.getCommandes()) {
            HBox commandeBox = new HBox(10);
            Label commandeLabel = new Label("Commande ID: " + commande.getIdCommande() + ", Statut: " + commande.getStatut());
            Button doneButton = new Button("Terminé");
            doneButton.setOnAction(e -> {
                model.removeCommande(commande);
                update(); // Rafraîchit la vue après suppression
            });
            commandeBox.getChildren().addAll(commandeLabel, doneButton);
            view.getChildren().add(commandeBox);
        }
    }
}
