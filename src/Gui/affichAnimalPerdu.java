/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entite.AnimalPerdu;
import Entite.AnimalSdf;
import Service.ServiceAnimalperdu;
import Service.ServiceAnimalsdf;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class affichAnimalPerdu {
    
     private Form f;
    private Container Asdf;
    
    
     public affichAnimalPerdu() throws IOException {
         f = new Form();
         Asdf = new Container(new BoxLayout(BoxLayout.Y_AXIS)) ;
         ServiceAnimalperdu SE=new ServiceAnimalperdu();
         ArrayList<AnimalPerdu> listsdf = SE.getAll();
         System.out.println("listaa : "+listsdf);
         
          f.getToolbar().addCommandToRightBar("back", null, (ev)->{EspaceService ES=new EspaceService();
          ES.getF().show();
          });
          for (AnimalPerdu A : listsdf)
          {
              SpanLabel label = new SpanLabel(A.getLieu_disparition());
              SpanLabel label1 = new SpanLabel(A.getDate_disparition().toString());
              Boolean etat = Boolean.valueOf(A.isEtat());
              String etatt;
              if (etat == true)
              {
                   etatt = "trouve";
              }
              else etatt = "perdu";
              SpanLabel label2 = new SpanLabel(etatt);

             Asdf.addAll(label,label1,label2);
          }
    f.add(Asdf);
}
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    
    
}
