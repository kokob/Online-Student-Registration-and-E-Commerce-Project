/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs425.yogastudio.DAO;

import cs425.yogastudio.entity.Role;
import java.util.List;
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
public class RoleDAO {

    public RoleDAO() {
    }

    SessionFactory sessionFactory;

    @Transactional(propagation = Propagation.SUPPORTS)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
     public void addRole(Role role) {
        sessionFactory.getCurrentSession().persist(role);
    }
     
      public List<Role> getAll() {
        List<Role> roles = sessionFactory.getCurrentSession().createQuery("from Role").list();
        return roles;
    }

    public Role getRole(int id) {
        return (Role) sessionFactory.getCurrentSession().get(Role.class, id);
    }
    
    public Role getRoleByRoleName(String roleName){
        
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Role.class);
       
        criteria.add(Restrictions.eq("roleName", roleName));
    
        return (Role) criteria.uniqueResult();
    }

}
