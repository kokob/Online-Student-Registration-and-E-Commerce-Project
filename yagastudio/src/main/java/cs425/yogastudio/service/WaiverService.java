/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs425.yogastudio.service;

import cs425.yogastudio.DAO.WaiverDAO;
import cs425.yogastudio.entity.Waiver;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author b
 */
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class WaiverService {
    
    private WaiverDAO waiverDAO;

    @Transactional(propagation = Propagation.SUPPORTS)
    public void setWaiverDAO(WaiverDAO waiverDAO) {
        this.waiverDAO = waiverDAO;
    }

    public List<Waiver> getAll() {

        return waiverDAO.getAll();
    }

    public void addWaiver(Waiver waiver) {

        waiverDAO.addWaiver(waiver);
    }

    public Waiver get(int id) {
        return waiverDAO.get(id);
    }

    public void update(Waiver waiver) {

        waiverDAO.update(waiver);
    }

    public void delete(int waiverId) {

        waiverDAO.delete(waiverId);
    }
    
    public List<Waiver> getWaiversByCustomer(int id) {
        return waiverDAO.getWaiversByCustomer(id);
    }
    
}
