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
public class Favoris {
   private int id;
   private int id_client;
   private String id_produit;

    public Favoris(){}

    public Favoris(int id, int id_client, String id_produit) {
        this.id = id;
        this.id_client = id_client;
        this.id_produit = id_produit;
    }
    
    public Favoris(int id_client, String id_produit) {
        this.id_client = id_client;
        this.id_produit = id_produit;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public int getId() {
        return id;
    }

    public int getId_client() {
        return id_client;
    }

    public String getId_produit() {
        return id_produit;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public void setId_produit(String id_produit) {
        this.id_produit = id_produit;
    }
   
   
}
