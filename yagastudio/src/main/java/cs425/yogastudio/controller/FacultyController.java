

package cs425.yogastudio.controller;

import cs425.yogastudio.entity.Address;
import cs425.yogastudio.entity.Faculty;
import cs425.yogastudio.service.FacultyService;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class FacultyController {

    public FacultyController() {
    }
  
    @Resource
    private FacultyService facultyService;

    public void setCustomerService(FacultyService facultyService) {
        this.facultyService = facultyService;
    }
    
    
    @RequestMapping(value="/facultySignup",method=RequestMethod.GET)
     public String goToFacultySignUp(){
         
         return "facultySignup";
     }
     
     @RequestMapping(value="/addFaculty", method=RequestMethod.POST)
     public String addFaculty(String firstname, String lastname, String gender, String email,
            String username, String password, String state, String zip, String street, String city, Model model, HttpSession session){
         
         Faculty newFaculty = new Faculty(firstname, lastname, gender, email, username, password);
         Address newAddress = new Address(state, zip, street, city);
         
         newFaculty.addAddress(newAddress);
         facultyService.add(newFaculty);
         model.addAttribute("newFaculty", newFaculty);
         session.setAttribute("newFaculty", newFaculty);
         return "redirect:/signUpSuccess";
     }
     
      @RequestMapping(value="/signUpSuccess",method=RequestMethod.GET)
     public String goToSignUpSuccess(Model model, HttpSession session){
         
         model.addAttribute("newFaculty", session.getAttribute("newFaculty"));
         
         
         return "signUpSuccess";
     }
     
    
}
