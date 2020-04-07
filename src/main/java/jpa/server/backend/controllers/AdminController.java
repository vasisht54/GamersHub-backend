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

import jpa.server.backend.models.Admin;

import jpa.server.backend.services.AdminService;

@RestController
@CrossOrigin(origins = "*")
public class AdminController {

  @Autowired
  private AdminService adminService;

  @DeleteMapping("/api/admin/{adminId}")
  public void deleteAdmin(@PathVariable int adminId) {
    this.adminService.deleteAdmin(adminId);
  }

  @GetMapping("/api/admins")
  public List<Admin> findAllAdmins() {
    return adminService.findAllAdmins();
  }

  @GetMapping("/api/admin/{adminId}")
  public Admin findAdminById(@PathVariable int adminId) {
    return adminService.findAdminById(adminId);
  }

  @PostMapping("/api/admin")
  public Admin createAdmin(@RequestBody Admin admin) {
    return adminService.createAdmin(admin);
  }

  @PutMapping("api/admin")
  public Admin updateAdmin(@RequestBody Admin admin) {
    return adminService.updateAdmin(admin);
  }


  @GetMapping("/api/admins/{username}")
  public Admin findAdminByUsername(@PathVariable String username) {return adminService.findAdminByUsername(username); }
}