/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entite.AnimalSdf;
import Service.ServiceAnimalsdf;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.spinner.Picker;

/**
 *
 * @author user
 */
public class AjoutASDF {
     private Form f;
    private Container event;
     
     
    TextField tlieu;
    ComboBox <String> sexe = new ComboBox();
   
    Button btnajout;
    
     public AjoutASDF() {
       
         f = new Form("home");
        
        tlieu = new TextField();
        
        btnajout = new Button("ajouter");
        
          Picker dateD = new Picker();
          sexe.addItem("male");
          sexe.addItem("femele");
          
        
        f.add(dateD);
        f.add(tlieu);
        f.add(sexe);
        
        
        
        f.add(btnajout);
        
       
        btnajout.addActionListener((ActionEvent e) -> {
            String  stringdate = new SimpleDateFormat("yyyy-MM-dd").format(dateD.getDate());   
            ServiceAnimalsdf AS = new ServiceAnimalsdf();
            AnimalSdf S = new AnimalSdf(sexe.getSelectedItem(),tlieu.getText(),stringdate);
            AS.Create(S);
            
            

        });
        
        
        
        
    }
    
     public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
}
