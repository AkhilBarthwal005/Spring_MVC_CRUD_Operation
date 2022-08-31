package com.curd.operation.controller;

import com.curd.operation.DAO.ProductDAO;
import com.curd.operation.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping("/")
    public String HomePage(Model model){
        // getting All products
        List<Product> productList = productDAO.getAllProductDetails();
        model.addAttribute("products",productList);
        return "index";
    }

    @RequestMapping("/add-product")
    public String addProduct(){
        return "addProduct";
    }

    @RequestMapping(value = "/product-added" , method = RequestMethod.POST)
    public RedirectView addProductHandler(@ModelAttribute Product product, HttpServletRequest request){
        System.out.println(product);
        // save product to the database
        productDAO.createProduct(product);
        RedirectView redirectView = new RedirectView();
        // get contextPath is used to redirect it to /
        redirectView.setUrl(request.getContextPath() + "/");
        return redirectView;
    }

    @RequestMapping("/product/{product_id}")
    public RedirectView deleteProductHandler(@PathVariable("product_id") int product_id,HttpServletRequest request){
        RedirectView redirectView = new RedirectView();
        // deleting product
        productDAO.deleteProduct(product_id);
        redirectView.setUrl(request.getContextPath() +"/");
        return redirectView;
    }
}
