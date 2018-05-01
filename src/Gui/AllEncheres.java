/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entite.Encheres;
import Entite.Participantsencheres;
import Service.ServiceEncheres;
import Service.ServiceParticipantEncheres;
import com.cd1.esprit.Countdown;
import com.codename1.components.ImageViewer;
import com.codename1.components.OnOffSwitch;
import com.codename1.components.SpanLabel;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.RadioButton;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.DataChangedListener;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author azizkastalli
 */
public class AllEncheres {
    private Form f;
    private Container encheres;

    public AllEncheres() throws IOException {
         f = new Form();
         Map <Integer,Container> SortEncheres = new TreeMap<>();
         encheres = new Container(new BoxLayout(BoxLayout.Y_AXIS)) ;
         ServiceEncheres serviceEncheres=new ServiceEncheres();
         ArrayList<Encheres> listeEncheres = serviceEncheres.getAll();
         ServiceParticipantEncheres ServiceParticipant=new ServiceParticipantEncheres();
         ArrayList<Integer> IdEncheres = ServiceParticipant.verificationParticipation(1);
         
          TextField recherche = new  TextField();
          RadioButton rb1 = new RadioButton("All");
          RadioButton rb2 = new RadioButton("Participe"); 
          RadioButton rb3 = new RadioButton("prticipe pas");
          new ButtonGroup(rb1, rb2, rb3);
          rb1.setSelected(true);
          Container Radio = new Container(new BoxLayout(BoxLayout.Y_AXIS));
          Radio.addAll(rb1,rb2,rb3);
          f.getToolbar().addComponentToSideMenu(recherche);
          f.getToolbar().addComponentToSideMenu(Radio);
          
         //radio buttons listener
         rb1.addActionListener((evt) -> {
                encheres.removeAll();
            for (Encheres e : listeEncheres) 
                 { if(recherche.getText().equals(""))
                   {
                       encheres.add(SortEncheres.get(e.getId_encheres()));
                   }
                  else
                   { 
                       if(e.getLabel().contains(recherche.getText()) )
                            encheres.add(SortEncheres.get(e.getId_encheres()));
                    }
              
                 }
         });
         
         rb2.addActionListener((evt) -> {
                encheres.removeAll();
                 for (Encheres e : listeEncheres) 
                 { if(recherche.getText().equals(""))
                     { 
                          for(Integer id : IdEncheres )
                             {
                                if(e.getId_encheres()==id)
                                    encheres.add(SortEncheres.get(e.getId_encheres()));}
                                    }
                  else
                   { 
                            for(Integer id : IdEncheres )
                             {
                                if(e.getId_encheres()==id && e.getLabel().contains(recherche.getText()))
                                    encheres.add(SortEncheres.get(e.getId_encheres()));}
                    }
                 }
         });
         
         rb3.addActionListener((evt) -> {
                encheres.removeAll();
                boolean ajout;  
             
                 for (Encheres e : listeEncheres) 
                 {              
                   ajout= true;
                   if(recherche.getText().equals(""))
                     { 
                          for(Integer id : IdEncheres )
                             {
                                 if(e.getId_encheres()==id)
                                   ajout=false;  
                                     }
                         if(ajout)
                             encheres.add(SortEncheres.get(e.getId_encheres()));  
                     } 
                  else
                   { 
                        for(Integer id : IdEncheres )
                             {
                                if(e.getId_encheres()==id)
                                     ajout=false;  
                                     }
                         if(ajout && e.getLabel().contains(recherche.getText()) )
                             encheres.add(SortEncheres.get(e.getId_encheres()));  
                    }
                 }
         });
         
         
         recherche.addDataChangedListener(new DataChangedListener() {
             @Override
             public void dataChanged(int type, int index) {
                 encheres.removeAll();
                 boolean ajout;
              
                 for (Encheres e : listeEncheres) 
                 { 
                    ajout= true;
                     if(recherche.getText().equals(""))
                         {
                      if(rb1.isSelected())
                         encheres.add(SortEncheres.get(e.getId_encheres()));
                      else if(rb2.isSelected())
                      {
                            for(Integer id : IdEncheres )
                             {
                                if(e.getId_encheres()==id)
                                    encheres.add(SortEncheres.get(e.getId_encheres()));
                                    }
                      }
                      else if (rb3.isSelected())
                      {
                           for(Integer id : IdEncheres )
                             {
                                 if(e.getId_encheres()==id)
                                   ajout=false;  
                                     }
                         if(ajout)
                             encheres.add(SortEncheres.get(e.getId_encheres()));  
                      }
                           }  
                     
                     else if( (e.getLabel().contains(recherche.getText())) )
                     {
                       if(rb1.isSelected())
                         encheres.add(SortEncheres.get(e.getId_encheres()));
                      else if(rb2.isSelected())
                      {
                            for(Integer id : IdEncheres )
                             {
                                if(e.getId_encheres()==id)
                                    encheres.add(SortEncheres.get(e.getId_encheres()));
                                    }
                      }
                      else if (rb3.isSelected())
                      {
                         for(Integer id : IdEncheres )
                             {
                                 if(e.getId_encheres()==id)
                                   ajout=false;  
                                     }
                                 if(ajout)
                                   encheres.add(SortEncheres.get(e.getId_encheres()));  
                        }
                     }                    
                   }                 
             }
         });
             
       
          f.getToolbar().addCommandToRightBar("back", null, (ev)->{EspaceMagasin EM=new EspaceMagasin();
          EM.getF().show();
          });
         
         for(Encheres e : listeEncheres)
      {
          //bloc de creation d'image
          ImageViewer image = new ImageViewer();
          Image placeholder = Image.createImage( 100, 100, 0xbfc9d2); 
          EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
          Image img=URLImage.createToStorage(encImage, e.getLabel() ,"http://localhost/pidev8.0/web/images/gallery/"+e.getNom_image(), URLImage.RESIZE_SCALE);
          image.setImage(img);
          
          SpanLabel participlabel = new SpanLabel();
          participlabel.getTextAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));

