/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entite.Categorie;
import Entite.Evenement;
import Service.ServiceEvenement;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.spinner.Picker;
import java.util.ArrayList;


/**
 *
 * @author iheb bf
 */
public class AjoutEvent {
 private Form f;
    private Container event;
     private EncodedImage encImage;
      public Evenement ev = new Evenement();
     
    TextField tnom;
    TextField tdesc;
    TextField tnbr;
    TextField timage;
    Button btnajout,btnaff;
    int idCat=0;
    public AjoutEvent() {
       
         f = new Form("home");
        tnom = new TextField();
        tdesc = new TextField();
        tnbr=new TextField();
        timage=new TextField();
        btnajout = new Button("ajouter");
        btnaff=new Button("Affichage");
          Picker dateDebut = new Picker();
          Picker heuresD = new Picker();
          heuresD.setType(Display.PICKER_TYPE_TIME);
           Picker dateFin = new Picker();
          Picker heuresF = new Picker();
                    heuresF.setType(Display.PICKER_TYPE_TIME);
                        ComboBox cb=new ComboBox();
                  
                          ServiceEvenement SE=new ServiceEvenement();
                         
         ArrayList<Categorie> listeCat = SE.getAllCat();
         for(Categorie e : listeCat){
    
         cb.addItem(e.getNom());
        
            
         
       
           
         
            cb.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent evt) {
               int idCat=0;
              
          if(e.getNom().equals( cb.getSelectedItem()))
         {
        idCat=e.getId();
          
          System.out.println("id"+idCat);
          ev.setId_categorie(idCat);
         }
      
           
      
         
           }});
         }
        f.add(tnom);
        f.add(tdesc);
        f.add(tnbr);
        
         f.add(dateDebut);
        f.add(heuresD);
          f.add(dateFin);
        f.add(heuresF);
        f.add(timage);
        f.add(cb);
        f.add(btnajout);
        f.add(btnaff);
         
       
        btnajout.addActionListener((ActionEvent e) -> {
             String  stringdateD = new SimpleDateFormat("yyyy-MM-dd").format(dateDebut.getDate())
                                       +" "+heuresD.getText()+":00";
              String  stringdateF = new SimpleDateFormat("yyyy-MM-dd").format(dateFin.getDate())
                                       +" "+heuresF.getText()+":00";
        ServiceEvenement se = new ServiceEvenement();
         int nbr = Integer.parseInt(tnbr.getText());  
         
           
          ev.setNom(tnom.getText());
          ev.setDescription(tdesc.getText());
          ev.setNbr_participants(nbr);
          ev.setStringdateD(stringdateD);
          ev.setStringdateF(stringdateF);
          ev.setNom_image(timage.getText());
        
            se.Create(ev);
            

        });
       
       
        
        /*Display.getInstance().openGallery(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                if (ev != null && ev.getSource() != null) {
                    
                    String filePath = (String) ev.getSource();
                    
                    System.err.println( ev.getSource());
                    System.out.println(filePath);
                    int fileNameIndex = filePath.lastIndexOf("/") + 1;
                    String fileName = filePath.substring(fileNameIndex);
                 
                    Image img = null;
                    try {
                        img = Image.createImage(FileSystemStorage.getInstance().openInputStream(filePath));
                       
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                   // MultiList photoList = findPhotoList();
                    Hashtable tableItem = new Hashtable();
                    tableItem.put("icon", img.scaled(Display.getInstance().getDisplayHeight() / 10, -1));
                    tableItem.put("emblem", fileName);
                    
                  
                    //photoList.getModel().addItem(tableItem);
                    // Do something, add to List
                }
            }
        }, Display.GALLERY_IMAGE);*/
        
    }
    
     public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
}
