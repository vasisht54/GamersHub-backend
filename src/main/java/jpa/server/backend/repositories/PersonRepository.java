package jpa.server.backend.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import jpa.server.backend.models.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {
  @Query("SELECT person FROM Person person WHERE person.username=:username AND person.password=:password")
  Person findPersonByCredentials(@Param("username") String username, @Param("password") String password);
}
