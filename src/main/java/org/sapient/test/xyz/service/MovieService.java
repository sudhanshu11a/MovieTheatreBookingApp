package org.sapient.test.xyz.service;

import org.sapient.test.xyz.entity.Movie;

import java.util.List;

/**
 *
 * @author Sudhanshu Sharma
 * on 11-07-2022
 */
public interface MovieService {

    List<Movie> getAllMovies() throws Exception;

    Movie getMovie(String name) throws Exception;

    Movie saveMovie(Movie movie) throws Exception;

    Movie updateMovie(String movieId, Movie movie) throws Exception;

    boolean deleteMovie(String movieId) throws Exception;
}
