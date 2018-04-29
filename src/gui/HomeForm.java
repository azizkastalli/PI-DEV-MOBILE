/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entite.Produit;
import Service.ServiceProduit;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author HP
 */
public class HomeForm {
        private Container label;
        Form f2;
        
        TextField tetat;
        Button btnajt,btnaff;

    public HomeForm() {

     


        label = new Container(new BoxLayout(BoxLayout.Y_AXIS)) ;
       TextField labell = new TextField("","Nom Produit");
       TextField caracteristique = new TextField("","caracteristique");
       TextField description = new TextField("","description");
       TextField prix = new TextField("","prix");
       TextField categorie = new TextField("","categorie");
       TextField image = new TextField("","image");
       TextField poid = new TextField("","poid");
       TextField quantite = new TextField("","quantite");
        
        f2 = new Form("Formulaire", new BoxLayout(BoxLayout.Y_AXIS));
        btnaff=new Button("Affichage");
        btnajt=new Button("Ajouter");
        label.add(labell);
        label.add(caracteristique);
        label.add(description);
        label.add(prix);
        label.add(categorie);
        label.add(image);
        label.add(poid);
        label.add(quantite);
        f2.add(label);
        f2.add(btnajt);
        f2.add(btnaff);
       
        btnajt.addActionListener((e) -> {
            ServiceProduit ser = new ServiceProduit();
            double pri = Double.parseDouble(prix.getText());
            double poi = Double.parseDouble(poid.getText());
            int quant = Integer.parseInt(quantite.getText());
            
            Produit t = new Produit(caracteristique.getText(),description.getText(),"confirmer",categorie.getText(),0,image.getText(),poi,0,pri,quant,0,labell.getText());
            ser.Create(t);
            

        });
        
        btnaff.addActionListener((e)->{
        allProduit a=new allProduit();
        a.getF().show();
        });
    }

    public Form getF() {
        return f2;
    }

    public void setF(Form f) {
        this.f2 = f;
    }

   

    
}
