
package controller;

import model.bean.User;
import model.dao.UserDAO;

public class UserController {
    
    public static String registerUser(String login, String email, String pass){
        User user = new User(login, email, pass);
           
        return UserDAO.create(user);
    }
    
    public static Boolean login(String login, String pass){
        User user = new User(login, pass);
     
        return UserDAO.login(user);
    }
    
}
