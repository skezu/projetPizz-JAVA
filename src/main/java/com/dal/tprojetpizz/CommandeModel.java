package com.dal.tprojetpizz;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CommandeModel {
    private ObservableList<Commande> commandes = FXCollections.observableArrayList();

    public ObservableList<Commande> getCommandes() {
        return commandes;
    }

    // Méthode pour ajouter une commande
    public void addCommande(Commande commande) {
        commandes.add(commande);
    }

    // Méthode pour supprimer une commande
    public void removeCommande(Commande commande) {
        commandes.remove(commande);
    }
}
