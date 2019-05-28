
package beans;

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
 * @author Maryna
 */

@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private String username;
    private String password;
    @EJB
    private Users users = new Users();

    public String loginControl(){
        if(users.loginControl(username, password)){
            return "index.xhtml";
        }
        System.out.println("Wrong login or password!");
        RequestContext.getCurrentInstance().update("growl");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Username or password invalid!"));
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public LoginBean() {
    }
    
}
