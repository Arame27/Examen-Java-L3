/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entities.Rdv;
import entities.User;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.Service;

/**
 * FXML Controller class
 *
 * @author armem
 */
public class PatientController implements Initializable {

    private  final Controller ctrl=new Controller();
    private final User user=ConnectionController.getCtrl().getUser();
    private final Service service= new Service();
    private final List<Rdv> rdvs=service.rdvByPatient(user.getId());
    private final ObservableList obList= FXCollections.observableArrayList(rdvs);
    @FXML
    private TableView<Rdv> tblview;
    @FXML
    private TableColumn<Rdv, String> tblType;
    @FXML
    private TableColumn<Rdv, String> tblDate;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadTableView();
    }    

    @FXML
    private void handleRDV(ActionEvent event) {
        ctrl.chemin("V_DemandeRdv");
    }
    
    //permet de charger la table avec la list des rdv
    private void loadTableView(){
        tblview.setItems(obList);
        tblType.setCellValueFactory(new PropertyValueFactory<>("type"));
        tblDate.setCellValueFactory(new PropertyValueFactory<>("date"));
    }
    
}
