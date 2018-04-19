/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author azizkastalli
 */
public class EspaceMagasin {
        private Form f;
        
    public EspaceMagasin() {
        f = new Form(new BoxLayout(BoxLayout.X_AXIS));
        Label gestion = new Label("gestion");
        Label ajout = new Label("ajout");
        Container gestionEncheres = new Container();
        Container ajoutEncheres = new Container();
        gestionEncheres.add(gestion);
        ajoutEncheres.add(ajout);
        f.addAll(gestionEncheres,ajoutEncheres);
        
        ajoutEncheres.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    AddEncheres add = new AddEncheres();
                    add.getF().show();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
           
            }
        });
        
        gestionEncheres.addPointerPressedListener(new ActionListener() {
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
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    
    
}
