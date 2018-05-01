/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entite.Commande;
import Entite.Lignecommande;
import Entite.Livraison;
import Entite.Produit;
import Service.ServiceCommande;
import Service.ServiceLignecommande;
import Service.ServiceLivraison;
import Service.ServiceProduit;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.events.DataChangedListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class Meslivraisons {
    
    
    public Form f;
    private Container event;
     private EncodedImage encImage;
          private Resources theme;
          private double prix_tot=0;

    public Meslivraisons()  {
         f = new Form("Livraisons non livrées");
         event = new Container(new BoxLayout(BoxLayout.Y_AXIS)) ;
         ServiceLivraison SE=new ServiceLivraison();
         Livraison liv2=new Livraison();
         liv2.setId_livreur(Gui.Login.loggduser.getId());
         ArrayList<Livraison> listeEvent = SE.getlivs(liv2);
         
         System.out.println("listaa : "+listeEvent);
            
         
         
         for(Livraison e : listeEvent)
      {
          
          
          SpanLabel label;
         StringBuilder sb = new StringBuilder();
         sb.append("");
          sb.append(e.getId());
            String strI = sb.toString();
             label = new SpanLabel("ref livraison:"+strI);
             SpanLabel label2;
         StringBuilder sb2 = new StringBuilder();
         sb2.append("");
          sb2.append(e.getId_commande());
            String strI2 = sb2.toString();
             label2 = new SpanLabel("ref commande:"+strI2);
             
              Button    btndetail=new Button("livraison terminée");
              
              btndetail.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent evt) {
                  Commande comm3=new Commande();
                  comm3.setId(e.getId_commande());
                  ServiceCommande SC1=new ServiceCommande();
                  SC1.get(comm3);
                  comm3.setEtat(2);
                  SC1.Update(comm3);
                  ServiceLivraison SL1=new ServiceLivraison();
                  SL1.Update(e);
                  Meslivraisons ml = new Meslivraisons();
                 ml.getF().show();
                 
                 
              }
          });
                
              
               
         
          
          
          
      
          Container c =new Container(new BoxLayout(BoxLayout.Y_AXIS));
          c.addAll(label,label2);
          if (e.getEtat()==0){c.add(btndetail);}
          event.addAll(c);
          
      }
      f.getToolbar().addCommandToSideMenu("Les Livraison",null, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent d) {
                 
             }
         });
      
      f.add(event);
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

private void initStarRankStyle(Style s, Image star) {
    s.setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
    s.setBorder(Border.createEmpty());
    s.setBgImage(star);
    s.setBgTransparency(0);
}
public void destroy(){}
 
    
}
