package ism.gestion.services;

import java.util.List;

import ism.gestion.entities.Classe;
import ism.gestion.entities.Professeur;
import ism.gestion.repository.IClasseRepository;
import ism.gestion.repository.IProfesseurRepository;

public class RPService implements IRPservice {

    IClasseRepository classeRepository;
    IProfesseurRepository professeurRepository;

    public RPService(IClasseRepository classeRepository, IProfesseurRepository professeurRepository) {
        this.classeRepository = classeRepository;
        this.professeurRepository = professeurRepository;
    }

    @Override
    public Classe creeClasse(Classe classe) {
        return classeRepository.insert(classe);
    }

    @Override
    public List<Classe> listerClasse() {
        return classeRepository.selectAll();
    }

    @Override
    public Professeur ajouterProfesseur(Professeur professeur) { 
        return professeurRepository.insert(professeur);
    }

    @Override
    public Professeur affecterClasseProfesseur(Professeur professeur, Classe classe) {
       return professeurRepository.insertClassProf(professeur, classe);
        
    }

    @Override
    public List<Professeur> listerProfesseurs() {
        return professeurRepository.selectAll();
    }

    @Override
    public List<Classe> filtrerClasseProfesseur(int id) {
        return professeurRepository.selectClasseProfessuer(id);
    }

    @Override
    public Classe findClasseByLibelle(String libelle) { 
        return classeRepository.selectClasseByLibelle(libelle);
    }

    @Override
    public Professeur findProfesseurByName(String nomComplet) {
        return professeurRepository.selectByName(nomComplet);
    }
    
}
