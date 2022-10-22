package ism.gestion.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ism.gestion.App;
import ism.gestion.core.Fabrique;
import ism.gestion.entities.Classe;
import ism.gestion.entities.Professeur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;

public class AjouterProfesseurController implements Initializable {

    @FXML
    private TextField txtClasse;

    @FXML
    Text lblErrorClasse;

    @FXML
    private TextField txtGrade;

    @FXML
    private TextField txtNci;

    @FXML
    private TextField txtNomComplet;

    ObservableList professeurs =FXCollections.observableList(Fabrique.RPService().listerProfesseurs());


    @FXML
    void handleAjouterProfesseur(){
        String nci=txtNci.getText().trim();
        int Nci = Integer.parseInt(nci);
        String libelle=txtClasse.getText().trim();
        String grade=txtGrade.getText().trim();
        String nomComplet=txtNomComplet.getText().trim();
        Classe classe=Fabrique.RPService().findClasseByLibelle(libelle);
        if (classe!=null) {
            Professeur professeur =Fabrique.RPService().ajouterProfesseur(new Professeur(Nci, nomComplet, grade));
            Fabrique.RPService().affecterClasseProfesseur(professeur,classe);
            Alert alert= new Alert(AlertType.INFORMATION);
            alert.setTitle("Gestion Professeur");
            alert.setContentText("un professeur à été ajouté avec succés");
            alert.show();
            professeurs.add(professeur);
            txtNci.clear();
            txtClasse.clear();
            txtNomComplet.clear();
            txtGrade.clear();
            try {
                handleGoBack();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            lblErrorClasse.setVisible(true); 
        }
       
    }

    @FXML
    void handleGoBack() throws IOException {
        App.setRoot("accueille");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        lblErrorClasse.setVisible(false); 
    }

}
