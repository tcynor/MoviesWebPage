package edu.cvtc.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 * 
 * The HomeServlet is the home web page for the Mafia movies site. 
 * It holds code for HTML responses and CSS formatting.  
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		final PrintWriter out = response.getWriter();
		
		final String webApplicationContext = getServletContext().getContextPath();
		
		// NOTES: Writing output message in for HTML page
		out.append("<!doctype html>\n<html>\n<head>\n\t<title>Welcome</title>\n");		
		out.append("\n\t<style> body "
				+ "{ background-color: #A82A2A }\n\t "
				+ "h1 { text-align: center; }\n\t "
				+ "nav { text-align: center; }\n\t "
				+ "h2 { text-align: center; }\n\t "
				+ "h4 { text-align: center; }\n\t "
				+ "p { text-align: center; }\n\t "
				+ "h1 { border-style: solid; }\n\t "
				+ "h1 { border-top-style: none } ");
		
		out.append("\n\t</style>\n</head>\n<body>");	
		
		// NOTES: Site Navigation for Home and Movies
		out.append("\n\t<nav><a href=\"" + webApplicationContext + "/home\">Home</a>"
				+ " - <a href=\"" + webApplicationContext + "/movies\">Movies</a></nav>");		
		
		out.append("\n\t<h1>Welcome to Mafia Territory</h1>");
		out.append("<i><h4>\"Great men are not born great, they grow great\"</h4></i>" +"<center> - Mario Puzo, The Godfather</center>");
		
		out.append("<p><br><br><br><strong>Warning!</strong> You have entered mafia territory, and are about to experience <br>the rise and fallings  "
				+ "from our World's most notorious mafia bosses.</br>");
		out.append("<p>Click on the <i><u>\"Movies\"</u></i> tab to view our top 5 list of movies.</p>");
		
		// NOTES: Copyright signature
		out.append("\n\t<p><br><br>&copy; Copyright 2016 Travis Cynor</p>\n</body>\n</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
