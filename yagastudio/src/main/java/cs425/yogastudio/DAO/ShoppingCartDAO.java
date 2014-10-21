/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs425.yogastudio.DAO;

import cs425.yogastudio.entity.ShoppingCart;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
public class ShoppingCartDAO {
    

    public ShoppingCartDAO() {
    }
    
    private SessionFactory sessionFactory;

    @Transactional(propagation = Propagation.SUPPORTS)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addShoppingCart(ShoppingCart shoppingCart) {
        sessionFactory.getCurrentSession().persist(shoppingCart);
    }

    public List<ShoppingCart> getAll() {
        List<ShoppingCart> shoppingCarts = sessionFactory.getCurrentSession().createQuery("from ShoppingCart").list();

        return shoppingCarts;
    }

    public ShoppingCart get(int id) {
        return (ShoppingCart) sessionFactory.getCurrentSession().get(ShoppingCart.class, id);
    }

    public void update(ShoppingCart shoppingCart) {
        sessionFactory.getCurrentSession().update(shoppingCart);
    }

    public void delete(int shoppingCartId) {
        sessionFactory.getCurrentSession().delete(shoppingCartId);
    }
    
    

}
