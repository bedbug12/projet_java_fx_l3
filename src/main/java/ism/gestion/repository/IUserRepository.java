package ism.gestion.repository;

import ism.gestion.entities.User;

public interface IUserRepository {
    public User selectUserByLoginAndPassword(String login,String password);
}
