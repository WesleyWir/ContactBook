
package model.bean;

public class Contact {
    //Nome, data de nascimento, telefone, email, cidade(select), estado(select) e bairro
    private String name;
    private String bornDate;
    private String phone;
    private String email;
    private String state;
    private String city;
    private String neighborhood;

    public Contact(String name, String bornDate, String phone, String email, String state, String city, String neighborhood) {
        this.name = name;
        this.bornDate = bornDate;
        this.phone = phone;
        this.email = email;
        this.state = state;
        this.city = city;
        this.neighborhood = neighborhood;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    public String getBornDate() {
        return bornDate;
    }

    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String bairro) {
        this.neighborhood = neighborhood;
    }
    
    
}
