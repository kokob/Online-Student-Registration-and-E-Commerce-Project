/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs425.yogastudio.DAO;

import cs425.yogastudio.entity.Customer;
import cs425.yogastudio.entity.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kokob
 */
@Transactional(propagation = Propagation.MANDATORY)
public class UserDAO {

    public UserDAO() {
    }
    
    private SessionFactory sessionFactory; 
    
    
    @Transactional(propagation = Propagation.SUPPORTS)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
     public Customer findCustomerByUserName(String userName){
        
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Customer.class);
       
        criteria.add(Restrictions.eq("userName", userName));
    
        return (Customer) criteria.uniqueResult();
         
    }

    public List<User> getUserByUsername(String username) {
        Query query = sessionFactory.getCurrentSession().createQuery("Select distinct u from User u where u.userName=:username");
         query.setString("username", username);
         
         return query.list();
    }
    
}
