/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Favoris;
import Entite.Produit;
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
 * @author HP
 */
public class ServiceFavoris implements IntService<Favoris>{
    boolean s;
    int gg;
    @Override
    public void Create(Favoris obj) {
        
         ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/pidev3.0/web/app_dev.php/newfav"+"/"+obj.getId_produit()+"/"+obj.getId_client();
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
          
        });
        NetworkManager.getInstance().addToQueueAndWait(con);    
    }

    @Override
    public void Delete(Favoris obj) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/pidev3.0/web/app_dev.php/deletefavv"+"/"+obj.getId();
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
          
        });
        NetworkManager.getInstance().addToQueueAndWait(con);  
    }

    @Override
    public void Update(Favoris obj) {
    }

    @Override
    public ArrayList<Favoris> getAll() {
         ArrayList<Favoris> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pidev3.0/web/app_dev.php/allfav");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    for (Map<String, Object> obj : list) {
                        Favoris prod = new Favoris();
                        
                        float poi = Float.parseFloat(obj.get("idClient").toString());
                        float poin = Float.parseFloat(obj.get("id").toString());

                        prod.setId_produit(obj.get("idProduit").toString());
                        prod.setId_client((int) poi);
                        prod.setId((int) poin);
                        
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
    public Favoris get(Favoris obj) {
        return null;
    }
 
    
     public boolean getAllvot(int prod,String prod1) {
            
        ConnectionRequest con = new ConnectionRequest();
    con.setUrl("http://localhost/pidev3.0/web/app_dev.php/findfavclient"+"/"+prod+"/"+prod1);       
    con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    JSONParser jsonp = new JSONParser();
                    
                    
                    Map<String, Object> tasks;
                    
                    tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    for (Map<String, Object> obj : list) {
                      
                         float id = Float.parseFloat(obj.get("idClient").toString());
                        
                       
                        String l =  obj.get("idProduit").toString();
                        
                        if( id==prod && l.equals(prod1) )
                            
                            
                        {
                            s=true ;
                        }
                    
                    }
                } catch (IOException ex) {
                    
                }
                    }
               

            
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return s;

    }
      public void Deletefav(String id) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/pidev3.0/web/app_dev.php/deletefavv"+"/"+id;
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
          
        });
        NetworkManager.getInstance().addToQueueAndWait(con);  
    }
      
       
}
