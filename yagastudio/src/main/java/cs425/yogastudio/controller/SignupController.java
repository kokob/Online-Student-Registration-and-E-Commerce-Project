/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs425.yogastudio.controller;

import cs425.yogastudio.entity.Address;
import cs425.yogastudio.entity.Customer;
import cs425.yogastudio.entity.Faculty;
import cs425.yogastudio.service.CustomerService;
import cs425.yogastudio.service.FacultyService;
import cs425.yogastudio.service.UserService;
import java.io.IOException;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author b
 */
@Controller
public class SignupController {

    @Resource
    private CustomerService customerService;

    @Resource
    private FacultyService facultyService;

    @Resource
    private UserService userService;

    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public String addCustomer(String firstname, String lastname, String email,
            String username, String password, String state, String zip, String street,
            String city, Model model, HttpSession session, @RequestParam("file") MultipartFile file) {

        if (checkUsername(username)) {
            session.setAttribute("nonUniqueMessage", null);
            
            Customer newCustomer = new Customer(firstname, lastname, email, username, password);
            Address newAddress = new Address(state, zip, street, city);
//         ShoppingCart shoppingCart = new ShoppingCart(newCustomer);

            
               if (!file.isEmpty()) {
            try {
                newCustomer.setProductImage(file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            
            newCustomer.addAddress(newAddress);
            customerService.addCustomer(newCustomer);
            //model.addAttribute("newcustomer", newCustomer);
            session.setAttribute("added", newCustomer.getFirstName());
            return "redirect:/signUpSuccess";
        } else {
            session.setAttribute("nonUniqueMessage", "username already exists, try another one");
            return "redirect:/customerSignup";
        }

    }

    @RequestMapping(value = "/addFaculty", method = RequestMethod.POST)
    public String addFaculty(String firstname, String lastname, String gender, String email,
            String username, String password, String state, String zip, String street, String city, Model model, HttpSession session) {

        if (checkUsername(username)) {
            
            session.setAttribute("nonUniqueMessage", null);
            
            Faculty newFaculty = new Faculty(firstname, lastname, gender, email, username, password);
            Address newAddress = new Address(state, zip, street, city);

            newFaculty.addAddress(newAddress);
            facultyService.add(newFaculty);
            //model.addAttribute("newFaculty", newFaculty);
            session.setAttribute("added", newFaculty.getFirstName());
            return "redirect:/signUpSuccess";
        }else{
            String msg = "username already exists, try another one";
            session.setAttribute("nonUniqueMessage", msg);
            return "redirect:/customerSignup";
        }

    }

    public boolean checkUsername(String userName) {
        return userService.getUserByUsername(userName).isEmpty();
    }

}
