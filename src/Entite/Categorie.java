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
public class Categorie {
    private int id;
    private String nom;
    private String type;

  

 

    public Categorie(){
    
    }
    
    public Categorie(int id, String nom, String type) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        
    }
    
    public Categorie(String nom, String type) {
        this.nom = nom;
        this.type = type;
    }
    
    

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
