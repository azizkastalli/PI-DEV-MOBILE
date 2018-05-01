/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

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
 * @author azizkastalli
 */
public class ServiceProduit implements IntService<Produit> {

    @Override
    public void Create(Produit obj) {
      //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Delete(Produit obj) {
     //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Update(Produit obj) {
      //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Produit> getAll() {
        
   ArrayList<Produit> listProduit = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pidev8.0/web/app_dev.php/allProduits");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               // listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> produits = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(produits);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) produits.get("root");
                    
                    for (Map<String, Object> obj : list) {
                        if(!obj.get("etat").toString().equals("encheres"))
                {String id = obj.get("id").toString();
                        double d = Double.parseDouble(id);
                        Double dd= new Double(d);
                        int idconverted = dd.intValue();
                        
                        Produit produit = new Produit();
                        produit.setId(idconverted);
                        produit.setNom_image(obj.get("nomImage").toString());
                        produit.setLabel(obj.get("label").toString());
                        
                        
                        listProduit.add(produit);
                }
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);

        return listProduit;

    }

    @Override
    public Produit get(Produit obj) {
        return null;
        //To change body of generated methods, choose Tools | Templates.
    }

  
}
