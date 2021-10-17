/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dal.sql;

import hr.algebra.dal.RepoFactory;
import hr.algebra.dal.Repository;
import hr.algebra.model.Genre;
import hr.algebra.model.Movie;
import hr.algebra.model.MoviePerson;
import hr.algebra.model.PersonType;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;


public class MovieRepo implements Repository<Movie> {
    
    private static final String ID_MOVIE = "IDMovie";
    private static final String TITLE = "Title";
    private static final String PUB_DATE = "PubDate";
    private static final String DESCRIPTION = "Description";
    private static final String ORIG_TITLE = "OrigTitle";
    private static final String DURATION = "Duration";
    private static final String YEAR = "Year";
    private static final String POSTER = "Poster";
    private static final String RATING = "Rating";
    private static final String BOOKING="Booking";
    private static final String DATE="Date";
    private static final String TRAILER="Trailer";
    private static final String GENRE_ID = "GenreID";

    private static final String CREATE_MOVIE = "{ CALL createMovie (?,?,?,?,?,?,?,?,?,?,?,?,?) }";
    private static final String UPDATE_MOVIE = "{ CALL updateMovie (?,?,?,?,?,?,?,?,?,?,?,?,?) }";
    private static final String DELETE_MOVIE = "{ CALL deleteMovie (?) }";
    private static final String SELECT_MOVIE = "{ CALL selectMovie (?) }";
    private static final String SELECT_MOVIES = "{ CALL selectMovies }";
    private static final String DELETE_MOVIES = "{ CALL deleteMovies }";
    private static final String SELECT_MOVIE_BY_TITLE = "{ CALL selectMovieByTitle (?) }";

