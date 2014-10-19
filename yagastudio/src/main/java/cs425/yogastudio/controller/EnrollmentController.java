/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs425.yogastudio.controller;

import cs425.yogastudio.entity.Course;
import cs425.yogastudio.entity.CourseTaken;
import cs425.yogastudio.entity.Customer;
import cs425.yogastudio.entity.Section;
import cs425.yogastudio.entity.Waiver;
import cs425.yogastudio.service.CourseService;
import cs425.yogastudio.service.CustomerService;
import cs425.yogastudio.service.SectionService;
import cs425.yogastudio.service.WaiverService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author b
 */
@Controller
public class EnrollmentController {
    
    @Resource
    CustomerService customerService;
    @Resource
    SectionService sectionService;
    @Resource
    WaiverService waiverService;
    
    @RequestMapping(value = "/enroll/{id}", method = RequestMethod.GET)
    public String enroll(@PathVariable int id, HttpSession session, Model model) {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        
        String view = "enrollSuccess";
        
        UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        
        Customer currentCustomer = customerService.getCustomerByUser(username);
        
        Section section = sectionService.get(id);
        Course course = section.getCourse();
        
        session.setAttribute("section", section);
        session.setAttribute("currentCustomer", currentCustomer);
        
        if(checkPrerequisite(currentCustomer, course)){
            System.out.println("################################seaats Available" + section.getSeatsAvailable());
            if(section.getSeatsAvailable() > 0){
                System.out.println("SeatsAval################################3");
                section.addEnrolled(currentCustomer);
                System.out.println("SeatsAval################################4");
                currentCustomer.setIsEnrolled(true);
                section.setSeatsAvailable(section.getSeatsAvailable() - 1);
                System.out.println("################################seaats Available" + section.getSeatsAvailable());
                sectionService.update(section);
                System.out.println("SeatsAval################################5");
                customerService.update(currentCustomer);
                System.out.println("SeatsAval################################6");
                
                session.setAttribute("seatInavailableMessage", null);
                //model.addAttribute("section", section);
            }else{
                session.setAttribute("seatInavailableMessage", "This Section is full");
                
                view = "addToWaitlist";
            }
        }else{
            
//            session.setAttribute("noPrerequisiteMessage", "You need to take " + course.getPrerequisite().getCourseName() + 
//                    " before taking " + course.getCourseName());
            model.addAttribute("noPrerequisiteMessage", "You need to take " + course.getPrerequisite().getCourseName() + 
                    " before taking " + course.getCourseName());
            view = "requestWaiver";
        }
        return view;
    }
    
//    @RequestMapping(value = "/enrollSuccess", method = RequestMethod.GET)
//    public String toEnrollSuccess(HttpSession session, Model model) {
//        model.addAttribute("seatInavailableMessage", null);
//        model.addAttribute("section", session.getAttribute("section"));
//        return "enrollSuccess";
//    }
//    
//    @RequestMapping(value = "/addToWaitlist", method = RequestMethod.GET)
//    public String toAddToWaitlist(HttpSession session, Model model) {
//        //model.addAttribute("seatInavailableMessage", "This Section is full");
//        model.addAttribute("section", session.getAttribute("section"));
//        model.addAttribute("currentCustomer", session.getAttribute("currentCustomer"));
//        return "addToWaitlist";
//    }
//    
//    @RequestMapping(value = "/requestWaiver", method = RequestMethod.GET)
//    public String toRequestWaiver(HttpSession session, Model model) {
//        model.addAttribute("noPrerequisiteMessage", session.getAttribute("noPrerequisiteMessage"));
//        return "requestWaiver";
//    }
    
    @RequestMapping(value = "/addToWaitlist", method = RequestMethod.GET)
    public String addToWaitlist(HttpSession session, Model model) {
        System.out.println("heeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeer");
        Section theSection = (Section)session.getAttribute("section");
        Customer student = (Customer)session.getAttribute("currentCustomer");
        System.out.println("################heeeeeeeeeeeeeer##################");
        System.out.println("seats#################" + theSection.getSeatsAvailable());
        theSection.getWaitlisted().add(student);
        //theSection.addWaitlisted(student);
        sectionService.update(theSection);
        System.out.println("heeeeeeeeeeeeeer##################");
        
        return "redirect:/viewCourses";
    }

    private boolean checkPrerequisite(Customer currentCustomer, Course course) {
        boolean c = hasPrereq(currentCustomer, course) || isWaived(currentCustomer, course);
        System.out.println("checkpre##################"+c);
        return c;
    }
    
    private boolean hasPrereq(Customer currentCustomer, Course course) {
        List<CourseTaken> listCourseTaken = currentCustomer.getCoursesTaken();
        //System.out.println("listCoursetaken############"+listCourseTaken);
        List<Course> coursesTaken = new ArrayList();
        for(CourseTaken taken : listCourseTaken) {
            coursesTaken.add(taken.getCourse());
        }
//        System.out.println("Coursestaken############"+coursesTaken);
//        System.out.println("hasPrereq############"+coursesTaken.contains(course.getPrerequisite()));
        
        return coursesTaken.contains(course.getPrerequisite());
    }
    
    private boolean isWaived(Customer currentCustomer, Course course) {
        List<Waiver> waivers = waiverService.getWaiversByCustomer(currentCustomer.getId());
        System.out.println("waivers############"+waivers);
        List<Course> waivedCourses = new ArrayList();
        for(Waiver waiver : waivers) {
            if(waiver.isIsApproved()){
                waivedCourses.add(waiver.getCourse());
            }
        }
        
//        System.out.println("Coursestaken############"+waivedCourses);
//        System.out.println("hasPrereq############"+waivedCourses.contains(course.getPrerequisite()));
        
        //return waivedCourses.contains(course.getPrerequisite());
        return true;
    }
    
}
