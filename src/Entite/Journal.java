/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.sql.Time;

/**
 *
 * @author azizkastalli
 */
public class Journal {
    private Time date_mise;
    private int id;
    private String id_client;
    private String nom_client;
    private String id_session;
    private double mise;

    public Journal(){}
    
    public Journal(Time date_mise, String id_client, String id_session, double mise,String nom_client) {
        this.date_mise = date_mise;
        this.id_client = id_client;
        this.nom_client = nom_client;
        this.id_session = id_session;
        this.mise = mise;
    }


    public Journal(int id,Time date_mise,double mise,String nom_client) {
       this.id=id;
       this.date_mise=date_mise;
       this.mise=mise;
       this.nom_client=nom_client;
    }

    
    public Time getDate_mise() {
        return date_mise;
    }

    public int getId() {
        return id;
    }

    public String getId_client() {
        return id_client;
    }

    public String getId_session() {
        return id_session;
    }

    public double getMise() {
        return mise;
    }

    public void setDate_mise(Time date_mise) {
        this.date_mise = date_mise;
    }

    public void setId_client(String id_client) {
        this.id_client = id_client;
    }

    public void setId_session(String id_session) {
        this.id_session = id_session;
    }

    public void setMise(double mise) {
        this.mise = mise;
    }

    public String getNom_client() {
        return nom_client;
    }

    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }
    
    
}
