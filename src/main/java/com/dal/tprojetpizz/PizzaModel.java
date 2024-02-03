package com.dal.tprojetpizz;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class PizzaModel {
    private ObservableList<Pizza> pizzaList = FXCollections.observableArrayList();

    public ObservableList<Pizza> getPizzaList() {
        return pizzaList;
    }

    public void addPizza(Pizza pizza) {
        pizzaList.add(pizza);
    }

    public void removePizza(Pizza pizza) {
        String url = "jdbc:mysql://localhost:3306/prjalt-dbakaar"; // Assurez-vous que le nom de votre base de données est correct
        String user = "root";
        String password = ""; // Pas de mot de passe pour root par défaut avec XAMPP

        // Utilisation de try-with-resources pour la gestion automatique des ressources
        try (Connection connection = DriverManager.getConnection(url, user, password);
             // Préparation de la requête SQL pour mettre à jour le statut de la commande
             PreparedStatement statement = connection.prepareStatement("UPDATE commande SET statutCommande = 'Terminé' WHERE idCommande = ?;")) {

            statement.setInt(1, pizza.getId()); // Remplacez pizza.getId() par l'identifiant approprié de la commande associée à la pizza
            int affectedRows = statement.executeUpdate(); // Exécute la requête de mise à jour

            // Logique optionnelle pour vérifier si la mise à jour a réussi
            if (affectedRows > 0) {
                System.out.println("Le statut de la commande pour la Pizza avec ID " + pizza.getId() + " a été mis à jour en 'Terminé'.");
            } else {
                System.out.println("Aucune commande trouvée pour la mise à jour avec l'ID " + pizza.getId() + ".");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Assurez-vous que la logique de suppression de la pizza de la liste, si nécessaire, est correcte
        // Assurez-vous que pizzaList est accessible et modifiable ici
        // pizzaList.remove(pizza);
    }


}
