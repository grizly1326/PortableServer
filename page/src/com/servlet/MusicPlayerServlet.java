package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Settings;

/**
 * Servlet implementation class MusicPlayerServlet
 */
@WebServlet("/MusicPlayerServlet")
public class MusicPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MusicPlayerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Settings.musicSelected=request.getParameter("button");
		response.sendRedirect("Music.jsp");					//same web-page.
		
	}

}
