/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs425.yogastudio.DAO;

import cs425.yogastudio.entity.Customer;
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
@Transactional(propagation=Propagation.MANDATORY)
public class CustomerDAO {

//    public CustomerDAO() {
//    }
    
   
    private SessionFactory sessionFactory;
@Transactional(propagation=Propagation.SUPPORTS)
 public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
  
    public void addCustomer(Customer customer){
        
        sessionFactory.getCurrentSession().persist(customer);
        
    }

    public List<Customer> getAll() {
        List<Customer> customers = sessionFactory.getCurrentSession().createQuery("from Customer").list();
   
        return customers;
    }

//    public void add(Customer customer) {
//        sessionFactory.getCurrentSession().persist(customer);
//    }

    public Customer get(int id) {
        return (Customer)sessionFactory.getCurrentSession().get(Customer.class, id);
    }

    public void update(Customer customer) {
        sessionFactory.getCurrentSession().saveOrUpdate(customer);
    }

   
    public void delete(Customer customer) {
        sessionFactory.getCurrentSession().delete(customer);
    }
    
    public Customer findCustomerByName(String firstName){
        
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Customer.class);
        criteria.add(Restrictions.eq("firstName", firstName));
    
        return (Customer) criteria.uniqueResult();
    }
    
    public Customer getCustomerByUser(String username) {
        Query query = sessionFactory.getCurrentSession().createQuery("Select distinct c from Customer c where c.userName=:username");
         query.setString("username", username);
         
         Customer customer = (Customer)query.list().get(0);
         return customer;
    }
    
    
}
