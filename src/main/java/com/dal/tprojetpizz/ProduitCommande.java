package com.dal.tprojetpizz;

public class ProduitCommande {
    private int idProduitCmd;
    private String nom;
    // Autres propriétés et méthodes

    // Constructeur, getters et setters
  public ProduitCommande(int idProduitCmd, String nom) {
      this.idProduitCmd = idProduitCmd;
      this.nom = nom;
  }

  public int getIdProduitCmd() {
      return idProduitCmd;
  }

  public String getNom() {
      return nom;
  }

  public void setNom(String nom) {
      this.nom = nom;
  }

}
