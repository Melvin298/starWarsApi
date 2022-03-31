package com.StarWarsApi.bookApi.service;

import com.StarWarsApi.bookApi.model.Jedi;
import com.StarWarsApi.bookApi.model.Planete;

import java.util.List;
import java.util.Optional;

public interface PlaneteService {
    Optional<Planete> get(long addressId);
    List<Planete> getAll();
    Optional<Planete> create(String name, Jedi addressOwner);
    Optional<Planete> getByOwnerId(long addressOwnerId);
}
