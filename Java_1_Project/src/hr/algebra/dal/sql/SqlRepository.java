/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dal.sql;

import hr.algebra.dal.Repository;
import hr.algebra.model.Movie;
import hr.algebra.model.Person;
import hr.algebra.model.User;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

public class SqlRepository implements Repository {

    //For users
    private static final String USERNAME = "Username";
    private static final String PASSWORD = "Password";
    private static final String ADMIN = "Admin";

    private static final String CHECK_USER = "{ CALL checkUser (?,?) }";
    private static final String CHECK_IF_USERNAME_EXISTS = "{ CALL checkIfUsernameExists (?) }";
    private static final String ADD_USER = "{ CALL addUser (?,?) }";
    private static final String ADD_ADMIN = "{ CALL addAdmin (?) }";
    private static final String SELECT_USER = "{ CALL selectUser (?) }";
    private static final String SELECT_USERS = "{ CALL selectUsers }";
    private static final String DELETE_USER = "{ CALL deleteUser (?) }";

    //For movies
    private static final String ID_MOVIE = "IDMovie";
    private static final String TITLE = "Title";
    private static final String ORIGINAL_TITLE = "OriginalTitle";
    private static final String DESCRIPTION = "Description";
    private static final String LENGTH = "Length";
    private static final String GENRE = "Genre";
    private static final String LINK = "Link";
    private static final String PATH_TO_PICTURE = "PathToPicture";
    private static final String PUBLISHED_DATE = "PublishedDate";
    private static final String ID_PERSON = "IDPerson";
    private static final String NAME = "Name";
    private static final String SURNAME = "Surname";
    private static final String POSITION = "Position";

    private static final String ADD_MOVIE = "{ CALL addMovie (?, ?, ?, ?, ?, ?, ?, ?, ?) }";
    private static final String UPDATE_MOVIE = "{ CALL updateMovie (?, ?, ?, ?, ?, ?, ?, ?, ?) }";
    private static final String ADD_PERSON = "{ CALL addPerson (?, ?, ?, ?) }";
    private static final String SELECT_MOVIES = "{ CALL selectMovies }";
    private static final String SELECT_MOVIE = "{ CALL selectMovie (?) }";
    private static final String SELECT_PERSONS = "{ CALL selectPersons (?)}";
    private static final String DELETE_MOVIES = "{ CALL deleteMovies }";
    private static final String DELETE_MOVIE = "{ CALL deleteMovie(?) }";
    private static final String DELETE_PERSON = "{ CALL deletePerson(?, ?) }";

