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
import jpa.server.backend.models.GroupAdmin;
import jpa.server.backend.services.GroupAdminService;

@RestController
@CrossOrigin(origins = "*")
public class GroupAdminController {

  @Autowired
  private GroupAdminService groupAdminService;

  @DeleteMapping("/api/groupAdmins/{groupAdminId}")
  public void deleteGroupAdmin(@PathVariable int groupAdminId) {
    this.groupAdminService.deleteGroupAdmin(groupAdminId);
  }

  @GetMapping("/api/groupAdmins")
  public List<GroupAdmin> findAllGroupAdmins() {
    return groupAdminService.findAllGroupAdmins();
  }

  @GetMapping("/api/groupAdmins/{groupAdminId}")
  public GroupAdmin findGroupAdminById(@PathVariable int groupAdminId) {
    return groupAdminService.findGroupAdminById(groupAdminId);
  }

  @PostMapping("/api/groupAdmins")
  public GroupAdmin createGroupAdmin(@RequestBody GroupAdmin groupAdmin) {
    return groupAdminService.createGroupAdmin(groupAdmin);
  }

  @PutMapping("api/groupAdmins")
  public GroupAdmin updateGroupAdmin(@RequestBody GroupAdmin groupAdmin) {
    return groupAdminService.updateGroupAdmin(groupAdmin);
  }

  @GetMapping("/api/groupAdmins/{groupAdminId}/groupAdminGroups")
  public List<GameGroup> getGroupAdminGroups(@PathVariable Integer groupAdminId) {
    return groupAdminService.getGroupAdminGroups(groupAdminId);
  }

  @GetMapping("/api/groupAdmins/{username}")
  public GroupAdmin findGroupAdminByUsername(@PathVariable String username) {return groupAdminService.findGroupAdminByUsername(username); }
  
}
