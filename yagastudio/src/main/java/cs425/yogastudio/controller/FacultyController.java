package cs425.yogastudio.controller;

import cs425.yogastudio.entity.Address;

import cs425.yogastudio.entity.Faculty;
import cs425.yogastudio.service.FacultyService;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "/facultySignup", method = RequestMethod.GET)
    public String goToFacultySignUp() {

        return "facultySignup";
    }

    @RequestMapping(value = "/addFaculty", method = RequestMethod.POST)
    public String addFaculty(String firstname, String lastname, String gender, String email,
            String username, String password, String state, String zip, String street, String city, Model model, HttpSession session) {

        Faculty newFaculty = new Faculty(firstname, lastname, gender, email, username, password);
        Address newAddress = new Address(state, zip, street, city);

        newFaculty.addAddress(newAddress);
        facultyService.add(newFaculty);
        //model.addAttribute("newFaculty", newFaculty);
        session.setAttribute("added", newFaculty.getFirstName());
        return "redirect:/signUpSuccess";
    }

    @RequestMapping(value = "/faculties", method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("faculties", facultyService.getAll());

        return "facultiesList";
    }
  
    @RequestMapping(value = "/faculty/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable int id, HttpSession session) {
        session.setAttribute("faculty", facultyService.get(id));
        model.addAttribute("faculty", facultyService.get(id)); // 

        return "facultyUpdate";
    }

    @RequestMapping(value = "/faculty/{id}", method = RequestMethod.POST)
    public String updateFaculty(@PathVariable int id, HttpSession session, Faculty faculty,
            String firstname, String lastname, String email, String username) {
        
        faculty.setFirstName(firstname);
        faculty.setLastName(lastname);
        faculty.setEmail(email);
        faculty.setUserName(username);
        
       facultyService.update(faculty);
        return "redirect:/faculties";
    }
    

}
