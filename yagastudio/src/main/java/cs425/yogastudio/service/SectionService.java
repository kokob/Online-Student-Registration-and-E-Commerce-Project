/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs425.yogastudio.service;

import cs425.yogastudio.DAO.SectionDAO;
import cs425.yogastudio.entity.Section;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author b
 */
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class SectionService {
    
    private SectionDAO sectionDAO;

    @Transactional(propagation = Propagation.SUPPORTS)
    public void setSectionDAO(SectionDAO sectionDAO) {
        this.sectionDAO = sectionDAO;
    }

    public List<Section> getAll() {

        return sectionDAO.getAll();
    }

    public void addSection(Section section) {

        sectionDAO.addSection(section);
    }

    public Section get(int id) {
        return sectionDAO.get(id);
    }

    public void update(Section section) {

        sectionDAO.update(section);
    }

    public void delete(int sectionId) {

        sectionDAO.delete(sectionId);
    }
    
}
