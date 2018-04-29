/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author iheb bf
 */
public class Lignecommande {
    
private int id;
private int id_client;
private int id_commande;
private int id_produit;
private int qte;

    public Lignecommande() {}

    public Lignecommande(int id, int id_client, int id_commande, int id_produit, int qte) {
        this.id = id;
        this.id_client = id_client;
        this.id_commande = id_commande;
        this.id_produit = id_produit;
        this.qte = qte;
    }

    public Lignecommande(int id_client, int id_commande, int id_produit, int qte) {
        this.id_client = id_client;
        this.id_commande = id_commande;
        this.id_produit = id_produit;
        this.qte = qte;
    }

    public int getId() {
        return id;
    }

    public int getId_client() {
        return id_client;
    }

    public int getId_commande() {
        return id_commande;
    }

    public int getId_produit() {
        return id_produit;
    }

    public int getQte() {
        return qte;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

  
    
}
