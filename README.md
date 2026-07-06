# Curadesk

Curadesk is a Spring Boot backend for managing patient records. It uses Spring MVC, Spring Data JPA, MySQL, and Lombok.

## Tech Stack

- Java 17
- Spring Boot 4.0.6
- Maven
- MySQL
- Spring Data JPA
- Lombok

## Project Structure

```text
src/main/java/com/curadesk
+-- controller      # REST controllers
+-- entity          # JPA entities
+-- enums           # Enum values used by entities
+-- exception       # Custom exceptions and global handler
+-- repository      # Spring Data repositories
+-- service         # Business logic
```

## Prerequisites

Install the following before running the application:

- Java 17 or newer
- MySQL Server
- Maven, or use the included Maven wrapper

## Database Setup

Create a MySQL database named `curadesk`:

```sql
CREATE DATABASE curadesk;
```

The application reads database credentials from environment variables:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/curadesk
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
```

Set the variables before starting the app.

PowerShell:

```powershell
$env:DB_USERNAME="your_mysql_username"
$env:DB_PASSWORD="your_mysql_password"
```

Command Prompt:

```bat
set DB_USERNAME=your_mysql_username
set DB_PASSWORD=your_mysql_password
```

The app uses `spring.jpa.hibernate.ddl-auto=update`, so Hibernate will create or update tables automatically based on the JPA entities.

## Run the Application

Using the Maven wrapper on Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

Using Maven directly:

```powershell
mvn spring-boot:run
```

The application starts on the default Spring Boot port:

```text
http://localhost:8080
```

## Test the Application

```powershell
.\mvnw.cmd test
```

## API Endpoints

### Health Check

```http
GET /test
```

Response:

```text
Backend is running
```

### Patients

Create a patient:

```http
POST /api/patients
Content-Type: application/json
```

Example request body:

```json
{
  "firstName": "Aarav",
  "lastName": "Sharma",
  "dateOfBirth": "1995-04-12",
  "gender": "MALE",
  "phoneNumber": "9876543210",
  "email": "aarav@example.com",
  "address": "Bengaluru, India",
  "bloodGroup": "O_POSITIVE",
  "emergencyContact": "9876500000"
}
```

Get all patients:

```http
GET /api/patients
```

Get a patient by ID:

```http
GET /api/patients/{id}
```

If a patient is not found, the API returns `404 Not Found`.

## Enum Values

Allowed `gender` values:

```text
MALE
FEMALE
OTHER
```

Allowed `bloodGroup` values:

```text
A_POSITIVE
A_NEGATIVE
B_POSITIVE
B_NEGATIVE
AB_POSITIVE
AB_NEGATIVE
O_POSITIVE
O_NEGATIVE
```

## Configuration

Main configuration file:

```text
src/main/resources/application.properties
```

Current settings include:

- Application name: `curadesk`
- MySQL database URL: `jdbc:mysql://localhost:3306/curadesk`
- JPA schema update mode: `update`
- SQL logging enabled
- Hibernate SQL formatting enabled
