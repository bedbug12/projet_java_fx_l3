package ism.gestion.core;

public class Etudiant {
    private final String prefix="MAT_";
    private int num;



    public Etudiant(int num) {
        this.num = num;
    }
    public Etudiant() {
    }
    public String getPrefix() {
        return prefix;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
}
