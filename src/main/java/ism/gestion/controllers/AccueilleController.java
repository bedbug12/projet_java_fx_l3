package ism.gestion.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ism.gestion.App;
import ism.gestion.entities.Role;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class AccueilleController implements Initializable {

    @FXML
    AnchorPane anchorContent;

    @FXML
    private Button btnClasse;

    @FXML
    private Button btnEtudiant;

    @FXML
    private Button btnProfesseur;

    @FXML
    void handleDeconnexion(ActionEvent event) throws IOException {
        App.setRoot("connexion");
    }

    @FXML
    void handleLoadViewClasse(ActionEvent event) throws IOException {
        loadView("classe");
    }

    @FXML
    void handleLoadViewEtudiant(ActionEvent event) throws IOException {
       loadView("etudiant");
    }

    @FXML
    void handleLoadViewProfesseur(ActionEvent event) throws IOException {
       loadView("professeur");
    }

    void loadView(String fxml) throws IOException{
        AnchorPane root= (AnchorPane) App.loadFXML(fxml);
        anchorContent.getChildren().clear();
        anchorContent.getChildren().add(root);
    }
    public void isAC(){
        btnClasse.setDisable(true);
        btnProfesseur.setDisable(true);
    }

    void isRP(){
        btnEtudiant.setDisable(true);
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        if (ConnexionController.user.getRole().compareTo(Role.AC)==0) {
            isAC();
            try {
                loadView("etudiant");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            isRP();
            try {
                loadView("professeur");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }


}
