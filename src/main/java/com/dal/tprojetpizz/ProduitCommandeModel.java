package com.dal.tprojetpizz;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ProduitCommandeModel {
    private ObservableList<ProduitCommande> produitsCommande = FXCollections.observableArrayList();

    public ObservableList<ProduitCommande> getProduitsCommande() {
        return produitsCommande;
    }

    public void addProduitCommande(ProduitCommande produitCommande) {
        produitsCommande.add(produitCommande);
    }

    public void removeProduitCommande(ProduitCommande produitCommande) {
        String url = "jdbc:mysql://localhost:3306/prjalt-dbakaar"; // Assurez-vous que le nom de votre base de données est correct
        String user = "root";
        String password = ""; // Pas de mot de passe pour root par défaut avec XAMPP

        try (Connection connection = DriverManager.getConnection(url, user, password);
             // Mise à jour du statutProduitCommande pour tous les produits de la commande spécifiée
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE produitCommande SET statutProduitCommande = 'termine' WHERE idCommande = ?;")) {

            statement.setInt(1, produitCommande.getIdProduitCmd()); // Utilisation de l'identifiant de la commande
            int affectedRows = statement.executeUpdate(); // Exécute la requête de mise à jour

            if (affectedRows > 0) {
                System.out.println("Le statutProduitCommande pour les produits de la commande avec l'idCommande " + produitCommande.getIdProduitCmd() + " a été mis à jour en 'Terminé'.");
            } else {
                System.out.println("Aucun produit trouvé pour la mise à jour avec l'idCommande " + produitCommande.getIdProduitCmd() + ".");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Suppression du produitCommande de la liste, si nécessaire
        // Assurez-vous que la liste des produits de la commande est accessible et modifiable ici
        produitsCommande.remove(produitCommande);
    }

}
