# JPADemo - Flight Management System

A small RESTful API built with Spring Boot and Spring Data JPA that demonstrates basic CRUD operations for managing flight records stored in a PostgreSQL database.

## Technology stack

- Java 17
- Spring Boot 4.0.2 (spring-boot-starter-parent)
- Spring Data JPA
- Spring Web MVC
- PostgreSQL (jdbc:postgresql)
- Maven (wrapper included)

## Project purpose

- Provide a minimal example of a layered Spring Boot application using JPA entities, a Spring Data repository, a service layer, and a REST controller.
- Demonstrate auto schema management (hibernate ddl-auto=update) and simple REST endpoints for common CRUD operations.

## Table of contents

- [Project structure](#project-structure)
- [Architecture](#architecture)
- [Data model](#data-model)
- [API endpoints (examples)](#api-endpoints-examples)
- [Configuration](#configuration)
- [Build & run (Windows PowerShell)](#build--run-windows-powershell)
- [Tests](#tests)
- [Troubleshooting](#troubleshooting)
- [Future improvements](#future-improvements)

## Project structure

```
JPADemo/
├── src/
│   ├── main/
│   │   ├── java/org/hartford/jpademo/
│   │   │   ├── controller/FlightController.java    # REST endpoints
│   │   │   ├── model/Flight.java                    # JPA entity
│   │   │   ├── repository/FlightRepository.java    # Spring Data repository
│   │   │   ├── service/FlightService.java          # Business logic
│   │   │   └── JpaDemoApplication.java             # Spring Boot main class
│   │   └── resources/application.properties        # Configuration
│   └── test/
└── pom.xml
```

## Architecture

This project follows a simple layered architecture:

- Controller: `FlightController` — exposes REST endpoints under `/flights`.
- Service: `FlightService` — contains business logic and delegates to the repository.
- Repository: `FlightRepository` — extends `JpaRepository<Flight, Long>` and contains a custom finder.
- Model: `Flight` — a JPA entity mapped to the `flights` table.

## Data model

Entity: `Flight` (mapped to table `flights`)

- id: Long (primary key, generated)
- source: String (not nullable)
- destination: String (not nullable)
- departureDate: Date (not nullable) — stored as SQL date
- departureTime: Time (not nullable) — stored as SQL time

Sample JSON representation

POST/PUT payload example

```json
{
  "source": "New York",
  "destination": "Los Angeles",
  "departureDate": "2024-12-25",
  "departureTime": "14:30:00"
}
```

Response example (created entity)

```json
{
  "id": 1,
  "source": "New York",
  "destination": "Los Angeles",
  "departureDate": "2024-12-25",
  "departureTime": "14:30:00"
}
```

## Repository

`FlightRepository` extends `JpaRepository<Flight, Long>` and exposes the usual CRUD methods plus a custom finder:

- `List<Flight> findBySourceAndDestinationAndDepartureDate(String source, String destination, Date departureDate)`

## Service behavior

`FlightService` provides simple methods used by the controller:

- `addFlight(Flight)`: saves and returns the entity
- `deleteById(Long)`: returns true when an entity existed and was deleted, false otherwise
- `findAll()`: returns all flights
- `findById(Long)`: returns the flight or null when not found
- `update(Long, Flight)`: updates source, destination and departureDate for an existing flight; returns null if flight does not exist

## Controller & API endpoints

Base path: `/flights`

Endpoints

- `GET /flights`
  - Description: Retrieve all flights
  - Response: 200 OK, JSON array of flights

- `GET /flights/{id}`
  - Description: Retrieve a flight by id
  - Response: 200 OK with flight JSON, or 404 if not found (note: current controller returns null body with 200 if service returns null; consider improving to return 404)

- `POST /flights`
  - Description: Create a new flight
  - Request: Flight JSON (see sample above)
  - Response: 201 Created, created flight JSON

- `PUT /flights/{id}`
  - Description: Update an existing flight (partial fields handled by service)
  - Request: Flight JSON
  - Response: 200 OK with updated flight JSON, or 200 with null body if id not found (service returns null) — consider returning 404

- `DELETE /flights/{id}`
  - Description: Delete a flight
  - Response: 204 No Content on success, 404 Not Found when id doesn't exist

Notes about controller behavior

- `GET /flights/{id}` and `PUT /flights/{id}` currently will return 200 with a null body when the requested flight is not found; you may want to change the controller to return 404 NOT FOUND in those cases.

## Configuration

Key properties in `src/main/resources/application.properties` (defaults included in this project):

```properties
spring.application.name=JPADemo
spring.datasource.url=jdbc:postgresql://localhost:5433/demo
spring.datasource.username=postgres
spring.datasource.password=
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

Important: Update `spring.datasource.password` to match your PostgreSQL setup.

## Build & run (Windows PowerShell)

Prerequisites

- JDK 17 installed and JAVA_HOME set
- Maven installed (optional — wrapper included)
- PostgreSQL running and accessible; create a database named `demo` or update `spring.datasource.url` to match your database

Build using Maven wrapper (recommended on Windows PowerShell)

1. Open PowerShell and navigate to the project directory
2. Run:

   ```powershell
   .\mvnw.cmd clean install
   ```

3. Run the application (using the wrapper)

   ```powershell
   .\mvnw.cmd spring-boot:run
   ```

   Or run the packaged jar after building

   ```powershell
   java -jar .\target\JPADemo-0.0.1-SNAPSHOT.jar
   ```

4. Run tests

   ```powershell
   .\mvnw.cmd test
   ```

   (You can also use `mvn` if you prefer: `mvn clean install` / `mvn spring-boot:run`)

Notes about artifact

- artifactId: JPADemo
- version: 0.0.1-SNAPSHOT
- produced jar: `target/JPADemo-0.0.1-SNAPSHOT.jar`

Testing the API (example with curl)

- Create a flight

  ```bash
  curl -X POST http://localhost:8080/flights -H "Content-Type: application/json" -d '{"source":"New York","destination":"Los Angeles","departureDate":"2024-12-25","departureTime":"14:30:00"}'
  ```

- Get all flights

  ```bash
  curl http://localhost:8080/flights
  ```

- Get flight by id

  ```bash
  curl http://localhost:8080/flights/1
  ```

## Troubleshooting

- Database connection errors:
  - Verify PostgreSQL is running and the `spring.datasource.url` matches host/port/database
  - Make sure the username/password are correct
  - Ensure the `postgresql` driver is on the classpath (pom.xml includes it as runtime dependency)

- Port already in use:
  - Change the server port with `server.port=<port>` in `application.properties` or via `-Dserver.port=XXXX`

- Entity not persisted or schema issues:
  - Check `spring.jpa.hibernate.ddl-auto` (current default: `update`) and logs for DDL statements

Quality gates (quick)

1. Build: `.\mvnw.cmd clean install` — should complete with exit code 0
2. Tests: `.\mvnw.cmd test` — tests should pass
3. Smoke test: start app and call `GET /flights` to confirm 200 response

## Future improvements / TODO

- Add request validation (e.g., javax.validation / jakarta.validation annotations on `Flight` DTO)
- Return proper HTTP status codes for not-found cases (404) instead of returning null bodies
- Use DTOs for API requests/responses and map to entities (avoid exposing entity directly)
- Add integration tests that run against a Testcontainers PostgreSQL instance
- Add OpenAPI / Swagger documentation
- Add logging configuration and file-based logging

## License & contact

- Add license information as required
