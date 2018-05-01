/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Animal;
import Entite.AnimalPerdu;
import Entite.AnimalSdf;
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
 * @author user
 */
public class ServiceAnimalperdu implements IntService<AnimalPerdu>{

    @Override
    public void Create(AnimalPerdu obj) {
 ConnectionRequest con = new ConnectionRequest();
      String Url = "http://localhost/pidev8.0/web/app_dev.php/service/create/"
                +obj.getId_animal()+"/"
                +obj.getDateD()+"/"
                +obj.getLieu_disparition()
                ;
        System.out.println(Url);
        con.setUrl(Url);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });        
        NetworkManager.getInstance().addToQueueAndWait(con);    }

    @Override
    public void Delete(AnimalPerdu obj) {
    }

    @Override
    public void Update(AnimalPerdu obj) {
         ConnectionRequest con = new ConnectionRequest();
        System.out.println("id animal : "+obj.getId_animal());
        System.out.println("mise : "+obj.getDate_disparition());
        System.out.println("date : "+obj.getLieu_disparition());
        String Url = "http://localhost/pidev8.0/web/app_dev.php/Update/"+obj.getId_animal()
                +"/"+obj.getDate_disparition()
                +"/"+obj.getLieu_disparition();
        
        con.setUrl(Url);
        

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    @Override
    public ArrayList<AnimalPerdu> getAll() {
        ArrayList<AnimalPerdu> listsdf = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pidev8.0/web/app_dev.php/service/all2");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                JSONParser jsonp = new JSONParser();
                         
                try {
                    Map<String, Object> Asdf = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(Asdf);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) Asdf.get("root");
                    for (Map<String, Object> obj : list) {
                                  
                        AnimalPerdu sdf = new AnimalPerdu();
                                
                    sdf.setLieu_dispairition(obj.get("lieuDisparition").toString());
                    
                       Boolean etat = Boolean.valueOf(obj.get("etat").toString());
                    sdf.setEtat(etat); 
                                  
                           
                    Map<String,Object> datemap = (Map<String,Object>) obj.get("dateDisparition"); 
                     Date date = new Date( (long) Double.parseDouble(datemap.get("timestamp").toString())*1000);
                  
                       sdf.setDate_disparition(date);      
             
                          listsdf.add(sdf);
                      
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                } 
                
                

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
         System.out.println("just before sending : " + listsdf);
        return listsdf;
    }

    @Override
    public AnimalPerdu get(AnimalPerdu obj) {
        return null;
    }
     public ArrayList<Animal> getAllAnimal() {
      ArrayList<Animal> listAn = new ArrayList<>();
       ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pidev8.0/web/app_dev.php/service/allAnimal");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                JSONParser jsonp = new JSONParser();
                         
                try {
                    Map<String, Object> event1 = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(event1);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) event1.get("root");
                    for (Map<String, Object> obj : list) {
                        
                            
                   float nbr= Float.parseFloat(obj.get("id").toString());
                   float age= Float.parseFloat(obj.get("age").toString());
                     Animal a = new Animal((int)age,(int)nbr, obj.get("sexe").toString());
                     listAn.add(a);
                      // a.setId((int) nbr);
                             
            }
        }       catch (IOException ex) {
                }
        
        
    }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
         System.out.println("just before sending : " + listAn);
          return listAn;  
     } 
}
     
