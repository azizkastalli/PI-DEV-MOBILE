/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entite.Produit;
import Entite.User;
import Service.ServiceProduit;
import Service.ServiceUser;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class Login {
        private Container label;
        Form f;
        public static List<ArrayList> panier = new ArrayList<>();
        public static User loggduser = new User();
        TextField tetat= new TextField("","Login");
        TextField pass = new TextField("", "Password", 20, TextField.PASSWORD);
       
        Button btnreg,btnaff;
          String tetat33= "";

    public Login() {
        
        
        label = new Container(new BoxLayout(BoxLayout.Y_AXIS)) ;
       
        
        f = new Form("home");
        btnaff=new Button("Login");
        btnreg=new Button("Register");
        Button btnpassoub=new Button("mot de passe oublié");
        label.add(tetat);
        label.add(pass);
        f.add(label);
        f.add(btnreg);
        f.add(btnaff);
        f.add(btnpassoub);
       
        btnreg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               
               Form f2 = new Form("Register",new BoxLayout(BoxLayout.Y_AXIS));
                    Container SS = new Container(new BoxLayout(BoxLayout.Y_AXIS)) ;
                TextField tetat1= new TextField("","Username");
                TextField tetat2= new TextField("","Email");
              
                ComboBox  tetat3=new ComboBox();
                tetat3.addItem("");
                tetat3.addItem("CLIENT");
                tetat3.addItem("ASSOCIATION");
                tetat3.addItem("LIVREUR");
                tetat3.addItem("MAGASIN");
                tetat3.addItem("VETERINAIRE");
                tetat3.addItem("DRESSEUR");
                TextField tetat4= new TextField("","Nom");
                TextField tetat5= new TextField("","Prenom");
                TextField tetat6= new TextField("","Num_tel");
        TextField pass2 = new TextField("", "Password", 20, TextField.PASSWORD);
                tetat3.addActionListener(new ActionListener() {
                           @Override
                           public void actionPerformed(ActionEvent evt) {
                               tetat33= "ROLE_"+ tetat3.getSelectedItem();
                               System.out.println(tetat3.getSelectedItem());
                               
                           }
                       });
          
          Button rating = new Button("Registrer");
          Button    btncart=new Button("retour au login");
            
             btncart.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent evt) {
                       Login rlo = new Login();
                       rlo.getF().show();
                   }
               });
             rating.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent evt) {
                       ServiceUser seru2= new ServiceUser();
                       User crus = new User();
                       crus.setEmail(tetat2.getText());
                       crus.setUsername(tetat1.getText());
                       crus.setRoles(tetat33);
                       
                       
                       crus.setNom(tetat4.getText());
                       crus.setPrenom(tetat5.getText());
                       crus.setNum_tel(tetat6.getText());
                       crus.setPassword(pass2.getText());
                       seru2.Create(crus);
                       Dialog.show("register", "ajout avec succes", "ok", null);
                   }
               });
               
               SS.add(tetat1);
               SS.add(pass2);
               SS.add(tetat2);
               SS.add(tetat3);
               SS.add(tetat4);
               SS.add(tetat5);
               SS.add(tetat6);
               SS.add(rating);
               SS.add(btncart);
               f2.add(SS);
               
               f2.show();
            }
            
        });
        
        btnaff.addActionListener((e)->{
            ServiceUser seru = new ServiceUser();
            
            loggduser.setUsername(tetat.getText());
            loggduser=seru.get(loggduser);
            if(loggduser.getPassword().equals(pass.getText()))
            {
                System.out.println("login");
                System.out.println(loggduser.getId());
                if(loggduser.getRoles().equals("ROLE_CLIENT")){
                allProduit EM = new allProduit();
                EM.getF().show();}
                else if(loggduser.getRoles().equals("ROLE_LIVREUR")){
                Leslivraisons EM = new Leslivraisons();
                EM.getF().show();
                }
                
            
            }
                
            else{System.out.println("no login");}
            
        });
        btnpassoub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ServiceUser seru3 = new ServiceUser();
            
            loggduser.setUsername(tetat.getText());
            loggduser=seru3.get(loggduser);
            Message m = new Message("le mot de passe pour l'utilisateur "+loggduser.getUsername()+" est : "+loggduser.getPassword());
            Display.getInstance().sendMessage(new String[] {loggduser.getEmail()}, "recuperation de mot de passe", m);
            }
        });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

   

    
}

