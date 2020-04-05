package jpa.server.backend.repositories;

import org.springframework.data.repository.CrudRepository;

import jpa.server.backend.models.Game;

public interface GameRepository extends CrudRepository<Game, Integer> {
}
