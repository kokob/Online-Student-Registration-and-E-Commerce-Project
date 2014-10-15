/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs425.yogastudio.service;

import cs425.yogastudio.DAO.CustomerDAO;
import cs425.yogastudio.entity.Customer;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kokob
 */

@Transactional(propagation=Propagation.REQUIRES_NEW)
public class CustomerService {

    public CustomerService() {
    }
    
    
    private CustomerDAO customerDAO;

   @Transactional(propagation=Propagation.SUPPORTS)
   public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
  
    public List<Customer> getAll() {

        return customerDAO.getAll();
    }

    public void addCustomer(Customer customer) {

        customerDAO.addCustomer(customer);
    }

    public Customer get(int id) {

        return customerDAO.get(id);
    }

    public void update(int customerId, Customer customer) {

        customerDAO.update(customerId, customer);
    }

    public void delete(int customerId) {

        customerDAO.delete(customerId);
    }
    
    public Customer findCustomerByName(String firstname){
        
        return customerDAO.findCustomerByName(firstname);
    }
    
}
