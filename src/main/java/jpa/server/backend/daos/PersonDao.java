package jpa.server.backend.daos;

import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;

import jpa.server.backend.models.Person;

public interface PersonDao {

  void logout(HttpSession session);

  Person login(HttpSession session, @RequestBody Person person);

  Person register(HttpSession session, @RequestBody Person person);

  Person profile(HttpSession session);

}
