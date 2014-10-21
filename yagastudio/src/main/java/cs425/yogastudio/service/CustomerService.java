/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs425.yogastudio.service;

import cs425.yogastudio.DAO.CustomerDAO;
import cs425.yogastudio.DAO.RoleDAO;
import cs425.yogastudio.entity.Customer;
import cs425.yogastudio.entity.Role;
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
    
     private RoleDAO roleDAO;
    
    private CustomerDAO customerDAO;

   @Transactional(propagation=Propagation.SUPPORTS)
   public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

   
   
   @Transactional(propagation=Propagation.SUPPORTS)
    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }
   
     
    public List<Customer> getAll() {

        return customerDAO.getAll();
    }

    public void addCustomer(Customer customer) {

        Role roleCustomer = roleDAO.getRoleByRoleName("ROLE_CUSTOMER");
        customer.getRoles().add(roleCustomer);
        customerDAO.addCustomer(customer);
    }

    public Customer get(int id) {

        return customerDAO.get(id);
    }

    public void update(Customer customer) {

        customerDAO.update(customer);
    }

    public void delete(Customer customer) {

        customerDAO.delete(customer);
    }
    
    public Customer findCustomerByName(String firstname){
        
        return customerDAO.findCustomerByName(firstname);
    }
    
    public Customer getCustomerByUser(String username) {
        return customerDAO.getCustomerByUser(username);
    }
    
}
