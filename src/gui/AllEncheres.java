/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entite.Encheres;
import Entite.Participantsencheres;
import Service.ServiceEncheres;
import Service.ServiceParticipantEncheres;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.Zanimaux.CountDown;
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
         
         for(Encheres e : listeEncheres)
      {
          ImageViewer img = new ImageViewer(Image.createImage(e.getNom_image()));
          SpanLabel label = new SpanLabel(e.getLabel());
          SpanLabel SeuilMise = new SpanLabel(String.valueOf(e.getSeuil_mise()));
          CountDown CompteRebours = new CountDown();
          Container cd = CompteRebours.SetCountDown(e.getDate_debut());
          Button inscription = new Button();
          Button Quit = new Button();

          Container c =new Container(new BoxLayout(BoxLayout.Y_AXIS));
          c.addAll(img,label,inscription,Quit,SeuilMise,cd);
          encheres.add(c);
            
          inscription.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent evt) {
                 //inscription à une enchere
                 Participantsencheres participant = new Participantsencheres();
                 ServiceParticipantEncheres Serviceparticipants = new ServiceParticipantEncheres();
                 participant.setDebut_session(e.getDate_debut());
                 participant.setId_session(e.getId_encheres());
                 participant.setId_user(0);
                 participant.setNum("");
                 Serviceparticipants.Create(participant);
              }
          });
      
          Quit.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent evt) {
                 //inscription à une enchere
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
