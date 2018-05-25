/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;


import Entite.Evenement;
import Service.ServiceEvenement;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.ImageIO;
import java.io.IOException;
import java.util.ArrayList;
import com.restfb.BinaryAttachment;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import java.io.ByteArrayOutputStream;





/**
 *
 * @author iheb bf
 */
public class AffichageEvent {
    
      private Form f;
    private Container event;
     private EncodedImage encImage;

    public AffichageEvent() throws IOException {
         f = new Form();
         event = new Container(new BoxLayout(BoxLayout.Y_AXIS)) ;
         ServiceEvenement SE=new ServiceEvenement();
         ArrayList<Evenement> listeEvent = SE.getAll();
         System.out.println("listaa : "+listeEvent);
         
         f.getToolbar().addCommandToRightBar("back", null, (ev)->{EspaceService ES=new EspaceService();
          ES.getF().show();
          });
         
         
         for(Evenement e : listeEvent)
      {
          //bloc de creation d'image
        ImageViewer image = new ImageViewer();
          Image placeholder = Image.createImage(100, 100, 0xbfc9d2); 
          EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
          
        
          Image img=URLImage.createToStorage(encImage,e.getNom(),"http://localhost/pidev3.0/web/images/"+e.getNom_image(), URLImage.RESIZE_SCALE);
    image.setImage(img);
          
          SpanLabel label = new SpanLabel(e.getNom());
          
             Button Details = new Button("Details");
                 Button Reserver = new Button("Reserver");
               
           Container c =new Container(new BoxLayout(BoxLayout.Y_AXIS));
                    Container c1 =new Container(new BoxLayout(BoxLayout.X_AXIS));
                    
            c.addAll(image,label,Details);
      Details.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                ImageViewer image = new ImageViewer();
          Image placeholder = Image.createImage(320, 200, 0xbfc9d2); 
          EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
          
        
          Image img=URLImage.createToStorage(encImage,e.getNom(),"http://localhost/pidev3.0/web/images/"+e.getNom_image(), URLImage.RESIZE_SCALE);
    image.setImage(img);
          
          SpanLabel nom = new SpanLabel("nom : "+e.getNom());
            SpanLabel desc = new SpanLabel("Description : "+e.getNom());
            SpanLabel nbr = new SpanLabel("place restant est  : "+String.valueOf(e.getNbr_participants()));
            SpanLabel dateD = new SpanLabel("date debut est  : "+String.valueOf(e.getDate_debut()));

             Button Partage = new Button("Partage");
           Form h2 = new Form("Details ", new BoxLayout(BoxLayout.Y_AXIS));
           
           h2.getToolbar().addCommandToSideMenu("Menu Principale",null, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent d) {
                 Gui.allProduit panpage = new Gui.allProduit();
                 panpage.getF().show();
             }
         });
            
          h2.getToolbar().addCommandToSideMenu("voir panier",null, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent d) {
                 Gui.Panier panpage = new Gui.Panier();
                 panpage.getF().show();
             }
         });
          h2.getToolbar().addCommandToSideMenu("voir actualité",null, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent d) {
                 Actualite actpage = new Actualite();
                 actpage.getF().show();
                 
             }
         });
          h2.getToolbar().addCommandToSideMenu("Les evenements",null, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent d) {
                 try {
                     AffichageEvent afepage = new AffichageEvent();
                     afepage.getF().show();
                 } catch (IOException ex) {
                    
                 }
                 
             }
         });
          h2.getToolbar().addCommandToSideMenu("Espace services",null, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent d) {
                 EspaceService afepage = new EspaceService();
                 afepage.getF().show();
                 
             }
         });
          h2.getToolbar().addCommandToSideMenu("Les encheres",null, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent d) {
                 try {
                     AllEncheres afepage = new AllEncheres();
                     afepage.getF().show();
                 } catch (IOException ex) {
                     
                 }
                 
             }
         });
          h2.getToolbar().addCommandToSideMenu("Se déconnecter",null, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent d) {
                 Login afepage = new Login();
                 afepage.getF().show();
                 
             }
         });
         
                    Container c2 =new Container(new BoxLayout(BoxLayout.Y_AXIS));
                    
            h2.addAll(image,nom,desc,nbr,dateD,Partage);
                Partage.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                     
                        try {
                                String accessToken = "EAACEdEose0cBAAWfeDOcXSKGjiyCBEoeaELqgLGI3Q9YP6kIddQYiThKjD3RvFzooBcVqgsZB0KF8Gu9fgJChUCyAotAHMgMWH1OCZCc4fO0oLTiBpI3Gvf0z5UoT1G340jsPbec9haPyC5azqVNFqI4Ywt1V4Hx6rDxkEeOc3h2217ZBpSFhm8sIrlB1Y5OLSzQ0mBDwZDZD";
        FacebookClient fbClient = new DefaultFacebookClient(accessToken);
    
        ImageIO imgIO= ImageIO.getImageIO();
                 ByteArrayOutputStream out = new ByteArrayOutputStream();
             String  fileName = e.getNom_image();

 ImageViewer image = new ImageViewer();
          Image placeholder = Image.createImage(320, 200, 0xbfc9d2); 
          EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
          
        
          Image img=URLImage.createToStorage(encImage,e.getNom(),"http://localhost/pidev4.0/web/images/"+e.getNom_image(), URLImage.RESIZE_SCALE);                     
           Label myLabel=new Label(img);
        final Label ok=new Label(); 
        
          imgIO.save(myLabel.getIcon(),out,ImageIO.FORMAT_JPEG ,1.0f);
                 byte[] ba = out.toByteArray();
                           
                       FacebookType response = fbClient.publish("me/photos", FacebookType.class, BinaryAttachment.with(e.getNom_image(),ba), Parameter.with("message", e.getDescription()));
        System.out.println("fb.com/" + response.getId());
                        }catch (IOException ex) {
                        }
        
                    }

                  
                });
                
                h2.add(c2);
                
              h2.show();
                
                
                
            }
        });
      
        
        
    
          event.addAll(c);
            
        
          
      }
      f.getToolbar().addCommandToSideMenu("Menu Principale",null, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent d) {
                 allProduit afepage = new allProduit();
                 afepage.getF().show();
                 
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
      
      
      f.add(event);
         
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
 
    
    
}
