/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entite.Produit;
import Service.ServiceProduit;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class allProduit {
    private Form f;
    private Container event;
     private EncodedImage encImage;
      

    public allProduit()  {
         f = new Form();
         event = new Container(new BoxLayout(BoxLayout.Y_AXIS)) ;
         ServiceProduit SE=new ServiceProduit();
         ArrayList<Produit> listeEvent = SE.getAll();
         System.out.println("listaa : "+listeEvent);
         
         
         
         for(Produit e : listeEvent)
      {
          //bloc de creation d'image
       ImageViewer image = new ImageViewer();
          Image placeholder = Image.createImage( 400, 200, 0xbfc9d2); 
          EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
          
        
          Image img=URLImage.createToStorage(encImage,e.getLabel(),"http://localhost/pidev3.0/web/images/"+e.getNom_image(), URLImage.RESIZE_SCALE);
    image.setImage(img);
          
          SpanLabel label = new SpanLabel(e.getLabel());
              Button    btnajout=new Button("Detail");

               
         
          
          
          
      
          Container c =new Container(new BoxLayout(BoxLayout.Y_AXIS));
          c.addAll(image,label,btnajout);
          event.addAll(c);
            
          /*inscription.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent evt) {
                 //inscription à une enchere
                 Participantsencheres participant = new Participantsencheres();
                 ServiceParticipantEncheres Serviceparticipants = new ServiceParticipantEncheres();
                 String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(e.getDate_debut());
                 
                 participant.setDebut_session(date);
                 participant.setId_session(e.getId_encheres());
                 participant.setId_user(2);
                 participant.setNum("20435370");
                 Serviceparticipants.Create(participant);
              }
          });*/
      
       /*   Quit.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent evt) {
                 //quitter une encheres
                 Participantsencheres participant = new Participantsencheres();
                 ServiceParticipantEncheres Serviceparticipants = new ServiceParticipantEncheres();
                 participant.setId_session(e.getId_encheres());
                 participant.setId_user(2);
                 Serviceparticipants.Delete(participant);
              }
          });*/
          
      }
      
      f.add(event);
         
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
 
    
}
