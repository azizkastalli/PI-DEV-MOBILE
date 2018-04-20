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
public class User {
 
private int     id;
private String  confirmation_token;
private String  email;
private String  email_canonical;
private int     enabled;
private Date    last_login;
private String  nom;
private String  password;
private Date    password_requested_at;
private String  prenom;
private int     prix_unitaire;
private String  roles;
private String  salt;
private String  username;
private String  username_canonical;
private String  num_tel;

    public User(){}

    public User(int id, String confirmation_token, String email, String email_canonical, int enabled, Date last_login, String nom, String password, Date password_requested_at, String prenom, int prix_unitaire, String roles, String salt, String username, String username_canonical,String  num_tel) {
        this.id = id;
        this.confirmation_token = confirmation_token;
        this.email = email;
        this.email_canonical = email_canonical;
        this.enabled = enabled;
        this.last_login = last_login;
        this.nom = nom;
        this.password = password;
        this.password_requested_at = password_requested_at;
        this.prenom = prenom;
        this.prix_unitaire = prix_unitaire;
        this.roles = roles;
        this.salt = salt;
        this.username = username;
        this.username_canonical = username_canonical;
        this.num_tel=num_tel;
    }

    public User(String confirmation_token, String email, String email_canonical, int enabled, Date last_login, String nom, String password, Date password_requested_at, String prenom, int prix_unitaire, String roles, String salt, String username, String username_canonical,String  num_tel) {
        this.confirmation_token = confirmation_token;
        this.email = email;
        this.email_canonical = email_canonical;
        this.enabled = enabled;
        this.last_login = last_login;
        this.nom = nom;
        this.password = password;
        this.password_requested_at = password_requested_at;
        this.prenom = prenom;
        this.prix_unitaire = prix_unitaire;
        this.roles = roles;
        this.salt = salt;
        this.username = username;
        this.username_canonical = username_canonical;
        this.num_tel=num_tel;
    }

    public int getId() {
        return id;
    }

    public String getConfirmation_token() {
        return confirmation_token;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail_canonical() {
        return email_canonical;
    }

    public int getEnabled() {
        return enabled;
    }

    public Date getLast_login() {
        return last_login;
    }

    public String getNom() {
        return nom;
    }

    public String getPassword() {
        return password;
    }

    public Date getPassword_requested_at() {
        return password_requested_at;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getPrix_unitaire() {
        return prix_unitaire;
    }

    public String getRoles() {
        return roles;
    }
    public String getNum_tel() {
        return num_tel;
    }

    public String getSalt() {
        return salt;
    }

    public String getUsername() {
        return username;
    }

    public String getUsername_canonical() {
        return username_canonical;
    }

    public void setConfirmation_token(String confirmation_token) {
        this.confirmation_token = confirmation_token;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmail_canonical(String email_canonical) {
        this.email_canonical = email_canonical;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPassword_requested_at(Date password_requested_at) {
        this.password_requested_at = password_requested_at;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setPrix_unitaire(int prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUsername_canonical(String username_canonical) {
        this.username_canonical = username_canonical;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setNum_tel(String num_tel) {
        this.num_tel = num_tel;
    }
    
}
