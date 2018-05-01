/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entite.Evenement;
import Service.ServiceEvenement;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;

import java.util.ArrayList;

/**
 *
 * @author iheb bf
 */
public class ModifSuppEvent {

    private Form f;
    private Container event;
    private EncodedImage encImage;
    private TextField tnom = new TextField();
    private TextField description = new TextField();
    private TextField timage = new TextField();
    private TextField nbr = new TextField();

    public ModifSuppEvent() {

        f = new Form();
        event = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        ServiceEvenement SE = new ServiceEvenement();
        ArrayList<Evenement> listeEvent = SE.getAll();
        System.out.println("listaa : " + listeEvent);

        f.getToolbar().addCommandToRightBar("back", null, (ev) -> {
            EspaceMagasin EM = new EspaceMagasin();
            EM.getF().show();
        });

        for (Evenement e : listeEvent) {
            //bloc de creation d'image
            ImageViewer image = new ImageViewer();
            Image placeholder = Image.createImage(100, 100, 0xbfc9d2);
            EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);

            Image img = URLImage.createToStorage(encImage, e.getNom(), "http://localhost/pidev4.0/web/images/" + e.getNom_image(), URLImage.RESIZE_SCALE);
            image.setImage(img);

            SpanLabel label = new SpanLabel("nom est : " + e.getNom());
            SpanLabel label1 = new SpanLabel("description : " + e.getDescription());

            //Font fnt = Font.createTrueTypeFont("fontello", "fontello.ttf");
            int w = Display.getInstance().getDisplayWidth();

            Label la = new Button();
            la.setIcon(FontImage.createMaterial(FontImage.MATERIAL_UPDATE, "", 5));

            Label la1 = new Button();
            la1.setIcon(FontImage.createMaterial(FontImage.MATERIAL_DELETE, "", 5));

            Container c = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container c3 = new Container(new BoxLayout(BoxLayout.Y_AXIS));

            Container c2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));

            Container c1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            la.setHeight(10);
            la.setWidth(10);
            la.addPointerPressedListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    Form f1 = new Form();
                    Container c2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                    Button update = new Button("modifier");

                    tnom.setText(e.getNom());
                    description.setText(e.getDescription());
                    nbr.setText(String.valueOf(e.getNbr_participants()));
                    timage.setText(e.getNom_image());
                    System.out.println(e.getId());

                    update.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            int nbr1 = Integer.parseInt(nbr.getText());
                            Evenement ev = new Evenement(e.getId(), tnom.getText(), description.getText(), nbr1, timage.getText());
                            SE.Update(ev);

                        }
                    });

                    c2.addAll(tnom, description, nbr, timage, update);
                    f1.add(c2);
                    f1.show();

                }
            });

            la1.addPointerPressedListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {

                    Evenement ev = new Evenement();
                    ev.setId(e.getId());
                    System.out.println("id est" + e.getId());
                    if (Dialog.show("Confirmer", "Voulez vous  supprimer cet evenemenet ?", "Oui", "Non")) {
                        SE.Delete(ev);
                    }
                    Dialog.show("suppression avec succes", "l'evenement " + e.getNom() + " est supprimé ", "OK", null);
                    ModifSuppEvent mse = new ModifSuppEvent();
                    mse.getF().show();
                }
            });

            c.addAll(label, label1);

            c1.addAll(image, c);

            c2.addAll(c1, la, la1);

            event.addAll(c2);

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
