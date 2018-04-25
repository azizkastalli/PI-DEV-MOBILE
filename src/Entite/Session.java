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
public class Session {
  private double derniere_mise;
  private String etat;
  private int id;
  private String id_gagnant;
  private String NomProduit;
  private String gagnant;
  private String img;
  
    public Session(){}
  
    public double getDerniere_mise() {
        return derniere_mise;
    }

    public String getEtat() {
        return etat;
    }

    public int getId() {
        return id;
    }

    public String getId_gagnant() {
        return id_gagnant;
    }

    public void setDerniere_mise(double derniere_mise) {
        this.derniere_mise = derniere_mise;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setId_gagnant(String id_gagnant) {
        this.id_gagnant = id_gagnant;
    }

    public void setId(int id) {
        this.id = id;
    }
   
    public String getNomProduit() {
        return NomProduit;
    }

    public String getGagnant() {
        return gagnant;
    }

    public void setNomProduit(String NomProduit) {
        this.NomProduit = NomProduit;
    }

    public void setGagnant(String gagnant) {
        this.gagnant = gagnant;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
   
}
