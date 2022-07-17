package org.sapient.test.xyz.controller;

import org.sapient.test.xyz.entity.Movie;
import org.sapient.test.xyz.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Sudhanshu Sharma
 */
@RestController
@RequestMapping("api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) throws Exception {
        return ResponseEntity.ok().body(movieService.saveMovie(movie));
    }

    @PutMapping(value = "/{movieId}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Movie> updateMovie(@PathVariable String movieId, @RequestBody Movie movie) throws Exception {
        return ResponseEntity.ok().body(movieService.updateMovie(movieId, movie));
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Movie>> getAllMovies() throws Exception {
        return ResponseEntity.ok().body(movieService.getAllMovies());
    }

    @GetMapping(value = "/{movieId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Movie> getMovie(@PathVariable String movieId) throws Exception {
        return ResponseEntity.ok().body(movieService.getMovie(movieId));
    }

    @DeleteMapping(value = "/{movieId}")
    public ResponseEntity<HttpStatus> deleteMovie(@PathVariable String movieId) throws Exception {
        boolean success = movieService.deleteMovie(movieId);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
}
