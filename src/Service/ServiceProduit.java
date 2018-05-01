/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Lignecommande;
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

    Produit ligne = new Produit();
    @Override
    public void Create(Produit obj) {

         ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/pidev3.0/web/app_dev.php/new"+"/"+obj.getCaracteristiques()+"/"+obj.getDescription()+"/"+obj.getEtat()+"/"+obj.getNom_image()+"/"+obj.getId_categorie()+"/"+obj.getId_propietaire()+"/"+obj.getLabel()+"/"+obj.getPoid()+"/"+obj.getPrix_ancien()+"/"+obj.getVote()+"/"+obj.getPrix_nouv()+"/"+obj.getQuantite();
        System.out.println(Url);
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
          
        });
        NetworkManager.getInstance().addToQueueAndWait(con);

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
       
        ArrayList<Produit> listTasks = new ArrayList<>();
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
                        Produit prod = new Produit();
                        
                        float poi = Float.parseFloat(obj.get("poid").toString());
                        float id = Float.parseFloat(obj.get("id").toString());
                       
                        prod.setCaracteristiques(obj.get("caracteristiques").toString());
                        prod.setDescription(obj.get("description").toString());
                        prod.setId_categorie(obj.get("idCategorie").toString());
                        prod.setPoid(poi);
                        prod.setId((int) id);
                        
                        
                       
                        prod.setLabel(obj.get("label").toString());
                       prod.setNom_image(obj.get("nomImage").toString());
                        double prixn = Double.parseDouble(obj.get("prixNouv").toString());
                        prod.setPrix_nouv(prixn);
                        
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
    public Produit get(Produit obj) {
        return null;
        //To change body of generated methods, choose Tools | Templates.
    }
    public Produit get(Lignecommande obj) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pidev3.0/web/app_dev.php/finpro/"+obj.getId_produit());
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(tasks);
                    Map<String, Object> obje;
                    obje = (Map<String, Object>) tasks;
                    System.out.println(obje);
                        Produit prod = new Produit();
                        float poi = Float.parseFloat(obje.get("poid").toString());
                        float id = Float.parseFloat(obje.get("id").toString());
                       
                        prod.setCaracteristiques(obje.get("caracteristiques").toString());
                        prod.setDescription(obje.get("description").toString());
                        prod.setId_categorie(obje.get("idCategorie").toString());
                        prod.setPoid(poi);
                        prod.setId((int) id);
                        prod.setLabel(obje.get("label").toString());
                        prod.setNom_image(obje.get("nomImage").toString());
                        double prixn = Double.parseDouble(obje.get("prixNouv").toString());
                        prod.setPrix_nouv(prixn);
                        
                       ligne=prod;
                        
                        
                        
                       
                        
                       
                       
                        
                        
                    
                    
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        
        return ligne;
        //To change body of generated methods, choose Tools | Templates.
    }

  
}
