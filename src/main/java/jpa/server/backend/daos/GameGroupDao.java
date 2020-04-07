package jpa.server.backend.daos;

import java.util.List;

import jpa.server.backend.models.Game;
import jpa.server.backend.models.GameGroup;
import jpa.server.backend.models.GroupAdmin;
import jpa.server.backend.models.User;

public interface GameGroupDao {
  GameGroup createGameGroup(GameGroup gameGroup);

  GameGroup findGameGroupById(Integer gameGroupId);

  List<GameGroup> findAllGameGroup();

  void deleteGameGroup(Integer gameGroupId);

  GameGroup updateGameGroup(GameGroup gameGroup);

//  List<GameGroup> findGameGroupByGameName(String gameName);

  GroupAdmin getGroupAdmin(GameGroup gameGroup);

  List<User> getUsersInGroup(GameGroup gameGroup);
}
