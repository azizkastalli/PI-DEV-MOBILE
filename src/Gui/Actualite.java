/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import com.cd1.esprit.Rss;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import java.util.List;

/**
 *
 * @author azizkastalli
 */
public class Actualite {
   private Form f;

    public Actualite() {
       this.f = new Form();
       
          f.getToolbar().addCommandToRightBar("back", null, (ev)->{
          EspaceMagasin EM=new EspaceMagasin();
          EM.getF().show();
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
