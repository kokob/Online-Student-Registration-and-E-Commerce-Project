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


public class CustomerService {

    public CustomerService() {
    }
    
    
    private CustomerDAO customerDAO;

   public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public List<Customer> getAll() {

        return customerDAO.getAll();
    }

    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public void add(Customer customer) {

        customerDAO.add(customer);
    }

    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public Customer get(int id) {

        return customerDAO.get(id);
    }

    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public void update(int customerId, Customer customer) {

        customerDAO.update(customerId, customer);
    }

    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public void delete(int customerId) {

        customerDAO.delete(customerId);
    }
    
}
