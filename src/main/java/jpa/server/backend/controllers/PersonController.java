package jpa.server.backend.controllers;

import jpa.server.backend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

import jpa.server.backend.models.Person;
import jpa.server.backend.repositories.PersonRepository;
import jpa.server.backend.services.PersonService;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true")
public class PersonController {

  @Autowired
  private PersonService personService;

  @PostMapping("api/register")
  public User register(HttpSession session, @RequestBody User person) {
    System.out.println("Register Reached");
    return personService.register(session, person);
  }

  @PostMapping("api/logout")
  public void logout(HttpSession session) {
    personService.logout(session);
  }

  @PostMapping("api/login")
  public User login(HttpSession session, @RequestBody User person) {
    return personService.login(session, person);
  }

  @PutMapping("api/update")
  public User updateUser(HttpSession session,
                         @RequestBody User updateUser){
    System.out.println("Update Reached");
    return personService.update(updateUser);
  }
  
  @PostMapping("api/profile")
  public User profile(HttpSession session) {
    User profile = (User)session.getAttribute("profile");
    return profile;
  }
}
