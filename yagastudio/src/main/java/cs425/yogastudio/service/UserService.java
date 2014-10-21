/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs425.yogastudio.service;

import cs425.yogastudio.DAO.UserDAO;
import cs425.yogastudio.entity.Customer;
import cs425.yogastudio.entity.User;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kokob
 */

@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UserService {

    public UserService() {
    }
    
    private UserDAO userDAO;
    
    @Transactional(propagation = Propagation.SUPPORTS)
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    
   public Customer findCustomerByUserName(String userName){
    
        return userDAO.findCustomerByUserName(userName);
    
   }

    public List<User> getUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }
    
}
