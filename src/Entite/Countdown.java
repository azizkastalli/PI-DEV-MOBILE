/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import java.util.Date;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;

/**
 *
 * @author azizkastalli
 */
public class Countdown {
    
      
       private Container cdownLabel;
       private Container cdownTimer; 
       private Container countDown;
       private Label days;
       private Label Tdays;
       private Label hours;
       private Label Thours;
       private Label minutes;
       private Label Tminutes;
       private Label secondes;
       private Label Tsecondes;
       private Timer timer;  
       private boolean verif;

       public Countdown()
       {//init
        
         this.cdownLabel = new Container(new BoxLayout(BoxLayout.X_AXIS));
         this.cdownTimer = new Container(new BoxLayout(BoxLayout.X_AXIS));
         this.countDown = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         this.timer = new Timer();  
         this.verif=true;
         
         this.days =new Label("Days");
         this.hours =new Label("Hours");
         this.minutes =new Label("Minutes");
         this.secondes =new Label("Seconds");
         this.Tdays =new Label("00");
         this.Thours =new Label("00");
         this.Tminutes =new Label("00");
         this.Tsecondes =new Label("00");
         
         this.cdownLabel.addAll(days,hours,minutes,secondes);
         this.cdownTimer.addAll(Tdays,Thours,Tminutes,Tsecondes);
         this.countDown.addAll(cdownLabel,cdownTimer);
       }
       
 
      private Map<String,Integer> OperationIndex(Date time)
      {
          Map<String,Integer> index =new TreeMap<>();
         
         //current date
         Date date = new Date();
         
                        long diff = time.getTime() - date.getTime();
                        if(diff<0)
                            this.verif=false;
			int diffSeconds = (int) (diff / 1000 % 60);
			int diffMinutes = (int) (diff / (60 * 1000) % 60);
			int diffHours = (int) (diff / (60 * 60 * 1000) % 24);
			int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
      
        index.put("hours",diffHours);                
        index.put("minutes",diffMinutes);                
        index.put("seconds",diffSeconds);                
        index.put("days",diffDays);
        
        return index;
      }
      
      public Container SetCountDown(Date time)
      {
         Map<String,Integer> index = OperationIndex(time);
         if(verif)
         {
          this.Tdays.setText(Integer.toString(index.get("days")));
          this.Thours.setText(Integer.toString(index.get("hours")));
          this.Tminutes.setText(Integer.toString(index.get("minutes")));
          this.Tsecondes.setText(Integer.toString(index.get("seconds")));
         }
         else
         {
          this.Tdays.setText("00");
          this.Thours.setText("00");
          this.Tminutes.setText("00");
          this.Tsecondes.setText("00");
         }
         
          //decrement CountDown each second
          if(verif)
         {   this.timer.schedule(new TimerTask() {
            @Override
            public void run() {
                 UpdateTimer();                   
            }
        }, 1000 , 1000 );     
       }
          return this.countDown;
      }
      
      private void UpdateTimer()
      {
       //decrement second
        int s,d,m,h; 
        s=Integer.parseInt(this.Tsecondes.getText());
        m=Integer.parseInt(this.Tminutes.getText());
        h=Integer.parseInt(this.Thours.getText());
        d=Integer.parseInt(this.Tdays.getText());
       
        if(s==0 && m==0 && h==0 && d==0)
        { //stop the countDown
            this.timer.cancel();
        }
        else
        {  
           if(s==0)
         {
           s=59;
           if(m==0)
            { m=59;
              if(h==0)
               {
                 h=23;
                 if(d!=0)
                     d--;
               }
              else h--;
                 }
             else m--;
         }
           
        else 
           s--;
            
        }
        
        if(s<0)  
        this.Tsecondes.setText("0"+Integer.toString(s));
        else
        this.Tsecondes.setText(Integer.toString(s));
        
        if(d<10)
        this.Tdays.setText("0"+Integer.toString(d));
        else
        this.Tdays.setText(Integer.toString(d));
        
        if(h<10)
            this.Thours.setText("0"+Integer.toString(h));
        else
            this.Thours.setText(Integer.toString(h));
        
        if(m<10)
        this.Tminutes.setText("0"+Integer.toString(m));
        else
        this.Tminutes.setText(Integer.toString(m));
        
       
      }

}
