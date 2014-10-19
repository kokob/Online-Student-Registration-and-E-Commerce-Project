/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs425.yogastudio.service;

import cs425.yogastudio.DAO.CourseDAO;
import cs425.yogastudio.entity.Course;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author b
 */
@Transactional(propagation=Propagation.REQUIRES_NEW)
public class CourseService {

    private CourseDAO courseDAO;

    public CourseService() {
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void setCourseDAO(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    public List<Course> getAll() {

        return courseDAO.getAll();
    }

    public void addCourse(Course course) {

        courseDAO.addCourse(course);
    }

    public Course get(int id) {

        return courseDAO.get(id);
    }

    public void update(Course course) {

        courseDAO.update(course);
    }

    public void delete(int courseId) {

        courseDAO.delete(courseId);
    }

}
