package com.mwguerra.jpm4moviesapi.interfaces;

import java.util.List;
import java.util.UUID;

public interface IDatabaseTable<T> {
  List<T> all();
  T create(T item);
  T find(UUID id);
  void update(UUID id, T item);
  T delete(UUID id);
}