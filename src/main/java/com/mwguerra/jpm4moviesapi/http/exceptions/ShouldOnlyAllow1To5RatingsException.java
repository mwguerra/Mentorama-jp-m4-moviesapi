package com.mwguerra.jpm4moviesapi.http.exceptions;

public class ShouldOnlyAllow1To5RatingsException extends RuntimeException {
  public ShouldOnlyAllow1To5RatingsException() {
    super("Ratings should be integer numbers from 1 to 5");
  }

  public ShouldOnlyAllow1To5RatingsException(String message) {
    super(message);
  }
}
