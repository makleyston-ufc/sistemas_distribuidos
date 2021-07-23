/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author makleyston
 */
public class CAT {

    /**
     * @param args the command line arguments
     */
    
    private static final String HIGH_TEMPERATURE        = "TEMPERATURA ALTA";
    private static final String TEMPERATURE_INCREASE    = "AUMENTO DE TEMPERATURA REPETINA";
    
    public static void main(String[] args) {
       
       
        
        AVGCalculatorSubscriber avgSubscriber = new AVGCalculatorSubscriber("tcp://localhost:1883");
        avgSubscriber.start();
        avgSubscriber.subscribe(0, "temperature/#");
        
        final double avg[] = new double[1];
        final boolean flag[] = new boolean[1];
        flag[0] = false;
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(20 * 1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(CAT.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    if(!flag[0]){
                        avg[0] = avgSubscriber.calculateAVG();
                        flag[0] = true;
                    }else{
                        double newAVG = avgSubscriber.calculateAVG();
                        if(newAVG+5 >= avg[0]){
                            MqttPublish.getInstance().publish(TEMPERATURE_INCREASE);
                        }
                        if(newAVG > 200){
                            MqttPublish.getInstance().publish(HIGH_TEMPERATURE);
                        }
                        avg[0] = newAVG;
                    }     
                }
            }
        }).start();

    }
    
}
