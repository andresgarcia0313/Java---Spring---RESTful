package com.organization.artifactdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.organization.artifactdemo.models.Task;
import com.organization.artifactdemo.services.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {

  private final TaskService taskService;

  public TaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  @GetMapping
  public String getAllTasks(Model model) {
    model.addAttribute("tasks", taskService.getAllTasks());
    return "task/list-tasks";
  }

  @GetMapping("/{taskId}")
  public String getTaskById(@PathVariable Long taskId, Model model) {
    Task task = taskService.getTaskById(taskId);
    model.addAttribute("task", task);
    return "task/view-task";
  }

  @GetMapping("/create")
  public String showCreateTaskForm(Model model) {
    return "task/create-task";
  }

  @PostMapping("/create")
  public String createTask(@RequestParam String description, @RequestParam Boolean completed,
      @RequestParam Long personId) {
    taskService.createTask(description, completed, personId);
    return "redirect:/tasks";
  }

}
