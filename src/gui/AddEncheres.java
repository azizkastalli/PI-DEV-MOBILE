/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entite.Encheres;
import Entite.Produit;
import Service.ServiceEncheres;
import com.codename1.ui.layouts.BoxLayout;
import Service.ServiceProduit;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.spinner.DateTimeSpinner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author azizkastalli
 */
public class AddEncheres {
    
    private Form f;
    private final Container produits;    
    
    public AddEncheres() throws IOException {
         f = new Form();
         produits = new Container(new BoxLayout(BoxLayout.Y_AXIS)) ;
         ServiceProduit serviceProduit=new ServiceProduit();
         ArrayList<Produit> listeProduits = serviceProduit.getAll();
         
      for(Produit p : listeProduits)
      {
          ImageViewer img = new ImageViewer(Image.createImage(p.getNom_image()));
          SpanLabel label = new SpanLabel(p.getLabel());
          TextField SeuilMise = new TextField("placer le seuil de mise ici ");
          DateTimeSpinner dateEncheres = new DateTimeSpinner();
          Button add = new Button();

          Container c =new Container(new BoxLayout(BoxLayout.Y_AXIS));
          c.addAll(img,label,SeuilMise,dateEncheres,add);
          produits.add(c);
            
          add.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent evt) {
                     //controle ensuite ajout
                 Date date = dateEncheres.getCurrentDate();
                 
                 double mise = Double.parseDouble(SeuilMise.getText());    
                 Encheres  E = new Encheres();
                 E.setId_cible(p.getId());
                 E.setSeuil_mise(mise);
               //  E.setDate_debut();
                 ServiceEncheres serviceEncheres=new ServiceEncheres();
                 serviceEncheres.Create(E);
              }
          });
      }
      
      f.add(produits);
      
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    
}
