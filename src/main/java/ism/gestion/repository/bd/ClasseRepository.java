package ism.gestion.repository.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ism.gestion.core.MysqlDb;
import ism.gestion.entities.Classe;
import ism.gestion.repository.IClasseRepository;

public class ClasseRepository extends MysqlDb implements IClasseRepository {

    private final String SQL_INSERT="INSERT INTO `classe` (`libelle`) VALUE (?) ";
    private final String SQL_SELECT_CLASSE_BY_LIBELLE="SELECT * FROM classe WHERE libelle LIKE ?";
    private final String SQL_SELECT="SELECT * FROM classe";



    @Override
    public Classe insert(Classe classe) {
        this.ouvrirConnexionBD();
        try {
            ps= conn.prepareStatement(SQL_INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,classe.getLibelle());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()) {
                classe.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.fermerConnexionBD();
        return classe;
    }




    @Override
    public List<Classe> selectAll() {

        List<Classe> classes=new ArrayList<>();

        this.ouvrirConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_SELECT);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                Classe classe=new Classe(rs.getInt("id"),
                                         rs.getString("libelle"));
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
    public Classe selectClasseByLibelle(String libelle) {
      Classe classe=null;

        this.ouvrirConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_SELECT_CLASSE_BY_LIBELLE);
            ps.setString(1, libelle);
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                classe=new Classe(rs.getInt("id"),
                                  rs.getString("libelle"));
                
            }

          
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.fermerConnexionBD();
        return classe;
    }



}
