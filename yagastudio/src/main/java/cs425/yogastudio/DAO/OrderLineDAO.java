/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs425.yogastudio.DAO;
import cs425.yogastudio.entity.Order;
import cs425.yogastudio.entity.OrderLine;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
public class OrderLineDAO {

    public OrderLineDAO() {
    }
    private SessionFactory sessionFactory;

    @Transactional(propagation = Propagation.SUPPORTS)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addOrderLine(OrderLine orderLine) {
        sessionFactory.getCurrentSession().persist(orderLine);
    }

    public List<OrderLine> getAllByCustomerId(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from OrderLine o where o.shoppingCart.customer.id =:id ");
        
        query.setInteger("id", id);
        
        List<OrderLine> orderLines = query.list();
        
        return orderLines;
    }

    public OrderLine get(int id) {
        return (OrderLine) sessionFactory.getCurrentSession().get(OrderLine.class, id);
    }

    public void update(int orderLineId, OrderLine orderLine) {
        sessionFactory.getCurrentSession().update(orderLine);
    }

    public void delete(int orderLineId) {
        sessionFactory.getCurrentSession().delete(orderLineId);
    }

}