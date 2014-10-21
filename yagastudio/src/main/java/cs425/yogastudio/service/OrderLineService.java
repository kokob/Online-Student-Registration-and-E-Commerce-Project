/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs425.yogastudio.service;


import cs425.yogastudio.DAO.OrderLineDAO;
import cs425.yogastudio.entity.Order;
import cs425.yogastudio.entity.OrderLine;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation=Propagation.REQUIRES_NEW)
public class OrderLineService {

    private OrderLineDAO orderLineDAO;


    public OrderLineService() {
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void setOrderLineDAO(OrderLineDAO orderLineDAO) {
        this.orderLineDAO = orderLineDAO;
    }

    public List<OrderLine> getAllByCustomerId(int id) {

        return orderLineDAO.getAllByCustomerId(id);
    }

    public void addOrderLine(OrderLine orderLine) {

        orderLineDAO.addOrderLine(orderLine);
    }

    public OrderLine get(int id) {

        return orderLineDAO.get(id);
    }

    public void update(int orderLineId, OrderLine orderLine) {

        orderLineDAO.update(orderLineId, orderLine);
    }

    public void delete(int orderLineId) {

        orderLineDAO.delete(orderLineId);
    }

}