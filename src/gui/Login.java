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
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
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

    public Login() {
        
        
        label = new Container(new BoxLayout(BoxLayout.Y_AXIS)) ;
       
        
        f = new Form("home");
        btnaff=new Button("Login");
        btnreg=new Button("Register");
        label.add(tetat);
        label.add(pass);
        f.add(label);
        f.add(btnreg);
        f.add(btnaff);
       
        btnreg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               
               Form f2 = new Form("Register",new BoxLayout(BoxLayout.Y_AXIS));
                    Container SS = new Container(new BoxLayout(BoxLayout.Y_AXIS)) ;
                TextField tetat1= new TextField("","Username");
                TextField tetat2= new TextField("","Email");
                TextField tetat3= new TextField("","Role");
                TextField tetat4= new TextField("","Nom");
                TextField tetat5= new TextField("","Prenom");
                TextField tetat6= new TextField("","Num_tel");
        TextField pass2 = new TextField("", "Password", 20, TextField.PASSWORD);
           
          
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
                       crus.setRoles("ROLE_"+tetat3.getText());
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
                allProduit EM = new allProduit();
                EM.getF().show();
                
            
            }
                
            else{System.out.println("no login");}
            
        });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

   

    
}

