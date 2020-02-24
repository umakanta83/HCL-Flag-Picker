Exercise:

 Challenge:
 Build a generic services using Spring Boot that allows the user to pick different world flags based on the provided JSON file (attached to this email).
 Instructions:
 1. Build a generic rest based services that can pull list of items that fits for the given criterion -  Filter these options based on the user's input:-All data, if continent is provided then pull list of countries and flag. If countries is provided then send the flag.
 2. Build Unit tests for your search service
 3. Feel free to add Design pattern or more functionality as it fits this problem.

 Bonus:
 1. Performance and Audit logging enhancement to service.
 2. A metrics service that can provide - number of times certain continent/country flag has been viewed.
 3. Create a schema for this problem for MySQL/NoSql data store

 Requirements:
 - Use Sprint Boot with Rest End points
 - Only use the provided JSON file (as is)




HCL-Flag-Picker - App is created to complete the above exercise

Use

Spring-Boot 2.2
JDK 1.8
Spring Actuator

SPring-JPA-- Commented as just created the entity object
Oracle -  Commented as just created the entity object


Build
mvn clean package

Run the Project:

FlagPickerApplication.java -> Run as Java Application

Rest Endpoint URl:

Get the continents
http://localhost:8080/continents/

Get the Country List End point:
http://localhost:8080/continents/{continentName}

Get the Country Flag End point:

http://localhost:8080/continents/{continentName}/country/{countryName}

Accuator Health Check URL:
http://localhost:9001/actuator/health

JUnit Test Cases are available in src/test package.

Oracle Entity Object Created - Commented as dependency Oracle is not present
ContinentStructureEntity.Java

Oracle Table Continent Structure ---

---------------------------------------
ID -> Continent Name -> Country Name -> Flag


--------------------------------------