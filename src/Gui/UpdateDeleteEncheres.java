/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entite.Encheres;
import Service.ServiceEncheres;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author azizkastalli
 */
public class UpdateDeleteEncheres {

    private Form f;
    private Container encheres;
    
    public UpdateDeleteEncheres() throws IOException {
        
         f = new Form();
         encheres = new Container(new BoxLayout(BoxLayout.Y_AXIS)) ;
         ServiceEncheres serviceEncheres=new ServiceEncheres();
         ArrayList<Encheres> listeEncheres = serviceEncheres.getAll();
         
          f.getToolbar().addCommandToRightBar("back", null, (ev)->{EspaceMagasin EM=new EspaceMagasin();
          EM.getF().show();
          });
         
      for(Encheres e : listeEncheres)
      {
          //1er bloc : creation d'image 
          ImageViewer image = new ImageViewer();
          Image placeholder = Image.createImage( 200, 200, 0xbfc9d2); 
          EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
          Image img=URLImage.createToStorage(encImage, e.getLabel() ,"http://localhost/pidev8.0/web/images/gallery/"+e.getNom_image(), URLImage.RESIZE_SCALE);
          image.setImage(img);

          //2eme bloc : les informations de l'enchere
          SpanLabel label = new SpanLabel(e.getLabel());
          TextField SeuilMise = new TextField(Double.toString(e.getSeuil_mise()));
          Picker dateEncheres = new Picker();
          dateEncheres.setDate(e.getDate_debut());
          Picker heureEncheres = new Picker();
          heureEncheres.setType(Display.PICKER_TYPE_TIME);
          heureEncheres.setTime(Integer.parseInt(e.getDate_debut().toString().substring(11,13)) 
                  , Integer.parseInt(e.getDate_debut().toString().substring(14,16)));

          //dernier bloc : les bouttons
          Button update = new Button("update");
          Button delete = new Button("Delete");

          Container c =new Container(new BoxLayout(BoxLayout.Y_AXIS));
          c.addAll(image,label,SeuilMise,dateEncheres,heureEncheres,update,delete);
          encheres.add(c);
            
          //update enchere
          update.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent evt) {
                     //controle ensuite mise à jours

                  boolean verifmise=false;
                  boolean verifdate=false;
                  
                  Encheres  E = new Encheres();
                  E.setId_encheres(e.getId_encheres());
            
                  Date currDate = new Date();  
                    if( (dateEncheres.getDate().getTime()-currDate.getTime()) <= 0 )
                  {
                    Dialog.show("Date incorrect", "SVP saisissez une date correcte ", "OK", null);
                  } 
                    else
                  {
                     verifdate=true;
                         String  stringdate = new SimpleDateFormat("yyyy-MM-dd").format(dateEncheres.getDate())
                                       +" "+heureEncheres.getText()+":00";

                         E.setStringdate_debut(stringdate);
                  }
              
             try{
                    double mise = Double.parseDouble(SeuilMise.getText());   
                    E.setSeuil_mise(mise);
                    verifmise=true;
              }
              catch(Exception ex)
             {
                 Dialog.show("Mise incorrect", "SVP saisissez un reel ", "OK", null);
             }     
                   
              
             if( verifmise && verifdate )    
             { ServiceEncheres serviceEncheres=new ServiceEncheres();
                  if (Dialog.show("Confirmer", "Voulez vous vraiment modifier cette enchere ?", "Oui", "Non")) 
                  {
                      serviceEncheres.Update(E);
                       Dialog.show("Mise à jour avec succes", "l'encehres "+e.getLabel()+" est modifié ", "OK", null);
                  }
                   }
              }
          });
          
          //delete enchere
          delete.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent evt) {
                 Encheres  E = new Encheres();
                 E.setId_encheres(e.getId_encheres());
                 ServiceEncheres serviceEncheres=new ServiceEncheres();
                  if (Dialog.show("Confirmer", "Voulez vous vraiment supprimer cette enchere ?", "Oui", "Non")) 
                   {serviceEncheres.Delete(E);
                    Dialog.show("suppression avec succes", "l'encehres "+e.getLabel()+" est supprimé ", "OK", null);
                      }     
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
