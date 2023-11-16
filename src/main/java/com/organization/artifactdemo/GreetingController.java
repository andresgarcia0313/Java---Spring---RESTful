// Importación de clases necesarias para el funcionamiento del código
package com.organization.artifactdemo;

// Clase para generar identificadores únicos
import java.util.concurrent.atomic.AtomicLong;

// Anotación para indicar que este método responde a las solicitudes HTTP GET
import org.springframework.web.bind.annotation.GetMapping;
// Anotación para indicar que este método recibe un parámetro desde la solicitud
import org.springframework.web.bind.annotation.RequestParam;
// Anotación para indicar que esta clase es un controlador REST
import org.springframework.web.bind.annotation.RestController;

// Anotación que indica que esta clase es un controlador REST para la API y 
// su proposito es devolver objetos JSON
@RestController
public class GreetingController {

  // Cadena de formato para los saludos
  private static final String TEMPLATE = "Hola, %s!";

  // Contador atómico para asignar identificadores únicos a los saludos
  private final AtomicLong counter = new AtomicLong();

  // Método que responde a las solicitudes HTTP GET en la ruta "/greeting"
  // http://localhost:8080/greeting
  // http://localhost:8080/greeting?name=Andrés
  @GetMapping("/greeting")
  public Greeting greeting(@RequestParam(value = "name", defaultValue = "Mundo") String name) {
    // El método greeting recibe un parámetro 'name' desde la solicitud. Si no se
    // proporciona, se utiliza "World" como valor predeterminado.

    // Se crea una nueva instancia de la clase Greeting, utilizando el contador para
    // asignar un ID único a cada saludo y formateando el mensaje con el nombre
    // proporcionado.
    return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name));
  }

  @GetMapping("/saludo")
  public Greeting saludo(@RequestParam(value = "name", defaultValue = "Nombre") String name) {
    // El método greeting recibe un parámetro 'name' desde la solicitud. Si no se
    // proporciona, se utiliza "World" como valor predeterminado.

    // Se crea una nueva instancia de la clase Greeting, utilizando el contador para
    // asignar un ID único a cada saludo y formateando el mensaje con el nombre
    // proporcionado.
    return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name));
  }
}
