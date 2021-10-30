package com.hospital.hospitalexample;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HospitalServlet extends HttpServlet {
	
	public HospitalServlet() {
		System.out.println("object created");
	}

	@Override
	protected void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
      res.setContentType("text/html");
      PrintWriter writer = res.getWriter();
      writer.print("<html>");
      writer.print("<h4>");
      writer.print("<a href='hospitalinfo?name=apollo&founder=prathapc.reddy&estDate=1983&specialisation=multispeciality'>Apollo</a><br>");
      writer.print("<a href='hospitalinfo?name=narayanahealth&founder=devishetty&estDate=2000&specialisation=multispeciality'>NarayanaHealth</a><br>");
      writer.print("<a href='hospitalinfo?name=columbiaasia&founder=nandakumar&estDate=1996&specialisation=multispeciality'>Columbia Asia</a><br>");
      writer.print("<a href='hospitalinfo?name=manipal&founder=TMApai&estDate=1953&specialisation=multispeciality'>Manipal</a>");
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
	
