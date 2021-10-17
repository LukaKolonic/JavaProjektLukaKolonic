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
public class MoviePersonTableModel extends AbstractTableModel{
    
    private List<MoviePerson> moviePerson;
    
    private static final String[] COLUMN_NAMES = { "ID", "Name", "Surname", "PersonType", "Title" };

    public MoviePersonTableModel(List<MoviePerson> moviePerson) {
        this.moviePerson = moviePerson;
    }

    public void setMoviePerson(List<MoviePerson> moviePerson) {
        this.moviePerson = moviePerson;
        fireTableDataChanged();
    }
    
     
    
    @Override
    public int getRowCount() {
        return moviePerson.size();
    }

    @Override
    public int getColumnCount() {
        return MoviePerson.class.getDeclaredFields().length-2; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                return moviePerson.get(rowIndex).getId();
            case 1:
                return moviePerson.get(rowIndex).getPerson().getName();
            case 2:
                return moviePerson.get(rowIndex).getPerson().getSurname();
            case 3:
                return PersonType.from(moviePerson.get(rowIndex).getType().getType());
            case 4:
                return moviePerson.get(rowIndex).getMovie().getTitle();
           
                   
        }
        throw new RuntimeException("No such column!");
    
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
        }
        return super.getColumnClass(columnIndex);
    }
}
