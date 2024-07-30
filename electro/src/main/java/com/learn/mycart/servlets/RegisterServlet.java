/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.learn.mycart.servlets;

import com.learn.mycart.helper.FactoryProvider;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 *
 * @author akshita
 */
public class RegisterServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try{
                String userName=request.getParameter("user_name");
                String userEmail=request.getParameter("user_email");
                String userPassword=request.getParameter("user_password");
                String userPhone=request.getParameter("user_phone");
                String userAddress=request.getParameter("user_address");
                //validation
                if(userName.isEmpty())
                {
                    out.println("Enter name");
                    return;
                }
                
                //creating user object
               com.learn.mycart.entities.User user= new com.learn.mycart.entities.User(userName, userEmail, userPassword, userPhone, "default.jpg", userAddress,"normal");
                //create hibernate session now
                Session hibernateSession=FactoryProvider.getFactory().openSession();
            Transaction tx=hibernateSession.beginTransaction();
           int userId=(int)hibernateSession.save(user);
                hibernateSession.close();
              HttpSession httpsession= request.getSession();
              httpsession.setAttribute("message","Your account is successfully made with user ID:"+userId);
              response.sendRedirect("register.jsp");
              return;
                
            }
            catch(Exception e)
            {
                e.printStackTrace();
                 HttpSession httpsession= request.getSession();
              httpsession.setAttribute("message","Error:"+e);
              response.sendRedirect("register.jsp");
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
