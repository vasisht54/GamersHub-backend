package jpa.server.backend.services;

import jpa.server.backend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

import jpa.server.backend.daos.PersonDao;
import jpa.server.backend.repositories.PersonRepository;

@Service
public class PersonService implements PersonDao {
  @Autowired
  PersonRepository personRepository;

  @Override
  public void logout(HttpSession session) {
    session.invalidate();
  }

  @Override
  public User login(HttpSession session, User user) {
    User profile = personRepository.findPersonByCredentials(user.getUsername(), user.getPassword());
    if (profile == null) {
      return new User();
    } else {
      user.setPassword("");
      session.setAttribute("profile", profile);
      return profile;
    }

  }

  @Override
  public User register(HttpSession session, User user) {
    User newPerson = personRepository.save(user);
    newPerson.setPassword("");
    session.setAttribute("profile", newPerson);
    return newPerson;
  }

  public User update(User user){
    return personRepository.save(user);
  }

  @Override
  public User profile(HttpSession session) {
    User profile = (User)session.getAttribute("profile");
    return profile;
  }
}
