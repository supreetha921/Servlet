package com.xworkz.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xworkz.register.dao.RegisterDAO;
import com.xworkz.registration.model.RegisterForm;


/**
 * 
 */

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RegisterDAO registerDao;

    public void init() {
        registerDao = new RegisterDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    	 String Name = request.getParameter("Name");
         String qualification = request.getParameter("qualification");
         String place = request.getParameter("username");
         String contact = request.getParameter("password");
         
         RegisterForm register = new RegisterForm();
         register.setName(Name);
         register.setQualification(qualification);
         register.setPlace(place);
         register.setContact(contact);
         

        try {
            registerDao.registration(register);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

       
}
}