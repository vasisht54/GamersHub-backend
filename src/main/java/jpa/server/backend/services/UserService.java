package jpa.server.backend.services;

import jpa.server.backend.models.Game;
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

  @Autowired
  private GameGroupServices gameGroupServices;

  @Override
  public User createUser(User user) {
    return this.userRepository.save(user);
  }

  @Override
  public List<GameGroup> getUserMembershipGroups(Integer userId) {
    return userRepository.findById(userId).get().getMembershipGroups();
  }

  @Override
  public List<GameGroup> getUserAdminGroups(Integer userId) {
    return userRepository.findById(userId).get().getAdminGroups();
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
  public User updateUser(User user, Integer userId) {
    User userToUpdate = findUserById(userId);
    userToUpdate.setId(user.getId());
    userToUpdate.setMembershipGroups(user.getMembershipGroups());
    userToUpdate.setAdminGroups(user.getAdminGroups());
    userToUpdate.setPassword(user.getPassword());
    userToUpdate.setDob(user.getDob());
    userToUpdate.setFirstName(user.getFirstName());
    userToUpdate.setLastName(user.getLastName());
    userToUpdate.setUsername(user.getUsername());
    return userRepository.save(userToUpdate);
  }

  @Override
  public User findUserByUsername(String username) {
    return userRepository.findUserByUsername(username);
  }

  /*public int addUserToGroup(Integer groupId, Integer userId) {
    GameGroup gameGroup = gameGroupServices.findGameGroupById(groupId);
    User user = userRepository.findById(userId).get();
    List<GameGroup> userMembershipGroups = user.getMembershipGroups();
    userMembershipGroups.add(gameGroup);
    user.setMembershipGroups(userMembershipGroups);
    return 1;
  }*/

}
