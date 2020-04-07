package jpa.server.backend.daos;

import java.util.List;

import javafx.scene.Group;
import jpa.server.backend.models.Admin;
import jpa.server.backend.models.GroupAdmin;
import jpa.server.backend.models.User;

public interface AdminDao {

  Admin createAdmin(Admin admin);

//  User createUser(User userPassed);
//
//  GroupAdmin createGroupAdmin(GroupAdmin groupAdmin);


  Admin findAdminById(Integer adminId);

  //find all users
  List<Admin> findAllAdmins();

  void deleteAdmin(Integer adminId);
//  void deleteUser(Integer userId);
//  void deleteGroupAdmin(Integer groupAdminId);

  Admin updateAdmin(Admin admin);
//  User updateUser(User userId);
//  GroupAdmin updateGroupAdmin(GroupAdmin groupAdmin);

  Admin findAdminByUsername(String username);

}
