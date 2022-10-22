package ism.gestion.repository;

import java.util.List;

import ism.gestion.entities.Classe;

public interface IClasseRepository {
    public Classe insert(Classe classe);
    public List<Classe> selectAll();
    public Classe selectClasseByLibelle(String libelle);
}
