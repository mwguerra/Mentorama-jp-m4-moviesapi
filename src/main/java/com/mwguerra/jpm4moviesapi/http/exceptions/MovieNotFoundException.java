package com.mwguerra.jpm4moviesapi.http.exceptions;

public class MovieNotFoundException extends RuntimeException {
  public MovieNotFoundException() {
    super("Movie not found");
  }

  public MovieNotFoundException(String message) {
    super(message);
  }
}
