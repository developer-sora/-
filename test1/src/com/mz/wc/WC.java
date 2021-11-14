package com.mz.wc;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WC")
public class WC extends HttpServlet {

   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
     
	   
	   if(!request.getParameterNames().hasMoreElements()) {
	  request.setAttribute("contentPage", "WC/WVS.jsp");}
	   
	   else  {
	   request.setAttribute("contentPage", "WC/Windex.jsp");}
	   request.getRequestDispatcher("index.jsp").forward(request, response);
   

	   request.getRequestDispatcher("index.jsp").forward(request, response);}
   
   
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {

	   
      DataMaker.saveA(request);

      request.setAttribute("contentPage", "WC/WV.jsp");
      
      if (DataMaker.saveA(request) == 1 ) {
         request.setAttribute("contentPage", "WC/WVOutput.jsp");
      }
      
      
      request.getRequestDispatcher("index.jsp").forward(request, response);

   }}
   