
package cs425.yogastudio.service;

import cs425.yogastudio.DAO.OrderLineDAO;
import cs425.yogastudio.DAO.ProductDAO;
import cs425.yogastudio.DAO.ShoppingCartDAO;
import cs425.yogastudio.entity.ShoppingCart;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Transactional(propagation=Propagation.REQUIRES_NEW)
public class ShoppingCartService {

    private ShoppingCartDAO shoppingCartDAO;
    

    public ShoppingCartService() {
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void setShoppingCartDAO(ShoppingCartDAO shoppingCartDAO) {
        this.shoppingCartDAO = shoppingCartDAO;
    }

    public List<ShoppingCart> getAll() {

        return shoppingCartDAO.getAll();
    }

    public void addShoppingCart(ShoppingCart shoppingCart) {

        shoppingCartDAO.addShoppingCart(shoppingCart);
    }

    public ShoppingCart get(int id) {

        return shoppingCartDAO.get(id);
    }

    public void update(ShoppingCart shoppingCart) {

        shoppingCartDAO.update(shoppingCart);
    }

    public void delete(int shoppingCartId) {

        shoppingCartDAO.delete(shoppingCartId);
    }

}
