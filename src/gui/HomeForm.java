/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;

/**
 *
 * @author HP
 */
public class HomeForm {
    
    Form f;
    TextField tnom;
    TextField tetat;
    Button btnajout,btnaff;

    public HomeForm() {
        f = new Form("home");
        btnaff=new Button("Affichage");
        
        f.add(btnaff);
       
        btnaff.addActionListener((e)->{
        allProduit a=new allProduit();
        a.getF().show();
        });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

   

    
}
