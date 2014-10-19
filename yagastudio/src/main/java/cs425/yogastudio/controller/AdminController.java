/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs425.yogastudio.controller;

import cs425.yogastudio.entity.Admin;
import cs425.yogastudio.service.AdminService;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author kokob
 */
@Controller
public class AdminController {

    public AdminController() {
    }
    
    

    @Resource
    private AdminService adminService;

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping(value = "adminSignup", method = RequestMethod.GET)
    public String goToAdminSignUp() {
        return "adminSignup";
    }
    
     @RequestMapping(value="/addAdmin", method=RequestMethod.POST)
     public String addAdmin(String firstname, String lastname, String email,
            String username, String password, Model model, HttpSession session){
         
         Admin newAdmin = new Admin(firstname, lastname, email, username, password);
         
         adminService.addAdmin(newAdmin);
         session.setAttribute("added", newAdmin.getFirstName());
         return "redirect:/signUpSuccess";
     }
     
}
