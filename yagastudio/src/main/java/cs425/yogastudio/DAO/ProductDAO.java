/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs425.yogastudio.DAO;

import cs425.yogastudio.entity.Product;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author zeriet
 */
@Transactional(propagation = Propagation.MANDATORY)
public class ProductDAO {

    public ProductDAO() {
    }

    private SessionFactory sessionFactory;

    @Transactional(propagation = Propagation.SUPPORTS)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addProduct(Product product) {
        sessionFactory.getCurrentSession().persist(product);
    }

    public List<Product> getAll() {
        List<Product> products = sessionFactory.getCurrentSession().createQuery("from Product").list();

        return products;
    }

    public Product get(int id) {
        return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
    }

    public void update(Product product) {
        sessionFactory.getCurrentSession().update(product);
        sessionFactory.getCurrentSession().flush();
    }

    public void delete(Product product) {
        sessionFactory.getCurrentSession().delete(product);
    }

    public List<Product> searchProductsByName(String searchText) {
        
       Query query = sessionFactory.getCurrentSession().createQuery("select distinct p from Product p where p.productName like :searchText");
       query.setString("searchText", searchText+"%");
       List<Product> products = query.list();
       return products;
    
    }

}
