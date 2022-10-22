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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ProfesseurController implements Initializable {

    @FXML
    private ComboBox<?> cbClasse;

    @FXML
    private TableColumn<Professeur, String> tblcGrade;

    @FXML
    private TableColumn<Professeur, String> tblcId;

    @FXML
    private TableColumn<Professeur, String> tblcNci;

    @FXML
    private TableColumn<Professeur, String> tblcNomComplet;

    @FXML
    private TableView<Professeur> tblvProfesseur;

    @FXML
    private TableColumn<Classe, String> tblcIdClasse;

    @FXML
    private TableColumn<Classe, String> tblcLibelle;

    @FXML
    private TableView<Classe> tblvClasse;


    ObservableList professeurs =FXCollections.observableList(Fabrique.RPService().listerProfesseurs());
    


    public void handleListerProfesseur() {
        tblcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblcGrade.setCellValueFactory(new PropertyValueFactory<>("grade"));
        tblcNomComplet.setCellValueFactory(new PropertyValueFactory<>("nomComplet"));
        tblcNci.setCellValueFactory(new PropertyValueFactory<>("Nci"));
        tblvProfesseur.setItems(professeurs);
    }

   

    @FXML
    public void getSelected(MouseEvent event){
        int id=tblvProfesseur.getSelectionModel().getSelectedItem().getId(); 
        ObservableList classes =FXCollections.observableList(Fabrique.RPService().filtrerClasseProfesseur(id));
        handleListerClasse(classes);
    }

    public void handleFiltrerProfesseur() {

        

    }

    
    public void handleAjouter() throws IOException {
        App.setRoot("ajouterProfesseur");
    }

    
    public void handleAffecter() throws IOException {
        App.setRoot("affecterProfesseur");
    }


    public void handleListerClasse(ObservableList list){
        tblcIdClasse.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblcLibelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        tblvClasse.setItems(list);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        handleListerProfesseur();
    }

}
