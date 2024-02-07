package com.dal.tprojetpizz;

public class ProduitCommandeController {
    private ProduitCommandeModel model;

    public ProduitCommandeController(ProduitCommandeModel model) {
        this.model = model;
    }

    // Méthode pour ajouter un produit à la commande
    public void addProduitCommande(int idProduitCmd, String nom) {
        ProduitCommande produitCommande = new ProduitCommande(idProduitCmd, nom);
        model.addProduitCommande(produitCommande);
    }
}
