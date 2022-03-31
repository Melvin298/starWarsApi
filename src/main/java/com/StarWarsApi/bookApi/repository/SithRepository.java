package com.StarWarsApi.bookApi.repository;

import com.StarWarsApi.bookApi.model.Sith;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SithRepository extends JpaRepository<Sith, Long> {
}
