/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs425.yogastudio.controller;

import cs425.yogastudio.entity.Course;
import cs425.yogastudio.service.CourseService;
import static java.lang.Integer.parseInt;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author b
 */
@Controller
public class CourseController {
    
    @Resource
    private CourseService courseService;
    
    @RequestMapping(value="/addCourse", method=RequestMethod.POST)
    public String addingCourse(String name, String code, String credit, HttpSession session) {
        int theCredit = parseInt(credit);
        Course course = new Course(name, code, theCredit);
        courseService.addCourse(course);
        session.setAttribute("added", course.getCourseName());
        return "redirect:/addsuccess";
    }
    
    @RequestMapping(value="/addsuccess", method=RequestMethod.GET)
    public String toAddSuccess(Model model) {
        
        return "addSuccess";
    }
    
    @RequestMapping(value="/addCourse", method=RequestMethod.GET)
    public String toAddCourse(Model model, HttpSession session) {
        model.addAttribute("added", session.getAttribute("added"));
        return "addCourse";
    }
    
}