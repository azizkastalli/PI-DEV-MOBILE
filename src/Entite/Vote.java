/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author HP
 */
public class Vote {
     private int id;
     private String id_produit;
     private float votee;
     private int id_user;

    public Vote() {
    }

    public Vote(float vote) {
       this.votee = vote;
    }

    public Vote(String id_produit, float vote, int id_user) {
        this.id_produit = id_produit;
        this.votee = vote;
        this.id_user = id_user;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_produit() {
        return id_produit;
    }

    public void setId_produit(String id_produit) {
        this.id_produit = id_produit;
    }

    public float getVotee() {
        return votee;
    }

    public void setVotee(float vote) {
        this.votee = vote;
    }

   

    public Vote(String id_produit, float vote) {
        this.id_produit = id_produit;
        this.votee = vote;
    }

 
    
}
