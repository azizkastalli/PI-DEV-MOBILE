/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entite.Produit;
import Service.ServiceProduit;
import com.codename1.capture.Capture;
import com.codename1.components.MultiButton;
import com.codename1.io.File;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.io.Storage;
import com.codename1.io.Util;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import java.io.IOException;


/**
 *
 * @author HP
 */
public class HomeForm {
TextField image = new TextField("","lien de l'image..");       
        private Container label;
        Form f2;
        
        TextField tetat;
        Button btnajt,btnaff;

    public HomeForm() {

        String[] characters = { "Chien", "Chat", "Nourriture"};
        
        int size = Display.getInstance().convertToPixels(7);
    EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(size, size, 0xffcccccc), true);
    Image[] pictures = {
    URLImage.createToStorage(placeholder, "Chien","http://localhost/pidev3.0/web/images/news-img-02.jpg"),
    URLImage.createToStorage(placeholder, "Chat","http://localhost/pidev3.0/web/images/instagram-img-06.jpg"),
    URLImage.createToStorage(placeholder, "Nourriture","http://localhost/pidev3.0/web/images/cart-img-03.jpg")
};

    MultiButton b = new MultiButton("Choisit une catégorie...");
b.addActionListener(e -> {
    Dialog d = new Dialog();
    d.setLayout(BoxLayout.y());
    d.getContentPane().setScrollableY(true);
    for(int iter = 0 ; iter < characters.length ; iter++) {
        MultiButton mb = new MultiButton(characters[iter]);
        mb.setIcon(pictures[iter]);
        d.add(mb);
        mb.addActionListener(ee -> {
            b.setTextLine1(mb.getTextLine1());
            b.setIcon(mb.getIcon());
            d.dispose();
            b.revalidate();
        });
    }
    d.showPopupDialog(b);
});


        Button imag = new Button("upload image");
        imag.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
           String i = Capture.capturePhoto();
                
            if (i!= null)
            {
               try {
                   Image im = Image.createImage(i); 
             
                   
                   image.setText(i.substring(38));
                   
               } catch (IOException ex) {
                    ex.printStackTrace();
               }
            }
                }
        });

        
        
        
        
        


        label = new Container(new BoxLayout(BoxLayout.Y_AXIS)) ;
       TextField labell = new TextField("","Nom Produit");
       TextField caracteristique = new TextField("","caracteristique");
       TextField description = new TextField("","description");
       TextField prix = new TextField("","prix");
       
       
       TextField poid = new TextField("","poid");
       TextField quantite = new TextField("","quantite");
        
        f2 = new Form("Formulaire", new BoxLayout(BoxLayout.Y_AXIS));
        
        btnajt=new Button("Ajouter");
        label.add(labell);
        label.add(caracteristique);
        label.add(description);
        label.add(prix);
        label.add(imag);
        label.add(image);
        label.add(poid);
        label.add(quantite);
        label.add(b);
        f2.add(label);
        f2.add(btnajt);
      
       
        btnajt.addActionListener((e) -> {
            ServiceProduit ser = new ServiceProduit();
            double pri = Double.parseDouble(prix.getText());
            double poi = Double.parseDouble(poid.getText());
            int quant = Integer.parseInt(quantite.getText());
            
            Produit t = new Produit(caracteristique.getText(),description.getText(),"confirmer",b.getTextLine1(),0,image.getText(),poi,0,pri,quant,0,labell.getText());
            ser.Create(t);
             Dialog.show("Ajout du Produit", "Votre Produit a été ajouter avec succes", "OK", null);
             allProduit al = new allProduit();
             al.getF().show();
        });
        
             f2.getToolbar().addCommandToSideMenu("Les Produits",null, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent evt) {
                 allProduit al = new allProduit();
                 al.getF().show();
             }
         });
    }

    public Form getF() {
        return f2;
    }

    public void setF(Form f) {
        this.f2 = f;
    }

   

    
}
