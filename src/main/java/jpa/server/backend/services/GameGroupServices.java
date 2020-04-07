package jpa.server.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import jpa.server.backend.daos.GameGroupDao;
import jpa.server.backend.models.Game;
import jpa.server.backend.models.GameGroup;
import jpa.server.backend.models.GroupAdmin;
import jpa.server.backend.models.User;
import jpa.server.backend.repositories.GameGroupRepository;

@Service
public class GameGroupServices implements GameGroupDao {

  @Autowired
  GameGroupRepository gameGroupRepository;

  @Override
  public GameGroup createGameGroup(GameGroup gameGroup) {
    return gameGroupRepository.save(gameGroup);
  }

  @Override
  public GameGroup findGameGroupById(Integer gameGroupId) {
    return gameGroupRepository.findById(gameGroupId).get();
  }

  @Override
  public List<GameGroup> findAllGameGroup() {
    Iterable returnedGameGroups = gameGroupRepository.findAll();
    List<GameGroup> listToReturn = new ArrayList<>();

    for (Object gameGroup : returnedGameGroups) {
      listToReturn.add((GameGroup) gameGroup);
    }

    return listToReturn;
  }

  @Override
  public void deleteGameGroup(Integer gameGroupId) {
    gameGroupRepository.deleteById(gameGroupId);
  }

  @Override
  public GameGroup updateGameGroup(GameGroup gameGroup) {
    return gameGroupRepository.save(gameGroup);
  }

//  @Override
//  public List<GameGroup> findGameGroupByGameName(String gameName) {
//    return gameGroupRepository.findGameGroupByGameName(gameName);
//  }

  @Override
  public GroupAdmin getGroupAdmin(GameGroup gameGroup) {
    return gameGroup.getGroupAdmin();
  }

  @Override
  public List<User> getUsersInGroup(GameGroup gameGroup) {
    return gameGroup.getUsersList();
  }
}
