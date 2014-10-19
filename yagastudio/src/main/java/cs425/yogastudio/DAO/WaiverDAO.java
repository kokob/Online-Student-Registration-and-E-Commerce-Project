/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs425.yogastudio.DAO;

import cs425.yogastudio.entity.Waiver;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author b
 */
@Transactional(propagation = Propagation.MANDATORY)
public class WaiverDAO {
    
    private SessionFactory sessionFactory;

    public WaiverDAO() {
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addWaiver(Waiver waiver) {
        sessionFactory.getCurrentSession().persist(waiver);
    }

    public List<Waiver> getAll() {
        List<Waiver> waivers = sessionFactory.getCurrentSession().createQuery("from Waiver").list();

        return waivers;
    }

    public Waiver get(int id) {
        return (Waiver) sessionFactory.getCurrentSession().get(Waiver.class, id);
    }

    public void update(Waiver waiver) {
        sessionFactory.getCurrentSession().update(waiver);
    }

    public void delete(int waiverId) {
        sessionFactory.getCurrentSession().delete(waiverId);
    }
    
    public List<Waiver> getWaiversByCustomer(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Waiver w where w.customer.id = :id");
        query.setInteger("id", id);
        List<Waiver> waivers = query.list();
        return waivers;
    }
    
}
