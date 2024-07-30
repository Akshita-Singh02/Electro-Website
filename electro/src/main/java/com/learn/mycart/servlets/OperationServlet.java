/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.learn.mycart.servlets;

import com.learn.mycart.dao.CategoryDao;
import com.learn.mycart.dao.PrdDao;
import com.learn.mycart.entities.Category;
import com.learn.mycart.entities.Prd;
import com.learn.mycart.helper.FactoryProvider;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.http.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;


/**
 *
 * @author akshita
 */

@MultipartConfig
public class OperationServlet extends HttpServlet implements ServletContextListener {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = getServletContext();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
//            
String op=request.getParameter("operation");
if(op.trim().equals("addcategory"))
{
//            add category
    String title= request.getParameter("catTitle");
           String description= request.getParameter("catDescription");
           Category category =new Category();
           category.setCategoryTitle(title);
           category.setCategoryDescription(description);
           //saving data in db
           CategoryDao cd=new CategoryDao(FactoryProvider.getFactory());
int catId=cd.saveCategory(category);
    HttpSession httpsession = request.getSession();
httpsession.setAttribute("message","category "+title+" added successfully with ID:"+catId);
response.sendRedirect("admin.jsp");
return;
}
else if(op.trim().equals("add product"))
{
//            add product
 String title= request.getParameter("pTitle");
           String description= request.getParameter("pDescription");
           int price=Integer.parseInt(request.getParameter("pPrice"));
           int discount=Integer.parseInt(request.getParameter("pDiscount"));
           int quantity=Integer.parseInt(request.getParameter("pQuantity"));
           String category=request.getParameter("pCategory");
Part part=request.getPart("pPhoto");

    Prd p= new Prd();
    p.setpTitle(title);
    p.setpCategory(category);
    p.setpDesc(description);
    p.setpPrice(price);
    p.setpDiscount(discount);
    p.setpQuantity(quantity);
    p.setpPhoto(part.getSubmittedFileName());
    //save product
PrdDao pdao=new PrdDao(FactoryProvider.getFactory());
//pdao.saveProduct(p);
//save pic
//find path to upload pic
    String path = context.getRealPath("img")+File.separator+"products"+File.separator+part.getSubmittedFileName();
System.out.println(path);
//uploading pic code
try{
FileOutputStream fos=new FileOutputStream(path);
InputStream is=part.getInputStream();
//reading data
byte[] data=new byte[is.available()];
is.read(data);
//writing the data
fos.write(data);
fos.close();
}
catch(Exception e)
{
    e.printStackTrace();
}

//
 HttpSession httpsession = request.getSession();
httpsession.setAttribute("message","product-"+title+" added successfully ");
response.sendRedirect("admin.jsp");
return;
    
    
    
}


           
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
