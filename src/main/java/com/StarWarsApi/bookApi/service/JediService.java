package com.StarWarsApi.bookApi.service;

import com.StarWarsApi.bookApi.dto.model.UserDto;
import com.StarWarsApi.bookApi.model.Jedi;

import java.util.List;
import java.util.Optional;

public interface JediService {

    /**
     * Get jedi by id
     *
     * @param jediId  jedi identifiant
     * @return Jedi find by id
     */
    Optional<Jedi> get(long jediId);

    /**
     * Get list of jedis
     *
     * @return list of jedis
     */
    List<Jedi> getAll();

    /**
     * Create a new jedi
     *
     * @param userDto to create
     * @return a new jedi created
     */
    Optional<Jedi> create(UserDto userDto);

    /**
     * Delete jedi by id
     *
     * @param jediId  jedi identifiant
     * @return delete jedi by id
     */
    String delete(long jediId);

    /**
     * Update a existing user
     *
     * @param existingJediToUpdate existing jedi object
     * @param userDtoWithUpdate jedi dto with informations to update
     * @return Jedi updated
     */
    Optional<Jedi> update(Jedi existingJediToUpdate,UserDto userDtoWithUpdate);
}
