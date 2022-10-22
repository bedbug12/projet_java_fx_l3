package ism.gestion.services;

import java.util.List;

import ism.gestion.entities.Classe;
import ism.gestion.entities.Etudiant;
import ism.gestion.entities.Inscription;
import ism.gestion.repository.IClasseRepository;
import ism.gestion.repository.IEtudiantRepository;
import ism.gestion.repository.IInscriptionRepository;

public class ACService implements IACService {

    IEtudiantRepository etudiantRepository;
    IClasseRepository classeRepository;
    IInscriptionRepository inscriptionRepository;

    public ACService(IEtudiantRepository etudiantRepository, IClasseRepository classeRepository,IInscriptionRepository inscriptionRepository) {
        this.etudiantRepository = etudiantRepository;
        this.classeRepository = classeRepository;
        this.inscriptionRepository = inscriptionRepository;
    }

    
    

    
    @Override
    public Etudiant inscrireEtudiant(Inscription inscription,Classe classe,Etudiant etudiant) {
        
        etudiantRepository.insert(etudiant);
        return inscriptionRepository.insert(inscription, classe, etudiant);
    }

    @Override
    public Etudiant reinscrireEtudiant(Inscription inscription,Classe classe,Etudiant etudiant) {
        
        return inscriptionRepository.insert(inscription, classe, etudiant);
    }

    @Override
    public List<Etudiant> listerEtudiantInscritAnnee(String annee) {
        return etudiantRepository.selectAllByAnnee(annee);
    }

    @Override
    public List<Etudiant> filtrerEtudiantInscritParClasse(Classe classe) {
        return etudiantRepository.selectAllByClasse(classe);
    }


    @Override
    public List<Etudiant> listerEtudiants() {
        return etudiantRepository.selectAll();
    }



    @Override
    public Etudiant findByName(String nomComplet) {
        return etudiantRepository.selectAllByName(nomComplet);
    }
    
}
