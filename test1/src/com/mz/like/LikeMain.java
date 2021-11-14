package com.mz.like;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LikeMain")
public class LikeMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		DAO_Like.reg(M.reg(request));
		request.setAttribute("likes",DAO_Like.showAll());
		request.setAttribute("contentPage", "like.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			DAO_Like.delete();
			request.setAttribute("contentPage", "like.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

}
