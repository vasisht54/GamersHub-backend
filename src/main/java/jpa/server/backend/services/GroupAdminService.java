package jpa.server.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import jpa.server.backend.daos.GroupAdminDao;
import jpa.server.backend.models.GameGroup;
import jpa.server.backend.models.GroupAdmin;
import jpa.server.backend.repositories.GroupAdminRepository;

@Service
public class GroupAdminService implements GroupAdminDao {

  @Autowired
  private GroupAdminRepository groupAdminRepository;

  @Override
  public GroupAdmin createGroupAdmin(GroupAdmin groupAdmin) {
    return this.groupAdminRepository.save(groupAdmin);
  }

  @Override
  public List<GameGroup> getGroupAdminGroups(Integer groupAdminId) {
    return groupAdminRepository.findById(groupAdminId).get().getGroupsList();
  }

  @Override
  public GroupAdmin findGroupAdminById(Integer groupAdminId) {
    return groupAdminRepository.findById(groupAdminId).get();
  }

  @Override
  public List<GroupAdmin> findAllGroupAdmins() {
    Iterable returnedGroupAdmins = groupAdminRepository.findAll();
    List<GroupAdmin> listToReturn = new ArrayList<>();

    for (Object groupAdmin : returnedGroupAdmins) {
      listToReturn.add((GroupAdmin) groupAdmin);
    }
    return listToReturn;
  }

  @Override
  public void deleteGroupAdmin(Integer groupAdminId) {
    this.groupAdminRepository.deleteById(groupAdminId);
  }

  @Override
  public GroupAdmin updateGroupAdmin(GroupAdmin groupAdmin, Integer groupAdminId) {
    GroupAdmin groupAdminToUpdate = findGroupAdminById(groupAdminId);
    groupAdminToUpdate.setId(groupAdmin.getId());
    groupAdminToUpdate.setGroupsList(groupAdmin.getGroupsList());
    groupAdminToUpdate.setPassword(groupAdmin.getPassword());
    groupAdminToUpdate.setDob(groupAdmin.getDob());
    groupAdminToUpdate.setFirstName(groupAdmin.getFirstName());
    groupAdminToUpdate.setLastName(groupAdmin.getLastName());
    return groupAdminRepository.save(groupAdmin);
  }

  @Override
  public GroupAdmin findGroupAdminByUsername(String username) {
    return groupAdminRepository.findGroupAdminByUsername(username);
  }
}
