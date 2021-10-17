/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.model;

/**
 *
 * @author lukak
 */
public class FavouriteMovie {
    private int id;
    private int movieId;
    private Movie movie;

    public FavouriteMovie() {
    }

    public FavouriteMovie(int id, int movieId) {
        this.id = id;
        this.movieId = movieId;
    }

    public FavouriteMovie(int movieId) {
        this.movieId = movieId;
    }

    public int getId() {
        return id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }     
}
