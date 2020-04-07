package jpa.server.backend.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

import jpa.server.backend.models.GameGroup;

public interface GameGroupRepository extends CrudRepository<GameGroup, Integer> {
//  @Query("SELECT gameGroup FROM GameGroup gameGroup where gameGroup.game.username=:name")
//  List<GameGroup> findGameGroupByGameName(@Param("name") String name);
}
