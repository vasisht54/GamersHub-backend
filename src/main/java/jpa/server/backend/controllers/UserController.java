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

import java.util.List;

import jpa.server.backend.models.GameGroup;
import jpa.server.backend.models.User;
import jpa.server.backend.services.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

  @Autowired
  private UserService userService;

  @DeleteMapping("/api/users/{userId}")
  public void deleteUser(@PathVariable int userId) {
    this.userService.deleteUser(userId);
  }

  @GetMapping("/api/users")
  public List<User> findAllUsers() {
    return userService.findAllUsers();
  }

  @GetMapping("/api/users/{userId}")
  public User findUserById(@PathVariable int userId) {
    return userService.findUserById(userId);
  }

  @PostMapping("/api/users")
  public User createUser(@RequestBody User user) {
    return userService.createUser(user);
  }

  @PutMapping("api/users/{userId}")
  public User updateUser(@RequestBody User user, @PathVariable Integer userId) {
    return userService.updateUser(user, userId);
  }

  @GetMapping("/api/users/{userId}/userGroups")
  public List<GameGroup> getUserGroups(@RequestBody Integer userId) {
    return userService.getUserGroups(userId);
  }

  @GetMapping("/api/users/{username}")
  public User findUserByUsername(@PathVariable String username) {return userService.findUserByUsername(username); }
}
