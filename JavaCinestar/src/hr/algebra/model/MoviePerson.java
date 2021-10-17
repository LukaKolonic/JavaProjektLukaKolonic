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
public class MoviePerson {
    private int id;
    private int movieId;
    private int personId;
    private int typeId;
    private PersonType type;
    private Movie movie;
    private Person person;

    public MoviePerson() {
    }

    public MoviePerson(int id, int movieId, int personId, PersonType type) {
        this.id = id;
        this.movieId = movieId;
        this.personId = personId;
        this.type = type;
    }

    public MoviePerson(int movieId, int personId, PersonType type) {
        this.movieId = movieId;
        this.personId = personId;
        this.type = type;
    }

    public MoviePerson(int movieId, int personId, int typeId) {
        this.movieId = movieId;
        this.personId = personId;
        this.typeId = typeId;
    }

    public MoviePerson(int id, Movie movie, Person person, PersonType type) { 
        this.id=id;
        this.movie = movie;
        this.person = person;
        this.type = type;
    }

    public MoviePerson(int id, int movieId, int personId, int typeId, PersonType type, Movie movie, Person person) {
        this.id = id;
        this.movieId = movieId;
        this.personId = personId;
        this.typeId = typeId;
        this.type = type;
        this.movie = movie;
        this.person = person;
    }

    public MoviePerson(int movieId, int personId, int typeId, PersonType type, Movie movie, Person person) {
        this.movieId = movieId;
        this.personId = personId;
        this.typeId = typeId;
        this.type = type;
        this.movie = movie;
        this.person = person;
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

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public PersonType getType() {
        return type;
    }

    public void setType(PersonType type) {
        this.type = type;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
    
    

    @Override
    public String toString() {
        return "MoviePerson{" + "movieId=" + movieId + ", personId=" + personId + ", type=" + type + '}';
    }
    
    
}
