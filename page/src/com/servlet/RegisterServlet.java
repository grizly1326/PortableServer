package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ProfileList;
import com.Profile;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(ProfileList.checkIfExist(request.getParameter("fname"),request.getParameter("lname"),request.getParameter("email"))==true){
			response.sendRedirect("");
			System.out.println("INFO: Already in DB.");
		}else{
			ProfileList.addPerson(new Profile(request.getParameter("fname"),request.getParameter("lname"),request.getParameter("email"),0));
			ProfileList.save();
			System.out.println("INFO: Added to DB.");
			response.sendRedirect("");
		}
		
	}

}
