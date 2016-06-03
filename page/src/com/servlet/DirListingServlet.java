package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Filegetter;
import com.Settings;

@WebServlet("/ListingServlet")
public class DirListingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DirListingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DEBUG......");
		Settings.dirPathSelected=request.getParameter("button");
		System.out.println(request.getParameter("button"));
		if(Settings.dirPathSelected==null){
			Settings.dirPathSelected=Settings.musicPath;
		}
		Filegetter.fileLister(Settings.dirPathSelected);
		response.sendRedirect("FileBrowser.jsp");					//same web-page.
		
	}

}
