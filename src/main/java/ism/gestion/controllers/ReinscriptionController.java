package ism.gestion.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ism.gestion.App;
import ism.gestion.core.Fabrique;
import ism.gestion.entities.Classe;
import ism.gestion.entities.Etat;
import ism.gestion.entities.Etudiant;
import ism.gestion.entities.Inscription;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;

public class ReinscriptionController implements  Initializable{

    @FXML
    private TextField txtAnnee;

    @FXML
    Text lblErrorClasse;

    @FXML
    Text lblErrorEtudiant;

    @FXML
    private TextField txtClasse;

    @FXML
    private TextField txtNomComplet;

    ObservableList etudiants=FXCollections.observableList(Fabrique.ACService().listerEtudiants());


    @FXML
    void handleCreerEtudiant() {

        String annee=txtAnnee.getText().trim();
        String libelle=txtClasse.getText().trim();
        String nomComplet=txtNomComplet.getText().trim();
        Inscription inscription=new Inscription(annee, Etat.Inscrit);
        Classe classe = Fabrique.RPService().findClasseByLibelle(libelle);
        Etudiant etu =Fabrique.ACService().findByName(nomComplet);
        if (classe==null && etu==null) {
            lblErrorClasse.setVisible(true); 
            lblErrorEtudiant.setVisible(true);
        }else if(etu==null){
            lblErrorEtudiant.setVisible(true);
            lblErrorClasse.setVisible(false);
        }else if (classe==null) {
            lblErrorClasse.setVisible(true); 
            lblErrorEtudiant.setVisible(false);
        } else {
            Etudiant etudiant =Fabrique.ACService().reinscrireEtudiant(inscription, classe, etu); 
            Alert alert= new Alert(AlertType.INFORMATION);
            alert.setTitle("Gestion Etudiant");
            alert.setContentText("un(e) etudiant(e) à été ajouté(e) avec succés");
            alert.show();
            etudiants.add(etudiant);
            txtAnnee.clear();
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
        lblErrorEtudiant.setVisible(false);
        
    }
}
