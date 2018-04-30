/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Commande;
import Entite.Lignecommande;
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
public class ServiceLignecommande implements IntService<Lignecommande> {

    @Override
    public void Create(Lignecommande obj) {

         ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/pidev3.0/web/app_dev.php/newlc"+"/"+obj.getId_commande()+"/"+obj.getId_client()+"/"+obj.getId_produit()+"/"+obj.getQte();
        System.out.println(Url);
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
          
        });
        NetworkManager.getInstance().addToQueueAndWait(con);

    }

    @Override
    public void Delete(Lignecommande obj) {
     //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Update(Lignecommande obj) {
      //To change body of generated methods, choose Tools | Templates.
    }

 @Override
    public ArrayList<Lignecommande> getAll() {
       
        ArrayList<Lignecommande> listTasks = new ArrayList<>();
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
                        Lignecommande prod = new Lignecommande();
                        
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
    public Lignecommande get(Lignecommande obj) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pidev3.0/web/app_dev.php/finlincom/"+obj.getId_commande());
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(tasks);
                    Map<String, Object> obje;
                    obje = (Map<String, Object>) tasks;
                    
                        Lignecommande prod = new Lignecommande();
                        
                       List<String> poi = (List<String>) obje.get("roles");
                        System.out.println(obje);
                        float id_commande = Float.parseFloat(obje.get("id_commande").toString());
                        prod.setId_commande((int) id_commande);
                        float Id_client = Float.parseFloat(obje.get("id_client").toString());
                        prod.setId_client((int) Id_client);
                        float id_produit = Float.parseFloat(obje.get("id_produit").toString());
                        prod.setId_produit((int) id_produit);
                        float qte = Float.parseFloat(obje.get("qte").toString());
                        prod.setQte((int) qte);
                        
                        obj.setId_client(prod.getId_client());
                        obj.setId_commande(prod.getId_commande());
                        obj.setId_produit(prod.getId_produit());
                        obj.setQte(prod.getQte());
                        
                       
                       
                        
                        
                    
                    
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