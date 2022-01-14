/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author armem
 */
public class RpController implements Initializable {

    @FXML
    private TableColumn<?, ?> name;
    @FXML
    private TableColumn<?, ?> type;
    @FXML
    private TableColumn<?, ?> date;
    @FXML
    private TableColumn<?, ?> action;
    @FXML
    private TableView<?> tblView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleDeconnexion(MouseEvent event) {
    }

    @FXML
    private void filtrerParDate(ActionEvent event) {
    }
    
}
