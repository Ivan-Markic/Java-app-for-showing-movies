/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dal.file;

import hr.algebra.model.Movie;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author ivanm
 */
public class FileRepository {
    
    private static final String DIR = "assets";
    private static final Path DIR_PATH = Paths.get(DIR);
    private static final Path MOVIES_PATH = Paths.get(DIR + File.separator + "movies.txt");

    public FileRepository() throws IOException {
        if(!Files.exists(MOVIES_PATH)) {
            Files.createDirectories(DIR_PATH);
            Files.createFile(MOVIES_PATH);
        }
    }
    
    public void writeMovies(List<Movie> movies) throws IOException {
        StringBuilder lines = new StringBuilder();
        movies.forEach(s -> lines.append(s.formatForFileLine() + "\n"));
        
        Files.write(MOVIES_PATH, lines.toString().getBytes());
    }
}
