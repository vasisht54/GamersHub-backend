package jpa.server.backend.repositories;

import org.springframework.data.repository.CrudRepository;

import jpa.server.backend.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
