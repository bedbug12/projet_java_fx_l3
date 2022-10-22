package ism.gestion.services;

import ism.gestion.entities.User;
import ism.gestion.repository.IUserRepository;

public class Service implements IService {

    IUserRepository userRepository;

    
    public Service(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User connexion(String login, String password) {
        return userRepository.selectUserByLoginAndPassword(login, password);
    }
    
}
