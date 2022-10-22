package ism.gestion.repository.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ism.gestion.core.MysqlDb;
import ism.gestion.entities.Classe;
import ism.gestion.entities.Professeur;
import ism.gestion.repository.IProfesseurRepository;

public class ProfesseurRepository extends MysqlDb implements IProfesseurRepository{

    private final String SQL_INSERT="INSERT INTO `professeur`(`nci`, `nom_complet`, `grade`) VALUES (?,?,?)";
    private final String SQL_SELECT="SELECT * FROM professeur";
    private final String SQL_SELECT_BY_NAME="SELECT * FROM professeur WHERE nom_complet LIKE ?";
    private final String SQL_SELECT_CLASS_PROF="SELECT * FROM classe c ,professeur_classe pc WHERE c.id=pc.classe_id AND pc.professeur_id=?";
    private final String SQL_INSERT_ClASS_PROF="INSERT INTO `professeur_classe`(`classe_id`, `professeur_id`) VALUES (?,?)";

    @Override
    public Professeur insert(Professeur professeur) {
         this.ouvrirConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_INSERT,PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, professeur.getNci());
            ps.setString(2, professeur.getNomComplet());
            ps.setString(3, professeur.getGrade());

            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()) {
                professeur.setId(rs.getInt(1));
            } 
           
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.fermerConnexionBD();
        return professeur;
    }



    @Override
    public List<Professeur> selectAll() {
      List<Professeur> professeurs=new ArrayList<>();
        
        this.ouvrirConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_SELECT);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                Professeur professeur=new Professeur(rs.getInt("id"), 
                                                    rs.getInt("nci"),
                                                    rs.getString("nom_complet"), 
                                                    rs.getString("grade"));
                professeurs.add(professeur);                                
            }
           

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.fermerConnexionBD();
        return professeurs;
    }

    @Override
    public List<Classe> selectClasseProfessuer(int id) {
        List<Classe> classes=new ArrayList<>();
        
        this.ouvrirConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_SELECT_CLASS_PROF);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                Classe classe=new Classe(rs.getInt("id"), rs.getString("libelle"));
                classes.add(classe);                                
            }
           

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.fermerConnexionBD();


        return classes;
    }



    @Override
    public Professeur insertClassProf(Professeur professeur, Classe classe) {
        
        this.ouvrirConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_INSERT_ClASS_PROF,PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, classe.getId());
            ps.setInt(2, professeur.getId());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.fermerConnexionBD();
        return professeur;
    }



    @Override
    public Professeur selectByName(String nomComplet) {
        Professeur professeur=null;
        
        this.ouvrirConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_SELECT_BY_NAME);
            ps.setString(1, nomComplet);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                professeur=new Professeur(rs.getInt("id"), 
                                                    rs.getInt("nci"),
                                                    rs.getString("nom_complet"), 
                                                    rs.getString("grade"));
                                                
            }
           

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.fermerConnexionBD();
        return professeur;
    }


}
