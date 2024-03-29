package com.dal.tprojetpizz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        //Produit
        ProduitCommandeModel produitModel = new ProduitCommandeModel();
        //Pizza
        PizzaModel model = new PizzaModel();
        PizzaView view = new PizzaView(model, produitModel);
        PizzaController controller = new PizzaController(model, view);





        // Pour l'exemple, ajoutons quelques pizzas
        String url = "jdbc:mysql://localhost:3306/prjalt-dbakaar"; // Remplacez nom_de_votre_base par le nom de votre base de données
        String user = "root";
        String password = ""; // Pas de mot de passe pour root par défaut avec XAMPP

        try {
            // Étape 2 : Établir une connexion à la base de données
            Connection connection = DriverManager.getConnection(url, user, password);

            // Étape 3 : Créer un objet Statement
            Statement statement = connection.createStatement();

            // Étape 4 : Exécuter une requête SQL
            String sql = "SELECT * FROM `commandeproduitpizza` where statutPizza!='termine';"; // Ajustez cette requête selon vos besoins
            ResultSet resultSet = statement.executeQuery(sql);

            // Étape 5 : Parcourir les résultats de la requête
            while (resultSet.next()) {
                // Remplacez ces noms de colonnes par ceux de votre table
                int idCommande = resultSet.getInt("idCommande");
                int idPizza = resultSet.getInt("idPizza");
                String nom = resultSet.getString("nomPizza");
                String ingredients = resultSet.getString("ingredients");
                System.out.println("ID: " + idPizza + ", Nom de la pizza: " + nom + ", Suppléments: " + ingredients);
                controller.addPizza(idPizza, idCommande, nom, ingredients);
            }

            //Produit
            //ProduitCommandeController produitController = new ProduitCommandeController(produitModel);
            // Exemple d'ajout de produits de commande
            // Vous devrez récupérer ces données de votre base de données
            // Étape 4 : Exécuter une requête SQL
            //String sqlProduit = "SELECT * FROM `vueproduitscommande` where statutProduitCommande!='termine';"; // Ajustez cette requête selon vos besoins
            //ResultSet resultSetProduit = statement.executeQuery(sqlProduit);

            // Étape 5 : Parcourir les résultats de la requête
            /*while (resultSetProduit.next()) {
                // Remplacez ces noms de colonnes par ceux de votre table
                int idCmd = resultSetProduit.getInt("idCommande");
                String nom = resultSetProduit.getString("produitsListe");
                System.out.println("ID: " + idCmd + ", Liste des produits: " + nom);
                produitController.addProduitCommande(idCmd, nom);
            }*/
            // Assurez-vous que votre vue principale peut afficher ces produits
            //view.updateProduitsCommandeView(produitModel.getProduitsCommande());

            // Étape 6 : Fermer les ressources
            resultSet.close();
            statement.close();
            //resultSetProduit.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*controller.addPizza("Margherita", "+ Poivrons");
        controller.addPizza("Bolognaise", "");
        controller.addPizza("Orientale", "");
        controller.addPizza("Fermière", "+ Oeuf");*/

        primaryStage.setTitle("Liste des Pizzas");
        primaryStage.setScene(new Scene(view.asParent(), 800, 550));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}