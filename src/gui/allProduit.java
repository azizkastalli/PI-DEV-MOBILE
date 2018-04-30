/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entite.Produit;
import Service.ServiceProduit;
import com.codename1.components.ImageViewer;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SliderBridge;
import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
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
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class allProduit {
    public Form f;
    private Container event;
     private EncodedImage encImage;
          private Resources theme;
          

    public allProduit()  {
         f = new Form();
         event = new Container(new BoxLayout(BoxLayout.Y_AXIS)) ;
         ServiceProduit SE=new ServiceProduit();
         
         ArrayList<Produit> listeEvent = SE.getAll();
         System.out.println("listaa : "+listeEvent);
            
         Panier panpage = new Panier();
         
         for(Produit e : listeEvent)
      {
          //bloc de creation d'image
       ImageViewer image = new ImageViewer();
          Image placeholder = Image.createImage( 400, 200, 0xbfc9d2); 
          EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
          
        
          Image img=URLImage.createToStorage(encImage,e.getLabel(),"http://localhost/pidev3.0/web/images/"+e.getNom_image(), URLImage.RESIZE_SCALE);
    image.setImage(img);
          
          SpanLabel label = new SpanLabel(e.getLabel());
              Button    btndetail=new Button("Details");
              
                
              btndetail.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent evt) {
               Form f2 = new Form("haha",new BoxLayout(BoxLayout.Y_AXIS));
                    Container SS = new Container(new BoxLayout(BoxLayout.Y_AXIS)) ;

           ImageViewer image = new ImageViewer();
          Image placeholder = Image.createImage( 400, 200, 0xbfc9d2); 
          EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
          
        
          Image img=URLImage.createToStorage(encImage,e.getLabel(),"http://localhost/pidev3.0/web/images/"+e.getNom_image(), URLImage.RESIZE_SCALE);
    image.setImage(img);
          
          SpanLabel labelll = new SpanLabel("Nom Produit: "+e.getLabel());
          String pri = Double.toString(e.getPrix_nouv());
          SpanLabel prix = new SpanLabel("Prix: "+pri);
          SpanLabel carac = new SpanLabel("Caracteristique: "+e.getCaracteristiques());
          SpanLabel desc = new SpanLabel("Description: "+e.getDescription());
          Button rating = new Button("Rating");
          Button    btncart=new Button("ajout au panier");
            rating.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent evt) {
                                    
                  showForm();
                   }
               });
            btncart.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent evt) {
                       ArrayList<Object> nb_pdt = new ArrayList<>();
                       nb_pdt.add(0,e);
                       System.out.println(nb_pdt);
                       nb_pdt.add(1, 1);
                       Gui.Login.panier.add(nb_pdt);
                       System.out.println(Gui.Login.panier);
                       
                       
                   }
               });
               
               
               
               f2.getToolbar().addCommandToSideMenu("back",null,d->{f.showBack();});
               f2.getToolbar().addCommandToSideMenu("voir panier",null, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent d) {
                 Panier panpage = new Panier();
                 panpage.getF().show();
             }
         });
               
               
               SS.add(img);
               SS.add(labelll);
               SS.add(carac);
               SS.add(desc);
               SS.add(prix);
               SS.add(rating);
               SS.add(btncart);
               f2.add(SS);
               
               f2.show();
                             

                       
           }
       });
               
         
          
          
          
      
          Container c =new Container(new BoxLayout(BoxLayout.Y_AXIS));
          c.addAll(image,label,btndetail);
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
    public void showForm() {
    Label ll=new Label();    
  Form hi = new Form("Star rating vote", new BoxLayout(BoxLayout.Y_AXIS));
     Slider starRank = new Slider();
    starRank.setEditable(true);
    starRank.setMinValue(0);
    starRank.setMaxValue(5);
    Font fnt = Font.createTrueTypeFont("native:MainThin", "native:ItalicLight").
            derive(Display.getInstance().convertToPixels(5, true), Font.STYLE_PLAIN);
    Style s = new Style(0xffff33, 0, fnt, (byte)0);
    Image fullStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
    s.setOpacity(100);
    s.setFgColor(0);
    Image emptyStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
    initStarRankStyle(starRank.getSliderEmptySelectedStyle(), emptyStar);
    initStarRankStyle(starRank.getSliderEmptyUnselectedStyle(), emptyStar);
    initStarRankStyle(starRank.getSliderFullSelectedStyle(), fullStar);
    initStarRankStyle(starRank.getSliderFullUnselectedStyle(), fullStar);
    starRank.setPreferredSize(new Dimension(fullStar.getWidth() * 5, fullStar.getHeight()));
    starRank.addDataChangedListener(new DataChangedListener() {
        
        @Override
        public void dataChanged(int type, int index) {
            
            System.out.println("rank :"+starRank.getProgress());
            ll.setText("Vote :"+starRank.getProgress());
        }
    });
  
  hi.add(FlowLayout.encloseCenter(starRank));
  hi.add(ll);
  hi.show();
}

private void initStarRankStyle(Style s, Image star) {
    s.setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
    s.setBorder(Border.createEmpty());
    s.setBgImage(star);
    s.setBgTransparency(0);
}

 
    
}
    