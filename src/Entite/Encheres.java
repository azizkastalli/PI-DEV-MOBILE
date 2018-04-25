/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;


import java.util.Date;

/**
 *
 * @author azizkastalli
 */
public class Encheres { 
   private String caracteristiques;
   private String description;
   private String categorie;
   private String nom_proprietaire;
   private String nom_image;
   private double poid;
   private String label;
   private int    id_encheres;
   private int    id_cible;
   private double seuil_mise;
   private String etat;
   private Date   date_debut;
   private String   stringdate_debut;
   
 
  
   //constructeur vide
    public Encheres() {}

    public String getCaracteristiques() {
        return caracteristiques;
    }

    public String getDescription() {
        return description;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getNom_proprietaire() {
        return nom_proprietaire;
    }

    public String getNom_image() {
        return nom_image;
    }

    public double getPoid() {
        return poid;
    }

    public String getLabel() {
        return label;
    }

    public int getId_encheres() {
        return id_encheres;
    }

    public int getId_cible() {
        return id_cible;
    }

    public double getSeuil_mise() {
        return seuil_mise;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setCaracteristiques(String caracteristiques) {
        this.caracteristiques = caracteristiques;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setNom_proprietaire(String nom_proprietaire) {
        this.nom_proprietaire = nom_proprietaire;
    }

    public void setNom_image(String nom_image) {
        this.nom_image = nom_image;
    }

    public void setPoid(double poid) {
        this.poid = poid;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setId_encheres(int id_encheres) {
        this.id_encheres = id_encheres;
    }

    public void setId_cible(int id_cible) {
        this.id_cible = id_cible;
    }

    public void setSeuil_mise(double seuil_mise) {
        this.seuil_mise = seuil_mise;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getStringdate_debut() {
        return stringdate_debut;
    }

    public void setStringdate_debut(String stringdate_debut) {
        this.stringdate_debut = stringdate_debut;
    }
  

}
