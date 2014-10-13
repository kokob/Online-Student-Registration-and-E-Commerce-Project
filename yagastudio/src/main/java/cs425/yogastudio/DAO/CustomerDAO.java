/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs425.yogastudio.DAO;

import cs425.yogastudio.entity.Customer;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kokob
 */

public class CustomerDAO {

//    public CustomerDAO() {
//    }
    
   
    private SessionFactory sessionFactory;

 public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
  @Transactional(propagation=Propagation.MANDATORY)
    public void addCustomer(Customer customer){
        
        sessionFactory.getCurrentSession().persist(customer);
        
    }

    @Transactional(propagation=Propagation.MANDATORY)
    public List<Customer> getAll() {
        List<Customer> customers = sessionFactory.getCurrentSession().createQuery("from customer").list();
   
        return customers;
    }

    @Transactional(propagation=Propagation.MANDATORY)
    public void add(Customer customer) {
        sessionFactory.getCurrentSession().persist(customer);
    }

    @Transactional(propagation=Propagation.MANDATORY)
    public Customer get(int id) {
        return (Customer)sessionFactory.getCurrentSession().get(Customer.class, id);
    }

    @Transactional(propagation=Propagation.MANDATORY)
    public void update(int customerId, Customer customer) {
        sessionFactory.getCurrentSession().update(customer);
    }

    @Transactional(propagation=Propagation.MANDATORY)
    public void delete(int customerId) {
        sessionFactory.getCurrentSession().delete(customerId);
    }
    
    
}
