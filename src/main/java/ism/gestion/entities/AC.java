package ism.gestion.entities;

abstract public class AC extends User{

    public AC(int id, String nomComplet, String login, String password, Role role) {
        super(id, nomComplet, login, password, role);
    }

    public AC() {
    }
    
}
