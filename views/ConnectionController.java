/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entities.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import service.Service;

/**
 * FXML Controller class
 *
 * @author armem
 */
public class ConnectionController implements Initializable {

    private final Service service = new Service();
    private final Controller controller = new Controller();
    private static ConnectionController ctrl;
    private User user;
    @FXML
    private TextField login;
    @FXML
    private TextField password;
    @FXML
    private Text erreur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ctrl = this;
    }    

    @FXML
    private void handleCancel(ActionEvent event) {
        login.clear();
        password.clear();
        erreur.setVisible(true);
    }

    @FXML
    private void handleConnection(ActionEvent event) {
        
        String log = login.getText().trim();
        String pass = password.getText().trim();
        if(log.isEmpty() || pass.isEmpty()){
            erreur.setVisible(true);
        }else{
            user= service.setConnection(log, pass);
            if (user==null){
                erreur.setText("Utilisateur inexistant");
                erreur.setVisible(true);
            }else{
                if((user.getRole()).compareTo("ROLE_PATIENT")==0){
                    this.setUser(user);
                    login.getScene().getWindow().hide();
                    controller.chemin("V_Patient");
                }
                //
            }
        }
        
    }

    public static ConnectionController getCtrl() {
        return ctrl;
    }

    public static void setCtrl(ConnectionController ctrl) {
        ConnectionController.ctrl = ctrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @FXML
    private void handleInscription(MouseEvent event) {
        controller.chemin("V_Inscription");
    }
    
    
    
}
