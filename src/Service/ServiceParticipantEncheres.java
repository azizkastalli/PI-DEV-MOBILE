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
        System.out.println("id session : "+obj.getId_session());
        System.out.println("date : "+ obj.getDebut_session());
        System.out.println("id user : "+ obj.getId_user());
        System.out.println("numero : "+ obj.getNum());

        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/pidev8.0/web/app_dev.php/CreateParticipants/"
                +obj.getId_session()+"/"
                +obj.getDebut_session()+"/"
                +obj.getId_user()+"/"
                +obj.getNum();
        
        con.setUrl(Url);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    @Override
    public void Delete(Participantsencheres obj) {
           
    ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/pidev8.0/web/app_dev.php/DeleteParticipants/"+obj.getId_user()+"/"
                +obj.getId_session();
        
        con.setUrl(Url);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    
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
