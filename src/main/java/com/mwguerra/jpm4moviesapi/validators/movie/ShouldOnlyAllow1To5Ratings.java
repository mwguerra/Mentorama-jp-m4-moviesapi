package com.mwguerra.jpm4moviesapi.validators.movie;

import com.mwguerra.jpm4moviesapi.entities.Movie;
import com.mwguerra.jpm4moviesapi.http.exceptions.ShouldOnlyAllow1To5RatingsException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ShouldOnlyAllow1To5Ratings implements MovieValidator {
  @Override
  public void handle(Movie movie) {
    List<Integer> allowedValues = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

    if (!allowedValues.contains(movie.rating)) {
      throw new ShouldOnlyAllow1To5RatingsException();
    }
  }
}
