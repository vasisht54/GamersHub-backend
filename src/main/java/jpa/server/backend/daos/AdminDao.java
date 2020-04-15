package jpa.server.backend.daos;

import java.util.List;

import jpa.server.backend.models.Admin;

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

  Admin updateAdmin(Admin admin, Integer adminId);
//  User updateUser(User userId);
//  GroupAdmin updateGroupAdmin(GroupAdmin groupAdmin);

  Admin findAdminByUsername(String username);

}
