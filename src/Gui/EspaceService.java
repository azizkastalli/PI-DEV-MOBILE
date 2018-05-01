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
        f = new Form(new BoxLayout(BoxLayout.Y_AXIS));
        Button Sdf = new Button("AnimalSdf");
        Button gestion = new Button("Liste Sdf");
        Button ajout = new Button("ajout");
        Button stat = new Button("Stats");
        Button P = new Button ("Liste Animal Perdu");
        Container gestionService = new Container();
        Container ajoutService = new Container();
        Container ajoutSdf = new Container();
        Container Stat = new Container();
         Container AP = new Container();
        
        
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
     }    

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    
}
