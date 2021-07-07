/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alarms;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author makleyston
 */
public class FXMLAlarmController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label lbAlarm;
    @FXML
    private TableView<Message> tableView;
    @FXML
    private TableColumn<Message, String> colTopic;
    @FXML
    private TableColumn<Message, String> colMessage;
    
    private ObservableList observableList;
//    private ObservableValue observableLabel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
               
        observableList = FXCollections.observableList(new ArrayList<>());
        tableView.setItems(observableList);
        lbAlarm.setText("Atenção");
//        lbAlarm.textProperty().bind(observableLabel);
        
        
        colTopic.setCellValueFactory(new PropertyValueFactory("topic"));
        colMessage.setCellValueFactory(new PropertyValueFactory("message"));
        
        AlarmSubscriber alarmSubscriber = new AlarmSubscriber(new CallBackMessage() {
            @Override
            public void listener(Message m) {
                Platform.runLater(new Runnable() {
				@Override
				public void run() {
					lbAlarm.setText(m.getMessage());
				}
			});
                loadTable(m);
            }
        });
        alarmSubscriber.start();
        alarmSubscriber.subscribe(0, "alarm/");

    }   
    
    public void loadTable(Message m){
        tableView.getItems().add(m);
    }
    
}
