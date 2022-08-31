package com.curd.operation.DAO;

import com.curd.operation.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ProductDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    // create product or update product
    @Transactional
    public void createProductOrUpdate(Product product){
        hibernateTemplate.saveOrUpdate(product);
    }

    // get All products
    public List<Product> getAllProductDetails(){
        return hibernateTemplate.loadAll(Product.class);
    }

    // delete product
    @Transactional
    public void deleteProduct(int id){
        Product product = hibernateTemplate.get(Product.class, id);
        if(product!=null){
            hibernateTemplate.delete(product);
        }
    }

    public Product getProduct(int id){
        return hibernateTemplate.get(Product.class,id);
    }




    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
