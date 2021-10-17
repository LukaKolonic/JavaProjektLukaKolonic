/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dal.sql;

import hr.algebra.dal.RepoFactory;
import hr.algebra.model.Movie;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Set;
import javax.sql.DataSource;

/**
 *
 * @author lukak
 */
public class FavouriteMovieRepo {
    
    private static final String CREATE_MOVIE = "{ CALL createFavouriteMovie (?,?) }";
    private static final String DELETE_MOVIES = "{ CALL deleteFavouriteMovies }";
    
     public static void create(Set<Movie> movies) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
          
        try(Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_MOVIE)) {
            
            int genreId = 0;
            for (Movie movie : movies) {
                genreId = RepoFactory.getGenreRepo().create(movie.getGenre());
                
                stmt.setInt(1, movie.getId());
                 
                stmt.registerOutParameter(2, Types.INTEGER);     
                stmt.executeUpdate();
                
              
            }
           
        }
    }
     

    public static void deleteFavMovies() throws SQLException {
        DataSource dataSource = DataSourceSingleton.getInstance();

        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_MOVIES)) {

            stmt.executeUpdate();
        }

    }

}
