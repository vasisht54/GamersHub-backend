package jpa.server.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import jpa.server.backend.models.GameGroup;
import jpa.server.backend.models.GroupAdmin;
import jpa.server.backend.models.User;
import jpa.server.backend.services.GameGroupServices;

@RestController
@CrossOrigin(origins = "*")
public class GameGroupController {

  @Autowired
  private GameGroupServices gameGroupServices;

  @PostMapping("/api/gameGroup")
  public GameGroup createGameGroup(@RequestBody GameGroup gameGroup) {
    return gameGroupServices.createGameGroup(gameGroup);
  }

  @GetMapping("api/gameGroup/{gameGroupId}")
  public GameGroup findGameGroupById(@PathVariable int gameGroupId) {
    return gameGroupServices.findGameGroupById(gameGroupId);
  }

  @GetMapping("api/gameGroups")
  public List<GameGroup> findAllGameGroups() {
    return gameGroupServices.findAllGameGroup();
  }

  @DeleteMapping("api/gameGroup/{gameGroupId}")
  public void deleteGameGroup(@PathVariable int gameGroupId) {
    this.gameGroupServices.deleteGameGroup(gameGroupId);
  }


  @PutMapping("api/gameGroup")
  public GameGroup updateGameGroup(@RequestBody GameGroup gameGroup) {
    return this.updateGameGroup(gameGroup);
  }

//  @GetMapping("api/gameGroup/{gameName}")
//  public List<GameGroup> findGameGroupsByGameName(@PathVariable String gameName) {
//    return gameGroupServices.findGameGroupByGameName(gameName);
//  }

//
//  @Override
//  public GroupAdmin getGroupAdmin(GameGroup gameGroup) {
//    return gameGroup.getGroupAdmin();
//  }
//
//  @Override
//  public List<User> getUsersInGroup(GameGroup gameGroup) {
//    return gameGroup.getUsersList();
//  }
}
