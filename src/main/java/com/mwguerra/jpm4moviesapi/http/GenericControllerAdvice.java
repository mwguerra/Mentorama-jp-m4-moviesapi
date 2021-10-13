package com.mwguerra.jpm4moviesapi.http;

import com.mwguerra.jpm4moviesapi.http.exceptions.MovieNotFoundException;
import com.mwguerra.jpm4moviesapi.http.exceptions.ShouldOnlyAllow1To5RatingsException;
import com.mwguerra.jpm4moviesapi.http.exceptions.MovieAlreadyInDatabaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericControllerAdvice {
  Logger logger = LoggerFactory.getLogger(GenericControllerAdvice.class);

  @ExceptionHandler({ShouldOnlyAllow1To5RatingsException.class})
  public ResponseEntity<String> ShouldOnlyAllow1To5Ratings (final ShouldOnlyAllow1To5RatingsException e) {
    logger.error(e.getMessage());
    return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler({MovieAlreadyInDatabaseException.class})
  public ResponseEntity<String> MovieAlreadyInDatabase (final MovieAlreadyInDatabaseException e) {
    logger.error(e.getMessage());
    return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler({MovieNotFoundException.class})
  public ResponseEntity<String> MovieNotFound (final MovieNotFoundException e) {
    logger.error(e.getMessage());
    return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
  }
}
