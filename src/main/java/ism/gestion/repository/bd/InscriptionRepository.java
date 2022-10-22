package ism.gestion.repository.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ism.gestion.core.MysqlDb;
import ism.gestion.entities.Classe;
import ism.gestion.entities.Etudiant;
import ism.gestion.entities.Inscription;
import ism.gestion.repository.IEtudiantRepository;
import ism.gestion.repository.IInscriptionRepository;

public class InscriptionRepository extends MysqlDb implements IInscriptionRepository {

    public InscriptionRepository(IEtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    private final String SQL_INSERT ="INSERT INTO `inscription`(`annee`, `etat`, `classe_id`, `etudiant_id`) VALUES (?,?,?,?)";
    IEtudiantRepository etudiantRepository;
    
    @Override
    public Etudiant insert(Inscription inscription,Classe classe,Etudiant etudiant) {
        this.ouvrirConnexionBD();
        try {

            ps=conn.prepareStatement(SQL_INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, inscription.getAnnee());
            ps.setString(2, inscription.getEtat().name());
            ps.setInt(3, classe.getId());
            ps.setInt(4, etudiant.getId());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.fermerConnexionBD();
       return etudiant;
    }

   
}
