/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs425.yogastudio.service;

import cs425.yogastudio.DAO.RoleDAO;
import cs425.yogastudio.entity.Role;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kokob
 */


@Transactional(propagation = Propagation.REQUIRES_NEW)
public class RoleService {

    public RoleService() {
    }
    
    RoleDAO roleDAO;

    @Transactional(propagation = Propagation.SUPPORTS)
    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }
    
     public void addRole(Role role) {
         
         roleDAO.addRole(role);
         
     }
     
      public List<Role> getAll() {
       
        return roleDAO.getAll();
    }

    public Role getRole(int id) {
        
        return roleDAO.getRole(id);
    }
   
    
}
