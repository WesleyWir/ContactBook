
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.bean.User;

public class UserDAO {
    
    private static final String TABLE_NAME = "user_login";
    
    public static String getTable(){
        return UserDAO.TABLE_NAME;
    }
    
    public static void create(User user){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        try{
            String sql = "INSERT INTO "+UserDAO.getTable()+" (login, email, pass) VALUES (?, ?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getSenha());
            
            stmt.execute();
            stmt.close();
        }catch(SQLException ex){
            throw new RuntimeException("Erro na Conexão: ", ex);
        }
    }
    
    public static Boolean login(User user){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        try{
            String sql = "SELECT * FROM "+UserDAO.getTable()+" WHERE login = ? AND pass = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getSenha());
            
            if(stmt.executeQuery().next()){
                return true;
            }
            
            return false;
        }catch(SQLException ex){
            throw new RuntimeException("Erro na Conexão: ", ex);
        }
    }
}
