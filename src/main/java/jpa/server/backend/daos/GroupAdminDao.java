package jpa.server.backend.daos;

import java.util.List;

import jpa.server.backend.models.GameGroup;
import jpa.server.backend.models.GroupAdmin;

public interface GroupAdminDao {
  //create user
  GroupAdmin createGroupAdmin(GroupAdmin groupAdmin);

  //Get list of game groups for user
  List<GameGroup> getGroupAdminGroups(Integer groupAdminId);

  //find user by id
  GroupAdmin findGroupAdminById(Integer groupAdminId);

  //find all users
  List<GroupAdmin> findAllGroupAdmins();

  void deleteGroupAdmin(Integer groupAdminId);

  GroupAdmin updateGroupAdmin(GroupAdmin groupAdmin);
}
