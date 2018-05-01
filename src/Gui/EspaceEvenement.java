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

/**
 *
 * @author iheb bf
 */
public class EspaceEvenement {

    private Form f;

    public EspaceEvenement() {
        f = new Form("Espace Evenement",new BoxLayout(BoxLayout.X_AXIS));
        Button gestion = new Button("gestion");
        Button ajout = new Button("ajout");
      
        Button encheres = new Button("Encheres");
        Container c = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        ImageViewer image = new ImageViewer();
        ImageViewer image1 = new ImageViewer();

        Image placeholder = Image.createImage(200, 200, 0xbfc9d2);
        EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);

        Image img = URLImage.createToStorage(encImage, "update.png", "http://localhost/pidev4.0/web/images/update.png", URLImage.RESIZE_SCALE);
        Image img1 = URLImage.createToStorage(encImage, "add.png", "http://localhost/pidev4.0/web/images/add.png", URLImage.RESIZE_SCALE);
        image.setImage(img);
        image1.setImage(img1);
        Label l1 = new Label("ajout evenement");
        Label l2 = new Label("modif/supp evenement");

        c.add(image);
        c.add(l1);

        c.add(image1);
        c.add(l2);
        f.add(c);

        l1.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                AjoutEvent add = new AjoutEvent();
                add.getF().show();
            }

        });

        l2.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                ModifSuppEvent ae = new ModifSuppEvent();
                ae.getF().show();
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
