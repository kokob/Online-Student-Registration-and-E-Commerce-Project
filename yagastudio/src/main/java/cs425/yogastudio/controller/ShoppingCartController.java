package cs425.yogastudio.controller;

import cs425.yogastudio.entity.Customer;
import cs425.yogastudio.entity.OrderLine;
import cs425.yogastudio.entity.ShoppingCart;
import cs425.yogastudio.entity.Product;
import cs425.yogastudio.service.CustomerService;
import cs425.yogastudio.service.OrderLineService;
import cs425.yogastudio.service.ShoppingCartService;
import cs425.yogastudio.service.ProductService;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShoppingCartController {

    @Resource
    private ShoppingCartService shoppingCartService;
//    
    @Resource
    private CustomerService customerService;

    @Resource 
    private ProductService productService;

    @Resource 
    private OrderLineService orderLineService;
    
    
    
    public ShoppingCartController() {
    }
   

   @RequestMapping(value = "/addToCart/{id}", method = RequestMethod.POST)
    public String addingToCart(@PathVariable int id, int quantity, HttpSession session) {

        UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Customer c1 = (Customer)customerService.getCustomerByUser(userDetails.getUsername());
        ShoppingCart sc1 = c1.getShoppingCart();
        
        Product currentProduct = productService.get(id);
        
        OrderLine o1 = new OrderLine(quantity, currentProduct, sc1);
        
        orderLineService.addOrderLine(o1);
 
        shoppingCartService.update(sc1);
        
        List<OrderLine> currentOrderLines = orderLineService.getAllByCustomerId(c1.getId());
        
        session.setAttribute("currentOrderLines", currentOrderLines);
        double totalPrice = 0.0;
        for(OrderLine ol : currentOrderLines){
            totalPrice += ol.getQuantity() * ol.getProduct().getPrice();
        }
        session.setAttribute("currentShoppingCartPrice",totalPrice );
        
        System.out.println("############################ am here");
         return "redirect:/cartDetails";
         
         
    }
    
    @RequestMapping(value = "/cartDetails" , method = RequestMethod.GET)
    public String goToCartDetails(HttpSession session, Model model){
        
        return "cartDetail";
    }



}
