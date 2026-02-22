# JPADemo - Flight Management System

A RESTful API application built with Spring Boot and JPA for managing flight information. This project demonstrates CRUD operations using Spring Data JPA with PostgreSQL database.

## Technology Stack

- **Java**: 17
- **Spring Boot**: 4.0.2
- **Spring Data JPA**: For database operations
- **Spring Web MVC**: For REST API endpoints
- **PostgreSQL**: Database
- **Maven**: Build tool

## Project Structure

```
JPADemo/
├── src/
│   ├── main/
│   │   ├── java/org/hartford/jpademo/
│   │   │   ├── controller/
│   │   │   │   └── FlightController.java      # REST endpoints
│   │   │   ├── model/
│   │   │   │   └── Flight.java                # Entity class
│   │   │   ├── repository/
│   │   │   │   └── FlightRepository.java      # Data access layer
│   │   │   ├── service/
│   │   │   │   └── FlightService.java         # Business logic
│   │   │   └── JpaDemoApplication.java        # Main application
│   │   └── resources/
│   │       └── application.properties         # Configuration
│   └── test/
└── pom.xml
```

## Features

- Create new flight records
- Retrieve all flights
- Retrieve flight by ID
- Update existing flight information
- Delete flights
- PostgreSQL database integration
- Automatic schema generation/update

## Database Configuration

The application connects to PostgreSQL with the following default settings:

- **URL**: `jdbc:postgresql://localhost:5433/demo`
- **Username**: `postgres`
- **Password**: (empty - update in application.properties)
- **Database**: `demo`

### Database Schema

The `flights` table contains:
- `id` (Long) - Primary key, auto-generated
- `source` (String) - Departure location (required)
- `destination` (String) - Arrival location (required)
- `departure_date` (Date) - Date of departure (required)
- `departure_time` (Time) - Time of departure (required)

## API Endpoints

### Base URL: `/flights`

| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| GET | `/flights` | Get all flights | - |
| GET | `/flights/{id}` | Get flight by ID | - |
| POST | `/flights` | Create new flight | Flight JSON |
| PUT | `/flights/{id}` | Update flight | Flight JSON |
| DELETE | `/flights/{id}` | Delete flight | - |

### Sample Request/Response

**POST /flights** - Create Flight
```json
{
  "source": "New York",
  "destination": "Los Angeles",
  "departureDate": "2024-12-25",
  "departureTime": "14:30:00"
}
```

**Response** (201 Created)
```json
{
  "id": 1,
  "source": "New York",
  "destination": "Los Angeles",
  "departureDate": "2024-12-25",
  "departureTime": "14:30:00"
}
```

## Prerequisites

- Java 17 or higher
- Maven 3.6+
- PostgreSQL 12+
- PostgreSQL database named `demo` running on port 5433

## Setup Instructions

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd JPADemo
   ```

2. **Configure Database**
   - Ensure PostgreSQL is running on port 5433
   - Create a database named `demo`
   - Update `src/main/resources/application.properties` with your database credentials:
     ```properties
     spring.datasource.password=<your-password>
     ```

3. **Build the project**
   ```bash
   mvn clean install
   ```

4. **Run the application**
   ```bash
   mvn spring-boot:run
   ```
   
   Or using the Maven wrapper:
   ```bash
   ./mvnw spring-boot:run    # Linux/Mac
   mvnw.cmd spring-boot:run  # Windows
   ```

5. **Access the API**
   - The application runs on `http://localhost:8080`
   - Test endpoints using tools like Postman, cURL, or any REST client

## Configuration

Key configurations in `application.properties`:

```properties
# Application name
spring.application.name=JPADemo

# Database connection
spring.datasource.url=jdbc:postgresql://localhost:5433/demo
spring.datasource.username=postgres
spring.datasource.password=

# JPA/Hibernate settings
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

## Development Features

- **Auto-reload**: Spring Boot DevTools enabled for automatic restart during development
- **SQL Logging**: SQL queries are logged to console for debugging
- **Schema Auto-update**: Database schema automatically updates based on entity changes

## Testing

Run tests using:
```bash
mvn test
```

## Architecture

The application follows a layered architecture:

1. **Controller Layer**: Handles HTTP requests and responses
2. **Service Layer**: Contains business logic
3. **Repository Layer**: Manages database operations using Spring Data JPA
4. **Model Layer**: Defines entity classes mapped to database tables

## License

This project is for educational/demonstration purposes.
