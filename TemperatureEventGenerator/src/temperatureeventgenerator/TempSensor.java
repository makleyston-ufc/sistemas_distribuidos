/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temperatureeventgenerator;

/**
 *
 * @author makleyston
 */
public class TempSensor {
    private int id;
    private double temperature;
    private String dateTime;

    public TempSensor(int id, double temperature, String dateTime) {
        this.id = id;
        this.temperature = temperature;
        this.dateTime = dateTime;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
    
    
}
