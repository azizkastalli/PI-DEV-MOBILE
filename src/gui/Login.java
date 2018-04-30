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
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
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
       
        btnreg.addActionListener((e) -> {
           
            

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

