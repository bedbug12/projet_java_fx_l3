package ism.gestion.repository;

import java.util.List;

import ism.gestion.entities.Classe;
import ism.gestion.entities.Etudiant;

public interface IEtudiantRepository {
    public Etudiant insert(Etudiant etudiant);
    public List<Etudiant> selectAll();
    public List<Etudiant> selectAllByAnnee(String annee);
    public List<Etudiant> selectAllByClasse(Classe classe);
    public Etudiant selectAllByName(String nomComplet);

    


}
