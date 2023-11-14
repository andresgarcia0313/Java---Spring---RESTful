package com.organization.artifactdemo;

public record Greeting(long id, String content) {
}
// A partir de la versión 16, se introdujo el concepto de "records".
// Un record es una forma concisa de declarar una clase que es principalmente un
// contenedor de datos inmutables. El código que has compartido es un ejemplo de
// un record en Java.
// La ventaja clave de los records es que generan automáticamente métodos como
// equals(), hashCode(), y toString() basados en los componentes definidos. Esto
// reduce significativamente el boilerplate (código redundante) que necesitarías
// escribir para clases que son principalmente contenedores de datos.

// Aquí el record Greeting se usa para representar un
// saludo, donde id es un identificador y content es el contenido del saludo. Al
// utilizar un record, se obtiene de forma automática la implementación de
// métodos esenciales para la comparación y representación de cadenas, lo que
// hace que el código sea más limpio y menos propenso a errores.