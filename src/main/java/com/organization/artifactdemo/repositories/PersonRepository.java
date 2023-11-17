package com.organization.artifactdemo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.organization.artifactdemo.models.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

  List<Person> findByTasksCompleted(Boolean completed);
}