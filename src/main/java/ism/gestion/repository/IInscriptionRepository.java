package ism.gestion.repository;

import ism.gestion.entities.Classe;
import ism.gestion.entities.Etudiant;
import ism.gestion.entities.Inscription;

public interface IInscriptionRepository {
    public Etudiant insert(Inscription inscription,Classe classe,Etudiant etudiant);
    
}
