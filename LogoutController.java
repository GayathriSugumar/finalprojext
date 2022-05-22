package com.xworkz.vaccine.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LogoutController extends HttpServlet{

	public LogoutController() {
		System.out.println(this.getClass().getSimpleName()+ "Bean created");
	}
	
	 @RequestMapping("/logout")
	 public String doGet(HttpServletRequest request) {
		 String email=request.getParameter("email");
		 HttpSession session = request.getSession();
		 session.removeAttribute("email");
         session.invalidate();
		return "redirect:/WellcomePage.jsp";
	 
	 }
} 
//	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
//	            throws ServletException, IOException {
//		 HttpSession session = request.getSession(false);
//	        if (session != null) {
//	            session.removeAttribute("email");
//	            session.invalidate();
//	            RequestDispatcher dispatcher = request.getRequestDispatcher("WellcomePage.jsp");
//	            dispatcher.forward(request, response);
//	        }
//
//}

//String email=request.getParameter("email");
//if (email.equals("email")) {
//	HttpSession session=request.getSession();
//	session.setAttribute("email", email);
//	response.setContentType("text/html/jsp");
//} else {
//	response.sendRedirect("WellcomePage.jsp");
//}