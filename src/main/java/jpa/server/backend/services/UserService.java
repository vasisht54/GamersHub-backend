package jpa.server.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import jpa.server.backend.daos.UserDao;
import jpa.server.backend.models.GameGroup;
import jpa.server.backend.models.User;
import jpa.server.backend.repositories.UserRepository;

@Service
public class UserService implements UserDao {

  @Autowired
  private UserRepository userRepository;

  @Override
  public User createUser(User user) {
    return this.userRepository.save(user);
  }

  @Override
  public List<GameGroup> getUserGroups(Integer userId) {
    return userRepository.findById(userId).get().getGroupsList();
  }

  @Override
  public User findUserById(Integer userId) {
    return this.userRepository.findById(userId).get();
  }

  @Override
  public List<User> findAllUsers() {
    Iterable returnedUsers = userRepository.findAll();
    List<User> listToReturn = new ArrayList<>();

    for (Object user : returnedUsers) {
      listToReturn.add((User) user);
    }

    return listToReturn;
  }

  @Override
  public void deleteUser(Integer userId) {
    this.userRepository.deleteById(userId);
  }

  @Override
  public User updateUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public User findUserByUsername(String username) {
    return userRepository.findUserByUsername(username);
  }
}
