package com.mwguerra.jpm4moviesapi.interfaces;

import java.util.UUID;

public interface IEntity {
  void setId(UUID id);
  UUID getId();
}
