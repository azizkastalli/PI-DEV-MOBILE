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
public class Panier {
     
private int     id;
private String  id_client;
private String  id_produit;
private int     quantite;

    public Panier(){}
    
    public Panier(String id_client, String id_produit, int quantite) {
        this.id_client = id_client;
        this.id_produit = id_produit;
        this.quantite = quantite;
    }

    public Panier(int id, String id_client, String id_produit, int quantite) {
        this.id = id;
        this.id_client = id_client;
        this.id_produit = id_produit;
        this.quantite = quantite;
    }

    public int getId() {
        return id;
    }

    public String getId_client() {
        return id_client;
    }

    public String getId_produit() {
        return id_produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_client(String id_client) {
        this.id_client = id_client;
    }

    public void setId_produit(String id_produit) {
        this.id_produit = id_produit;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    

}
