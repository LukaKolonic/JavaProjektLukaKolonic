/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author lukak
 */

@XmlAccessorType(XmlAccessType.FIELD) 
public class Movie implements Comparable<Movie> {
     public static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
     
    @XmlAttribute 
    private int id;
    private String title;
    @XmlElement(name = "pubdate")
    @XmlJavaTypeAdapter(PublishedDateAdapter.class)
    private LocalDateTime pubDate;
    private String description;
    @XmlElement(name = "origtitle")
    private String origTitle;
    private int duration;
    private int year;
    private String poster;
    private int rating;
    private String booking;
    private String date;
    private String trailer;
    @XmlTransient
    private int genreId;
    @XmlElementWrapper
    @XmlElement(name = "director")
    private List<Person> directors;
     @XmlElementWrapper
    @XmlElement(name = "actor")
    private List<Person> actorss;
    private Genre genre;

    public Movie() {
    }

    public Movie(int id, String title, LocalDateTime pubDate, String description, String origTitle, int duration, int year, String poster, int rating, String booking, String date, String trailer, int genreId) {
        this.id = id;
        this.title = title;
        this.pubDate = pubDate;
        this.description = description;
        this.origTitle = origTitle;
        this.duration = duration;
        this.year = year;
        this.poster = poster;
        this.rating = rating;
        this.booking = booking;
        this.date = date;
        this.trailer = trailer;
        this.genreId = genreId;
    }

    public Movie(String title, LocalDateTime pubDate, String description, String origTitle, int duration, int year, String poster, int rating, String booking, String date, String trailer, int genreId) {
        this.title = title;
        this.pubDate = pubDate;
        this.description = description;
        this.origTitle = origTitle;
        this.duration = duration;
        this.year = year;
        this.poster = poster;
        this.rating = rating;
        this.booking = booking;
        this.date = date;
        this.trailer = trailer;
        this.genreId = genreId;
    }

    public Movie(int id, String title, LocalDateTime pubDate, String description, String origTitle, int duration, int year, String poster, int rating, String booking, String date, String trailer, Genre genre) {
        this.id = id;
        this.title = title;
        this.pubDate = pubDate;
        this.description = description;
        this.origTitle = origTitle;
        this.duration = duration;
        this.year = year;
        this.poster = poster;
        this.rating = rating;
        this.booking = booking;
        this.date = date;
        this.trailer = trailer;
        this.genre = genre;
    }

    public Movie(String title, LocalDateTime pubDate, String description, String origTitle, int duration, int year, String poster, int rating, String booking, String date, String trailer, Genre genre) {
        this.title = title;
        this.pubDate = pubDate;
        this.description = description;
        this.origTitle = origTitle;
        this.duration = duration;
        this.year = year;
        this.poster = poster;
        this.rating = rating;
        this.booking = booking;
        this.date = date;
        this.trailer = trailer;
        this.genre = genre;
    }
    
    
    
    

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getPubDate() {
        return pubDate;
    }

    public void setPubDate(LocalDateTime pubDate) {
        this.pubDate = pubDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrigTitle() {
        return origTitle;
    }

    public void setOrigTitle(String origTitle) {
        this.origTitle = origTitle;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getBooking() {
        return booking;
    }

    public void setBooking(String booking) {
        this.booking = booking;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public List<Person> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Person> directors) {
        this.directors = directors;
    }

    public List<Person> getActorss() {
        return actorss;
    }

    public void setActorss(List<Person> actorss) {
        this.actorss = actorss;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    
    
    

    @Override
    public String toString() {
        return id + "-" + title + "-" + origTitle + "-" + pubDate;
    }

    @Override
    public int compareTo(Movie o) {
         return Integer.valueOf(id).compareTo(o.id);
    }
    
    
    
    
    
}

