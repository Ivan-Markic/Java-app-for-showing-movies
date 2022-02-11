/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dal;

import hr.algebra.model.Movie;
import hr.algebra.model.User;
import java.util.List;

/**
 *
 * @author ivanm
 */
public interface Repository {
    
    User selectUser(String username) throws Exception;
    Boolean checkUser(User user) throws Exception;
    Boolean checkIfUserNameExists(String username) throws Exception;
    void addUser(User user) throws Exception;
    public List<Movie> selectMovies() throws Exception;
    public void addMovies(List<Movie> movies) throws Exception;

    public void deleteMovies() throws Exception;

    public Movie selectMovie(int selectedMoviesId) throws Exception;

    public void deleteMovie(int selectedMoviesId) throws Exception;

    public void addMovie(Movie movie) throws Exception;

    public void updateMovie(int id, Movie movie) throws Exception;
    
    public void deletePerson(int personID, int movieID) throws Exception;

    public List<User> selectUsers() throws Exception;

    public void addAdmin(String username) throws Exception;

    public void deleteUser(String username) throws Exception;
}
