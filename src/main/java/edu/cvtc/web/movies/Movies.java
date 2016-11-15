package edu.cvtc.web.movies;

/**
 * @author Travis Cynor
 *
 * This class provides information about a movie's title, director and movie length.
 * Also, holds the fields getters, and toString method for output. 
 */
public class Movies {
	
	// NOTES: Initialize Variables
	private String title;
	private String director;
	private String lengthInMinutes;
	
	// NOTES: Constructor for Movies
	public Movies(final String title, final String director, final String lengthInMinutes) {
		super();
		this.title = title;
		this.director = director;
		this.lengthInMinutes = lengthInMinutes;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * @return the lengthInMinutes
	 */
	public String getLengthInMinutes() {
		return lengthInMinutes;
	}
	
	// NOTES: Return output using toString
	@Override
	public String toString() {
		return "Movies [title=" + title + ", director=" + director 
						+ ", lengthInMinutes=" + lengthInMinutes + "]";
	}
	
}
