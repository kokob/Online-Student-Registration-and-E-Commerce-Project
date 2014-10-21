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
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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
public class SectionController {

    @Resource
    SectionService sectionService;
    @Resource
    CourseService courseService;
    @Resource
    FacultyService facultyService;

    @RequestMapping(value = "/createSection", method = RequestMethod.POST)
    public String creatingSection(int selectedCourse, int selectedfaculty, String seatsavailable, Model model, HttpSession session) {
        Course course = courseService.get(selectedCourse);
        
        Faculty faculty = facultyService.get(selectedfaculty);
        int seats = parseInt(seatsavailable);
        Section newSection = new Section(seats,course, faculty);
        sectionService.addSection(newSection);
        return "redirect:/createSection";
    }

    @RequestMapping(value = "/sections", method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("sections", sectionService.getAll());

        return "sectionList";
    }

     // Deleting a section
    @RequestMapping(value = "/section/delete", method = RequestMethod.POST)
    public String deleteSection(int sectionId) {

        Section s1 = sectionService.get(sectionId);
        sectionService.delete(s1);
        return "redirect:/sections";
    }

    // updating a section
    @RequestMapping(value = "/section/{id}", method = RequestMethod.GET)
    public String update(Section section, Faculty faculty, Model model, @PathVariable int id, HttpSession session) {
        //session.setAttribute("section", sectionService.get(id));
        model.addAttribute("section", sectionService.get(id)); 
        model.addAttribute("theFaculties", facultyService.getAll());
        
        return "sectionUpdate";
    }
    @RequestMapping(value = "/section/{id}", method = RequestMethod.POST)
    public String updateSection(Section section, @PathVariable int id, HttpSession session, int selectedfaculty, String seatsAvailable) {
        section.setTeacher(facultyService.get(selectedfaculty));
        int seats2 = parseInt(seatsAvailable);
        section.setSeatsAvailable(seats2);
        sectionService.update(section); 
        return "redirect:/sections";
    }


}
