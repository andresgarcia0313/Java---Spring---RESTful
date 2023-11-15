Extensión vscode
https://marketplace.visualstudio.com/items?itemName=vmware.vscode-boot-dev-pack
Guia del presente código
https://spring.io/guides/gs/rest-service/

# Compilar y ejecutar

## Compilar y ejecutar

./mvnw spring-boot:run
./mvnw clean package

## Ejecutar

java -jar target/artifactdemo-0.0.1-SNAPSHOT.jar

http://localhost:8080/greeting
http://localhost:8080/greeting?name=Andrés

Instalar maven:

Descargarlo

https://dlcdn.apache.org/maven/maven-3/3.9.5/binaries/apache-maven-3.9.5-bin.zip

Descomprime el archivo ZIP en un directorio de tu elección. Puedes utilizar el 
Explorador de Archivos para esto.

Configurar variables de entorno:

Haz clic con el botón derecho en "Este PC" o "Mi PC" en tu escritorio o en el 
menú de inicio y selecciona "Propiedades".
Haz clic en "Configuración avanzada del sistema" en el panel izquierdo.
En la ventana de Propiedades del sistema, haz clic en "Variables de entorno".
En la sección "Variables del sistema", haz clic en "Nuevo" y agrega una nueva 
variable con el nombre M2_HOME y el valor de la ruta donde descomprimiste Maven
 (por ejemplo, C:\ruta\donde\descomprimiste\apache-maven-3.8.4).
Selecciona la variable Path en la sección "Variables del sistema" y haz clic en
 "Editar". Agrega una nueva entrada con %M2_HOME%\bin.

 Validalo ejecutando mvn --version
