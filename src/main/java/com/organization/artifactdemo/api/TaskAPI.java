package com.organization.artifactdemo.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.organization.artifactdemo.models.Task;
import com.organization.artifactdemo.services.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskAPI {

  private final TaskService taskService;

  public TaskAPI(TaskService taskService) {
    this.taskService = taskService;
  }

  @GetMapping
  public List<Task> getAllTasks() {
    return taskService.getAllTasks();
  }

  @GetMapping("/{taskId}")
  public Task getTaskById(@PathVariable Long taskId) {
    return taskService.getTaskById(taskId);
  }

  @PostMapping
  public Task createTask(@RequestBody Task task) {
    return taskService.createTask(task.getDescription(), task.getCompleted(), task.getPerson().getId());
  }

  @DeleteMapping("/{taskId}")
  public void deleteTask(@PathVariable Long taskId) {
    taskService.deleteTask(taskId);
  }

}
