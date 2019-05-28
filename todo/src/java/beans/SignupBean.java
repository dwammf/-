/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import data.Users;

/**
 *
 * @author User
 */
@Named(value = "signupBean")
@SessionScoped
public class SignupBean implements Serializable {

    private String username;
    private String password1;
    private String password2;
    @EJB
    private Users users = new Users();

    public String signupControl(){
        if (password1 == password2 && username != "" && password1 != ""){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "WHAT THE HELL ?"));
            return "index.xhtml";
        }
        System.out.println("Smth goes wrong!");
        RequestContext.getCurrentInstance().update("growl");
        FacesContext context = FacesContext.getCurrentInstance();
        //context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Username or password invalid!"));
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "#" +  password1 +"?"+ password2 + "#"));
        return "";
    }
    
    public Users getUsers() {
        return users;
    }

    public void setUsers(Users query) {
        this.users = query;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }
    
    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
    
    public SignupBean() {
    }
    
}

