package com.mwguerra.jpm4moviesapi.database;

import com.mwguerra.jpm4moviesapi.database.tables.MoviesTable;
import org.springframework.stereotype.Component;

@Component
public class Database {
  public MoviesTable movies = new MoviesTable();

  public void seeder() {
  }
}
