package com.mwguerra.jpm4moviesapi.http.exceptions;

public class MovieAlreadyInDatabaseException extends RuntimeException {
  public MovieAlreadyInDatabaseException() {
    super("Movie already in the database");
  }

  public MovieAlreadyInDatabaseException(String message) {
    super(message);
  }
}
