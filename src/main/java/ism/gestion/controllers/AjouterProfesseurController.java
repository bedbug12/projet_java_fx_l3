package ism.gestion.controllers;

import java.io.IOException;

import ism.gestion.App;
import ism.gestion.core.Fabrique;
import ism.gestion.entities.Professeur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class AjouterProfesseurController {

    @FXML
    private TextField txtClasse;

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
        Professeur professeur =Fabrique.RPService().ajouterProfesseur(new Professeur(Nci, nomComplet, grade));
        Fabrique.RPService().affecterClasseProfesseur(professeur,Fabrique.RPService().findClasseByLibelle(libelle));
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
    }

    @FXML
    void handleGoBack() throws IOException {
        App.setRoot("accueille");
    }

}
