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
public class Participation {
    
    private int id;
    private int id_client;
    private int id_evenement;

    public Participation() {}
    
    public Participation(int id_client, int id_evenement) {
        this.id_client = id_client;
        this.id_evenement = id_evenement;
    }

    public Participation(int id, int id_client, int id_evenement) {
        this.id = id;
        this.id_client = id_client;
        this.id_evenement = id_evenement;
    }
    
    public int getId() {
        return id;
    }

    

    public int getId_client() {
        return id_client;
    }

    

    public int getId_evenement() {
        return id_evenement;
    }
    
}
