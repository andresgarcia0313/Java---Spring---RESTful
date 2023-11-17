package com.organization.artifactdemo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.organization.artifactdemo.models.Person;
import com.organization.artifactdemo.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

  List<Task> findByPersonAndCompleted(Person person, boolean b);
}
