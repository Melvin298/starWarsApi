package com.StarWarsApi.bookApi.repository;

import com.StarWarsApi.bookApi.model.Planete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Planete, Long> {
    /**
     * Hibernate function to get Planete by jedi id
     * The request like in sql => SELECT * FROM JEDIS WHERE JEDI_ID = 100
     *
     * @param jediId address owner id
     * @return planete find by owner id
     */
    Optional<Planete> findByUserId(long jediId);
}