package jpa.server.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

import jpa.server.backend.daos.PersonDao;
import jpa.server.backend.models.Person;
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
  public Person login(HttpSession session, Person person) {
    Person profile = personRepository.findPersonByCredentials(person.getUsername(), person.getPassword());
    session.setAttribute("profile", profile);
    return profile;
  }

  @Override
  public Person register(HttpSession session, Person person) {
    Person newPerson = personRepository.save(person);
    newPerson.setPassword("***");
    session.setAttribute("profile", newPerson);
    return newPerson;
  }

  @Override
  public Person profile(HttpSession session) {
    Person profile = (Person)session.getAttribute("profile");
    return profile;
  }
}
