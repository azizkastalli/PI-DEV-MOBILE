/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.User;
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
public class ServiceUser implements IntService<User> {

    @Override
    public void Create(User obj) {

         ConnectionRequest con = new ConnectionRequest();
       /*String Url = "http://localhost/pidev3.0/web/app_dev.php/new"+"/"+obj.getCaracteristiques()+"/"+obj.getDescription()+"/"+obj.getEtat()+"/"+obj.getNom_image()+"/"+obj.getId_categorie()+"/"+obj.getId_propietaire()+"/"+obj.getLabel()+"/"+obj.getPoid()+"/"+obj.getPrix_ancien()+"/"+obj.getVote()+"/"+obj.getPrix_nouv()+"/"+obj.getQuantite();
        System.out.println(Url);
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
          
        });*/
        NetworkManager.getInstance().addToQueueAndWait(con);

    }

    @Override
    public void Delete(User obj) {
     //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Update(User obj) {
      //To change body of generated methods, choose Tools | Templates.
    }

 @Override
    public ArrayList<User> getAll() {
       
        ArrayList<User> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pidev3.0/web/app_dev.php/all");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    for (Map<String, Object> obj : list) {
                        User prod = new User();
                        
                        float poi = Float.parseFloat(obj.get("poid").toString());
                       
                        
                        
                        
                       
                       
                        
                        listTasks.add(prod);

                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }

    @Override
    public User get(User obj) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pidev3.0/web/app_dev.php/finus/"+obj.getUsername());
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(tasks);
                    Map<String, Object> obje;
                    obje = (Map<String, Object>) tasks;
                    
                        User prod = new User();
                        
                       List<String> poi = (List<String>) obje.get("roles");
                        System.out.println(obje);
                        prod.setEmail(obje.get("email").toString());
                        prod.setPassword(obje.get("password").toString());
                        prod.setRoles(obje.get("roles").toString());
                        
                        obj.setEmail(prod.getEmail());
                        obj.setPassword(prod.getPassword());
                        obj.setRoles(poi.get(0));
                       
                       
                        
                        
                    
                    
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        
        return obj;
        //To change body of generated methods, choose Tools | Templates.
    }

  
}
