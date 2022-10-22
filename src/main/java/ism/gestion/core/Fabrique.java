package ism.gestion.core;

import ism.gestion.repository.IClasseRepository;
import ism.gestion.repository.IEtudiantRepository;
import ism.gestion.repository.IInscriptionRepository;
import ism.gestion.repository.IProfesseurRepository;
import ism.gestion.repository.IUserRepository;
import ism.gestion.repository.bd.ClasseRepository;
import ism.gestion.repository.bd.EtudiantRepository;
import ism.gestion.repository.bd.InscriptionRepository;
import ism.gestion.repository.bd.ProfesseurRepository;
import ism.gestion.repository.bd.UserRepository;
import ism.gestion.services.ACService;
import ism.gestion.services.IACService;
import ism.gestion.services.IRPservice;
import ism.gestion.services.IService;
import ism.gestion.services.RPService;
import ism.gestion.services.Service;

public class Fabrique {
    
    static IEtudiantRepository etudiantRepository = new EtudiantRepository();
    static IClasseRepository classeRepository = new ClasseRepository();
    static IInscriptionRepository inscriptionRepository = new InscriptionRepository(etudiantRepository);
    static IProfesseurRepository professeurRepository = new ProfesseurRepository();
    static IUserRepository userRepository = new UserRepository();
    
    
    public static IRPservice RPService(){
        return new RPService(classeRepository, professeurRepository);
    }
    public static IACService ACService(){
        return new ACService(etudiantRepository, classeRepository, inscriptionRepository);
    }
    public static IService getService(){
        return new Service(userRepository);
    }

}
