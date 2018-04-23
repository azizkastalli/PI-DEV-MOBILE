/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Participantsencheres;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import java.util.ArrayList;

/**
 *
 * @author azizkastalli
 */
public class ServiceParticipantEncheres implements IntService<Participantsencheres> {

    @Override
    public void Create(Participantsencheres obj) {
 /* ConnectionRequest con = new ConnectionRequest();
        String Url = "http://41.226.11.243:10004/tasks/" + ta.getNom() + "/" + ta.getEtat();
        con.setUrl(Url);
        
        System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
   */ }

    @Override
    public void Delete(Participantsencheres obj) {
   //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Update(Participantsencheres obj) {
       //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Participantsencheres> getAll() {
        return null;
      //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Participantsencheres get(Participantsencheres obj) {
        return null;
     //To change body of generated methods, choose Tools | Templates.
    }
    
}
