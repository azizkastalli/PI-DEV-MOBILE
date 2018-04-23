/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import CountDown.Countdown;
import Entite.Encheres;
import Entite.Participantsencheres;
import Service.ServiceEncheres;
import Service.ServiceParticipantEncheres;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author azizkastalli
 */
public class AllEncheres {
    private Form f;
    private Container encheres;

    public AllEncheres() throws IOException {
         f = new Form();
         encheres = new Container(new BoxLayout(BoxLayout.Y_AXIS)) ;
         ServiceEncheres serviceEncheres=new ServiceEncheres();
         ArrayList<Encheres> listeEncheres = serviceEncheres.getAll();
         System.out.println("listaa : "+listeEncheres);
         
         for(Encheres e : listeEncheres)
      {
          //bloc de creation d'image
          ImageViewer image = new ImageViewer();
          Image placeholder = Image.createImage( 200, 200, 0xbfc9d2); 
          EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
          Image img=URLImage.createToStorage(encImage, e.getLabel() ,"http://localhost/pidev8.0/web/images/gallery/"+e.getNom_image(), URLImage.RESIZE_SCALE);
          image.setImage(img);
          
          SpanLabel label = new SpanLabel(e.getLabel());
          SpanLabel SeuilMise = new SpanLabel(String.valueOf(e.getSeuil_mise()));
          
          Button inscription = new Button("participer");
          Button Quit = new Button("quitter");
          Countdown countdown = new Countdown();
          Container cd = countdown.SetCountDown(e.getDate_debut());
          Container c =new Container(new BoxLayout(BoxLayout.Y_AXIS));
          c.addAll(image,label,inscription,Quit,SeuilMise);
          encheres.addAll(c,cd);
            
          inscription.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent evt) {
                 //inscription à une enchere
                 Participantsencheres participant = new Participantsencheres();
                 ServiceParticipantEncheres Serviceparticipants = new ServiceParticipantEncheres();
                 participant.setDebut_session(e.getDate_debut());
                 participant.setId_session(e.getId_encheres());
                 participant.setId_user(0);
                 participant.setNum("20435370");
                 Serviceparticipants.Create(participant);
              }
          });
      
          Quit.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent evt) {
                 //quitter une encheres
                 Participantsencheres participant = new Participantsencheres();
                 ServiceParticipantEncheres Serviceparticipants = new ServiceParticipantEncheres();
                 participant.setDebut_session(e.getDate_debut());
                 participant.setId_session(e.getId_encheres());
                 participant.setId_user(0);
                 participant.setNum("");
                 Serviceparticipants.Delete(participant);
              }
          });
          
      }
      
      f.add(encheres);
         
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
 
    
    
}
