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
public class Panier {
    
    public Form f;
    private Container event;
     private EncodedImage encImage;
          private Resources theme;
          private double prix_tot=0;
         

    public Panier()  {
         f = new Form("Panier");
         event = new Container(new BoxLayout(BoxLayout.Y_AXIS)) ;
         ServiceProduit SE=new ServiceProduit();
         
         List<ArrayList> listeEventa = Login.panier;
          ArrayList<Produit> listeP = new ArrayList<Produit>();
          
         System.out.println("lista1 : "+listeEventa);
         for(ArrayList al : listeEventa)
         {
             listeP.add((Produit) al.get(0));}
            
         System.out.println("fama prod");
         ArrayList <ArrayList> alle =new ArrayList<>();
         for(Produit e : listeP)
      {
          prix_tot=prix_tot+e.getPrix_nouv();
          //bloc de creation d'image
       ImageViewer image = new ImageViewer();
          Image placeholder = Image.createImage( 400, 200, 0xbfc9d2); 
          EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
          
        
          Image img=URLImage.createToStorage(encImage,e.getLabel(),"http://localhost/pidev3.0/web/images/"+e.getNom_image(), URLImage.RESIZE_SCALE);
    image.setImage(img);
          
          SpanLabel label = new SpanLabel(e.getLabel());
              Button    btnsupppan=new Button("supprimer du panier");
              
              btnsupppan.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent evt) {
               for(ArrayList al : listeEventa)
         {     
             if (e.equals(al.get(0))){
                 alle.add(al);
         
         } }
               for(ArrayList al : alle)
         {     
             listeEventa.remove(al);
             Login.panier=listeEventa; }
               Gui.Panier panpage = new Panier();
               panpage.getF().show();
           }
       });
              
           
          
          
          
      
          Container c =new Container(new BoxLayout(BoxLayout.Y_AXIS));
          c.addAll(image,label,btnsupppan);
          event.addAll(c);
          
      }
         f.getToolbar().addCommandToSideMenu("les produits",null, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent d) {
                 allProduit panpage = new allProduit();
                 panpage.getF().show();
             }
         });
         f.getToolbar().addCommandToSideMenu("vider panier",null, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent d) {
                 listeEventa.clear();
                 Login.panier=listeEventa;
                 Gui.Panier panpage = new Panier();
               panpage.getF().show();
                 
             }
         });
         
         f.getToolbar().addCommandToSideMenu("prix total :"+prix_tot,null, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent d) {}});
         
         f.getToolbar().addCommandToSideMenu("passer commande",null, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent d) {
                 Commande comm = new Commande();
                 comm.setEtat(0);
                 comm.setId_client(Login.loggduser.getId());
                 comm.setPrix_tot(prix_tot);
                 ServiceCommande serco= new ServiceCommande();
                 serco.Create(comm);
                 int idf=0;
                 idf=serco.getlid(Login.loggduser.getId());
//ligne
                  for(Produit e : listeP)
                    {
                        Lignecommande lcomm = new Lignecommande();
                        lcomm.setQte(1);
                        lcomm.setId_client(Login.loggduser.getId());
                        lcomm.setId_produit(e.getId());
                        lcomm.setId_commande(idf);
                        ServiceLignecommande serlig=new ServiceLignecommande();
                        serlig.Create(lcomm);
                    
                    }
                 listeEventa.clear();
                 Login.panier=listeEventa;
                 Gui.Panier panpage = new Panier();
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
