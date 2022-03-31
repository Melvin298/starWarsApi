package com.StarWarsApi.bookApi.repository;

import com.StarWarsApi.bookApi.model.Jedi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Jedi, Long> {
}
