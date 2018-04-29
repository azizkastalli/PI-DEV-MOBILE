/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entite.Produit;
import Entite.User;
import Service.ServiceProduit;
import Service.ServiceUser;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author HP
 */
public class Login {
        private Container label;
        Form f2;
        
        TextField tetat;
        Button btnreg,btnaff;

    public Login() {
        
        
        label = new Container(new BoxLayout(BoxLayout.Y_AXIS)) ;
       TextField labell = new TextField("","Login");
       TextField caracteristique = new TextField("","Mot de pase");
       
        
        f2 = new Form("home");
        btnaff=new Button("Login");
        btnreg=new Button("Register");
        label.add(labell);
        label.add(caracteristique);
        f2.add(label);
        f2.add(btnreg);
        f2.add(btnaff);
       
        btnreg.addActionListener((e) -> {
           
            

        });
        
        btnaff.addActionListener((e)->{
            ServiceUser seru = new ServiceUser();
            User loggduser = new User();
            loggduser.setUsername(labell.getText());
            loggduser=seru.get(loggduser);
            if(loggduser.getPassword().equals(caracteristique.getText()))
            {
                System.out.println("login");
                System.out.println(loggduser.getRoles());}
            
            else{System.out.println("no login");}
        });
    }

    public Form getF() {
        return f2;
    }

    public void setF(Form f) {
        this.f2 = f;
    }

   

    
}

