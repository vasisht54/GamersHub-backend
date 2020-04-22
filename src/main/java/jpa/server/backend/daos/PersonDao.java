package jpa.server.backend.daos;

import jpa.server.backend.models.User;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;

import jpa.server.backend.models.Person;

public interface PersonDao {

  void logout(HttpSession session);

  User login(HttpSession session, @RequestBody User user);

  User register(HttpSession session, @RequestBody User user);

  User profile(HttpSession session);

}
