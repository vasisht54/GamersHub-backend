package jpa.server.backend.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import jpa.server.backend.models.GameGroup;

public interface GameGroupRepository extends CrudRepository<GameGroup, Integer> {
  @Query("SELECT gameGroup FROM GameGroup gameGroup where gameGroup.name=:name")
  GameGroup findGameGroupByName(@Param("name") String name);

  @Query(value = "SELECT game_id FROM game_group where group_id=:groupId", nativeQuery = true)
  int findGameIdForGameGroup(@Param("groupId") int id);

}
