package ism.gestion.services;

import java.util.List;

import ism.gestion.entities.Classe;
import ism.gestion.entities.Professeur;

public interface IRPservice {
    public Classe creeClasse(Classe classe);
    public Classe findClasseByLibelle(String libelle);
    public Professeur findProfesseurByName(String nomComplet);
    public List<Classe> listerClasse();
    public Professeur ajouterProfesseur(Professeur professeur);
    public Professeur affecterClasseProfesseur(Professeur professeur,Classe classe);
    public List<Professeur> listerProfesseurs();
    public List<Classe> filtrerClasseProfesseur(int id);
}

