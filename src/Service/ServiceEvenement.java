/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Evenement;
import Service.IntService;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author iheb bf
 */
public class ServiceEvenement implements IntService<Evenement>{

    @Override
    public void Create(Evenement obj) {
        
         ConnectionRequest con = new ConnectionRequest();
      String Url = "http://localhost/pidev4.0/web/app_dev.php/ajoutE/"
                +obj.getNom()+"/"
                +obj.getDescription()+"/"
                +obj.getNbr_participants()+"/"
                 +obj.getStringdateD();
        
        con.setUrl(Url);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });        
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    @Override
    public void Delete(Evenement obj) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Update(Evenement obj) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Evenement> getAll() {
        
          ArrayList<Evenement> listEvent = new ArrayList<>();
           ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pidev4.0/web/app_dev.php/all");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                JSONParser jsonp = new JSONParser();
                         
                try {
                    Map<String, Object> event1 = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(event1);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) event1.get("root");
                    for (Map<String, Object> obj : list) {
                        Evenement event = new Evenement();
                            
                      
                       event.setNom(obj.get("nom").toString());
                         event.setNom_image(obj.get("nomImage").toString());
                      event.setDescription(obj.get("description").toString());
                       float nbr = Float.parseFloat(obj.get("nbrParticipants").toString());
                        
                        event.setNbr_participants((int) nbr);
                        
                        
                  String date1 = obj.get("dateDebut").toString();

                        DateFormat format = new SimpleDateFormat("yyyy-MM-dd H:m");
                         Date date = null;
                     try {
                            date = format.parse(date1);
                        }catch (ParseException ex) {
                            System.out.println(ex.getMessage());
                        }
                  
                        event.setDate_debut(date);      
             
                          listEvent.add(event);
                      
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }   

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
         System.out.println("just before sending : " + listEvent);
        return listEvent;
    }

    @Override
    public Evenement get(Evenement obj) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      return obj;
    }
    
}
