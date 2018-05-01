/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.util.Date;

/**
 *
 * @author user
 */
public class AnimalPerdu {
    
    private int id;
    private int id_animal;
    private boolean etat;
    private Date date_disparition;
    private String lieu_disparition; 
    private String etat1;
    private String DateD;
  

   
    
    

    
        public AnimalPerdu() {}

        public AnimalPerdu(int id, int id_animal,  Date date_disparition, String lieu_disparition,boolean etat) {
        this.id = id;
        this.id_animal = id_animal;
        this.etat = etat;
        this.date_disparition = date_disparition;
        this.lieu_disparition = lieu_disparition;
    }

    public AnimalPerdu(int id_animal, String DateD,String lieu_disparition) {
        this.id_animal = id_animal;
        this.DateD = DateD;
        this.lieu_disparition = lieu_disparition;
        
    }

   

    public AnimalPerdu(int id, int id_animal, Date date_disparition, String lieu_disparition, String etat1) {
        this.id = id;
        this.id_animal = id_animal;
        this.date_disparition = date_disparition;
        this.lieu_disparition = lieu_disparition;
        this.etat1 = etat1;
    }

    
    


        public AnimalPerdu( int id_animal,  Date date_disparition, String lieu_disparition, boolean etat) {
        
        this.id_animal = id_animal;
        this.date_disparition = date_disparition;
        this.lieu_disparition = lieu_disparition;
        this.etat = etat;
        
        
    }

    public AnimalPerdu(boolean add) {
     //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "AnimalPerdu{" + "id=" + id + ", id_animal=" + id_animal + ", etat=" + etat + ", date_disparition=" + date_disparition + ", lieu_disparition=" + lieu_disparition + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AnimalPerdu other = (AnimalPerdu) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

   

    public int getId_animal() {
        return id_animal;
    }

    public void setId_animal(int id_animal) {
        this.id_animal = id_animal;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public Date getDate_disparition() {
        return date_disparition;
    }

    public void setDate_disparition(Date date_disparition) {
        this.date_disparition = date_disparition;
    }

    public String getLieu_disparition() {
        return lieu_disparition;
    }

    public void setLieu_dispairition(String lieu_disparition) {
        this.lieu_disparition = lieu_disparition;
    }

    public String getEtat1() {
        return etat1;
    }

    public void setEtat1(String etat1) {
        this.etat1 = etat1;
    }

    public String getDateD() {
        return DateD;
    }

    public void setDateD(String DateD) {
        this.DateD = DateD;
    }

   
}
