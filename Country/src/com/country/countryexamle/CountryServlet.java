package com.country.countryexamle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountryServlet extends HttpServlet{
	public CountryServlet() {
		System.out.println("object created");
	}

	@Override
	protected void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
      res.setContentType("text/html");
      PrintWriter writer = res.getWriter();
      writer.print("<html>");
      writer.print("<h4>");
      writer.print("<a href='countryinfo?name=India&popoulation=138crore&capital=Delhi&primeminister=NarendraModi'>India</a>");
      
      writer.print("</h4>");
      
      writer.print("<h1>");
      Enumeration parameters = req.getParameterNames();
      String value=null;
      while(parameters.hasMoreElements()) {
    	  value = (String) parameters.nextElement();
    	  writer.print(req.getParameter(value));
    	  writer.print("<br>");
    	  
      }
      writer.print("</h1>");
      writer.print("</html>");
	}	

	

}

