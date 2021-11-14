package com.mz.cc;

import javax.servlet.http.HttpServletRequest;

public class CM {

   public static void calc(HttpServletRequest request) {
      // TODO Auto-generated method stub
      String food = request.getParameter("food");
      String path = food+"//"+food+".jsp"; 
      request.setAttribute("path", path);
   }

}