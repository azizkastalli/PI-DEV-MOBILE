/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Livraison;
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
public class ServiceLivraison implements IntService<Livraison> {
private int idf;
    @Override
    public void Create(Livraison obj) {

         ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/pidev3.0/web/app_dev.php/newliv"+"/"+obj.getId_commande()+"/"+obj.getId_client()+"/"+obj.getId_livreur();
        System.out.println(Url);
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
          
        });
        NetworkManager.getInstance().addToQueueAndWait(con);

    }

    @Override
    public void Delete(Livraison obj) {
     //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Update(Livraison obj) {
      ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/pidev3.0/web/app_dev.php/editl"+"/"+obj.getId();
        System.out.println(Url);
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
          
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

 @Override
    public ArrayList<Livraison> getAll() {
       
        ArrayList<Livraison> listTasks = new ArrayList<>();
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
                        Livraison prod = new Livraison();
                        
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
    public Livraison get(Livraison obj) {
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
                    
                        Livraison prod = new Livraison();
                        
                       
                        System.out.println(obje);
                        float etat = Float.parseFloat(obje.get("etat").toString());
                        prod.setEtat((int) etat);
                        float Id_client = Float.parseFloat(obje.get("id_client").toString());
                        prod.setId_client((int) Id_client);
                        float Id_commande = Float.parseFloat(obje.get("id_commande").toString());
                        prod.setId_commande((int) Id_commande);
                        float id=Float.parseFloat(obje.get("id").toString());
                        prod.setId((int) id);
                        float Id_livreur = Float.parseFloat(obje.get("id_livreur").toString());
                        prod.setId_livreur((int) Id_livreur);
                        
                        
                        obj.setId_client(prod.getId_client());
                        obj.setId_commande(prod.getId_commande());
                        obj.setId_livreur(prod.getId_livreur());
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
    public ArrayList<Livraison> getlivs(Livraison obj) {
        
        ArrayList<Livraison> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pidev3.0/web/app_dev.php/finliv/"+obj.getId_livreur());
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
                    Livraison prod = new Livraison();
                        System.out.println(objec);
                    float etat = Float.parseFloat(objec.get("etat").toString());
                        prod.setEtat((int) etat);
                        
                        float id_client = Float.parseFloat(objec.get("idClient").toString());
                        prod.setId_client((int) id_client);
                        float id=Float.parseFloat(objec.get("id").toString());
                        prod.setId((int) id);
                        float id_commande = Float.parseFloat(objec.get("idCommande").toString());
                        prod.setId_commande((int) id_commande);
                        float id_livreur = Float.parseFloat(objec.get("idLivreur").toString());
                        prod.setId_livreur((int) id_livreur);
                        
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

