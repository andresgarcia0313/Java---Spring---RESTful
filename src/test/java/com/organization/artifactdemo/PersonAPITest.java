
package com.organization.artifactdemo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.organization.artifactdemo.api.PersonAPI;
import com.organization.artifactdemo.services.PersonService;

@WebMvcTest(PersonAPI.class)
class PersonAPITest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private PersonService personService;

  @Test
  void testGetAllPersons() throws Exception {
    mockMvc.perform(get("/api/persons"))
        .andExpect(status().isOk());
  }

  @Test
  void testGetPersonById() throws Exception {
    Long personId = 1L;
    mockMvc.perform(get("/api/persons/{id}", personId))
        .andExpect(status().isOk());
  }

  @Test
  void testCreatePerson() throws Exception {
    String personName = "John Doe";
    mockMvc.perform(post("/api/persons")
        .param("name", personName)
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void testDeletePerson() throws Exception {
    Long personId = 1L;
    mockMvc.perform(delete("/api/persons/{id}", personId))
        .andExpect(status().isOk());
  }
}
