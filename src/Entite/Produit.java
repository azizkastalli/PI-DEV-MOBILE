/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author azizkastalli
 */
public class Produit {
   private String caracteristiques;
   private String description;
   private String etat;
   private int id;
   private String id_categorie;
   private int id_propietaire;
   private String nom_image;
   private double poid;
   private double prix_ancien;
   private double prix_nouv;
   private int quantite;
   private double vote;
   private String label;

    public Produit(){}
   
    public Produit(String caracteristiques, String description, String etat, String id_categorie, int id_propietaire, String nom_image, double poid, double prix_ancien, double prix_nouv, int quantite, double vote, String label) {
        this.caracteristiques = caracteristiques;
        this.description = description;
        this.etat = etat;
        this.id_categorie = id_categorie;
        this.id_propietaire = id_propietaire;
        this.nom_image = nom_image;
        this.poid = poid;
        this.prix_ancien = prix_ancien;
        this.prix_nouv = prix_nouv;
        this.quantite = quantite;
        this.vote = vote;
        this.label = label;
    }

    public Produit(String caracteristiques, String description, String etat, int id, String id_categorie, int id_propietaire, String nom_image, double poid, double prix_ancien, double prix_nouv, int quantite, double vote, String label) {
        this.caracteristiques = caracteristiques;
        this.description = description;
        this.etat = etat;
        this.id = id;
        this.id_categorie = id_categorie;
        this.id_propietaire = id_propietaire;
        this.nom_image = nom_image;
        this.poid = poid;
        this.prix_ancien = prix_ancien;
        this.prix_nouv = prix_nouv;
        this.quantite = quantite;
        this.vote = vote;
        this.label = label;
    }

    public Produit(String etat, String label) {
        this.etat = etat;
        this.label=label;
    }

    public Produit(String caracteristiques, String description, String etat, String id_categorie, Integer id_propietaire, String nom_image, Double poid, Double prix_ancien, Double prix_nouv, Integer quantite, Double vote) {
        this.caracteristiques = caracteristiques;
        this.description = description;
        this.etat = etat;
        this.id_categorie = id_categorie;
        this.id_propietaire = id_propietaire;
        this.nom_image = nom_image;
        this.poid = poid;
        this.prix_ancien = prix_ancien;
        this.prix_nouv = prix_nouv;
        this.quantite = quantite;
        this.vote = vote;
    }

    @Override
    public String toString() {
        return "Produit{" + "caracteristiques=" + caracteristiques + ", description=" + description + ", etat=" + etat + ", id_categorie=" + id_categorie + ", id_propietaire=" + id_propietaire + ", nom_image=" + nom_image + ", poid=" + poid + ", prix_ancien=" + prix_ancien + ", prix_nouv=" + prix_nouv + ", quantite=" + quantite + ", vote=" + vote + ", label=" + label + '}';
    }

   
    
    

    public String getCaracteristiques() {
        return caracteristiques;
    }

    public String getDescription() {
        return description;
    }

    public String getEtat() {
        return etat;
    }

    public int getId() {
        return id;
    }

    public String getId_categorie() {
        return id_categorie;
    }

    public int getId_propietaire() {
        return id_propietaire;
    }

    public String getNom_image() {
        return nom_image;
    }

    public double getPoid() {
        return poid;
    }

    public double getPrix_ancien() {
        return prix_ancien;
    }

    public double getPrix_nouv() {
        return prix_nouv;
    }

    public int getQuantite() {
        return quantite;
    }

    public double getVote() {
        return vote;
    }

    public String getLabel() {
        return label;
    }

    public void setCaracteristiques(String caracteristiques) {
        this.caracteristiques = caracteristiques;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setId_categorie(String id_categorie) {
        this.id_categorie = id_categorie;
    }

    public void setId_propietaire(int id_propietaire) {
        this.id_propietaire = id_propietaire;
    }

    public void setNom_image(String nom_image) {
        this.nom_image = nom_image;
    }

    public void setPoid(double poid) {
        this.poid = poid;
    }

    public void setPrix_ancien(double prix_ancien) {
        this.prix_ancien = prix_ancien;
    }

    public void setPrix_nouv(double prix_nouv) {
        this.prix_nouv = prix_nouv;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setVote(double vote) {
        this.vote = vote;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    
}
