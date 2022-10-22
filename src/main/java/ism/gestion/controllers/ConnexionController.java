package ism.gestion.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ism.gestion.App;
import ism.gestion.core.Fabrique;
import ism.gestion.entities.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ConnexionController implements Initializable {
    
    @FXML
    Text lblErrors;
    @FXML
    TextField txtLogin;
    @FXML
    PasswordField txtPassword;


   
    public static User user;

    public void handleConnexion() throws IOException{
        String login=txtLogin.getText().trim();
        String password=txtPassword.getText().trim();

        user=Fabrique.getService().connexion(login, password);
        if (user==null) {
            lblErrors.setVisible(true);
        }else{
            lblErrors.setVisible(false);
            App.setRoot("accueille");
        }
    }




    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        lblErrors.setVisible(false);
        
    }
}
