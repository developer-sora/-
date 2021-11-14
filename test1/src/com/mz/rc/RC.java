package com.mz.rc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RC")
public class RC extends HttpServlet {
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
   request.setAttribute("contentPage", "RC/RV.jsp");
   request.getRequestDispatcher("index.jsp").forward(request, response);
   
   
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   RM.calc(request);
	   request.setAttribute("contentPage", "RC/RVOutput.jsp");
	   request.getRequestDispatcher("index.jsp").forward(request, response);
   
   }

}

 