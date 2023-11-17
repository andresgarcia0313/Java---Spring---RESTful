
package com.organization.artifactdemo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

// Anotación para indicar que esta clase realiza pruebas de integración para el controlador web
@WebMvcTest(GreetingController.class)
class GreetingControllerTest {

  // MockMvc se utiliza para simular solicitudes HTTP
  @Autowired
  private MockMvc mockMvc;

  // Prueba para verificar que se recibe un saludo predeterminado cuando no se
  // proporciona un nombre
  @Test
  void shouldReturnDefaultGreeting() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/greeting"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.content").value("Hola, Mundo!"));
  }

  // Prueba para verificar que se recibe un saludo personalizado cuando se
  // proporciona un nombre
  @Test
  void shouldReturnCustomGreeting() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/greeting").param("name", "Andrés"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.content").value("Hola, Andrés!"));
  }
}
