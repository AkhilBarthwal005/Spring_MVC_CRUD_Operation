package com.curd.operation.DAO;

import com.curd.operation.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    // create product
    public void createProduct(Product product){
        hibernateTemplate.save(product);
    }

    // get All products
    public List<Product> getAllProductDetails(){
        return hibernateTemplate.loadAll(Product.class);
    }

    // delete product
    public boolean deleteProduct(int id){
        Product product = hibernateTemplate.get(Product.class, id);
        if(product!=null){
            hibernateTemplate.delete(product);
            return true;
        }
        return false;
    }

    // update product
    public void updateProductDetails(Product product){
        hibernateTemplate.update(product);
    }





    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
