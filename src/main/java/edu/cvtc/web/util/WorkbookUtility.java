package edu.cvtc.web.util;

import java.io.File; 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import edu.cvtc.web.movies.Movies;

/**
 * @author TravisCynor
 *
 * This class creates, gathers and outputs from our Excel Workbook file.
 */
public class WorkbookUtility {
	
	public static final String INPUT_FILE = "/assets/MoviesList.xlsx";
	
	public static List<Movies> retrieveMoviesFromWorkbook(final File inputFile) throws InvalidFormatException, IOException {
		
		// NOTES: Create new movies ArrayList
		final List<Movies> movies = new ArrayList<>();
		
		// NOTES: Create new Workbook object from MoviesList.xslx file
		final Workbook workBook = WorkbookFactory.create(inputFile);
		
		// NOTES: Read-in first sheet from Workbook
		final Sheet sheet = workBook.getSheetAt(0);
		
		// NOTES: Gather data from Worksheet
		for (final Row row : sheet ) {
			final Cell titleOfMovieCell = row.getCell(0);
			final Cell directorOfMovieCell = row.getCell(1);
			final Cell lengthOfMovieTimeCell = row.getCell(2);
			
			final Movies movie = new Movies(
					titleOfMovieCell.getStringCellValue().trim(),
					directorOfMovieCell.getStringCellValue().trim(),
					lengthOfMovieTimeCell.getStringCellValue().trim());
					
			
			//NOTES: add each movie to our list of movies
			movies.add(movie);
		}
		
		// NOTES: Output movies list
		return movies;
		
	}

}
