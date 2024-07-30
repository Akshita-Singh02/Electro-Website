/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.learn.mycart.helper;

/**
 *
 * @author akshita
 */
public class Helper {
    
    public static String get10Words(String desc)
    {
        String[] str = desc.split(" ");
        String res="";
        if(str.length>10)
        {
            for(int i=0;i<10;i++)
            {
                res=res+str[i]+" ";
            }
            return (res+"...");
        }
        else
        {
            return (desc+"...");
        }
        
    }
    
}
