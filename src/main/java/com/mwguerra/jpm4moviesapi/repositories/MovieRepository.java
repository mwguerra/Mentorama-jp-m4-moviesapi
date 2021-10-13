package com.mwguerra.jpm4moviesapi.repositories;

import com.mwguerra.jpm4moviesapi.database.Database;
import com.mwguerra.jpm4moviesapi.entities.Movie;
import com.mwguerra.jpm4moviesapi.http.exceptions.MovieNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Repository
public class MovieRepository {
  @Autowired
  private Database database;

  public List<Movie> all() {
    return database.movies.all();
  }

  public Movie create(Movie movie) {
    return database.movies.create(movie);
  }

  public Movie find(UUID id) {
    return database.movies.find(id);
  }

  public void update(UUID id, Movie movie) {
    Movie response = database.movies.find(id);

    if (response == null) {
      throw new MovieNotFoundException();
    }

    database.movies.update(id, movie);
  }

  public void delete(UUID id) {
    Movie response = database.movies.delete(id);

    if (response == null) {
      throw new MovieNotFoundException();
    }
  }

  public Boolean alreadyHasThisMovie(Movie movie) {
    return database.movies
      .getDatabaseTable()
      .values()
      .stream()
      .anyMatch(item -> {
        return Objects.equals(item.title, movie.title)
          && Objects.equals(item.director, movie.director)
          && Objects.equals(item.year, movie.year);
      });
  }
}
