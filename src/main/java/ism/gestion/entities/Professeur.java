package ism.gestion.entities;

public class Professeur {
    private int id;
    private int Nci;
    private String nomComplet;
    private String grade;



    
    public Professeur(String nomComplet, String grade) {
        this.nomComplet = nomComplet;
        this.grade = grade;
    }

    public Professeur(int nci, String nomComplet, String grade) {
        Nci = nci;
        this.nomComplet = nomComplet;
        this.grade = grade;
    }

    public Professeur(int id, int nci, String nomComplet, String grade) {
        this.id = id;
        Nci = nci;
        this.nomComplet = nomComplet;
        this.grade = grade;
    }

    public Professeur() {
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getNci() {
        return Nci;
    }
    public void setNci(int nci) {
        Nci = nci;
    }
    public String getNomComplet() {
        return nomComplet;
    }
    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
}
