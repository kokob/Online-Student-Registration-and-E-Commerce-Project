

package cs425.yogastudio.service;

import cs425.yogastudio.DAO.FacultyDAO;
import cs425.yogastudio.entity.Faculty;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



@Transactional(propagation=Propagation.REQUIRES_NEW)
public class FacultyService {

    public FacultyService() {
    }
    
    
    private FacultyDAO facultyDAO;

   @Transactional(propagation=Propagation.SUPPORTS)
   public void setFacultyDAO(FacultyDAO facultyDAO) {
        this.facultyDAO = facultyDAO;
    }
  
    public List<Faculty> getAll() {

        return facultyDAO.getAll();
    }

    public void add(Faculty faculty) {

        facultyDAO.add(faculty);
    }

    public Faculty get(int id) {

        return facultyDAO.get(id);
    }

    public void update(int facultyId, Faculty faculty) {

        facultyDAO.update(facultyId, faculty);
    }

    public void delete(int facultyId) {

        facultyDAO.delete(facultyId);
    }
    
}
