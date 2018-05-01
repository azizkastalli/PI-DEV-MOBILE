/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entite.Commande;
import Entite.Lignecommande;
import Entite.Produit;
import Service.ServiceCommande;
import Service.ServiceLignecommande;
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
public class Mescommandes {
    
    public Form f;
    private Container event;
     private EncodedImage encImage;
          private Resources theme;
          private double prix_tot=0;
        private ArrayList<Lignecommande> listeEvent2 = new ArrayList<>();
        private ArrayList<Produit> listeEvent3 = new ArrayList<>(); 

    public Mescommandes()  {
         f = new Form();
         event = new Container(new BoxLayout(BoxLayout.Y_AXIS)) ;
         ServiceCommande SE=new ServiceCommande();
         ServiceLignecommande SEL=new ServiceLignecommande();
         ServiceProduit SEP=new ServiceProduit();
         Commande commidc=new Commande();
         commidc.setId_client(Login.loggduser.getId());
         ArrayList<Commande> listeEvent = SE.getc(commidc);
         
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
             
              Button    btndetail=new Button("Details");
              
                
              btndetail.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent evt) {
               listeEvent2=SEL.getc(e);
               
               Form f2 = new Form("command"+strI,new BoxLayout(BoxLayout.Y_AXIS));
                    Container SS = new Container(new BoxLayout(BoxLayout.Y_AXIS)) ;
                    
               for(Lignecommande ee:listeEvent2)
               { Produit pt = new Produit();
               
                    listeEvent3.add(SEP.get(ee));
               }
               
               for(Produit eee:listeEvent3)
               {
          //bloc de creation d'image
       ImageViewer image = new ImageViewer();
          Image placeholder = Image.createImage( 400, 200, 0xbfc9d2); 
          EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
          
                   System.out.println(eee);
          Image img=URLImage.createToStorage(encImage,eee.getLabel(),"http://localhost/pidev3.0/web/images/"+eee.getNom_image(), URLImage.RESIZE_SCALE);
    image.setImage(img);
          
          SpanLabel label = new SpanLabel(eee.getLabel());
              
         Container c =new Container(new BoxLayout(BoxLayout.Y_AXIS));
          c.addAll(image,label);
          f2.addAll(c);
          
      }
           
          
               
               
               
               f2.getToolbar().addCommandToSideMenu("back",null, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent d) {
                 
                 Gui.Mescommandes commpage = new Mescommandes();
               commpage.getF().show();
                 
             }
         });
               f2.getToolbar().addCommandToSideMenu("voir panier",null, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent d) {
                 Panier panpage = new Panier();
                 panpage.getF().show();
             }
         });
               
               
               
               
               f2.show();
                             

                       
           }
       });
               
         
          
          
          
      
          Container c =new Container(new BoxLayout(BoxLayout.Y_AXIS));
          c.addAll(label,label2,btndetail);
          event.addAll(c);
          
      }
      f.getToolbar().addCommandToSideMenu("voir panier",null, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent d) {
                 Panier panpage = new Panier();
                 panpage.getF().show();
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