package ism.gestion.repository.bd;


import java.sql.ResultSet;
import java.sql.SQLException;

import ism.gestion.core.MysqlDb;
import ism.gestion.entities.Role;
import ism.gestion.entities.User;
import ism.gestion.repository.IUserRepository;

public class UserRepository extends MysqlDb implements IUserRepository {

    private final String SQL_SELECT="SELECT * FROM user WHERE login LIKE ? AND password LIKE ?";
    @Override
    public User selectUserByLoginAndPassword(String login, String password) {
        User user=null;
        this.ouvrirConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_SELECT);
            ps.setString(1, login);
            ps.setString(2, password);
           
            ResultSet rs= ps.executeQuery();
            if (rs.next()) {
                user=new User(rs.getString("login"),
                                rs.getString("password"),
                                rs.getString("role").compareTo("AC")==0?Role.AC:Role.RP);
                
            }

           
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.fermerConnexionBD();
        return user;
    }
    
}
