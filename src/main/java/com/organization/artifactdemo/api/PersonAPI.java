package com.organization.artifactdemo.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.organization.artifactdemo.models.Person;
import com.organization.artifactdemo.services.PersonService;

@RestController
@RequestMapping("/api/persons")
public class PersonAPI {

  private final PersonService personService;

  public PersonAPI(PersonService personService) {
    this.personService = personService;
  }

  @GetMapping
  public List<Person> getAllPersons() {
    return personService.getAllPersons();
  }

  @GetMapping("/{id}")
  public Person getPersonById(@PathVariable Long id) {
    return personService.getPersonById(id);
  }

  @PostMapping
  public Person createPerson(@RequestParam String name) {
    return personService.createPerson(name);
  }

  @DeleteMapping("/{id}")
  public void deletePerson(@PathVariable Long id) {
    personService.deletePerson(id);
  }
}
