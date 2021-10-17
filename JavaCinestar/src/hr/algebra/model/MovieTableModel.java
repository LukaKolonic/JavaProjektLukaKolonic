/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author lukak
 */
public class MovieTableModel extends AbstractTableModel{
    
     private static final String[] COLUMN_NAMES = {"IDMovie", "Title", "Orig Title", "Pub date", "Description",  "Duration", "Year", "Genre",  "Rating", "Poster" ,"Booking", "Date", "Trailer"  };
     
     private List<Movie> movies;

    public MovieTableModel(List<Movie> movies) {
        this.movies = movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
        fireTableDataChanged();
    }
     
     

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex) {
            case 0:
                return Integer.class; 
            case 5:
                return Integer.class; 
            case 6:
                return Integer.class; 
            case 8:
                return Integer.class; 
        }
        return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
    }
    
    
     

    @Override
    public int getRowCount() {
        return movies.size();
    }

    @Override
    public int getColumnCount() {
        return Movie.class.getDeclaredFields().length -4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                return movies.get(rowIndex).getId();
            case 1:
                return movies.get(rowIndex).getTitle();
            case 2:
                return movies.get(rowIndex).getOrigTitle();
            case 3:
                return movies.get(rowIndex).getPubDate().format(Movie.DATE_FORMATTER);
            case 4:
                return movies.get(rowIndex).getDescription();
            case 5:
                return movies.get(rowIndex).getDuration();
            case 6:
                return movies.get(rowIndex).getYear();
            case 7:
                return movies.get(rowIndex).getGenre();
            case 8:
                return movies.get(rowIndex).getRating();
            case 9:
                return movies.get(rowIndex).getPoster();
            case 10:
                return movies.get(rowIndex).getBooking();
            case 11:
                return movies.get(rowIndex).getDate();   
            case 12:
                return movies.get(rowIndex).getTrailer();           
        }
        throw new RuntimeException("No such column.");
    }
    
}
