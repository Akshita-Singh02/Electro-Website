/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.learn.mycart.dao;

import com.learn.mycart.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author akshita
 */
public class ProductDao {
    private SessionFactory factory;

    public ProductDao(SessionFactory factory) {
        this.factory = factory;
    }
    
    //save product
    
    public boolean saveProduct(Product product)
            
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
    
    
    
}
