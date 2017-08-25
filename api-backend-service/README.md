# API Backend service

This is a Java / Gradle / Spring Boot application used as backend in order to serve a public API and persist on database.

## Requirements

### RabbitMQ

Visit [RabbitMQ](https://www.rabbitmq.com/download.html) to download and install.

Once server running you can access to management plugin at [http://localhost:15672](http://localhost:15672)
  
### PostgreSQL

To make it work on your installation, be sure running PostgreSQL service and change in `application.properties` under `src/main/resources` the following with your local information:

    spring.datasource.url=jdbc:postgresql://localhost:5432/<database>
    spring.datasource.username=<username>
    spring.datasource.password=<password>

## Running the application

     gradle run
     