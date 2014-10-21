/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs425.yogastudio.service;

import cs425.yogastudio.DAO.ProductDAO;
import cs425.yogastudio.entity.Product;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author zeriet
 */
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ProductService {

    public ProductService() {
    }

    private ProductDAO productDAO;

    @Transactional(propagation = Propagation.SUPPORTS)

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<Product> getAll() {

        return productDAO.getAll();
    }

    public void addProduct(Product product) {

        productDAO.addProduct(product);
    }

    public Product get(int id) {
        return productDAO.get(id);
    }

    public void update(Product product) {

        productDAO.update(product);
    }

    public void delete(Product product) {

        productDAO.delete(product);
    }

    public List<Product> searchProductsByName(String searchText) {
       
        return productDAO.searchProductsByName(searchText);    
    }
}
