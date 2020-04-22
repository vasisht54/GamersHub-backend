package jpa.server.backend.services;

import jpa.server.backend.models.Game;
import jpa.server.backend.repositories.GameRepository;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import jpa.server.backend.daos.GameGroupDao;
import jpa.server.backend.models.GameGroup;
import jpa.server.backend.models.User;
import jpa.server.backend.repositories.GameGroupRepository;

@Service
public class GameGroupServices implements GameGroupDao {

  @Autowired
  GameGroupRepository gameGroupRepository;

  @Autowired
  GameService gameService;

  @Autowired
  UserService userService;

  @Override
  public GameGroup createGameGroup(GameGroup gameGroup, int userId, int gameId) {
    User groupAdmin = userService.findUserById(userId);
    List<GameGroup> groupAdminsGroups = groupAdmin.getAdminGroups();

    Game gameForGroup = gameService.findGameById(gameId);
    List<GameGroup> groupsForGame = gameForGroup.getGroupsList();

    gameGroup.setGroupAdmin(groupAdmin);
    gameGroup.setGame(gameForGroup);


    groupAdminsGroups.add(gameGroup);
    groupsForGame.add(gameGroup);
    return gameGroupRepository.save(gameGroup);
  }

  @Override
  public GameGroup findGameGroupById(Integer gameGroupId) {
    try {
      GameGroup gameGroupToReturn = this.gameGroupRepository.findById(gameGroupId).get();
      return gameGroupToReturn;
    }catch (NoSuchElementException e) {
      return new GameGroup();
    }
  }

  @Override
  public List<GameGroup> findAllGameGroups() {
    Iterable returnedGameGroups = gameGroupRepository.findAll();
    List<GameGroup> listToReturn = new ArrayList<>();

    for (Object gameGroup : returnedGameGroups) {
      listToReturn.add((GameGroup) gameGroup);
    }

    return listToReturn;
  }

  @Override
  public int deleteGameGroup(Integer gameGroupId) {

    GameGroup gameGroup = findGameGroupById(gameGroupId);
    List<User> users = findUsersInGroup(gameGroupId);

    for(User u: users) {
      userService.getUserMembershipGroups(u.getId()).remove(gameGroup);
    }

    gameGroupRepository.deleteById(gameGroupId);
    return 1;
  }

  @Override
  public GameGroup updateGameGroup(GameGroup gameGroup, Integer gameId) {
    User groupAdmin = findGameGroupById(gameGroup.getId()).getGroupAdmin();
    Game game = findGameGroupById(gameGroup.getId()).getGame();

    GameGroup gameGroupToUpdate = findGameGroupById(gameId);
    gameGroupToUpdate.setGame(game);
    gameGroupToUpdate.setGroupAdmin(groupAdmin);
    gameGroupToUpdate.setDescription(gameGroup.getDescription());
    gameGroupToUpdate.setName(gameGroup.getName());
    gameGroupToUpdate.setUsersList(gameGroup.getUsersList());
    return gameGroupRepository.save(gameGroupToUpdate);
  }

  @Override
  public List<GameGroup> findGameGroupsByGameName(String gameName){
    Game game = gameService.findGameByName(gameName);
    return game.getGroupsList();
  }

  @Override
  public User getGroupAdmin(Integer gameGroupId) {
    return findGameGroupById(gameGroupId).getGroupAdmin();
  }

  @Override
  public List<User> findUsersInGroup(Integer gameGroupId) {
    GameGroup gameGroup = findGameGroupById(gameGroupId);
    return gameGroup.getUsersList();
  }

  @Override
  public GameGroup addUserToGameGroup(Integer userId, Integer gameGroupId) {
    GameGroup group = findGameGroupById(gameGroupId);
    User user = userService.findUserById(userId);
    user.getMembershipGroups().add(group);
    group.getUsersList().add(user);
    gameGroupRepository.save(group);
    return group;
  }

  @Override
  public int deleteUserFromGroup(Integer userId, Integer gameGroupId) {
    GameGroup group = findGameGroupById(gameGroupId);
    User user = userService.findUserById(userId);
    user.getMembershipGroups().remove(group);
    group.getUsersList().remove(user);
    gameGroupRepository.save(group);
    return 1;
  }

  @Override
  public int findGameIdForGameGroup(int gameGroupId) {
    return gameGroupRepository.findGameIdForGameGroup(gameGroupId);
  }

  @Override
  public GameGroup findGameGroupByName(String name) {
    return gameGroupRepository.findGameGroupByName(name);
  }
}
