/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs425.yogastudio.controller;

import cs425.yogastudio.entity.Customer;
import cs425.yogastudio.service.UserService;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author kokob
 */

@Controller
public class UserController {
    
    @Resource
    private UserService userService;
    
     public void setUserService(UserService userService) {
        this.userService = userService;
    }
    
     
}
