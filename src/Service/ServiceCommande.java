/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Commande;
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
 * @author USER
 */
public class ServiceCommande implements IntService<Commande> {
private int idf;
    @Override
    public void Create(Commande obj) {

         ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/pidev3.0/web/app_dev.php/newc"+"/"+obj.getEtat()+"/"+obj.getId_client()+"/"+obj.getPrix_tot();
        System.out.println(Url);
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
          
        });
        NetworkManager.getInstance().addToQueueAndWait(con);

    }

    @Override
    public void Delete(Commande obj) {
     //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Update(Commande obj) {
      //To change body of generated methods, choose Tools | Templates.
    }

 @Override
    public ArrayList<Commande> getAll() {
       
        ArrayList<Commande> listTasks = new ArrayList<>();
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
                        Commande prod = new Commande();
                        
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
    public Commande get(Commande obj) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pidev3.0/web/app_dev.php/fincom/"+obj.getId_client());
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(tasks);
                    Map<String, Object> obje;
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    for (Map<String, Object> obj : list) {}
                    obje = (Map<String, Object>) tasks;
                    
                        Commande prod = new Commande();
                        
                       
                        System.out.println(obje);
                        float etat = Float.parseFloat(obje.get("etat").toString());
                        prod.setEtat((int) etat);
                        float Id_client = Float.parseFloat(obje.get("id_client").toString());
                        prod.setId_client((int) Id_client);
                        float Prix_tot = Float.parseFloat(obje.get("prix_tot").toString());
                        prod.setPrix_tot(Prix_tot);
                        float id=Float.parseFloat(obje.get("id").toString());
                        prod.setId((int) id);
                        
                        obj.setId_client(prod.getId_client());
                        obj.setPrix_tot(prod.getPrix_tot());
                        obj.setEtat(prod.getEtat());
                        obj.setId(prod.getId());
                       
                       
                        
                        
                    
                    
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        
        return obj;
        //To change body of generated methods, choose Tools | Templates.
    }

    public int getlid(int idc) {
       
    ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pidev3.0/web/app_dev.php/fincoml/"+idc);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();
                int prod = 0;
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(tasks);
                    Map<String, Object> obje;
                    obje = (Map<String, Object>) tasks;
                    
                        
                        
                      
                        float id = Float.parseFloat(obje.get("id").toString());
                        prod = (int) id;
                        
                       
                       
                        
                        
                    
                    
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                    
                }
                idf=prod;

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        
        
        return idf;
    }
    public ArrayList<Commande> getc(Commande obj) {
        
        ArrayList<Commande> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pidev3.0/web/app_dev.php/fincom/"+obj.getId_client());
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(tasks);
                    Map<String, Object> obje;
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    for (Map<String, Object> objec : list) {
                    Commande prod = new Commande();
                        System.out.println(objec);
                    float etat = Float.parseFloat(objec.get("etat").toString());
                        prod.setEtat((int) etat);
                        
                        float Prix_tot = Float.parseFloat(objec.get("prixTot").toString());
                        prod.setPrix_tot(Prix_tot);
                        float id=Float.parseFloat(objec.get("id").toString());
                        prod.setId((int) id);
                        
                        listTasks.add(prod);
                    }
                    
                       
                       
                        
                        
                    
                    
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        
        return listTasks;
        //To change body of generated methods, choose Tools | Templates.
    }
  
}
