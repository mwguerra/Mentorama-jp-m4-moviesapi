package com.mwguerra.jpm4moviesapi.validators;

public interface Validator<T> {
  void handle(T item);
}
