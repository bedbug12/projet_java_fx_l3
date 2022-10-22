package ism.gestion.services;

import ism.gestion.entities.User;

public interface IService {
    public User connexion(String login,String password);
}
