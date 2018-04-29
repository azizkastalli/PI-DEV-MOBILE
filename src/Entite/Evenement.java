/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;


import java.util.Date;


/**
 *
 * @author user
 */
public class Evenement {
    
  
   private int id;
   private String nom;
   private String description;
   private int nbr_participants;
   private Date date_debut;
   private Date date_fin;
   private Boolean etat;
   private String nom_image;
   private String nom_association;
   private int id_association;
   private int id_categorie;
   private String StringdateD;
   
    public Evenement(){}

  

    public Evenement(String nom, String description, int nbr_participants, Date date_debut, Date date_fin, Boolean etat, String nom_image,int id_categorie,int id_association) {
        this.nom = nom;
        this.id_association=id_association;
        this.description = description;
        this.nbr_participants = nbr_participants;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.etat = etat;
        this.nom_image = nom_image;
        this.id_categorie=id_categorie;
  
    }

    public Evenement(String nom, String description, int nbr_participants, Boolean etat, String nom_image,int id_categorie) {
        this.nom = nom;
        this.description = description;
        this.nbr_participants = nbr_participants;
        this.etat = etat;
        this.nom_image = nom_image;
        this.id_categorie=id_categorie;
       
    }
    
    
      public Evenement(int id,String nom, String description, int nbr_participants, Date date_debut, Date date_fin, Boolean etat, String nom_image,int id_categorie) {
        this.id=id;
        this.nom = nom;
        this.description = description;
        this.nbr_participants = nbr_participants;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.etat = etat;
        this.nom_image = nom_image;
        this.id_categorie=id_categorie;

     }

  

    public Evenement(String nom, String description, int nbr_participants, String StringdateD) {
        this.nom = nom;
        this.description = description;
        this.nbr_participants = nbr_participants;
        this.StringdateD = StringdateD;
    }

      
          

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public int getNbr_participants() {
        return nbr_participants;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public Boolean getEtat() {
        return etat;
    }

    public String getNom_image() {
        return nom_image;
    }

    public String getNom_association() {
        return nom_association;
    }

  

    public int getId_association() {
        return id_association;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNbr_participants(int nbr_participants) {
        this.nbr_participants = nbr_participants;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }

    public void setNom_image(String nom_image) {
        this.nom_image = nom_image;
    }

    public void setNom_association(String nom_association) {
        this.nom_association = nom_association;
    }

   

    public void setId_association(int id_association) {
        this.id_association = id_association;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

   

  
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Evenement other = (Evenement) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Evenement{" + "nom=" + nom + ", description=" + description + ", nbr_participants=" + nbr_participants + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", etat=" + etat + ", nom_image=" + nom_image + ", nom_association=" + nom_association + '}';
    }

    public String getStringdateD() {
        return StringdateD;
    }

    public void setStringdateD(String StringdateD) {
        this.StringdateD = StringdateD;
    }

     
}
