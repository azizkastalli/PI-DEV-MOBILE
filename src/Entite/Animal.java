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
public class Animal {
   int age;
   int id;
   String sexe;

    public Animal(){}

    public Animal(int age, int id, String sexe) {
        this.age = age;
        this.id = id;
        this.sexe = sexe;
    }
   
    public Animal(int age, String sexe) {
        this.age = age;
        this.sexe = sexe;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public String getSexe() {
        return sexe;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
   
   
}
