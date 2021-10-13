package com.mwguerra.jpm4moviesapi.http.controllers;

import com.mwguerra.jpm4moviesapi.entities.Movie;
import com.mwguerra.jpm4moviesapi.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/movies")
public class MovieController {
  @Autowired
  private MovieService movieService;

  @GetMapping
  public ResponseEntity<List<Movie>> index() {
    List<Movie> movies = movieService.index();

    return new ResponseEntity<>(movies, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Movie> create(@RequestBody Movie movie) {
    Movie newStudent = movieService.create(movie);

    return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
  }

  @PostMapping("/{id}")
  public ResponseEntity<Movie> show(@PathVariable("id") UUID id) {
    Movie movie = movieService.show(id);

    return new ResponseEntity<>(movie, HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity update(@PathVariable("id") UUID id, @RequestBody Movie movie) {
    movieService.update(id, movie);

    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable("id") UUID id) {
    movieService.delete(id);

    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }
}
