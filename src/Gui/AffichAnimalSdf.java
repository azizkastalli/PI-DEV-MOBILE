/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entite.AnimalSdf;
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
public class AffichAnimalSdf {
    
    private Form f;
    private Container Asdf;
     

    public AffichAnimalSdf() throws IOException {
         f = new Form();
         Asdf = new Container(new BoxLayout(BoxLayout.Y_AXIS)) ;
         ServiceAnimalsdf SE=new ServiceAnimalsdf();
         ArrayList<AnimalSdf> listsdf = SE.getAll();
         System.out.println("listaa : "+listsdf);
         
          f.getToolbar().addCommandToRightBar("back", null, (ev)->{EspaceService ES=new EspaceService();
          ES.getF().show();
          });
          
          for (AnimalSdf A : listsdf)
          {
              SpanLabel label = new SpanLabel(A.getLieu_trouvaille());
              SpanLabel label1 = new SpanLabel(A.getDate_trouvaille().toString());
              SpanLabel label2 = new SpanLabel(A.getSexe());

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
