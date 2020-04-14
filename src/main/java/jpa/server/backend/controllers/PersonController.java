package jpa.server.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

import jpa.server.backend.models.Person;
import jpa.server.backend.repositories.PersonRepository;
import jpa.server.backend.services.PersonService;

@RestController
@CrossOrigin(origins = "*")
public class PersonController {

  @Autowired
  private PersonService personService;

  @PostMapping("api/register")
  public Person register(HttpSession session, @RequestBody Person person) {
    return personService.register(session, person);
  }

  @PostMapping("api/logout")
  public void logout(HttpSession session) {
    personService.logout(session);
  }

  @PostMapping("api/login")
  public Person login(HttpSession session, @RequestBody Person person) {
    return personService.login(session, person);
  }

  @PostMapping("api/profile")
  public Person profile(HttpSession session) {
    Person profile = (Person)session.getAttribute("profile");
    return profile;
  }
}
