package com.dal.tprojetpizz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/prjalt-dbakaar"; // Remplacez nom_de_votre_base par le nom de votre base de données
        String user = "root";
        String password = ""; // Pas de mot de passe pour root par défaut avec XAMPP

        try {
            // Étape 1 : Charger le driver JDBC
            //Class.forName("com.mysql.cj.jdbc.Driver");

            // Étape 2 : Établir une connexion à la base de données
            Connection connection = DriverManager.getConnection(url, user, password);

            // Étape 3 : Créer un objet Statement
            Statement statement = connection.createStatement();

            // Étape 4 : Exécuter une requête SQL
            String sql = "SELECT commande.idCommande, basepizza.nom FROM commande inner join pizzaperso on commande.idCommande = pizzaperso.idCommande inner join basepizza on basepizza.idPizza = pizzaperso.idBasePizza where commande.statutCommande!='terminé';"; // Ajustez cette requête selon vos besoins
            ResultSet resultSet = statement.executeQuery(sql);

            // Étape 5 : Parcourir les résultats de la requête
            while (resultSet.next()) {
                // Remplacez ces noms de colonnes par ceux de votre table
                int id = resultSet.getInt("idCommande");
                String nom = resultSet.getString("nom");
                System.out.println("ID: " + id + ", Nom de la pizza: " + nom);
            }

            // Étape 6 : Fermer les ressources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
