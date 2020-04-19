package jpa.server.backend.daos;

import org.springframework.data.repository.query.Param;

import java.util.List;

import jpa.server.backend.models.GameGroup;
import jpa.server.backend.models.User;

public interface GameGroupDao {
  GameGroup createGameGroup(GameGroup gameGroup, int userId, int gameId);

  GameGroup findGameGroupById(Integer gameGroupId);

  List<GameGroup> findAllGameGroups();

  void deleteGameGroup(Integer gameGroupId);

  GameGroup updateGameGroup(GameGroup gameGroup, Integer gameId);

  List<GameGroup> findGameGroupsByGameName(String gameName);

  User getGroupAdmin(Integer gameGroupId);

  List<User> findUsersInGroup(Integer gameGroupId);

  GameGroup addUserToGameGroup(Integer userId, Integer gameGroupId);

  int deleteUserFromGroup(Integer userId, Integer gameGroupId);

  GameGroup findGameGroupByName(String name);


}
