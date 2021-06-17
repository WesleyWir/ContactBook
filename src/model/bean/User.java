
package model.bean;

public class User {
    private String login;
    private String email;
    private String senha;

    public User(String login, String email, String senha) {
        this.login = login;
        this.email = email;
        this.senha = senha;
    }
    
    public User(String login, String senha){
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
}