    @Override
    public Boolean checkUser(User user) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CHECK_USER)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Boolean checkIfUserNameExists(String username) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CHECK_IF_USERNAME_EXISTS)) {

            stmt.setString(1, username);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void addUser(User user) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(ADD_USER)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());

            stmt.executeUpdate();
        }
    }

    @Override
    public User selectUser(String username) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_USER)) {

            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return new User(
                            rs.getString(USERNAME),
                            rs.getString(PASSWORD),
                            rs.getBoolean(ADMIN));
                }
            }
        }
        return null;
    }

    @Override
    public List<Movie> selectMovies() throws Exception {
        List<Movie> movies = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_MOVIES);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                movies.add(new Movie(
                        rs.getInt(ID_MOVIE),
                        rs.getString(TITLE),
                        rs.getString(ORIGINAL_TITLE),
                        rs.getString(DESCRIPTION),
                        rs.getInt(LENGTH),
                        rs.getString(GENRE),
                        rs.getString(LINK),
                        LocalDateTime.parse(rs.getString(PUBLISHED_DATE), Movie.DATE_FORMATTER),
                        rs.getString(PATH_TO_PICTURE)));
            }
            for (Movie movie : movies) {
                CallableStatement cs = con.prepareCall(SELECT_PERSONS);
                cs.setInt(1, movie.getId());

                ResultSet results = cs.executeQuery();

                while (results.next()) {

                    Person person = new Person(
                            results.getInt(ID_PERSON),
                            results.getString(NAME),
                            results.getString(SURNAME),
                            results.getBoolean(POSITION));

                    if (person.isPosition()) {
                        List<Person> directors;
                        if (movie.getDirectors() == null) {
                            directors = new ArrayList<>();
                            directors.add(person);
                            movie.setDirectors(directors);
                        } else {
                            directors = movie.getDirectors();
                            directors.add(person);
                            movie.setDirectors(directors);
                        }
                    } else {
                        List<Person> actors;
                        if (movie.getActors() == null) {
                            actors = new ArrayList<>();
                            actors.add(person);
                            movie.setActors(actors);
                        } else {
                            actors = movie.getActors();
                            actors.add(person);
                            movie.setActors(actors);
                        }
                    }
                }
            }

        }

        return movies;
    }

    @Override
    public void addMovies(List<Movie> movies) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();) {

            for (Movie movie : movies) {
                CallableStatement stmt = con.prepareCall(ADD_MOVIE);
                stmt.setString(1, movie.getTitle());
                stmt.setString(2, movie.getOriginalTitle());
                stmt.setString(3, movie.getDescription());
                stmt.setInt(4, movie.getLength());
                stmt.setString(5, movie.getGenre());
                stmt.setString(6, movie.getLink());
                stmt.setString(7, movie.getPublishedDate().format(Movie.DATE_FORMATTER));
                stmt.setString(8, movie.getPicturePath());
                stmt.registerOutParameter(9, Types.INTEGER);

                stmt.executeUpdate();

                movie.setId(stmt.getInt(9));

                stmt = con.prepareCall(ADD_PERSON);

                if (movie.getActors() != null) {
                    for (Person person : movie.getActors()) {
                        fillStmt(stmt, person, movie);
                    }
                }

                if (movie.getDirectors() != null) {
                    for (Person person : movie.getDirectors()) {
                        fillStmt(stmt, person, movie);

                    }
                }

            }
        }
    }

    private void fillStmt(CallableStatement stmt, Person person, Movie movie) throws SQLException {

        person.setMovieID(movie.getId());

        stmt.setString(1, person.getFirstName());
        stmt.setString(2, person.getLastName());
        stmt.setBoolean(3, person.isPosition());
        stmt.setInt(4, person.getMovieID());

        stmt.executeUpdate();
    }

    @Override
    public void deleteMovies() throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();) {

            CallableStatement stmt = con.prepareCall(DELETE_MOVIES);

            stmt.executeUpdate();
        }
    }

    @Override
    public Movie selectMovie(int selectedMoviesId) throws Exception {

        DataSource dataSource = DataSourceSingleton.getInstance();
        Movie movie = new Movie();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_MOVIE);) {
            stmt.setInt(1, selectedMoviesId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                movie = new Movie(
                        rs.getInt(ID_MOVIE),
                        rs.getString(TITLE),
                        rs.getString(ORIGINAL_TITLE),
                        rs.getString(DESCRIPTION),
                        rs.getInt(LENGTH),
                        rs.getString(GENRE),
                        rs.getString(LINK),
                        LocalDateTime.parse(rs.getString(PUBLISHED_DATE), Movie.DATE_FORMATTER),
                        rs.getString(PATH_TO_PICTURE));
            }
            CallableStatement cs = con.prepareCall(SELECT_PERSONS);
            cs.setInt(1, movie.getId());

            ResultSet results = cs.executeQuery();

            while (results.next()) {

                Person person = new Person(
                        results.getInt(ID_PERSON),
                        results.getString(NAME),
                        results.getString(SURNAME),
                        results.getBoolean(POSITION));

                if (person.isPosition()) {
                    List<Person> directors;
                    if (movie.getDirectors() == null) {
                        directors = new ArrayList<>();
                        directors.add(person);
                        movie.setDirectors(directors);
                    } else {
                        directors = movie.getDirectors();
                        directors.add(person);
                        movie.setDirectors(directors);
                    }
                } else {
                    List<Person> actors;
                    if (movie.getActors() == null) {
                        actors = new ArrayList<>();
                        actors.add(person);
                        movie.setActors(actors);
                    } else {
                        actors = movie.getActors();
                        actors.add(person);
                        movie.setActors(actors);
                    }
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(SqlRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return movie;
    }

    @Override
    public void deleteMovie(int selectedMoviesId) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();) {

            CallableStatement stmt = con.prepareCall(DELETE_MOVIE);

            stmt.setInt(1, selectedMoviesId);

            stmt.executeUpdate();
        }
    }

    @Override
    public void addMovie(Movie movie) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();) {

            CallableStatement stmt = con.prepareCall(ADD_MOVIE);
            stmt.setString(1, movie.getTitle());
            stmt.setString(2, movie.getOriginalTitle());
            stmt.setString(3, movie.getDescription());
            stmt.setInt(4, movie.getLength());
            stmt.setString(5, movie.getGenre());
            stmt.setString(6, movie.getLink());
            stmt.setString(7, movie.getPublishedDate().format(Movie.DATE_FORMATTER));
            stmt.setString(8, movie.getPicturePath());
            stmt.registerOutParameter(9, Types.INTEGER);

            stmt.executeUpdate();

            movie.setId(stmt.getInt(9));

            stmt = con.prepareCall(ADD_PERSON);

            if (movie.getActors() != null) {
                for (Person person : movie.getActors()) {
                    fillStmt(stmt, person, movie);
                }
            }

            if (movie.getDirectors() != null) {
                for (Person person : movie.getDirectors()) {
                    fillStmt(stmt, person, movie);

                }
            }

        }
    }

    @Override
    public void updateMovie(int id, Movie movie) throws Exception {

        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();) {

            CallableStatement stmt = con.prepareCall(UPDATE_MOVIE);
            stmt.setString(1, movie.getTitle());
            stmt.setString(2, movie.getOriginalTitle());
            stmt.setString(3, movie.getDescription());
            stmt.setInt(4, movie.getLength());
            stmt.setString(5, movie.getGenre());
            stmt.setString(6, movie.getLink());
            stmt.setString(7, movie.getPublishedDate().format(Movie.DATE_FORMATTER));
            stmt.setString(8, movie.getPicturePath());
            stmt.setInt(9, id);

            stmt.executeUpdate();
            
            Movie movieFromBase = selectMovie(id);
            
            
            if (isEmpty(movieFromBase.getActors())) {
                for (Person person : movieFromBase.getActors()) {
                    deletePerson(person.getId(), movieFromBase.getId());
                }
            }
            
            if (isEmpty(movieFromBase.getDirectors())) {
                for (Person person : movieFromBase.getDirectors()) {
                    deletePerson(person.getId(), movieFromBase.getId());
                }
            }

            stmt = con.prepareCall(ADD_PERSON);

            if (isEmpty(movie.getActors())) {
                for (Person person : movie.getActors()) {
                    fillStmt(stmt, person, movie);
                }
            }
            if (isEmpty(movieFromBase.getDirectors())) {
                for (Person person : movie.getDirectors()) {
                    fillStmt(stmt, person, movie);
                }
            }
        }
    }

    @Override
    public void deletePerson(int personID, int movieID) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();) {

            CallableStatement stmt = con.prepareCall(DELETE_PERSON);

            stmt.setInt(1, personID);
            stmt.setInt(2, movieID);

            stmt.executeUpdate();
        }
    }

    private boolean isEmpty(List<Person> people) {
        return people != null;
    }

    @Override
    public List<User> selectUsers() throws Exception {
        
        List<User> users = new ArrayList<>();
        
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_USERS)) {

            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    users.add(new User(
                            rs.getString(USERNAME),
                            rs.getString(PASSWORD),
                            rs.getBoolean(ADMIN)));
                }
            }
        }
        return users;
    }

    @Override
    public void addAdmin(String username) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(ADD_ADMIN)) {

            stmt.setString(1, username);

            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteUser(String username) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_USER)) {

            stmt.setString(1, username);
            
            stmt.executeUpdate();
        }
    }
}
