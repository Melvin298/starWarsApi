package com.StarWarsApi.bookApi.service;

import com.StarWarsApi.bookApi.dto.model.SithDto;
import com.StarWarsApi.bookApi.model.Sith;

import java.util.List;
import java.util.Optional;

public interface SithService {

    /**
     * Get jedi by id
     *
     * @param sithId  jedi identifiant
     * @return Jedi find by id
     */
    Optional<Sith> get(long sithId);

    /**
     * Get list of jedis
     *
     * @return list of jedis
     */
    List<Sith> getAll();

    /**
     * Create a new jedi
     *
     * @param sithDto to create
     * @return a new jedi created
     */
    Optional<Sith> create(SithDto sithDto);

    /**
     * Delete jedi by id
     *
     * @param sithId  jedi identifiant
     * @return delete jedi by id
     */
    String delete(long sithId);

    /**
     * Update a existing user
     *
     * @param sithDtoWithUpdate existing jedi object
     * @param existingSithToUpdate jedi dto with informations to update
     * @return Jedi updated
     */
    Optional<Sith> update(Sith existingSithToUpdate,SithDto sithDtoWithUpdate);
}
