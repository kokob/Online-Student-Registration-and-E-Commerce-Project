/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs425.yogastudio.controller;

import cs425.yogastudio.entity.Admin;
import cs425.yogastudio.entity.Customer;
import cs425.yogastudio.entity.OrderLine;
import cs425.yogastudio.entity.Product;
import cs425.yogastudio.entity.ShoppingCart;
import cs425.yogastudio.service.AdminService;
import cs425.yogastudio.service.CustomerService;
import cs425.yogastudio.service.OrderLineService;
import cs425.yogastudio.service.ProductService;
import cs425.yogastudio.service.ShoppingCartService;
import cs425.yogastudio.service.UserService;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.sql.Blob;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.hibernate.Hibernate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.sql.Blob;
import java.sql.SQLException;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author zeriet
 */
@Controller
public class ProductController {

//    public ProductController() {
//    }
    @Resource
    private ProductService productService;
    @Resource
    private AdminService adminService;
    
    @Resource
    private ShoppingCartService shoppingCartService;
    @Resource
    private CustomerService customerService;
    @Resource
    private OrderLineService orderLineService;
    
   

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    public String goToaddProduct(HttpSession session, Model model) {
    
        model.addAttribute("currentCustomer",  session.getAttribute("currentCustomer"));
    
           UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
           
           Admin a1 =(Admin)adminService.findAdminByUserName(userDetails.getUsername());
           session.setAttribute("currentAdmin", a1);
           model.addAttribute("currentAdmin",  session.getAttribute("currenAdmin"));
       
        return "addProduct";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(String productName, String price, String description, Model model,
            HttpSession session, @RequestParam("file") MultipartFile file) {

        double thePrice = Double.parseDouble(price);
        Product newProduct = new Product(productName, thePrice, description);
        
        if (!file.isEmpty()) {
            try {
                newProduct.setProductImage(file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        productService.addProduct(newProduct);
        model.addAttribute("added", newProduct.getProductName());
        session.setAttribute("added", newProduct.getProductName());
        return "redirect:/addProductSuccess";
    }

    @RequestMapping(value = "/productpic/{id}", method = RequestMethod.GET)
    public void getUserImage(Model model, @PathVariable int id, HttpServletResponse response) {
        try {
            Product c = productService.get(id);
            if (c != null) {
                OutputStream out = response.getOutputStream();
                if(c.getProductImage()== null){
                    System.out.println("###################no image");
                }
                out.write(c.getProductImage()); 
                response.flushBuffer();
            }
        } catch (IOException ex) {
            //Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @RequestMapping(value = "/addProductSuccess", method = RequestMethod.GET)
    public String goToAddProductSuccess(Model model, HttpSession session ) {

        model.addAttribute("added", session.getAttribute("added"));
        
        
        
        return "addSuccess";
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getAllProducts(HttpSession session) {
        
       session.setAttribute("products", productService.getAll());

       return "redirect:/toProductList";
    }

    @RequestMapping(value = "/product/delete", method = RequestMethod.POST)
    public String deleteProduct(int productId) {

        Product p1 = productService.get(productId);
        productService.delete(p1);
        return "redirect:/products";
    }
    
@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable int id, HttpSession session) {
        session.setAttribute("product", productService.get(id));
        model.addAttribute("product", productService.get(id)); // 
        
        return "productUpdate";
    }
    
     @RequestMapping(value="/product/{id}", method=RequestMethod.POST)
	public String updateProduct(@PathVariable int id, HttpSession session,String productName, 
            String price, String description) {
            Product product = productService.get(id);
            double thePrice = parseDouble(price);
            product.setPrice(thePrice);
            product.setProductName(productName);
            product.setDescription(description);   
            product.getProductImage();
            productService.update(product);
		return "redirect:/products";
	}
  
        
         @RequestMapping(value = "/searchProducts", method = RequestMethod.POST)
    public String searchProductsByName(String searchText, HttpSession session ){
        
        session.setAttribute("products" , productService.searchProductsByName(searchText));
        
        return "redirect:/toProductList";
    }
    
    @RequestMapping(value = "/toProductList", method = RequestMethod.GET)
    public String getAll(Model model,HttpSession session) {
        
        model.addAttribute("products", session.getAttribute("products"));
        
       return "productList";
    }
    
    
    @RequestMapping(value = "/productDetails/{id}", method = RequestMethod.GET)
    public String goToProductDetail(@PathVariable int id,Model model, HttpSession session) {
      session.setAttribute("currentProduct", productService.get(id));
      model.addAttribute("currentProduct", session.getAttribute("currentProduct"));
        
        return "productDetail";
    }

    
}
