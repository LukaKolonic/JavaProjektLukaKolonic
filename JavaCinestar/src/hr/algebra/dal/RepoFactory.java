/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dal;

import hr.algebra.dal.sql.GenreRepo;
import hr.algebra.dal.sql.MoviePersonRepo;
import hr.algebra.dal.sql.MovieRepo;
import hr.algebra.dal.sql.PersonRepo;
import hr.algebra.dal.sql.UserRepo;

/**
 *
 * @author lukak
 */
public class RepoFactory {

    private RepoFactory() {
    }
    
    public static Repository getMovieRepo() throws Exception {
        return new MovieRepo();
    }
    
    public static Repository getMoviePersonRepo() throws Exception {
        return new MoviePersonRepo();
    }
    public static Repository getPersonRepo() throws Exception {
        return new PersonRepo();
    }
    public static Repository getGenreRepo() throws Exception {
        return new GenreRepo();
    }
    
    public static Repository getUserRepo() throws Exception {
        return new UserRepo();
    }
    
}
