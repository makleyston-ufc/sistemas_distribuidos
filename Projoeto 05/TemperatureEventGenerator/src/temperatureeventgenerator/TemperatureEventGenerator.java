/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temperatureeventgenerator;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author makleyston
 */
public class TemperatureEventGenerator {

    /**
     * @param args the command line arguments
     */
    private Random random = new Random();

    public static void main(String[] args) {

        String brokerIP = "localhost"; //(args[0] == null ? "localhost" : args[0]);
        String amountSensorsParam = "5"; //(args[1] == null ? "10" : args[1]);
        String timeLapseParam = "10"; //(args[2] == null ? "60" : args[2]);
        String precisionDataParam = "50"; //(args[3] == null ? "90" : args[3]);

        int timeLapse = Integer.parseInt(timeLapseParam);
        int amountSensors = Integer.parseInt(amountSensorsParam);
        int precisionData = Integer.parseInt(precisionDataParam);
        
        ArrayList<TempSensorThread> threads = new ArrayList<>();

        for (int i = 0; i < amountSensors; i++) {
            TempSensorThread tempSensor = new TempSensorThread(timeLapse, precisionData);
            tempSensor.start();
            threads.add(tempSensor);
        }
    }

}
