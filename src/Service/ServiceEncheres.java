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
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.Date;
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
      ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/pidev8.0/web/app_dev.php/CreateEncheres";
        con.setUrl(Url);
        con.setPost(true);

        con.addArgument("DateDebut",obj.getDate_debut().toString());
        con.addArgument("IdCible",Integer.toString(obj.getId_cible()));
        con.addArgument("SeuilMise",Double.toString(obj.getSeuil_mise()));
        con.addArgument("IdProprietaire","1");

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
    }

    @Override
    public ArrayList<Encheres> getAll() {

        ArrayList<Encheres> listEncheres = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pidev8.0/web/app_dev.php/allEncheres");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                JSONParser jsonp = new JSONParser();
                         
                try {
                    Map<String, Object> encheres1 = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(encheres1);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) encheres1.get("root");
                    for (Map<String, Object> obj : list) {
                        Encheres encheres = new Encheres();
                                
                        encheres.setNom_image(obj.get("nom_image").toString());
                        encheres.setLabel(obj.get("label").toString());
                        encheres.setSeuil_mise(Double.parseDouble(obj.get("seuil_mise").toString()));
                        String date1 = obj.get("date_debut").toString();

                        DateFormat format = new SimpleDateFormat("yyyy-MM-dd H:m");
                         Date date = null;
                     try {
                            date = format.parse(date1);
                        }catch (ParseException ex) {
                            System.out.println(ex.getMessage());
                        }
                  
                        encheres.setDate_debut(date);
                        listEncheres.add(encheres);
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
         System.out.println("just before sending : " + listEncheres);
        return listEncheres;

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

 
    
}
