package jpa.server.backend.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import jpa.server.backend.models.Game;

public interface GameRepository extends CrudRepository<Game, Integer> {

  @Query("SELECT game FROM Game game where game.name=:name")
  Game findGameByName(@Param("name") String name);
}
