package ism.gestion.repository;

import java.util.List;

import ism.gestion.entities.Classe;
import ism.gestion.entities.Professeur;

public interface IProfesseurRepository {

    public Professeur insert(Professeur professeur);
    public Professeur selectByName(String nomComplet);
    public Professeur insertClassProf(Professeur professeur,Classe classe);
    public List<Professeur> selectAll();
    public List<Classe> selectClasseProfessuer(int id);
    

}
