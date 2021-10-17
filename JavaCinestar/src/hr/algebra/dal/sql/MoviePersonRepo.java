/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dal.sql;

import hr.algebra.dal.RepoFactory;
import hr.algebra.dal.Repository;
import hr.algebra.model.Movie;
import hr.algebra.model.MoviePerson;
import hr.algebra.model.Person;
import hr.algebra.model.PersonType;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;

/**
 *
 * @author lukak
 */
public class MoviePersonRepo implements Repository<MoviePerson> {
    
    private static final String ID_MOVIE_PERSON = "IDMoviePerson";
    private static final String PERSON_ID = "PersonID";
    private static final String MOVIE_ID = "MovieID";
    private static final String PERSON_TYPE = "PersonType";
    
    private static final String CREATE_MOVIE_PERSON = "{ CALL createMoviePerson (?,?,?,?) }";
    private static final String UPDATE_MOVIE_PERSON = "{ CALL updateMoviePerson (?,?,?,?) }";
    private static final String DELETE_MOVIE_PERSON = "{ CALL deleteMoviePerson (?) }";
    private static final String SELECT_MOVIE_PERSON = "{ CALL selectMoviePerson (?) }";
    private static final String SELECT_MOVIE_PERSONS = "{ CALL selectMoviePersons }";
    

    @Override
    public int create(MoviePerson obj) throws Exception {
         DataSource dataSource = DataSourceSingleton.getInstance();
        try(Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_MOVIE_PERSON)) {
            stmt.setInt(1, obj.getPersonId());
            stmt.setInt(2, obj.getMovieId());
            stmt.setInt(3, obj.getTypeId());
            
            stmt.registerOutParameter(4, Types.INTEGER);
            stmt.executeUpdate();
            return stmt.getInt(4);
        }
    }

    @Override
    public void create(List<MoviePerson> persons) throws Exception {
         DataSource dataSource = DataSourceSingleton.getInstance();
        try(Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_MOVIE_PERSON)) {
            
            for (MoviePerson obj : persons) {
            stmt.setInt(1, obj.getPersonId());
            stmt.setInt(2, obj.getMovieId());
            stmt.setInt(3,obj.getTypeId());
            
            stmt.registerOutParameter(4, Types.INTEGER);
                stmt.executeUpdate();
            } 
        }
    }

    @Override
    public void update(int id, MoviePerson data) throws Exception {
         DataSource dataSource = DataSourceSingleton.getInstance();
        try(Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_MOVIE_PERSON)) {
            
            stmt.setInt(1, data.getPersonId());
            stmt.setInt(2, data.getMovieId());
            stmt.setInt(3,data.getType().getType());
            
            stmt.setInt(4, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws Exception {
         DataSource dataSource = DataSourceSingleton.getInstance();
        try(Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_MOVIE_PERSON)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<MoviePerson> select(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try(Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_MOVIE_PERSON)) {

            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()) {
                if(rs.next()) {
                    Optional<Person> person =RepoFactory.getPersonRepo().select(rs.getInt(PERSON_ID));
                    Optional<Movie> movie =RepoFactory.getMovieRepo().select(rs.getInt(MOVIE_ID));
                    
                    
                    return Optional.of(new MoviePerson(
                            rs.getInt(ID_MOVIE_PERSON),
                            rs.getInt(MOVIE_ID),
                            rs.getInt(PERSON_ID),
                            rs.getInt(PERSON_TYPE),
                            PersonType.from(rs.getInt(PERSON_TYPE)),
                            movie.get(),
                            person.get()));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<MoviePerson> select() throws Exception {
        List<MoviePerson> persons = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try(Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_MOVIE_PERSONS);
                ResultSet rs = stmt.executeQuery()) {
            while(rs.next()) {
                
                Optional<Person> person =RepoFactory.getPersonRepo().select(rs.getInt(PERSON_ID));
                Optional<Movie> movie =RepoFactory.getMovieRepo().select(rs.getInt(MOVIE_ID));
                
                persons.add(new MoviePerson(
                        rs.getInt(ID_MOVIE_PERSON),
                        movie.get(),
                        person.get(),
                        PersonType.from(rs.getInt(PERSON_TYPE))));
            }
        }
        return persons;
    }
    
}
