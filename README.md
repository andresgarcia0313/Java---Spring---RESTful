# Extensión vscode

<https://marketplace.visualstudio.com/items?itemName=vmware.vscode-boot-dev-pack>
<https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack>
<https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack>

## Guia del presente código

<https://spring.io/guides/gs/rest-service/>

## Compilar y ejecutar para desarrollo

./mvnw spring-boot:run
./mvnw clean package

## Reportes

./mvnw site

## Ejecutar

java -jar target/artifactdemo-0.0.1-SNAPSHOT.jar

<http://localhost:8080/greeting>
<http://localhost:8080/greeting?name=Andrés>

## Ejecutar Test

mvn test
`./mvnw surefire-report:report

## Instalar maven

Descargarlo

<https://dlcdn.apache.org/maven/maven-3/3.9.5/binaries/apache-maven-3.9.5-bin.zip>

Descomprime el archivo ZIP en un directorio de tu elección. Puedes utilizar el explorador de Archivos para esto.

Configurar variables de entorno:

En "Variables del sistema", agrega M2_HOME y el valor de la ruta donde descomprimiste Maven C:\ruta\donde\descomprimiste\apache-maven-3.8.4
Selecciona la variable Path en la sección "Variables del sistema" y haz clic en "Editar". Agrega una nueva entrada con %M2_HOME%\bin.

 Validalo ejecutando mvn --version

## Ejecuta el comando mvn

mvn dependency:resolve -DgroupId=org.springframework.boot -DartifactId=spring-boot-starter-data-jpa -Dtransitive=false

## Extrae la versión de la salida y agrega la dependencia al archivo pom.xml

version=$(mvn -q org.apache.maven.plugins:maven-help-plugin:3.2.0:evaluate -Dexpression=project.version -DforceStdout)
echo "<dependency>" >> pom.xml
echo "    <groupId>org.springframework.boot</groupId>" >> pom.xml
echo "    <artifactId>spring-boot-starter-data-jpa</artifactId>" >> pom.xml
echo "    <version>$version</version>" >> pom.xml
echo "</dependency>" >> pom.xml

## Actuator

