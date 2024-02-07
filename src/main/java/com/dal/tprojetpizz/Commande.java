package com.dal.tprojetpizz;

import java.util.List;


public class Commande {
    private int idCommande;
    private List<Pizza> pizzas; // Liste de pizzas dans la commande
    private List<ProduitCommande> produits; // Liste de produits dans la commande
    private String statut; // Statut de la commande, par exemple, "en cours" ou "Terminé"

    // Constructeur, getters et setters ici
    public Commande(int idCommande, List<Pizza> pizzas, List<ProduitCommande> produits, String statut) {
        this.idCommande = idCommande;
        this.pizzas = pizzas;
        this.produits = produits;
        this.statut = statut;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }


    public List<ProduitCommande> getProduits() {
        return produits;
    }

    public void setProduits(List<ProduitCommande> produits) {
        this.produits = produits;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

}
