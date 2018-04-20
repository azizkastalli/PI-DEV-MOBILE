/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.util.Date;

/**
 *
 * @author azizkastalli
 */
public class Participantsencheres {
    private int id;
    private int id_session;
    private int id_user;
    private String  num;
    private Date debut_session;

    public Participantsencheres() {
    }

    
    public Participantsencheres(int id_session, int id_user, Date debut_session,String num) {
        this.id = id;
        this.id_session = id_session;
        this.id_user = id_user;
        this.debut_session = debut_session;
        this.num=num;
    }
    
    public Participantsencheres(int id, int id_session, int id_user, Date debut_session) {
        this.id = id;
        this.id_session = id_session;
        this.id_user = id_user;
        this.debut_session = debut_session;
    }

    public Participantsencheres(int id_session, int id_user, Date debut_session) {
        this.id_session = id_session;
        this.id_user = id_user;
        this.debut_session = debut_session;
    }

    public int getId() {
        return id;
    }

    public int getId_session() {
        return id_session;
    }

    public int getId_user() {
        return id_user;
    }

    public Date getDebut_session() {
        return debut_session;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_session(int id_session) {
        this.id_session = id_session;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setDebut_session(Date debut_session) {
        this.debut_session = debut_session;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
    
    
}
