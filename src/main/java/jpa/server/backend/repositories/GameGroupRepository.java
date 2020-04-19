package jpa.server.backend.repositories;

import org.springframework.data.repository.CrudRepository;


import jpa.server.backend.models.GameGroup;

public interface GameGroupRepository extends CrudRepository<GameGroup, Integer> {

}
