package jpa.server.backend.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import jpa.server.backend.models.GroupAdmin;

public interface GroupAdminRepository extends CrudRepository<GroupAdmin, Integer> {

  @Query("SELECT groupAdmin FROM GroupAdmin groupAdmin where groupAdmin.username=:username")
  GroupAdmin findGroupAdminByUsername(@Param("username") String username);
}
