/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs425.yogastudio.service;

import cs425.yogastudio.DAO.AdminDAO;
import cs425.yogastudio.DAO.RoleDAO;
import cs425.yogastudio.entity.Admin;
import cs425.yogastudio.entity.Role;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kokob
 */
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class AdminService {

    public AdminService() {
    }
    
      private RoleDAO roleDAO;

      private AdminDAO adminDAO;
    
    @Transactional(propagation = Propagation.SUPPORTS)
    public void setAdminDAO(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }
    
    
    
   public Admin findAdminByUserName(String userName){
    
        return adminDAO.findAdminByUserName(userName);
    
   }

   public void addAdmin(Admin admin) {
       

        Role roleAdmin = roleDAO.getRoleByRoleName("ROLE_ADMIN");
        Role roleCustomer = roleDAO.getRoleByRoleName("ROLE_CUSTOMER");
        Role roleFaculty = roleDAO.getRoleByRoleName("ROLE_FACULTY");
        admin.getRoles().add(roleAdmin);
        admin.getRoles().add(roleCustomer);
        admin.getRoles().add(roleFaculty);
        adminDAO.addAdmin(admin);
    
    }
    
}
