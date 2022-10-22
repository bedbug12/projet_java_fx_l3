package ism.gestion.services;

import java.util.List;

import ism.gestion.entities.Classe;
import ism.gestion.entities.Etudiant;
import ism.gestion.entities.Inscription;

public interface IACService {
    public Etudiant inscrireEtudiant(Inscription inscription,Classe classe,Etudiant etudiant);
    public Etudiant reinscrireEtudiant(Inscription inscription,Classe classe,Etudiant etudiant);
    public List<Etudiant> listerEtudiants();
    public List<Etudiant> listerEtudiantInscritAnnee(String annee);
    public List<Etudiant> filtrerEtudiantInscritParClasse(Classe classe);
    public Etudiant findByName(String nomComplet);
}
