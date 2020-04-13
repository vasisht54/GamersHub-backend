package jpa.server.backend.repositories;

import org.springframework.data.repository.CrudRepository;

import jpa.server.backend.models.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {
}
