package ism.gestion.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ism.gestion.core.Fabrique;
import ism.gestion.entities.Classe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class ClasseController implements Initializable {
    
    @FXML
    private TableColumn<Classe, String> tblcId;

    @FXML
    private TableColumn<Classe,String> tblcLibelle;

    @FXML
    private TableView<Classe> tblvClasse;

    @FXML
    private TextField txtLibelle;

    ObservableList classes =FXCollections.observableList(Fabrique.RPService().listerClasse());

    public void handleListerClasse(){
        tblcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblcLibelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        tblvClasse.setItems(classes);
    }

    public void handleCreerClasse(){
        String libelle=txtLibelle.getText().trim();
        Classe classe =Fabrique.RPService().creeClasse(new Classe(libelle));
        Alert alert= new Alert(AlertType.INFORMATION);
        alert.setTitle("Gestion Classe");
        alert.setContentText("une classe à été ajoutée avec succés");
        alert.show();
        classes.add(classe);
        txtLibelle.clear();
       
    
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        handleListerClasse();
        
    }

}
