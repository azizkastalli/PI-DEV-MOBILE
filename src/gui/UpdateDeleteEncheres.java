/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entite.Encheres;
import Service.ServiceEncheres;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.DateTimeSpinner;
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
         
      for(Encheres e : listeEncheres)
      {
          ImageViewer img = new ImageViewer(Image.createImage(e.getNom_image()));
          SpanLabel label = new SpanLabel(e.getLabel());
          TextField SeuilMise = new TextField((int) e.getSeuil_mise());
          DateTimeSpinner dateEncheres = new DateTimeSpinner();
          Button update = new Button();
          Button delete = new Button();

          Container c =new Container(new BoxLayout(BoxLayout.Y_AXIS));
          c.addAll(img,label,SeuilMise,dateEncheres,update);
          encheres.add(c);
            
          //update enchere
          update.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent evt) {
                     //controle ensuite mise à jours
                 Date date = dateEncheres.getCurrentDate();
                 
                 double mise = Double.parseDouble(SeuilMise.getText());    
                 Encheres  E = new Encheres();
                 E.setId_encheres(e.getId_encheres());
                 E.setSeuil_mise(mise);
               //  E.setDate_debut();
                 ServiceEncheres serviceEncheres=new ServiceEncheres();
                 serviceEncheres.Update(E);
              }
          });
          
          //delete enchere
          delete.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent evt) {
                 Encheres  E = new Encheres();
                 E.setId_encheres(e.getId_encheres());
                 ServiceEncheres serviceEncheres=new ServiceEncheres();
                 serviceEncheres.Delete(E);
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
