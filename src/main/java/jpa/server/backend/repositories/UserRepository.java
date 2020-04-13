package jpa.server.backend.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import jpa.server.backend.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {

  @Query("SELECT user FROM User user where user.username=:username")
  User findUserByUsername(@Param("username") String username);
}
