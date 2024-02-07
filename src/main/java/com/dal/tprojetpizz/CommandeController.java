package com.dal.tprojetpizz;

public class CommandeController {
    private CommandeModel model;

    public CommandeController(CommandeModel model) {
        this.model = model;
    }

    // Méthode pour marquer une commande comme terminée et la supprimer
    public void terminerCommande(Commande commande) {
        // Logique pour marquer la commande comme terminée dans la base de données
        model.removeCommande(commande);
    }
}
