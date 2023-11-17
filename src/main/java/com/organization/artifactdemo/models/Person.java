package com.organization.artifactdemo.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Person {
  @Id
  @GeneratedValue
  private Long id;
  private String name;
  @OneToMany(mappedBy = "person")
  private List<Task> tasks;
}
