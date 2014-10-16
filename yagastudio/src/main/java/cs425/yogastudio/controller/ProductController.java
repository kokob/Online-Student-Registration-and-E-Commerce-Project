/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs425.yogastudio.controller;

import cs425.yogastudio.entity.Product;
import cs425.yogastudio.service.ProductService;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    public String goToaddProduct() {

        return "addProduct";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(String productName,String price, String description, Model model, HttpSession session) {
       double thePrice = Double.parseDouble(price);
        Product newProduct = new Product(productName, thePrice, description);
        productService.addProduct(newProduct);
        model.addAttribute("added", newProduct.getProductName());
        session.setAttribute("added", newProduct.getProductName());
        return "redirect:/addProductSuccess";
    }
    
     @RequestMapping(value="/addProductSuccess",method=RequestMethod.GET)
     public String goToAddProductSuccess(Model model, HttpSession session){
         
         model.addAttribute("added", session.getAttribute("added"));
         
         
         return "addSuccess";
     }
     
     @RequestMapping(value="/products", method=RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("products", productService.getAll());
               
		return "productList";
	}

}
