package com.mwguerra.jpm4moviesapi.validators.movie;

import com.mwguerra.jpm4moviesapi.entities.Movie;
import com.mwguerra.jpm4moviesapi.http.exceptions.MovieAlreadyInDatabaseException;
import com.mwguerra.jpm4moviesapi.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TitleDirectorAndYearShouldBeUnique implements MovieValidator {
  @Autowired
  private MovieRepository movieRepository;

  @Override
  public void handle(Movie movie) {
    if (movieRepository.alreadyHasThisMovie(movie)) {
      throw new MovieAlreadyInDatabaseException();
    }
  }
}
