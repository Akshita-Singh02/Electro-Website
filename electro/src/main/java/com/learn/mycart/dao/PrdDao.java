/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.learn.mycart.dao;

import com.learn.mycart.entities.Prd;
//import jakarta.persistence.Query;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author akshita
 */
public class PrdDao {
    private SessionFactory factory;

    public PrdDao(SessionFactory factory) {
        this.factory = factory;
    }
    
    //save product
    
    public boolean saveProduct(Prd product)
            
    {boolean f=false;
        try{
            Session session = this.factory.openSession();
            Transaction tx = session.beginTransaction();
            session.save(product);
            tx.commit();
            session.close();
            f=true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            f=false;
            
        }
        return f;
        
    }
    
    //getAllProducts
    
    public List<Prd> getAllProducts()
    {
        Session s = this.factory.openSession();
        Query query=s.createQuery("from prd");
        List<Prd> list=query.list();
        return list;
    }
    
    
    //get products by given category
     public List<Prd> getAllProductsById()
    {
        Session s = this.factory.openSession();
        Query query=s.createQuery("from Prd as p where p.category.categoryId =: id");
        query.setParameter("id",cid);
        List<Prd> list=query.list();
        return list;
    }
}
