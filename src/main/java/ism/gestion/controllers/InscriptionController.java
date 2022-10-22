package ism.gestion.controllers;

import java.io.IOException;

import ism.gestion.App;
import ism.gestion.core.Fabrique;
import ism.gestion.entities.Classe;
import ism.gestion.entities.Etat;
import ism.gestion.entities.Etudiant;
import ism.gestion.entities.Inscription;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class InscriptionController {

    @FXML
    private TextField txtAnnee;

    @FXML
    private TextField txtClasse;

    @FXML
    private TextField txtNomComplet;

    @FXML
    private TextField txtTuteur;


    ObservableList etudiants=FXCollections.observableList(Fabrique.ACService().listerEtudiants());


    @FXML
    void handleCreerEtudiant() {

        String annee=txtAnnee.getText().trim();
        String libelle=txtClasse.getText().trim();
       
        String nomComplet=txtNomComplet.getText().trim();
        String tuteur=txtTuteur.getText().trim();
        Etudiant etudiant =Fabrique.ACService().inscrireEtudiant(new Inscription(annee, Etat.Inscrit), 
                                                                Fabrique.RPService().findClasseByLibelle(libelle), 
                                                                new Etudiant(nomComplet, tuteur)); 
        Alert alert= new Alert(AlertType.INFORMATION);
        alert.setTitle("Gestion Etudiant");
        alert.setContentText("un(e) etudiant(e) à été ajouté(e) avec succés");
        alert.show();
        etudiants.add(etudiant);
        txtAnnee.clear();
        txtClasse.clear();
        txtNomComplet.clear();
        txtTuteur.clear();
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
