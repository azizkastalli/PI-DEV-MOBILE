/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.AnimalPerdu;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class ServiceAnimalperdu implements IntService<AnimalPerdu>{

    @Override
    public void Create(AnimalPerdu obj) {
 ConnectionRequest con = new ConnectionRequest();
      String Url = "http://localhost/pidev8.0/web/app_dev.php/CreateEncheres/"
                +obj.getId_animal()+"/"
                +obj.getDate_disparition()+"/"
                +obj.getLieu_disparition()
                +"/1";
        
        con.setUrl(Url);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });        
        NetworkManager.getInstance().addToQueueAndWait(con);    }

    @Override
    public void Delete(AnimalPerdu obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Update(AnimalPerdu obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<AnimalPerdu> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AnimalPerdu get(AnimalPerdu obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
