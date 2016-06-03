package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Filegetter;
import com.MediaList;
import com.Settings;

/**
 * Servlet implementation class SaveFileDestination
 */
@WebServlet("/SaveFileDestination")
public class SaveFileDestination extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveFileDestination() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("THIS IS RUNNING SAVEING TO FILE DESTINATION:	"+MediaList.getdirList().get(0).getPath());
		Settings.musicPath=MediaList.getdirList().get(0).getPath();
		Filegetter.getFilesToList(Settings.musicPath);
		response.sendRedirect("./Music.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
