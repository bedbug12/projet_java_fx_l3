package ism.gestion.entities;

abstract public class RP extends User {

    public RP(int id, String nomComplet, String login, String password, Role role) {
        super(id, nomComplet, login, password, role);
    }

    public RP() {
    }
    
}
