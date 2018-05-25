/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entite.AnimalSdf;
import Service.ServiceAnimalsdf;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.spinner.Picker;
import java.io.IOException;

/**
 *
 * @author user
 */
public class AjoutASDF {
     private Form f;
    private Container event;
     
     
    TextField tlieu;
    ComboBox <String> sexe = new ComboBox();
   
    Button btnajout;
    
     public AjoutASDF() {
       
         f = new Form("home");
        
        tlieu = new TextField();
        
        btnajout = new Button("ajouter");
        
          Picker dateD = new Picker();
          sexe.addItem("male");
          sexe.addItem("femele");
          
        
        f.add(dateD);
        f.add(tlieu);
        f.add(sexe);
        
        
        
        f.add(btnajout);
        
       
        btnajout.addActionListener((ActionEvent e) -> {
            String  stringdate = new SimpleDateFormat("yyyy-MM-dd").format(dateD.getDate());   
            ServiceAnimalsdf AS = new ServiceAnimalsdf();
            AnimalSdf S = new AnimalSdf(sexe.getSelectedItem(),tlieu.getText(),stringdate);
            AS.Create(S);
            
            

        });
        
        f.getToolbar().addCommandToRightBar("back", null, (ev)->{EspaceService ES=new EspaceService();
          ES.getF().show();
          });
        
        f.getToolbar().addCommandToSideMenu("Menu Principale",null, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent d) {
                 Gui.allProduit panpage = new Gui.allProduit();
                 panpage.getF().show();
             }
         });
            
          f.getToolbar().addCommandToSideMenu("voir panier",null, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent d) {
                 Gui.Panier panpage = new Gui.Panier();
                 panpage.getF().show();
             }
         });
          f.getToolbar().addCommandToSideMenu("voir actualité",null, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent d) {
                 Actualite actpage = new Actualite();
                 actpage.getF().show();
                 
             }
         });
          f.getToolbar().addCommandToSideMenu("Les evenements",null, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent d) {
                 try {
                     AffichageEvent afepage = new AffichageEvent();
                     afepage.getF().show();
                 } catch (IOException ex) {
                    
                 }
                 
             }
         });
          f.getToolbar().addCommandToSideMenu("Espace services",null, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent d) {
                 EspaceService afepage = new EspaceService();
                 afepage.getF().show();
                 
             }
         });
          f.getToolbar().addCommandToSideMenu("Les encheres",null, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent d) {
                 try {
                     AllEncheres afepage = new AllEncheres();
                     afepage.getF().show();
                 } catch (IOException ex) {
                     
                 }
                 
             }
         });
          f.getToolbar().addCommandToSideMenu("Se déconnecter",null, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent d) {
                 Login afepage = new Login();
                 afepage.getF().show();
                 
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
