/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Zanimaux.ZanimauxApp;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Yessine
 */
public class ApprouverRdv {

    public ApprouverRdv(Form f) {
        Zanimaux.ZanimauxApp a = new ZanimauxApp();
        a.init(new Object());
        
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/pidev3.0/web/app_dev.php/approuvezadmin";
        Form hi = new Form("Medecins", new BoxLayout(BoxLayout.Y_AXIS));
            hi.getToolbar().addCommandToLeftBar("back", a.getTheme().getImage("back-command.png"), l -> {
            f.showBack();
        });
        con.setUrl(Url);
        con.addArgument("id", String.valueOf(2));
        con.addResponseListener((e) -> {
            try {
                String str = new String(con.getResponseData());
                JSONParser jsonp = new JSONParser();
                Map< String, Object> medecinss;
                medecinss = (Map<String, Object>) jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                List<Map<String, Object>> rdvs = (List<Map<String, Object>>) medecinss.get("rdv");
                for (Map<String, Object> obj : rdvs) {
                    Container c = new Container(new BoxLayout(BoxLayout.X_AXIS));
                    System.out.println(obj.get("nomclient").toString());
                    Label l = new Label(obj.get("nomclient").toString() + " " + obj.get("prix").toString() + "dt");
                    Button prendrerdv = new Button("approuver");
                    prendrerdv.addActionListener((eee) -> {
   String Url1 = "http://localhost/pidev3.0/web/app_dev.php/approuvezMobileeee";
     ConnectionRequest conn = new ConnectionRequest();
        conn.setUrl(Url1);
                        System.out.println("szz");
        conn.addArgument("id", obj.get("id").toString());
          NetworkManager.getInstance().addToQueue(conn);
        conn.addResponseListener((eeee) -> {
            f.showBack();
            Dialog.show("acceptée", "", "ok", null);
        }); 
                    });
                    c.add(l);
                    c.add(prendrerdv);
                    hi.add(c);
                }
                hi.show();
            } catch (IOException ex) {
                System.out.println("aa");
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(con);

    }

}
