/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import com.codename1.components.ImageViewer;
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
import java.io.IOException;



/**
 *
 * @author iheb bf
 */
public class Home {
         private Form f;
        
    public Home() {
         f = new Form("Home" ,new BoxLayout(BoxLayout.X_AXIS));

        Button event =new Button("Evenement");
                Button espaceEvent =new Button("Espace Evenement");

      
        Container c = new Container(new BoxLayout(BoxLayout.Y_AXIS));

        c.addAll(event,espaceEvent);
       
        f.add(c);

        event.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

               AffichageEvent ae;
                try {
                    ae = new AffichageEvent();
                         ae.getF().show();
                } catch (IOException ex) {
                   
                }
           
            }

        });
        
         espaceEvent.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                EspaceEvenement ee= new EspaceEvenement();
                ee.getF().show();
           
            }

        });
        


    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
