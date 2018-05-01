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
 * @author azizkastalli
 */
public class EspaceMagasin {
        private Form f;
        
    public EspaceMagasin() {
        f = new Form(new BoxLayout(BoxLayout.Y_AXIS));
        Button gestion = new Button("gestion");
        Button ajout = new Button("ajout");
        Button encheres = new Button("Encheres");
        Button actualite = new Button("Actualite");
        Container gestionEncheres = new Container();
        Container ajoutEncheres = new Container();
        Container encheresEncheres = new Container();
        Container actualiteAnimaux = new Container();
        actualiteAnimaux.add(actualite);
        gestionEncheres.add(gestion);
        ajoutEncheres.add(ajout);
        encheresEncheres.add(encheres);
        f.addAll(gestionEncheres,ajoutEncheres,encheresEncheres,actualiteAnimaux);
        
        actualite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                    Actualite news = new Actualite();
                    news.getF().show();           
            }
        });
        
        ajout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
              
                  AddEncheres add;
                try {
                    add = new AddEncheres();
                    add.getF().show();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                
           
            }
        });
        
        gestion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    UpdateDeleteEncheres updatedelete = new UpdateDeleteEncheres();
                    updatedelete.getF().show();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
           
            }
        });
        
        encheres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
             try {
                    AllEncheres allEncheres = new AllEncheres();
                    allEncheres.getF().show();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
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
