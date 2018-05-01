/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Participantsencheres;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author azizkastalli
 */
public class ServiceParticipantEncheres implements IntService<Participantsencheres> {

    @Override
    public void Create(Participantsencheres obj) {
        

        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/pidev8.0/web/app_dev.php/CreateParticipants/"
                +obj.getId_session()+"/"
                +obj.getDebut_session()+"/"
                +obj.getId_user()+"/"
                +obj.getNum();
        
        con.setUrl(Url);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
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
    
    public  ArrayList<Integer> verificationParticipation(int userid)
    {
       ArrayList<Integer> liste = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pidev8.0/web/app_dev.php/VerifParticipants/"+userid);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                JSONParser jsonp = new JSONParser();
                         
                try {
                    Map<String, Object> encheres = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    List<Map<String, Object>> list = (List<Map<String, Object>>) encheres.get("root");
                  
                    for (Map<String, Object> obj : list) {        
                        liste.add(Integer.parseInt(obj.get("id_session").toString()));
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return liste;

    }
    
}
