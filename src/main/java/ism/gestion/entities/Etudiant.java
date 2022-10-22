package ism.gestion.entities;

import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import ism.gestion.core.Config;


public class Etudiant{
  private int id;  
  private String matricule;  
  private String nomComplet;  
  private String tuteur;
  private static int nb;



public Etudiant(String nomComplet, String tuteur){
    this.nomComplet = nomComplet;
    this.tuteur = tuteur;
    nb++;
    try {
        matricule=Config.getPrefEtudiant()+""+Config.getSeqEtudiant();
        Config.writeJsonFile();
    } catch (StreamReadException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (DatabindException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}

public Etudiant(int id, String matricule, String nomComplet, String tuteur) {
    this.id = id;
    this.matricule = matricule;
    this.nomComplet = nomComplet;
    this.tuteur = tuteur;
}

public Etudiant() {
}

public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public String getMatricule() {
    return matricule;
}
public void setMatricule(String matricule) {
    this.matricule = matricule;
}
public String getNomComplet() {
    return nomComplet;
}
public void setNomComplet(String nomComplet) {
    this.nomComplet = nomComplet;
}
public String getTuteur() {
    return tuteur;
}
public void setTuteur(String tuteur) {
    this.tuteur = tuteur;
}  
}
