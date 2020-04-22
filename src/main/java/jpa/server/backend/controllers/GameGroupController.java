package jpa.server.backend.controllers;

import jpa.server.backend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import jpa.server.backend.models.GameGroup;
import jpa.server.backend.services.GameGroupServices;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true")
public class GameGroupController {

  @Autowired
  private GameGroupServices gameGroupServices;

  @PostMapping("/api/users/{userId}/games/{gameId}/gameGroups")
  public GameGroup createGameGroup(@RequestBody GameGroup gameGroup, @PathVariable int userId, @PathVariable int gameId) {

    return gameGroupServices.createGameGroup(gameGroup, userId, gameId);
  }

  @GetMapping("api/gameGroups/{gameGroupId}/gameId")
  public int findGameIdByGroupId(@PathVariable("gameGroupId") int gameGroupId) {
    System.out.println("here");
    return gameGroupServices.findGameIdForGameGroup(gameGroupId);
  }

  @GetMapping("api/gameGroups/{gameGroupId:[0-9]+}")
  public GameGroup findGameGroupById(@PathVariable int gameGroupId) {
    return gameGroupServices.findGameGroupById(gameGroupId);
  }

  @GetMapping("api/gameGroups")
  public List<GameGroup> findAllGameGroups() {
    return gameGroupServices.findAllGameGroups();
  }

  @DeleteMapping("api/gameGroups/{gameGroupId}")
  public int deleteGameGroup(@PathVariable int gameGroupId) {
    return this.gameGroupServices.deleteGameGroup(gameGroupId);
  }


  @PutMapping("api/gameGroups/{gameGroupId}")
  public GameGroup updateGameGroup(@RequestBody GameGroup gameGroup, @PathVariable Integer gameGroupId) {
    return gameGroupServices.updateGameGroup(gameGroup, gameGroupId);
  }

  @GetMapping("api/gameGroups/name/{gameName}")
  public List<GameGroup> findGameGroupsByGameName(@PathVariable String gameName) {
    String actualGameName = gameName.replaceAll("%20", " ");
    System.out.println(actualGameName);
    return gameGroupServices.findGameGroupsByGameName(actualGameName);
  }

  @GetMapping("api/gameGroups/{gameGroupId}/groupAdmin")
  public User getGroupAdmin(@PathVariable("gameGroupId") Integer gameGroupId) {
    return gameGroupServices.getGroupAdmin(gameGroupId);
  }

  @GetMapping("api/gameGroups/{gameGroupId}/users")
  public List<User> findUsersInGroup(@PathVariable("gameGroupId") Integer gameGroupId) {
    return gameGroupServices.findUsersInGroup(gameGroupId);
  }

  @PutMapping("api/gameGroups/{gameGroupId}/users/{userId}")
  public GameGroup addUserToGameGroup(@PathVariable("userId") Integer userId, @PathVariable("gameGroupId") Integer gameGroupId) {
    return gameGroupServices.addUserToGameGroup(userId, gameGroupId);
  }

  @DeleteMapping("api/gameGroups/{gameGroupId}/users/{userId}")
  public int deleteUserFromGameGroup(@PathVariable("gameGroupId") Integer gameGroupId, @PathVariable("userId") Integer userId) {
    return gameGroupServices.deleteUserFromGroup(userId, gameGroupId);
  }

  @GetMapping("/api/gameGroups/{gameGroupName:[a-zA-z]+}")
  public GameGroup findGameGroupByName(@PathVariable String gameGroupName) {
    String actualGroupName = gameGroupName.replaceAll("%20", " ");
    return gameGroupServices.findGameGroupByName(actualGroupName);
  }
}
