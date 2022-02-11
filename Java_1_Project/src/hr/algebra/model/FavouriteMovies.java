/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.model;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ivanm
 */
@XmlRootElement(name = "favouritemovies")
@XmlAccessorType(XmlAccessType.FIELD)
public class FavouriteMovies {
    
    @XmlElementWrapper
    @XmlElement(name = "movie")
    private List<Movie> movies;

    public FavouriteMovies() {
    }

    public FavouriteMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
