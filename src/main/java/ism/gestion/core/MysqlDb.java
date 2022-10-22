package ism.gestion.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MysqlDb implements IDatabase {
 
    protected Connection conn;
    protected PreparedStatement ps;

    @Override
    public void ouvrirConnexionBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/projet_java_l3", "root", "");

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    @Override
    public void fermerConnexionBD() {
        
        try {
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    @Override
    public void initPreparedStatement() {
        // TODO Auto-generated method stub
        
    }
    
}
