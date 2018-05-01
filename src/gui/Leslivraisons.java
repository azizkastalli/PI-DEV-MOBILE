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
public class Leslivraisons {
    
    public Form f;
    private Container event;
     private EncodedImage encImage;
          private Resources theme;
          private double prix_tot=0;

    public Leslivraisons()  {
         f = new Form("Livraisons non livrées");
         event = new Container(new BoxLayout(BoxLayout.Y_AXIS)) ;
         ServiceCommande SE=new ServiceCommande();
         ServiceLignecommande SEL=new ServiceLignecommande();
         ServiceProduit SEP=new ServiceProduit();
         ArrayList<Commande> listeEvent = SE.getc();
         
         System.out.println("listaa : "+listeEvent);
            
         
         
         for(Commande e : listeEvent)
      {
          
          
          SpanLabel label;
         StringBuilder sb = new StringBuilder();
         sb.append("");
          sb.append(e.getId());
            String strI = sb.toString();
             label = new SpanLabel(strI);
             SpanLabel label2;
         StringBuilder sb2 = new StringBuilder();
         sb2.append("");
          sb2.append(e.getPrix_tot());
            String strI2 = sb2.toString();
             label2 = new SpanLabel(strI2);
             
              Button    btndetail=new Button("Livrer");
              
              btndetail.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent evt) {
                 Livraison liv= new Livraison();
                 Commande comm2= new Commande();
                 ServiceLivraison serli= new ServiceLivraison();
                 ServiceCommande sercom2=new ServiceCommande();
                 liv.setEtat(0);
                 liv.setId_client(e.getId_client());
                 liv.setId_commande(e.getId());
                 liv.setId_livreur(Login.loggduser.getId());
                 comm2.setId(e.getId());
                 comm2.setEtat(1);
                 serli.Create(liv);
                 sercom2.Update(comm2);
                 Leslivraisons ll = new Leslivraisons();
                 ll.getF().show();
                 
              }
          });
                
              
               
         
          
          
          
      
          Container c =new Container(new BoxLayout(BoxLayout.Y_AXIS));
          c.addAll(label,label2,btndetail);
          event.addAll(c);
          
      }
      f.getToolbar().addCommandToSideMenu("Mes Livraison",null, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent d) {
                 Meslivraisons ML = new Meslivraisons();
                 ML.getF().show();
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
