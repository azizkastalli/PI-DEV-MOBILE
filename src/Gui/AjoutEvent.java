/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entite.Evenement;
import Service.ServiceEvenement;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.spinner.Picker;

/**
 *
 * @author iheb bf
 */
public class AjoutEvent {
 private Form f;
    private Container event;
     private EncodedImage encImage;
     
    TextField tnom;
    TextField tdesc;
    TextField tnbr;
    Button btnajout,btnaff;
    public AjoutEvent() {
       
         f = new Form("home");
        tnom = new TextField();
        tdesc = new TextField();
        tnbr=new TextField();
        btnajout = new Button("ajouter");
        btnaff=new Button("Affichage");
          Picker dateDebut = new Picker();
          Picker heuresD = new Picker();
          heuresD.setType(Display.PICKER_TYPE_TIME);
        f.add(tnom);
        f.add(tdesc);
        f.add(tnbr);
         f.add(dateDebut);
        f.add(heuresD);
        f.add(btnajout);
        f.add(btnaff);
       
        btnajout.addActionListener((ActionEvent e) -> {
             String  stringdate = new SimpleDateFormat("yyyy-MM-dd").format(dateDebut.getDate())
                                       +" "+heuresD.getText()+":00";
        ServiceEvenement se = new ServiceEvenement();
         int nbr = Integer.parseInt(tnbr.getText());  
            Evenement ev = new Evenement(tnom.getText(),tdesc.getText(),nbr,stringdate);
            se.Create(ev);
            

        });
        
        
        
        
    }
    
     public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
}
