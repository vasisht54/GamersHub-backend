package jpa.server.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import jpa.server.backend.daos.AdminDao;
import jpa.server.backend.models.Admin;
import jpa.server.backend.repositories.AdminRepository;

@Service
public class AdminService implements AdminDao {
  @Autowired
  private AdminRepository adminRepository;

  @Override
  public Admin createAdmin(Admin admin) {
    return adminRepository.save(admin);
  }

  @Override
  public Admin findAdminById(Integer adminId) {
    try {
      Admin adminToReturn = this.adminRepository.findById(adminId).get();
      return adminToReturn;
    }catch (NoSuchElementException e) {
      return new Admin();
    }
  }

  @Override
  public List<Admin> findAllAdmins() {
    Iterable returnedAdmins = adminRepository.findAll();
    List<Admin> listToReturn = new ArrayList<>();

    for (Object admin : returnedAdmins) {
      listToReturn.add((Admin) admin);
    }

    return listToReturn;
  }

  @Override
  public void deleteAdmin(Integer adminId) {
    adminRepository.deleteById(adminId);
  }

  @Override
  public Admin updateAdmin(Admin admin, Integer adminId) {
    Admin adminToUpdate = findAdminById(adminId);
    adminToUpdate.setAdminKey(admin.getAdminKey());
    adminToUpdate.setPassword(admin.getPassword());
    adminToUpdate.setDob(admin.getDob());
    adminToUpdate.setFirstName(admin.getFirstName());
    adminToUpdate.setLastName(admin.getLastName());
    adminToUpdate.setUsername(admin.getUsername());
    adminToUpdate.setId(admin.getId());
    return adminRepository.save(admin);
  }

  @Override
  public Admin findAdminByUsername(String username) {
    return adminRepository.findAdminByUsername(username);
  }
}
