/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Encheres;
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
public class ServiceEncheres implements IntService<Encheres> {

    @Override
    public void Create(Encheres obj) {
   /*   ConnectionRequest con = new ConnectionRequest();
     //   String Url = "http://127.0.0.1:3306/tasks/" + ta.getNom() + "/" + ta.getEtat();
       // con.setUrl(Url);

        //System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    @Override
    public void Update(Encheres obj) {
      ConnectionRequest con = new ConnectionRequest();
     //   String Url = "http://127.0.0.1:3306/tasks/" + ta.getNom() + "/" + ta.getEtat();
       // con.setUrl(Url);

        //System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    */}

    @Override
    public ArrayList<Encheres> getAll() {
        return null;
   /*           ArrayList<Encheres> listEncheres = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://41.226.11.243:10004/tasks/");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    for (Map<String, Object> obj : list) {
                        Encheres task = new Encheres();
                        float id = Float.parseFloat(obj.get("id").toString());
                        
                        //task.setId((int) id);
                        //task.setEtat(obj.get("state").toString());
                        //task.setNom(obj.get("name").toString());
                      //  listTasks.add(task);

                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEncheres;
    */
    }

    @Override
    public Encheres get(Encheres obj) {
        return null;
    //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Delete(Encheres obj) {
      //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Update(Encheres obj) {
      //To change body of generated methods, choose Tools | Templates.
    }
    
}
