/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.AnimalSdf;
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
 * @author user
 */
public class ServiceAnimalsdf implements IntService<AnimalSdf>{


    @Override
    public void Create(AnimalSdf obj) {
ConnectionRequest con = new ConnectionRequest();
      String Url = "http://localhost/pidev3.0/web/app_dev.php/service/AnimalsdF/"
                +obj.getSexe()+"/"
                +obj.getDateD()+"/"
                +obj.getLieu_trouvaille()
                ;
        System.out.println(Url);
        con.setUrl(Url);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });        
        NetworkManager.getInstance().addToQueueAndWait(con);    }

    @Override
    public void Delete(AnimalSdf obj) {
    }

    @Override
    public void Update(AnimalSdf obj) {
    }

    @Override
    public ArrayList<AnimalSdf> getAll() {
        ArrayList<AnimalSdf> listsdf = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pidev3.0/web/app_dev.php/service/all3");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                JSONParser jsonp = new JSONParser();
                         
                try {
                    Map<String, Object> Asdf = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(Asdf);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) Asdf.get("root");
                    for (Map<String, Object> obj : list) {
                        
                        
                                AnimalSdf sdf = new AnimalSdf();
                                
                    sdf.setSexe(obj.get("sexe").toString());
                    
                       
                    sdf.setLieu_trouvaille(obj.get("lieuTrouvaille").toString()); 
                                  
                           
                   Map<String,Object> datemap = (Map<String,Object>) obj.get("dateTrouvaille"); 
                     Date date = new Date( (long) Double.parseDouble(datemap.get("timestamp").toString())*1000);
                  
                        sdf.setDate_trouvaille(date);      
             
                          listsdf.add(sdf);
                      
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                } 
                
                

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
         System.out.println("just before sending : " + listsdf);
        return listsdf;  }

    @Override
    public AnimalSdf get(AnimalSdf obj) {
return null;    }
    
}
