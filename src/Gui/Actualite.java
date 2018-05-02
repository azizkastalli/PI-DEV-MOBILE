/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import com.cd1.esprit.Rss;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author azizkastalli
 */
public class Actualite {
   private Form f;

    public Actualite() {
       this.f = new Form();
       
          f.getToolbar().addCommandToSideMenu("Actualité",null, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent evt) {
                 Gui.Actualite actualite = new Gui.Actualite();
                 actualite.getF().show();
             }
         });

         f.getToolbar().addCommandToSideMenu("Produits",null, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent evt) {
                 Gui.allProduit prd = new Gui.allProduit();
                 prd.getF().show();
             }
         });
         
         f.getToolbar().addCommandToSideMenu("Encheres",null, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent evt) {
                
                 try {
                     Gui.AllEncheres ench = new Gui.AllEncheres();
                     ench.getF().show();
                 } catch (IOException ex) {
                     System.out.println(ex.getMessage());
                 }
             }
         });
       
        Rss rss = new Rss("http://www.30millionsdamis.fr/actualites/rss.xml");
        rss.getListOfElements();
        List<Container> clist = rss.getListofContainers();
        for(Container c : clist)
        {
                f.add(c);
        }
               
    }

    public Form getF() {
        return f;
    }
   
   
}
