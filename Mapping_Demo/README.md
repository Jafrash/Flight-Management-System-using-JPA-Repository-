# Mapping Demo - JPA Relationship Mapping Project

A Spring Boot application demonstrating JPA entity relationship mappings including One-to-One, One-to-Many, and Many-to-One relationships using PostgreSQL database.

## Overview

This project showcases different types of JPA entity relationships through a practical implementation:
- **One-to-One**: Person ↔ Passport relationship
- **Many-to-One / One-to-Many**: Team ↔ Player relationship

## Technology Stack

- **Java**: 17
- **Spring Boot**: 4.0.3
- **Spring Data JPA**: For database operations
- **PostgreSQL**: Database
- **Maven**: Build tool

## Project Structure

```
src/main/java/org/hartford/mapping_demo/
├── controller/          # REST API endpoints
│   ├── PersonController.java
│   ├── PassportController.java
│   ├── PlayerController.java
│   └── TeamController.java
├── model/              # JPA entities
│   ├── Person.java
│   ├── Passport.java
│   ├── Player.java
│   └── Team.java
├── repository/         # Data access layer
│   ├── PersonRepo.java
│   ├── PassportRepo.java
│   ├── PlayerRepo.java
│   └── TeamRepo.java
├── service/           # Business logic layer
│   ├── PersonService.java
│   ├── PassportService.java
│   ├── PlayerService.java
│   └── TeamService.java
└── MappingDemoApplication.java
```

## Entity Relationships

### One-to-One: Person ↔ Passport
- Each Person can have one Passport
- Each Passport belongs to one Person
- Bidirectional relationship with cascade operations

### Many-to-One / One-to-Many: Team ↔ Player
- Each Team can have multiple Players
- Each Player belongs to one Team
- Bidirectional relationship

## Prerequisites

- Java 17 or higher
- PostgreSQL database
- Maven 3.6+

## Database Configuration

Update `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5433/demo
spring.datasource.username=postgres
spring.datasource.password=<your-password>
spring.jpa.hibernate.ddl-auto=update
```

## Installation & Setup

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd Mapping_Demo
   ```

2. **Configure PostgreSQL**
   - Create a database named `demo`
   - Update credentials in `application.properties`

3. **Build the project**
   ```bash
   mvnw clean install
   ```

4. **Run the application**
   ```bash
   mvnw spring-boot:run
   ```

The application will start on `http://localhost:8080`

## API Endpoints

### Person Endpoints
- `GET /persons` - Get all persons
- `GET /persons/{id}` - Get person by ID
- `POST /persons` - Create new person
- `GET /persons/passport/{personId}` - Get passport for a person
- `GET /persons/bind/{personId}/{passportId}` - Bind passport to person

### Passport Endpoints
- `GET /passports` - Get all passports
- `GET /passports/{id}` - Get passport by ID
- `POST /passports` - Create new passport
- `GET /passports/person/{id}` - Get person by passport ID
- `GET /passports/bind/{passportId}/{personId}` - Bind person to passport

### Player Endpoints
- `GET /players` - Get all players
- `GET /players/{id}` - Get player by ID
- `POST /players` - Create new player

### Team Endpoints
- `GET /teams` - Get all teams
- `GET /teams/{id}` - Get team by ID
- `POST /teams` - Create new team

## Example Usage

### Create a Person
```bash
curl -X POST http://localhost:8080/persons \
  -H "Content-Type: application/json" \
  -d '{"fname":"John","lname":"Doe"}'
```

### Create a Passport
```bash
curl -X POST http://localhost:8080/passports \
  -H "Content-Type: application/json" \
  -d '{"passportNumber":"AB123456","releaseDate":"2020-01-01","expiryDate":"2030-01-01"}'
```

### Bind Passport to Person
```bash
curl http://localhost:8080/persons/bind/1/1
```

## Features

- RESTful API architecture
- JPA entity relationship mappings
- Automatic schema generation
- PostgreSQL integration
- Service layer abstraction
- Repository pattern implementation

## Development

The application uses Spring Boot DevTools for hot reloading during development. Any changes to the code will automatically restart the application.

## License

This project is for educational purposes demonstrating JPA relationship mappings.
