

package cs425.yogastudio.DAO;

import cs425.yogastudio.entity.Faculty;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Transactional(propagation=Propagation.MANDATORY)
public class FacultyDAO {

//    public CustomerDAO() {
//    }
    
   
    private SessionFactory sessionFactory;
@Transactional(propagation=Propagation.SUPPORTS)
 public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
  
    public void addFaculty(Faculty faculty){
        
        sessionFactory.getCurrentSession().persist(faculty);
        
    }

    public List<Faculty> getAll() {
        List<Faculty> faculties = sessionFactory.getCurrentSession().createQuery("from Faculty").list();
   
        return faculties;
    }

    public void add(Faculty faculty) {
        sessionFactory.getCurrentSession().persist(faculty);
    }

    public Faculty get(int id) {
        return (Faculty)sessionFactory.getCurrentSession().get(Faculty.class, id);
    }

    public void update(int facultyId, Faculty faculty) {
        sessionFactory.getCurrentSession().update(faculty);
    }

   
    public void delete(int facultyId) {
        sessionFactory.getCurrentSession().delete(facultyId);
    }
    
    
}


