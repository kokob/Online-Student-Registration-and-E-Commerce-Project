/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs425.yogastudio.DAO;

import cs425.yogastudio.entity.Section;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author b
 */
@Transactional(propagation = Propagation.MANDATORY)
public class SectionDAO {
    
    private SessionFactory sessionFactory;

    public SectionDAO() {
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addSection(Section section) {
        sessionFactory.getCurrentSession().persist(section);
    }

    public List<Section> getAll() {
        List<Section> sections = sessionFactory.getCurrentSession().createQuery("from Section").list();

        return sections;
    }

    public Section get(int id) {
        return (Section) sessionFactory.getCurrentSession().get(Section.class, id);
    }

    public void update(Section section) {
        sessionFactory.getCurrentSession().update(section);
    }

    public void delete(Section section) {
        sessionFactory.getCurrentSession().delete(section);
    }
    
}
