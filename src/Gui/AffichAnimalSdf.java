/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entite.AnimalSdf;
import Service.ServiceAnimalsdf;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class AffichAnimalSdf {
    
    private Form f;
    private Container Asdf;
     

    public AffichAnimalSdf() throws IOException {
         f = new Form();
         Asdf = new Container(new BoxLayout(BoxLayout.Y_AXIS)) ;
         ServiceAnimalsdf SE=new ServiceAnimalsdf();
         ArrayList<AnimalSdf> listsdf = SE.getAll();
         System.out.println("listaa : "+listsdf);
         
          f.getToolbar().addCommandToRightBar("back", null, (ev)->{EspaceService ES=new EspaceService();
          ES.getF().show();
          });
          
          for (AnimalSdf A : listsdf)
          {
              SpanLabel label = new SpanLabel(A.getLieu_trouvaille());
              SpanLabel label1 = new SpanLabel(A.getDate_trouvaille().toString());
              SpanLabel label2 = new SpanLabel(A.getSexe());
              Label l = new Label("*******************");

             Asdf.addAll(label,label1,label2,l);
          }
          
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
        
          
          
           f.add(Asdf);
           
}
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
}
