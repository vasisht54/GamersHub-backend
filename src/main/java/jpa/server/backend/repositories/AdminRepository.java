package jpa.server.backend.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import jpa.server.backend.models.Admin;

public interface AdminRepository extends CrudRepository<Admin, Integer> {

  @Query("SELECT admin FROM Admin admin where admin.username=:username")
  Admin findAdminByUsername(@Param("username") String username);
}
