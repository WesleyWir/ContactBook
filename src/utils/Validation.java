/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.dao.UserDAO;

/**
 *
 * @author Lucas
 */
public class Validation {
    public static boolean dataExists(String column, String data){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        try{
            String sql = "SELECT "+column+" FROM "+UserDAO.getTable()+" WHERE "+column+" = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, data);
            
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
    
    public static boolean hasEmptyFields(Object[] fields){
        for(int i =0; i < fields.length; i++){
            if(fields[i].equals("")){
                return true;
            }
        }
        return false;
    }
}
