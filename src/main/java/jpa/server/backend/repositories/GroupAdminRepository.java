package jpa.server.backend.repositories;

import org.springframework.data.repository.CrudRepository;

import jpa.server.backend.models.GroupAdmin;

public interface GroupAdminRepository extends CrudRepository<GroupAdmin, Integer> {
}
