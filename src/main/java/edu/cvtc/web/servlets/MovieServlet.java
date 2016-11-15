package edu.cvtc.web.servlets;

import java.io.File; 
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import edu.cvtc.web.movies.Movies;
import edu.cvtc.web.util.WorkbookUtility;

/**
 * Servlet implementation class MovieServlet
 * 
 * The Movie Servlet is a servlet that holds code for our Movies web page. Including 
 * code for all movie HTML responses and CSS formatting. 
 * We receive movie data from a excel spreadsheet called "MovieLists" and post to the site.
 * 
 */
@WebServlet("/movies")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// NOTES: Create new PrintWriter object for  response
		final PrintWriter out = response.getWriter();
		
		try {
			
			final List<Movies> movie = new ArrayList<>();
			
			// Gets ROOT URL context path
			final String webApplicationContext = getServletContext().getContextPath();
			final String filePath = getServletContext().getRealPath(WorkbookUtility.INPUT_FILE);
			final File file = new File(filePath);
			movie.addAll(WorkbookUtility.retrieveMoviesFromWorkbook(file));
			
			// NOTES: Writing output message in for HTML page
			out.append("<!doctype html>\n<html>\n<head>\n\t<title>Mafia Movies</title>\n");
			
			// CSS Formatting
			out.append("\n\t<style> body "
					+ "{ background-color: #A82A2A; }\n\t "
					+ "h1 { text-align: center; }\n\t "
					+ "nav { text-align: center; }\n\t "
					+ "h2 { text-align: center; }\n\t "
					+ "p { text-align: center; }\n\t "
					+ "h1 { border-style: solid; }\n\t "
					+ "h1 { border-top-style: none } ");
					
			out.append("\n\t</style>\n<body>");	
			
			// NOTES: Site Navigation for Home and Movies
			out.append("\n\t<nav><a href=\"" + webApplicationContext + "/home\">Home</a>"
					+ " - <a href=\"" + webApplicationContext + "/movies\">Movies</a></nav>");
			
			out.append("\n\t<h1>Top Mafia Movies</h1>");
			
			// NOTES: Get response about movies
			for (final Movies movies : movie) {
				
				out.append("\n\t<div class=\"movie\">\n\t\t<h2>" + movies.getTitle() + "</h2>");
				out.append("\n\t\t<p>" + "Director: " + movies.getDirector() + "<br>");
				out.append("Duration: " + movies.getLengthInMinutes());
				out.append(".</p>\n\t</div>");
			}
			
			out.append("\n\t<p><br><br>&copy; Copyright 2016 Travis Cynor</p>\n</body>\n</html>");			
		
		// NOTES: Error checking, catch InvalidformatException and/or fileNotFoundException	
		} catch (InvalidFormatException e) {
			e.printStackTrace();
			out.println("Oops! There was a problem retrieving the list of movies.");
		} catch (FileNotFoundException e) {
			out.println("File Not Found!");		
		}			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
