/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs425.yogastudio.DAO;

import cs425.yogastudio.entity.Admin;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kokob
 */
@Transactional(propagation = Propagation.MANDATORY)
public class AdminDAO {

    public AdminDAO() {
    }
    
     private SessionFactory sessionFactory; 
    
    
    @Transactional(propagation = Propagation.SUPPORTS)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
     public Admin findAdminByUserName(String userName){
        
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Admin.class);
       
        criteria.add(Restrictions.eq("userName", userName));
    
        return (Admin) criteria.uniqueResult();
         
    }

    public void addAdmin(Admin admin) {
        
        sessionFactory.getCurrentSession().persist(admin);
    
    }
    
    
}
