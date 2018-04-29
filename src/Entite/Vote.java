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
     private Number vote;
     private int id_user;

    public Vote() {
    }

    public Vote(float vote) {
       this.vote = vote;
    }

    public Vote(String id_produit, Number vote, int id_user) {
        this.id_produit = id_produit;
        this.vote = vote;
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

    public Number getVote() {
        return vote;
    }

    public void setVote(Number vote) {
        this.vote = vote;
    }

    public Vote(int id, String id_produit, Number vote) {
        this.id = id;
        this.id_produit = id_produit;
        this.vote = vote;
    }

    public Vote(String id_produit, Number vote) {
        this.id_produit = id_produit;
        this.vote = vote;
    }

 
    
}
