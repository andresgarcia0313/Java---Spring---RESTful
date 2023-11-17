package com.organization.artifactdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.organization.artifactdemo.models.Person;
import com.organization.artifactdemo.services.PersonService;

@Controller
@RequestMapping("/persons")
public class PersonController {

  private final PersonService personService;

  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @GetMapping
  public String getAllPersons(Model model) {
    model.addAttribute("persons", personService.getAllPersons());
    return "person/list";
  }

  @GetMapping("/{id}")
  public String getPersonById(@PathVariable Long id, Model model) {
    Person person = personService.getPersonById(id);
    model.addAttribute("person", person);
    return "person/detail";
  }

  @GetMapping("/create")
  public String showCreateForm() {
    return "person/create";
  }

  @PostMapping("/create")
  public String createPerson(@RequestParam String name) {
    personService.createPerson(name);
    return "redirect:/persons";
  }

  @GetMapping("/{id}/delete")
  public String deletePerson(@PathVariable Long id) {
    personService.deletePerson(id);
    return "redirect:/persons";
  }
}
