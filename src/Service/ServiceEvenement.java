/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Categorie;
import Entite.Evenement;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
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
      String Url = "http://localhost/pidev3.0/web/app_dev.php/ajoutE/"
                +obj.getNom()+"/"
                +obj.getDescription()+"/"
                +obj.getNbr_participants()+"/"
                 +obj.getStringdateD()+"/"
                +obj.getStringdateF()+"/"
              +obj.getNom_image()+"/"
              +obj.getId_categorie();
        
        con.setUrl(Url);
        System.out.println(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });        
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    @Override
    public void Delete(Evenement obj) {
        ConnectionRequest con = new ConnectionRequest();
        System.out.println("delete id : "+obj.getId());
        String Url = "http://localhost/pidev3.0/web/app_dev.php/SuppEvent/"+obj.getId();
        con.setUrl(Url);
        

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    @Override
    public void Update(Evenement obj) {
        
        ConnectionRequest con = new ConnectionRequest();
       
        String Url = "http://localhost/pidev3.0/web/app_dev.php/modifEvent/"+obj.getNom()
                +"/"+obj.getDescription()
                +"/"+obj.getNbr_participants()
                +"/"+obj.getNom_image()+"/"
                +obj.getId();
        
        con.setUrl(Url);
        

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    @Override
    public ArrayList<Evenement> getAll() {
        
          ArrayList<Evenement> listEvent = new ArrayList<>();
           ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pidev3.0/web/app_dev.php/all4");
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
                              float id = Float.parseFloat(obj.get("id").toString());
                              
                              event.setId((int) id);
                      
                       event.setNom(obj.get("nom").toString());
                         event.setNom_image(obj.get("nomImage").toString());
                      event.setDescription(obj.get("description").toString());
                       float nbr = Float.parseFloat(obj.get("nbrParticipants").toString());
                                                 
                        event.setNbr_participants((int) nbr);

                     Map<String,Object> datemap = (Map<String,Object>) obj.get("dateDebut"); 
                     Date date = new Date( (long) Double.parseDouble(datemap.get("timestamp").toString())*1000);
                                                                 
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
    
    public ArrayList<Categorie> getAllCat(){
    ArrayList<Categorie> listCat = new ArrayList<>();
      ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pidev3.0/web/app_dev.php/allcat");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                JSONParser jsonp = new JSONParser();
                         
                try {
                    Map<String, Object> event1 = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(event1);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) event1.get("root");
                    for (Map<String, Object> obj : list) {
                        float nbr = Float.parseFloat(obj.get("id").toString());
                        
                        Categorie cat = new Categorie((int) nbr, obj.get("nom").toString(), obj.get("type").toString());
                            
                      
                     
                       
                    

                    
             
                          listCat.add(cat);
                      
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }   

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    
    
    return listCat;
    }
    
    
}
