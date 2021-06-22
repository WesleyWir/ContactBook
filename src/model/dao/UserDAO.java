
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.bean.User;
import utils.Validation;

public class UserDAO {
    
    private static final String TABLE_NAME = "user_login";
    
    public static String getTable(){
        return UserDAO.TABLE_NAME;
    }
    
    public static String create(User user){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        try{
            if(!(Validation.dataExists("login",user.getLogin()))){
                if(!(Validation.dataExists("email",user.getEmail()))){
                    String sql = "INSERT INTO "+UserDAO.getTable()+" (login, email, pass) VALUES (?, ?, ?)";
                    stmt = con.prepareStatement(sql);
                    stmt.setString(1, user.getLogin());
                    stmt.setString(2, user.getEmail());
                    stmt.setString(3, user.getSenha());

                    stmt.execute();
                    ConnectionFactory.closeConnection(con, stmt);
                    return "";
                }else{
                    return "Email já cadastrado.";
                }
                
            }else{
                return "Usuário já cadastrado.";
            }
            
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
                ConnectionFactory.closeConnection(con, stmt);
                return true;
            }
            
            ConnectionFactory.closeConnection(con, stmt);
            return false;
        }catch(SQLException ex){
            throw new RuntimeException("Erro na Conexão: ", ex);
        }
    }
    
    
}
