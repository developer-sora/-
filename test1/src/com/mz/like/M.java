package com.mz.like;

import javax.servlet.http.HttpServletRequest;

public class M {
	
	public static Like reg(HttpServletRequest request) {
		
	String name = request.getParameter("likename");
	System.out.println(name);
	String img = request.getParameter("likeimg");
	System.out.println(img);
	
	
	Like l = new Like(name, img);
	
	return l;
	
}}
