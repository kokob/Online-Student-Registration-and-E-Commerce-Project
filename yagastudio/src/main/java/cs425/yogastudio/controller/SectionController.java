/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs425.yogastudio.controller;

import cs425.yogastudio.entity.Course;
import cs425.yogastudio.entity.Faculty;
import cs425.yogastudio.entity.Section;
import cs425.yogastudio.service.CourseService;
import cs425.yogastudio.service.FacultyService;
import cs425.yogastudio.service.SectionService;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
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
public class SectionController {
    
    @Resource
    SectionService sectionService;
    @Resource
    CourseService courseService;
    @Resource
    FacultyService facultyService;
    
    @RequestMapping(value="/createSection", method=RequestMethod.POST)
    public String creatingSection(int selectedcourse, int selectedfaculty, String seatsavailable, Model model, HttpSession session) {
        Course course = courseService.get(selectedcourse);
        Faculty faculty = facultyService.get(selectedfaculty);
        int seats = parseInt(seatsavailable);
        Section newSection = new Section(seats, course, faculty);
        sectionService.addSection(newSection);
        return "redirect:/createSection";
    }
    
}
