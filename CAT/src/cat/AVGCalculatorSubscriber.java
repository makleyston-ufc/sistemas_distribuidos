/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MqttDefaultFilePersistence;

/**
 *
 * @author makleyston
 */
public class AVGCalculatorSubscriber {

    private final String serverURI = "tcp://192.168.100.18:1883";
    private MqttClient client;
    private final MqttConnectOptions mqttOptions;
    private List<Double> tempValues = new ArrayList<Double>();

    public AVGCalculatorSubscriber(String serverURI) {
        mqttOptions = new MqttConnectOptions();
        mqttOptions.setMaxInflight(200);
        mqttOptions.setConnectionTimeout(3);
        mqttOptions.setKeepAliveInterval(10);
        mqttOptions.setAutomaticReconnect(true);
        mqttOptions.setCleanSession(false);
    }

    public void subscribe(int qos, String... topicos) {
        if (client == null || topicos.length == 0) {
            return;
        }
        int tamanho = topicos.length;
        int[] qoss = new int[tamanho];
        
        for (int i = 0; i < tamanho; i++) {
            qoss[i] = qos;
        }
        try {
            client.subscribe(topicos, qoss);
        } catch (MqttException ex) {
            System.out.println(String.format("Erro ao se inscrever nos tópicos %s - %s", Arrays.asList(topicos), ex));
        }
    }

    public void start() {
        try {
            System.out.println("Conectando no broker MQTT em " + serverURI);
            client = new MqttClient(serverURI, String.format("CAT_%d",
                    System.currentTimeMillis()),
                    new MqttDefaultFilePersistence(System.getProperty("java.io.tmpdir")));
            client.setCallback(new MQTTCallBack());
            client.connect(mqttOptions);
        } catch (MqttException ex) {
            System.out.println("Erro ao se conectar ao broker mqtt " + serverURI + " - " + ex);
        }
    }

    public class MQTTCallBack implements MqttCallbackExtended {

        @Override
        public void connectComplete(boolean bln, String string) {

        }

        @Override
        public void connectionLost(Throwable thrwbl) {

        }

        @Override
        public void messageArrived(String topic, MqttMessage mm) throws Exception {
            System.out.println("Mensagem recebida:");
            System.out.println("\tTópico: " + topic);
            System.out.println("\tMensagem: " + new String(mm.getPayload()));
            System.out.println("");
            tempValues.add(Double.parseDouble(new String(mm.getPayload())));
        }

        @Override
        public void deliveryComplete(IMqttDeliveryToken imdt) {

        }

    }
    
    public double calculateAVG(){
        double total = 0, avg = 0;
        int i = 0;
        for(; i < tempValues.size(); i++){
            total += tempValues.get(i);
        }
        
        avg = total / i;
        
        tempValues = new ArrayList<>();
        
        return avg;
    }

}
