
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.bean.Contact;

public class ContactDAO {
    
    private static final String TABLE_NAME = "contacts";
    
    public static String getTable(){
        return ContactDAO.TABLE_NAME;
    }
    
    public static void create(Contact contact){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        try{
            String sql = "INSERT INTO "+ContactDAO.getTable()+" (name, born_date, phone, email, state, city, neighborhood) VALUES (?, ?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, contact.getName());
            stmt.setString(2, contact.getBornDate());
            stmt.setString(3, contact.getPhone());
            stmt.setString(4, contact.getEmail());
            stmt.setString(5, contact.getState());
            stmt.setString(6, contact.getCity());
            stmt.setString(7, contact.getNeighborhood());
            
            stmt.execute();
            stmt.close();
        }catch(SQLException ex){
            throw new RuntimeException("Erro na Conexão: ", ex);
        }
    }
    
    public static ResultSet readAll(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        try{
            String sql = "SELECT * FROM "+ContactDAO.getTable()+"";
            stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            return rs;
        }catch(SQLException ex){
            throw new RuntimeException("Erro na Conexão: ", ex);
        }
    }
    
    public static ResultSet read(int id){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        try{
            String sql = "SELECT * FROM "+ContactDAO.getTable()+" WHERE id = ?";
            stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();
         
            return rs; 
        }catch(SQLException ex){
            throw new RuntimeException("Erro na Conexão: ", ex);
        }
    }
    
    public static void update(int id, Contact contact){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        try{
            String sql = "UPDATE "+ContactDAO.getTable()+" "
                    +    "SET "
                    +    "name = '"+contact.getName()+"', "
                    +    "born_date = '"+contact.getBornDate()+"', "
                    +    "phone = '"+contact.getPhone()+"', "
                    +    "email = '"+contact.getEmail()+"', "
                    +    "state = '"+contact.getState()+"', "
                    +    "city = '"+contact.getCity()+"', "
                    +    "neighborhood = '"+contact.getState()+"'"
                    +    "WHERE id = "+ id;
            
            stmt = con.prepareStatement(sql); 
            
            stmt.execute();
            stmt.close();
        }catch(SQLException ex){
            throw new RuntimeException("Erro na Conexão: ", ex);
        }
    }
    
    public static boolean delete(int id){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        try{
            String sql = "DELETE FROM "+ContactDAO.getTable()+" WHERE id = "+id;
            
            stmt = con.prepareStatement(sql); 
            
            stmt.execute();
            stmt.close();
            
            return true;
        }catch(SQLException ex){
            throw new RuntimeException("Erro na Conexão: ", ex);
        }
    }
    
    public static ResultSet search(String query){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        try{
            String sql = "SELECT * FROM "+ContactDAO.getTable()+" "
                        + "WHERE name LIKE '%"+query+"%' OR phone LIKE '%"+query+"%' OR email LIKE '%"+query+"%'";
            stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
         
            return rs; 
        }catch(SQLException ex){
            throw new RuntimeException("Erro na Conexão: ", ex);
        } 
    }
    
}
