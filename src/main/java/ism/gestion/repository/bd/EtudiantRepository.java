package ism.gestion.repository.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ism.gestion.core.MysqlDb;
import ism.gestion.entities.Classe;
import ism.gestion.entities.Etudiant;
import ism.gestion.repository.IEtudiantRepository;

public class EtudiantRepository extends MysqlDb implements IEtudiantRepository {

    private final String SQL_INSERT="INSERT INTO `etudiant`(`matricule`, `nom_complet`, `tuteur`) VALUES (?,?,?)";
    private final String SQL_SELECT="SELECT * FROM etudiant";
    private final String SQL_SELECT_ETU_AN="SELECT * FROM etudiant e ,inscription i WHERE e.id=i.etudiant_id AND annee LIKE ?";
    private final String SQL_SELECT_ETU_CLA="SELECT * FROM etudiant e ,inscription i WHERE e.id=i.etudiant_id AND classe_id = ?";
    private final String SQL_SELECT_ETU_NAME="SELECT * FROM etudiant WHERE nom_complet LIKE ?";


    @Override
    public Etudiant insert(Etudiant etudiant) {
        this.ouvrirConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_INSERT,PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, etudiant.getMatricule());
            ps.setString(2, etudiant.getNomComplet());
            ps.setString(3, etudiant.getTuteur());

            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()) {
                etudiant.setId(rs.getInt(1));
            }
           
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.fermerConnexionBD();
        return etudiant;
    }

    @Override
    public List<Etudiant> selectAll() {
        List<Etudiant> etudiants=new ArrayList<>();
        
        this.ouvrirConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_SELECT);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                Etudiant etudiant=new Etudiant(rs.getInt("id"),
                                                rs.getString("matricule"), 
                                                rs.getString("nom_complet"), 
                                                rs.getString("tuteur"));
                etudiants.add(etudiant);                                
            }
            

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.fermerConnexionBD();


        return etudiants;
    }

    @Override
    public List<Etudiant> selectAllByAnnee(String annee) {
       
        List<Etudiant> etudiants=new ArrayList<>();

        this.ouvrirConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_SELECT_ETU_AN);
            ps.setString(1, annee);
            ResultSet rs= ps.executeQuery();
            while (rs.next()) {
                Etudiant etudiant=new Etudiant(rs.getInt("id"), 
                                                rs.getString("matricule"), 
                                                rs.getString("nom_complet"), 
                                                rs.getString("tuteur"));
                etudiants.add(etudiant);                                
            }
            

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.fermerConnexionBD();


        return etudiants;
    }

    @Override
    public List<Etudiant> selectAllByClasse(Classe classe) {
        List<Etudiant> etudiants=new ArrayList<>();

        this.ouvrirConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_SELECT_ETU_CLA);
            ps.setInt(1, classe.getId());
            ResultSet rs= ps.executeQuery();
            while (rs.next()) {
                Etudiant etudiant=new Etudiant(rs.getInt("id"), 
                                                rs.getString("matricule"), 
                                                rs.getString("nom_complet"), 
                                                rs.getString("tuteur"));
                etudiants.add(etudiant);                                
            }
            

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.fermerConnexionBD();


        return etudiants;
    
    }

    @Override
    public Etudiant selectAllByName(String nomComplet) {
       
            Etudiant etudiant=null;
            
            this.ouvrirConnexionBD();
            try {
                ps=conn.prepareStatement(SQL_SELECT_ETU_NAME);
                ps.setString(1, nomComplet);
                ResultSet rs=ps.executeQuery();
                if (rs.next()) {
                     etudiant=new Etudiant(rs.getInt("id"),
                                                    rs.getString("matricule"), 
                                                    rs.getString("nom_complet"), 
                                                    rs.getString("tuteur"));
                                                
                }
                
    
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            this.fermerConnexionBD();
    
    
            return etudiant;
        
    }

    
   

}
