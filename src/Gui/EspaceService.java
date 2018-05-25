/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;




/**
 *
 * @author user
 */
public class EspaceService {
     private Form f;
     
     public EspaceService() {
        f = new Form("Espace Services",new BoxLayout(BoxLayout.Y_AXIS));
        Button Sdf = new Button("AnimalSdf");
        Button gestion = new Button("Liste Sdf");
        Button ajout = new Button("ajout");
        Button stat = new Button("Stats");
        Button P = new Button ("Liste Animal Perdu");
        Container gestionService = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container ajoutService = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container ajoutSdf = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container Stat = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         Container AP = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        
        
        gestionService.add(gestion);
        ajoutService.add(ajout);
        ajoutSdf.add(Sdf);
        Stat.add(stat);
        AP.add(P);
       
        
        f.addAll(gestionService,ajoutService,ajoutSdf,Stat,AP);
        
        ajout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                AjoutAP ap = new AjoutAP();
                ap.getF().show();
            }
        });
        
        gestion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
              
                try {
                    AffichAnimalSdf aff = new AffichAnimalSdf();;
                    aff.getF().show();
                } catch (IOException ex) {
                    
                }
                } 
                    
               
           
            
        });
        Sdf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                AjoutASDF A = new AjoutASDF();
                A.getF().show();
 }
        });
        stat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                    StatAnimalPerdu S = new StatAnimalPerdu();
                    S.getF().show();
            }
        });
        P.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    affichAnimalPerdu ANP = new affichAnimalPerdu();
                    ANP.getF().show();
                } catch (IOException ex) {
                    
                }
            }
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
