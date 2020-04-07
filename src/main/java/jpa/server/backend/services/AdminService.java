package jpa.server.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    return adminRepository.findById(adminId).get();
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
  public Admin updateAdmin(Admin admin) {
    return adminRepository.save(admin);
  }

  @Override
  public Admin findAdminByUsername(String username) {
    return adminRepository.findAdminByUsername(username);
  }
}
