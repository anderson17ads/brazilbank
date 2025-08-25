# Brazil Bank

**Brazil Bank** is a banking application built with **Java 8** and **Spring Boot**, following the **Hexagonal Architecture (Ports and Adapters)** approach.  
The goal of this project is to provide a clean, maintainable, and scalable design where business rules are completely decoupled from frameworks and external dependencies.

---

## 🚀 Features
- Account domain with business rules separated in services
- REST API built with Spring Boot
- PostgreSQL integration using Spring Data JPA
- Domain-driven approach with `entities`, `value objects`, and `enums`
- Decoupled infrastructure layer for persistence and external adapters
- Lombok to reduce boilerplate code

---

## 🛠 Tech Stack
- **Java 8**
- **Spring Boot 2.7.x**
- **Spring Data JPA**
- **PostgreSQL**
- **Lombok**
- **Gradle**

---

## ⚙️ Setup

### 1. Clone repository
```bash
git clone https://github.com/your-username/brazilbank.git
cd brazilbank
```

### 2. Configure PostgreSQL
Make sure you have PostgreSQL running. Create a database:

```sql
CREATE DATABASE brazilbank;
```

### 3. Configure `application-dev.yml`

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/brazilbank
    username: postgres
    password: postgres
    driver-class-name: org.postgresql.Driver

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
```

---

## ▶️ Run the application

```bash
./gradlew bootRun
```

Or using IntelliJ, just run the `BrazilbankApplication` class.

---

## 📌 Example Endpoints

### Create an account
```http
POST /accounts
Content-Type: application/json

{
  "number": "12345",
  "balance": 500.00,
  "customerId": "550e8400-e29b-41d4-a716-446655440000",
  "type": "CHECKING"
}
```

### Get all accounts
```http
GET /accounts
```

### Get account by ID
```http
GET /accounts/{id}
```

---

## 🧑‍💻 Author
Developed by **Anderson Souza** – Senior PHP & Java Developer  
