/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entite.Animal;
import Entite.AnimalPerdu;
import Service.ServiceAnimalperdu;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.spinner.Picker;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class AjoutAP {
    
    private Form f;
    private Container event;
     
     
    TextField tanimal;
    TextField tlieu;
    ComboBox ap = new ComboBox();
    Button btnajout;
    
     public AjoutAP() {
       
         f = new Form("home");
        
        tlieu = new TextField();
        
        
        btnajout = new Button("ajouter");
        
          Picker dateD = new Picker();
          ServiceAnimalperdu A = new ServiceAnimalperdu();
          ArrayList <Animal> listAn = A.getAllAnimal();
          for (Animal a : listAn)
          {
              ap.addItem(a.getId());
              
          }
          
          
        f.add(ap);  
        f.add(dateD);
        f.add(tlieu);
              
        
        
        f.add(btnajout);
        
       
        btnajout.addActionListener((ActionEvent e) -> {
             String  stringdate = new SimpleDateFormat("yyyy-MM-dd").format(dateD.getDate());
             System.out.println(listAn);
             int id = Integer.parseInt(ap.getSelectedItem().toString());  
            ServiceAnimalperdu se = new ServiceAnimalperdu();
            AnimalPerdu ev = new AnimalPerdu(id,stringdate,tlieu.getText());
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
