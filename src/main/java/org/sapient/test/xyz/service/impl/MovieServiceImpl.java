package org.sapient.test.xyz.service.impl;

import org.sapient.test.xyz.entity.Movie;
import org.sapient.test.xyz.repository.MovieRepository;
import org.sapient.test.xyz.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author Sudhanshu Sharma
 * on 11-07-2022
 */
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    /**
     * Get all movies data
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<Movie> getAllMovies() throws Exception {
        List<Movie> movies = movieRepository.findAll();
        return movies;
    }

    /**
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public Movie getMovie(String name) throws Exception {
        return movieRepository.findByName(name);
    }

    /**
     * @param movie
     * @return
     * @throws Exception
     */
    @Override
    public Movie saveMovie(Movie movie) throws Exception {
        return movieRepository.save(movie);
    }

    /**
     * @param movie
     * @return
     * @throws Exception
     */
    @Override
    public Movie updateMovie(String movieId, Movie movie) throws Exception {
        Movie movieEntity = movieRepository.getById(UUID.fromString(movieId));
        if (movieEntity != null) {
            movieEntity.setName(movie.getName());
            movieEntity.setDescription(movie.getDescription());
            movieEntity.setReleaseDate(movie.getReleaseDate());
        }
        return movieRepository.save(movieEntity);
    }

    /**
     * @param movieId
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteMovie(String movieId) throws Exception {
        Movie movie = movieRepository.getById(UUID.fromString(movieId));
        if (movie != null) {
            movieRepository.delete(movie);
            return true;
        }
        return false;
    }


}
