package ism.gestion.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ism.gestion.App;
import ism.gestion.core.Fabrique;
import ism.gestion.entities.Classe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import ism.gestion.entities.Professeur;


public class AffecterProfesseurController implements  Initializable{


    @FXML
    Text lblErrorClasse;

    @FXML
    Text lblErrorProfesseur;

    @FXML
    private TextField txtClasse;

    @FXML
    private TextField txtNomComplet;

    ObservableList professeurs =FXCollections.observableList(Fabrique.RPService().listerProfesseurs());


    @FXML
    void handleAffecterProfesseur() {

        String libelle=txtClasse.getText().trim();
        String nomComplet=txtNomComplet.getText().trim();
        Classe classe = Fabrique.RPService().findClasseByLibelle(libelle);
        Professeur prof =Fabrique.RPService().findProfesseurByName(nomComplet);
        if (classe==null && prof==null) {
             lblErrorClasse.setVisible(true); 
             lblErrorProfesseur.setVisible(true);
        }else if(prof==null){
            lblErrorProfesseur.setVisible(true);
            lblErrorClasse.setVisible(false);
        }else if (classe==null) {
            lblErrorClasse.setVisible(true); 
            lblErrorProfesseur.setVisible(false);
        } else {
            Professeur professeur =Fabrique.RPService().affecterClasseProfesseur(prof, classe); 
            Alert alert= new Alert(AlertType.INFORMATION);
            alert.setTitle("Gestion Professeur");
            alert.setContentText("un professeur à été ajouté avec succés");
            alert.show();
            professeurs.add(professeur);
            txtClasse.clear();
            txtNomComplet.clear();
           
            try {
                handleGoBack();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
       
    }

    @FXML
    void handleGoBack() throws IOException {
        App.setRoot("accueille");
       
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        lblErrorClasse.setVisible(false);
        lblErrorProfesseur.setVisible(false);
        
    }
}
