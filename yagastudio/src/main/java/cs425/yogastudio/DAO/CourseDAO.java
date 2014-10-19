/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs425.yogastudio.DAO;

import cs425.yogastudio.entity.Course;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author b
 */
@Transactional(propagation=Propagation.MANDATORY)
public class CourseDAO {

    private SessionFactory sessionFactory;

    public CourseDAO() {
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addCourse(Course course) {

        sessionFactory.getCurrentSession().persist(course);

    }

    public List<Course> getAll() {
        List<Course> courses = sessionFactory.getCurrentSession().createQuery("from Course").list();

        return courses;
    }

    public Course get(int id) {
        return (Course) sessionFactory.getCurrentSession().get(Course.class, id);
    }

    public void update(Course course) {
        sessionFactory.getCurrentSession().update(course);
        sessionFactory.getCurrentSession().flush();
    }

    public void delete(Course course) {
        
        sessionFactory.getCurrentSession().delete(course);
    }

}
