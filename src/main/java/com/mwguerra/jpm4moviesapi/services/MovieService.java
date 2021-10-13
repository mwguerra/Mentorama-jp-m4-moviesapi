package com.mwguerra.jpm4moviesapi.services;

import com.mwguerra.jpm4moviesapi.entities.Movie;
import com.mwguerra.jpm4moviesapi.repositories.MovieRepository;
import com.mwguerra.jpm4moviesapi.validators.movie.MovieValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MovieService {
  @Autowired
  private MovieRepository movieRepository;

  @Autowired
  private List<MovieValidator> movieValidators;

  public List<Movie> index() {
    return movieRepository.all();
  }

  public Movie create(Movie movie) {
    movieValidators.forEach(validator -> validator.handle(movie));

    return movieRepository.create(movie);
  }

  public Movie show(UUID id) {
    return movieRepository.find(id);
  }

  public void update(UUID id, Movie movie) {
    movie.setId(id);

    movieValidators.forEach(validator -> validator.handle(movie));

    movieRepository.update(id, movie);
  }

  public void delete(UUID id) {
    movieRepository.delete(id);
  }
}
