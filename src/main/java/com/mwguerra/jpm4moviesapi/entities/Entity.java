package com.mwguerra.jpm4moviesapi.entities;

import com.mwguerra.jpm4moviesapi.interfaces.IEntity;

import java.util.UUID;

public class Entity implements IEntity {
  private UUID id;

  public void setId(UUID id) {
    this.id = id;
  }

  public UUID getId() {
    return id;
  }
}
