package com.organization.artifactdemo.services;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.organization.artifactdemo.models.Person;
import com.organization.artifactdemo.models.Task;
import com.organization.artifactdemo.repositories.PersonRepository;
import com.organization.artifactdemo.repositories.TaskRepository;

@Service
public class TaskService {

  private final TaskRepository taskRepository;
  private final PersonRepository personRepository;

  public TaskService(TaskRepository taskRepository, PersonRepository personRepository) {
    this.taskRepository = taskRepository;
    this.personRepository = personRepository;
  }

  public List<Task> getAllTasks() {
    return taskRepository.findAll();
  }

  public Task getTaskById(Long taskId) {
    return taskRepository.findById(taskId).orElse(null);
  }

  public Task createTask(String description, Boolean completed, Long personId) {
    Task task = new Task();
    task.setDescription(description);
    task.setCompleted(completed);

    Person person = personRepository.findById(personId).orElse(null);
    if (person != null) {
      task.setPerson(person);
      return taskRepository.save(task);
    } else
      return null;

  }

  public void deleteTask(Long taskId) {
    taskRepository.deleteById(taskId);
  }

  public List<Task> getTasksByPersonAndStatus(Long personId, Boolean completed) {
    Person person = personRepository.findById(personId).orElse(null);
    if (person != null)
      return taskRepository.findByPersonAndCompleted(person, completed);
    else
      return Collections.emptyList();

  }

  public void markTaskAsCompleted(Long taskId) {
    Task task = taskRepository.findById(taskId).orElse(null);
    if (task != null && !task.getCompleted()) {
      task.setCompleted(true);
      taskRepository.save(task);
    }
  }
}
