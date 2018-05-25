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
       String Url = "http://localhost/pidev3.0/web/app_dev.php/newus"+"/"+obj.getUsername()+"/"+obj.getEmail()+"/"+obj.getPassword()+"/"+obj.getRoles()+"/"+obj.getNom()+"/"+obj.getPrenom()+"/"+obj.getNum_tel();
        System.out.println(Url);
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
          
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        String Url2 = "http://localhost/pidev3.0/web/app_dev.php/ChangePassword"+"/"+obj.getUsername()+"/"+obj.getPassword();
        System.out.println(Url2);
        con.setUrl(Url2);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
          
        });
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
        con.setUrl("http://localhost/pidev3.0/web/app_dev.php/loginc/"+obj.getUsername()+"/"+obj.getPassword());
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    for (Map<String, Object> obje : list) {
                    
                    
                        User prod = new User();
                        
                       List<String> poi = (List<String>) obje.get("roles");
                        System.out.println("obje"+obje);
                        float id = Float.parseFloat(obje.get("id").toString());
                        prod.setEmail(obje.get("email").toString());
                        prod.setPassword(obje.get("password").toString());
                        prod.setRoles(obje.get("roles").toString());
                        prod.setId((int) id);
                    
                        obj.setEmail(prod.getEmail());
                        obj.setPassword(prod.getPassword());
                        obj.setRoles(poi.get(0));
                        obj.setId(prod.getId());}
                       
                       
                        
                        
                    
                    
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
