package jpa.server.backend.repositories;

import jpa.server.backend.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import jpa.server.backend.models.Person;

public interface PersonRepository extends CrudRepository<User, Integer> {
  @Query("SELECT person FROM Person person WHERE person.username=:username AND person.password=:password")
  User findPersonByCredentials(@Param("username") String username, @Param("password") String password);
}
