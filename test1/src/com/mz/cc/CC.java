package com.mz.cc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/CC")
public class CC extends HttpServlet {
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      
      if (!request.getParameterNames().hasMoreElements()) {
         //파라미터가 없으면 
         request.setAttribute("contentPage", "CC/CV.jsp");
      }else {
         
         CM.calc(request);
         String path = (String) request.getAttribute("path");
         request.setAttribute("contentPage", "CC//"+path);
      }
         request.getRequestDispatcher("index.jsp").forward(request, response);

         
         
      
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
   }

}