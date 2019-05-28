
package data;

import entity.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Maryna
 */

@Stateless
@LocalBean
public class Users {
   
    @PersistenceContext(unitName="todoPU")
    private EntityManager em;

    
    public boolean loginControl(String username, String password){
        try {
            System.out.println("4");
            List<User> list = em.createNamedQuery("User.loginControl", User.class).setParameter("username", username).setParameter("password", password).getResultList();
            System.out.println("5");
            if(list.isEmpty()) return false;
            else 
            if (list.get(0)!=null && list.size()==1){
                return true;
            } else {
                return false;
            }
        } catch(Exception e) {
            System.out.println("Exception in data/Users.java");
            System.out.println(e);
            return false;
        }
}
}