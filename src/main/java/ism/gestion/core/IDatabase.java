package ism.gestion.core;

public interface IDatabase {
    public void ouvrirConnexionBD();
    public void fermerConnexionBD();
    public void initPreparedStatement();
}
