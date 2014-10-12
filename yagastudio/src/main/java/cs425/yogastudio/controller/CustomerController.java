/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs425.yogastudio.controller;

import cs425.yogastudio.entity.Address;
import cs425.yogastudio.entity.Customer;
import cs425.yogastudio.service.CustomerService;
import javax.annotation.Resource;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author kokob
 */

@Controller
public class CustomerController {

    public CustomerController() {
    }
  
    @Resource
    private CustomerService customerService;

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
    
    
    @RequestMapping(value="/customerSignup",method=RequestMethod.GET)
     public String goToCustomerSignUp(){
         
         return "customerSignup";
     }
     
     @RequestMapping(value="/addCustomer", method=RequestMethod.POST)
     public String addCustomer(String firstname, String lastname, String email,
            String username, String password, String state, String zip, String street, String city, Model model){
         
         Customer newCustomer = new Customer(firstname, lastname, email, username, password);
         Address newAddress = new Address(state, zip, street, city);
         
         newCustomer.addAddress(newAddress);
         customerService.add(newCustomer);
         model.addAttribute("customer", newCustomer);
         
         return "redirect:/signUpSuccess";
     }
     
      @RequestMapping(value="/signUpSuccess",method=RequestMethod.GET)
     public String goToSignUpSuccess(){
         
         return "SignUpSuccess";
     }
     
    
}
