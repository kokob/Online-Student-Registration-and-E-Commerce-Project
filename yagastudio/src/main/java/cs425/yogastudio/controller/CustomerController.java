/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs425.yogastudio.controller;

import cs425.yogastudio.entity.Address;
import cs425.yogastudio.entity.Customer;
import cs425.yogastudio.entity.ShoppingCart;
import cs425.yogastudio.service.CustomerService;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
            String username, String password, String state, String zip, String street, String city, Model model, HttpSession session){
         
         Customer newCustomer = new Customer(firstname, lastname, email, username, password);
         Address newAddress = new Address(state, zip, street, city);
//         ShoppingCart shoppingCart = new ShoppingCart(newCustomer);
         
         newCustomer.addAddress(newAddress);
         customerService.addCustomer(newCustomer);
         //model.addAttribute("newcustomer", newCustomer);
         session.setAttribute("added", newCustomer.getFirstName());
         return "redirect:/signUpSuccess";
     }
     
      @RequestMapping(value="/signUpSuccess",method=RequestMethod.GET)
     public String goToSignUpSuccess(Model model, HttpSession session){
         
         model.addAttribute("added", session.getAttribute("added"));      
         
         return "signUpSuccess";
     }
     
      @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("customers", customerService.getAll());
        return "customerList";
    }
      @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable int id, HttpSession session) {
        session.setAttribute("customer", customerService.get(id));
        model.addAttribute("customer", customerService.get(id)); // 
        
        return "customerUpdate";
    }
    
     @RequestMapping(value="/customer/{id}", method=RequestMethod.POST)
	public String updateCustomer(@PathVariable int id, HttpSession session) {            
		customerService.update((Customer)session.getAttribute("customer"));
		return "redirect:/customers";
	}
        
          @RequestMapping(value = "/customer/delete", method = RequestMethod.POST)
    public String deleteFaculty(int customerId) {

//        Customer c1 = customerService.get(customerId);
        customerService.delete(customerId);
        return "redirect:/customers";
    }
    
}
