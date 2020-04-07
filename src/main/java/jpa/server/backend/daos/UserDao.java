package jpa.server.backend.daos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import jpa.server.backend.models.GameGroup;
import jpa.server.backend.models.User;

public interface UserDao {
  //create user
  User createUser(User user);

  //Get list of game groups for user
  List<GameGroup> getUserGroups(Integer userId);


  //find user by id
  User findUserById(Integer userId);

  //find all users
  List<User> findAllUsers();

  void deleteUser(Integer userId);

  User updateUser(User user);

  User findUserByUsername(String username);

}