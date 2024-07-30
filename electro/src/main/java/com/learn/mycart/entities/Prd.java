/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.learn.mycart.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 *
 * @author akshita
 */
@Entity
public class Prd {
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(length=10,name="p_pid")
    private int pPid;
    @Column(length=200,name="p_title")
    private String pTitle;
    @Column(length=500,name="p_desc")
    private String pDesc;
    @Column(length=300,name="p_photo")
    private String pPhoto;
    @Column(length=100,name="p_price")
    private int pPrice;
    @Column(length=100,name="p_discount")
    private int pDiscount;
    @Column(length=200,name="p_quantity")
    private int pQuantity;
    @Column(length=200,name="p_category")
    private String pCategory;
    
    
    

    public Prd(String pTitle, String pDesc, String pPhoto, int pPrice, int pDiscount, int pQuantity, String pCategory) {
        this.pTitle = pTitle;
        this.pDesc = pDesc;
        this.pPhoto = pPhoto;
        this.pPrice = pPrice;
        this.pDiscount = pDiscount;
        this.pQuantity = pQuantity;
        this.pCategory = pCategory;
    }

    public Prd(int pPid, String pTitle, String pDesc, String pPhoto, int pPrice, int pDiscount, int pQuantity, String pCategory) {
        this.pPid = pPid;
        this.pTitle = pTitle;
        this.pDesc = pDesc;
        this.pPhoto = pPhoto;
        this.pPrice = pPrice;
        this.pDiscount = pDiscount;
        this.pQuantity = pQuantity;
        this.pCategory = pCategory;
    }

    public Prd() {
    }

    

    public Prd(int pPid, String pTitle, String pDesc, String pPhoto, int pPrice, int pDiscount, int pQuantity) {
        this.pPid = pPid;
        this.pTitle = pTitle;
        this.pDesc = pDesc;
        this.pPhoto = pPhoto;
        this.pPrice = pPrice;
        this.pDiscount = pDiscount;
        this.pQuantity = pQuantity;
      
    }

    public int getpPid() {
        return pPid;
    }

    public void setpPid(int pPid) {
        this.pPid = pPid;
    }

    public String getpTitle() {
        return pTitle;
    }

    public void setpTitle(String pTitle) {
        this.pTitle = pTitle;
    }

    public String getpDesc() {
        return pDesc;
    }

    public void setpDesc(String pDesc) {
        this.pDesc = pDesc;
    }

    public String getpPhoto() {
        return pPhoto;
    }

    public void setpPhoto(String pPhoto) {
        this.pPhoto = pPhoto;
    }

    public int getpPrice() {
        return pPrice;
    }

    public void setpPrice(int pPrice) {
        this.pPrice = pPrice;
    }

    public int getpDiscount() {
        return pDiscount;
    }

    public void setpDiscount(int pDiscount) {
        this.pDiscount = pDiscount;
    }

    public int getpQuantity() {
        return pQuantity;
    }

    public void setpQuantity(int pQuantity) {
        this.pQuantity = pQuantity;
    }

    public String getpCategory() {
        return pCategory;
    }

    public void setpCategory(String pCategory) {
        this.pCategory = pCategory;
    }

   

    @Override
    public String toString() {
        return "Prd{" + "pPid=" + pPid + ", pTitle=" + pTitle + ", pDesc=" + pDesc + ", pPhoto=" + pPhoto + ", pPrice=" + pPrice + ", pDiscount=" + pDiscount + ", pQuantity=" + pQuantity +'}';
    }
    
  //calculate price after discount
    
    public int getPriceAfterDiscount()
    {
        int d=(int)((this.getpDiscount()/100.0)*this.getpPrice());
        return this.getpPrice()-d;
    }
    
    
}
