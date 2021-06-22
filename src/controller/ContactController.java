
package controller;

import model.bean.Contact;
import model.dao.ContactDAO;
import java.sql.ResultSet;

public class ContactController {
    
    public static String createContact(String name, String born_date, String phone, String email, String state, String city, String neighborhood){
        Contact contact = new Contact(name, born_date, phone, email, state, city, neighborhood);
        
        return ContactDAO.create(contact);
    }
    
    public static ResultSet readContacts(){
        return ContactDAO.readAll();
    }
    
    public static ResultSet readContact(int id){
        return ContactDAO.read(id);
    }
    
    public static void updateContact(int id, String name, String born_date, String phone, String email, String state, String city, String neighborhood){
        Contact contact = new Contact(name, born_date, phone, email, state, city, neighborhood);
        
        ContactDAO.update(id, contact);
    }
    
    public static boolean deleteContact(int id){
        return ContactDAO.delete(id);
    }
    
    public static ResultSet searchContact(String query){
        return ContactDAO.search(query);
    }
}
