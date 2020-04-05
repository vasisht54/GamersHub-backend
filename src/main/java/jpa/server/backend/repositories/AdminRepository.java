package jpa.server.backend.repositories;

import org.springframework.data.repository.CrudRepository;

import jpa.server.backend.models.Admin;

public interface AdminRepository extends CrudRepository<Admin, Integer> {
}
