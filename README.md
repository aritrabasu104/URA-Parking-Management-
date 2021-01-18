# URA Car Parking management

This is an application for URA Car Parking management. Api details are available in https://ura-car-parking-app.herokuapp.com/swagger-ui.html#/

Backend API is published to Azure WebApps, API details are available at: https://tsura-api.azurewebsites.net/swagger-ui.html#

## How to Run

This application is packaged as a war which has Tomcat 8 embedded. No Tomcat or JBoss installation is necessary. You run it using the `java -jar` command.

- Clone this repository
- Make sure you have JRE/JDK 1.8 or higher

```
        java -jar  CarParkingApp-0.0.1-SNAPSHOT.jar
or
        mvnw spring-boot:run
```
