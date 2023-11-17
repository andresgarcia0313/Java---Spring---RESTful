package com.organization.artifactdemo.services;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.organization.artifactdemo.models.Person;
import com.organization.artifactdemo.models.Task;
import com.organization.artifactdemo.repositories.PersonRepository;
import com.organization.artifactdemo.repositories.TaskRepository;

@Service
public class PersonService {

  private final PersonRepository personRepository;
  private TaskRepository taskRepository;

  public PersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  public List<Person> getAllPersons() {
    return personRepository.findAll();
  }

  public Person getPersonById(Long personId) {
    return personRepository.findById(personId).orElse(null);
  }

  public Person createPerson(String name) {
    Person person = new Person();
    person.setName(name);
    return personRepository.save(person);
  }

  public void deletePerson(Long personId) {
    personRepository.deleteById(personId);
  }

  public List<Person> getPersonsByTaskCompletionStatus(Boolean completed) {
    return personRepository.findByTasksCompleted(completed);
  }

  public List<Task> getIncompleteTasksByPerson(Long personId) {
    Person person = personRepository.findById(personId).orElse(null);
    if (person != null)
      return taskRepository.findByPersonAndCompleted(person, false);
    else
      return Collections.emptyList();

  }
}