          SpanLabel label = new SpanLabel("Label :  " +e.getLabel());
          SpanLabel SeuilMise = new SpanLabel(String.valueOf("Seuil Mise : "+e.getSeuil_mise()));
          SeuilMise.getTextAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));

          Date datecurr = new Date();
          OnOffSwitch participer = new  OnOffSwitch();
           if(e.getDate_debut().getTime()<datecurr.getTime())
           { 
               participlabel.setText("vous ne puvez plus participer à cette enchere");
               participer.setHidden(true);
           }
             

          participer.setValue(false);
          participlabel.setText("Participer");

          for(Integer id : IdEncheres )
          {
             if(e.getId_encheres()==id)
             {participer.setValue(true);
              participlabel.setText("Quitter");
              }
                      }
          
          Countdown countdown = new Countdown();
          Container cd = countdown.SetCountDown(e.getDate_debut());
          Container c =new Container(new BoxLayout(BoxLayout.Y_AXIS));
          Container c2 =new Container(new BoxLayout(BoxLayout.Y_AXIS));
          Container c1 =new Container(new BoxLayout(BoxLayout.X_AXIS));

           c.addAll(participlabel,participer,SeuilMise);
           c1.addAll(image,c);
           c2.addAll(label,c1,cd);
           encheres.add(c2);
          SortEncheres.put(e.getId_encheres(),c2);
          
          participer.addActionListener((evt) -> {
                Participantsencheres participant = new Participantsencheres();
                ServiceParticipantEncheres Serviceparticipants = new ServiceParticipantEncheres();
                boolean add= true; 
                
                          for(Integer id : IdEncheres )
                          {
                             if(e.getId_encheres()==id)
                                           add=false; 
                                   }
                
               if( participer.isValue() && add==true )            
               {
                 participlabel.setText("Quitter");
                 String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(e.getDate_debut());
                 participant.setDebut_session(date);
                 participant.setId_session(e.getId_encheres());
                 participant.setId_user(1);
                 participant.setNum("20435370");
                 Serviceparticipants.Create(participant);  
                 IdEncheres.add(e.getId_encheres());
               }
               else if (participer.isValue()==false && Dialog.show("Confirmer", "Voulez vous vraiment ne plus participer à cette encheres ?", "Oui", "Non") ) 
                   {
                 participlabel.setText("Participer");
                 participant.setId_session(e.getId_encheres());
                 participant.setId_user(1);
                 Serviceparticipants.Delete(participant); 
                 int count = 0 ;
                 for(Integer id : IdEncheres )
                    {
                           if(e.getId_encheres()==id)
                             break;
                           else
                           count++;
                    }
                         IdEncheres.remove(count);
                   }
                  else
                  {
                     participer.setValue(true);
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
