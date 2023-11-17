package com.organization.artifactdemo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String description;
  private Boolean completed;
  @ManyToOne
  private Person person;
}