    @Override
    public int create(Movie obj) throws Exception {
        //dohvati konekciju,pripremi upit,izvrsi upit
        DataSource dataSource = DataSourceSingleton.getInstance();
        try(Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_MOVIE)) {
            int genreId = RepoFactory.getGenreRepo().create(obj.getGenre());
            
            stmt.setString(1,obj.getTitle());
            stmt.setString(2, obj.getPubDate().format(Movie.DATE_FORMATTER));
            stmt.setString(3, obj.getDescription());
            stmt.setString(4, obj.getOrigTitle());
            stmt.setInt(5, obj.getDuration());
            stmt.setInt(6, obj.getYear());
            stmt.setString(7, obj.getPoster());
            stmt.setInt(8,obj.getRating());
            stmt.setString(9,obj.getBooking());
            stmt.setString(10, obj.getDate());
            stmt.setString(11,obj.getTrailer());
            stmt.setInt(12, genreId);
            
            stmt.registerOutParameter(13, Types.INTEGER);
        stmt.executeUpdate();
          
        setMoviePerson(obj, stmt);
        return stmt.getInt(13);
        
        }
        
    }
    

    @Override
    public void create(List<Movie> movies) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try(Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_MOVIE)) {
            
            for (Movie obj : movies) {
            int genreId = RepoFactory.getGenreRepo().create(obj.getGenre());
            
            stmt.setString(1,obj.getTitle());
            stmt.setString(2, obj.getPubDate().format(Movie.DATE_FORMATTER));
            stmt.setString(3, obj.getDescription());
            stmt.setString(4, obj.getOrigTitle());
            stmt.setInt(5, obj.getDuration());
            stmt.setInt(6, obj.getYear());
            stmt.setString(7, obj.getPoster());
            stmt.setInt(8,obj.getRating());
            stmt.setString(9,obj.getBooking());
            stmt.setString(10, obj.getDate());
            stmt.setString(11,obj.getTrailer());
            stmt.setInt(12, genreId);
            
            stmt.registerOutParameter(13, Types.INTEGER);
            stmt.executeUpdate();
        
            setMoviePerson(obj, stmt);
             
            }
            
        }
        
    }

    @Override
    public void update(int id, Movie obj) throws Exception {
         DataSource dataSource = DataSourceSingleton.getInstance();
        try(Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_MOVIE)) {
            
             int genreId = RepoFactory.getGenreRepo().create(obj.getGenre());
            stmt.setString(1,obj.getTitle());
            stmt.setString(2, obj.getPubDate().format(Movie.DATE_FORMATTER));
            stmt.setString(3, obj.getDescription());
            stmt.setString(4, obj.getOrigTitle());
            stmt.setInt(5, obj.getDuration());
            stmt.setInt(6, obj.getYear());
            stmt.setString(7, obj.getPoster());
            stmt.setInt(8,obj.getRating());
            stmt.setString(9,obj.getBooking());
            stmt.setString(10, obj.getDate());
            stmt.setString(11,obj.getTrailer());
            stmt.setInt(12, genreId);
            
             stmt.setInt(13, id);
        stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws Exception {
          DataSource dataSource = DataSourceSingleton.getInstance();
        try(Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_MOVIE)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<Movie> select(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try(Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_MOVIE)) {

            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()) {
                if(rs.next()) {
                    Optional<Genre> genre = RepoFactory.getGenreRepo().select(rs.getInt(GENRE_ID));
                    
                      return Optional.of(new Movie(
                            rs.getInt(ID_MOVIE),
                            rs.getString(TITLE), 
                            LocalDateTime.parse(rs.getString(PUB_DATE), Movie.DATE_FORMATTER), 
                            rs.getString(DESCRIPTION), 
                            rs.getString(ORIG_TITLE),
                            rs.getInt(DURATION), 
                            rs.getInt(YEAR),
                            rs.getString(POSTER),
                            rs.getInt(RATING),
                            rs.getString(BOOKING),
                            rs.getString(DATE),
                            rs.getString(TRAILER),
                            genre.get()));
                }
            }
        }
        return Optional.empty();
                
    }

    @Override
    public List<Movie> select() throws Exception {
        List<Movie> movies = new ArrayList<>();
        
        DataSource dataSource = DataSourceSingleton.getInstance();
        try(Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_MOVIES);
                ResultSet rs = stmt.executeQuery()) {
            while(rs.next()) {
               
                 Optional<Genre> genre = RepoFactory.getGenreRepo().select(rs.getInt(GENRE_ID));
                
                movies.add(new Movie( rs.getInt(ID_MOVIE),
                            rs.getString(TITLE), 
                            LocalDateTime.parse(rs.getString(PUB_DATE), Movie.DATE_FORMATTER), 
                            rs.getString(DESCRIPTION), 
                            rs.getString(ORIG_TITLE),
                            rs.getInt(DURATION), 
                            rs.getInt(YEAR),
                            rs.getString(POSTER),
                            rs.getInt(RATING),
                            rs.getString(BOOKING),
                            rs.getString(DATE),
                            rs.getString(TRAILER),
                            genre.get()));
                        
            }
        }
        return movies;
    }

     public static void deleteMovies() throws SQLException {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try(Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_MOVIES)) {

            stmt.executeUpdate();
        }
    }

    private void setMoviePerson(Movie movie, CallableStatement stmt) {
        if(movie.getDirectors() != null){
            movie.getDirectors().forEach(d -> {
                try {
                    int personId = RepoFactory.getPersonRepo().create(d);
                    int movieId = stmt.getInt(13);
                    MoviePerson moviePerson = new MoviePerson(movieId, personId,PersonType.DIRECTOR);
                    RepoFactory.getMoviePersonRepo().create(moviePerson); 
                } catch (Exception ex) {
                    Logger.getLogger(MovieRepo.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }
        
        if(movie.getActorss() != null){
            movie.getActorss().forEach(a -> {
                try {
                    int personId = RepoFactory.getPersonRepo().create(a);
                    int movieId = stmt.getInt(13);
                    MoviePerson moviePerson = new MoviePerson(movieId, personId, PersonType.ACTOR);
                    RepoFactory.getMoviePersonRepo().create(moviePerson); 
                } catch (Exception ex) {
                    Logger.getLogger(MovieRepo.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }
    
   
    }
    
    public static Optional<Movie> selectMovieByTitle(String title) throws SQLException, Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try(Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_MOVIE_BY_TITLE)) {

            stmt.setString(1, title);
            try(ResultSet rs = stmt.executeQuery()) {
                if(rs.next()) {
                    Optional<Genre> genre = RepoFactory.getGenreRepo().select(rs.getInt(GENRE_ID));
                    
                      return Optional.of(new Movie(
                            rs.getInt(ID_MOVIE),
                            rs.getString(TITLE), 
                            LocalDateTime.parse(rs.getString(PUB_DATE), Movie.DATE_FORMATTER), 
                            rs.getString(DESCRIPTION), 
                            rs.getString(ORIG_TITLE),
                            rs.getInt(DURATION), 
                            rs.getInt(YEAR),
                            rs.getString(POSTER),
                            rs.getInt(RATING),
                            rs.getString(BOOKING),
                            rs.getString(DATE),
                            rs.getString(TRAILER),
                            genre.get()));
                }
            }
        }
        return Optional.empty();
                
    }
    
}
