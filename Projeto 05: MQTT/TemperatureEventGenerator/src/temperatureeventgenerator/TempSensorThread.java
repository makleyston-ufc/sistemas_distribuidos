/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temperatureeventgenerator;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author makleyston
 */
public class TempSensorThread extends Thread {

    private final int ID;
    private int timeLapse;
    private int precisionData;
    private double lastTemp;
    private boolean flag = false;
    private Random random = new Random();
    private MqttPublish mqttPublish;
    
    public TempSensorThread(int timepLapse, int precisionData) {
        this.timeLapse = timepLapse;
        this.precisionData = precisionData;
        this.ID = random.nextInt(Integer.MAX_VALUE);
        this.mqttPublish = new MqttPublish(this.ID+"");
    }
    
    @Override
    public void run() {
        while(true){
            if(!flag){
                flag = true;
                lastTemp = (40 + (50 - 40) * random.nextDouble()); //40~50
            }else{
                lastTemp = getTemp(precisionData, lastTemp);
            }
            
            mqttPublish.publish(round(lastTemp, 1)+"", ID+"");
            
            try {
                
                Thread.sleep(timeLapse * 1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TempSensorThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private double getTemp(int precisionData, double lastTemp) {
        double margin = 4.9;
        if (random.nextInt(100) <= precisionData) {
            return ((lastTemp - margin) + ((lastTemp + margin) - (lastTemp - margin)) * random.nextDouble());
        } else {
            double res;
            do{
                res = ((lastTemp - (margin * 5)) + ((lastTemp + (margin * 5)) - (lastTemp - (margin * 5))) * random.nextDouble());
            }
            while((res <= (lastTemp + margin)) && (res >= (lastTemp - margin)));
            return res;
        }
    }
    
    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
}

}
