/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entite.AnimalPerdu;
import Service.ServiceAnimalperdu;
import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.io.Log;
import static com.codename1.ui.CN.addNetworkErrorListener;
import static com.codename1.ui.CN.getCurrentForm;
import static com.codename1.ui.CN.updateNetworkThreadCount;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class StatAnimalPerdu {
    
    
    
    
        private Form current;
        private Resources theme;
        Form f = new Form("Stats", BoxLayout.y());
     
     
     
        public void init(Object context) {
        // use two network threads instead of one
        updateNetworkThreadCount(2);

        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature
        Log.bindCrashProtection(true);

        addNetworkErrorListener(err -> {
            // prevent the event from propagating
            err.consume();
            if (err.getError() != null) {
                Log.e(err.getError());
            }
            Log.sendLogAsync();
            Dialog.show("Connection Error", "There was a networking error in the connection to " + err.getConnectionRequest().getUrl(), "OK", null);
        });
    }

    private DefaultRenderer buildCategoryRenderer(int[] colors) {
        DefaultRenderer renderer = new DefaultRenderer();
        renderer.setLabelsTextSize(15);
        renderer.setLegendTextSize(20);
        renderer.setMargins(new int[]{20, 30, 15, 0});
        for (int color : colors) {
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(color);
            renderer.addSeriesRenderer(r);
        }
        return renderer;
    }

    protected CategorySeries buildCategoryDataset(String title, double[] values) {
        CategorySeries series = new CategorySeries(title);
        ServiceAnimalperdu A = new ServiceAnimalperdu();
         ArrayList <AnimalPerdu> listAn = A.getEtat();
         int trouve = 0;
         int perdu = 0;
          for (AnimalPerdu a : listAn)
          {
                if (a.isEtat()==true)
                {
                    trouve++;
                }
                else perdu++;
               
          }
          series.add("Perdu" ,  perdu);
          series.add("Trouve" ,  trouve);
        int k = 0;
        /*for (double value : values) {
            
            series.add("Project " + ++k, value);
            
        }*/

        return series;
    }

    public StatAnimalPerdu() {
        if (current != null) {
            current.show();
            return;
        }
          f.add(new Label("Stats Animal Perdu/Trouve"));
          
                  ServiceAnimalperdu A = new ServiceAnimalperdu();

          ArrayList <AnimalPerdu> listAn = A.getEtat();
         int trouve = 0;
         int perdu = 0;
          for (AnimalPerdu a : listAn)
          {
                if (a.isEtat()==true)
                {
                    trouve++;
                }
                else perdu++;
               
          }
       
        double[] values = new double[]{trouve, perdu};

        // Set up the renderer
        int[] colors = new int[]{ColorUtil.BLUE, ColorUtil.GREEN};
        DefaultRenderer renderer = buildCategoryRenderer(colors);
        renderer.setZoomButtonsVisible(true);
        renderer.setZoomEnabled(true);
        renderer.setChartTitleTextSize(20);
        renderer.setDisplayValues(true);
        renderer.setShowLabels(true);
        SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
        r.setGradientEnabled(true);
        r.setGradientStart(0, ColorUtil.BLUE);
        r.setGradientStop(0, ColorUtil.GREEN);
        r.setHighlighted(true);

        // Create the chart ... pass the values and renderer to the chart object.
        PieChart chart = new PieChart(buildCategoryDataset("Project budget", values), renderer);

        // Wrap the chart in a Component so we can add it to a form
        ChartComponent c = new ChartComponent(chart);

        
        f.getToolbar().addCommandToRightBar("back", null, (ev)->{EspaceService ES=new EspaceService();
          ES.getF().show();
          });
        f.add(c);

   
        //f.show();
        
    }

    public void stop() {
        current = getCurrentForm();
        if (current instanceof Dialog) {
            ((Dialog) current).dispose();
            current = getCurrentForm();
        }
    }
      public void destroy() {
    }
      
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
   
}