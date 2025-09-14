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

### 2. Run PostgreSQL with Docker
The database is managed via **Docker Compose**.  
All configuration values are stored in the `.env` file at the project root.

Start the container:
```bash
docker-compose up -d
```

---

## ▶️ Run the application

```bash
./gradlew bootRun
```

Or using IntelliJ, just run the `BrazilbankApplication` class.

---

## 📌 Example Endpoints

### Create a customer
```http
POST /customers
Content-Type: application/json

{
  "name": "Anderson de Souza",
  "email": "anderson17ads@hotmail.com",
  "document": "123456",
  "phone": "11994048640",
  "birth_date": "1988-11-22"
}
```
### List all customers
```http
GET /customers
Content-Type: application/json
```
**Response Example**
```json
[
  {
    "id": "550e8400-e29b-41d4-a716-446655440000",
    "name": "Anderson de Souza",
    "email": "anderson17ads@hotmail.com",
    "document": "123456",
    "phone": "11994048640",
    "birth_date": "1988-11-22"
  },
  {
    "id": "660e8400-e29b-41d4-a716-446655440111",
    "name": "Maria Silva",
    "email": "maria.silva@example.com",
    "document": "654321",
    "phone": "11987654321",
    "birth_date": "1990-05-15"
  }
]
```
### Create an account
```http
POST /accounts
Content-Type: application/json

{
  "balance": 500.00,
  "customer_id": "550e8400-e29b-41d4-a716-446655440000",
  "type": "CHECKING"
}
```
### List all accounts
```http
GET /accounts
Content-Type: application/json
```
**Response Example**
```json
[
  {
    "id": "1475eb2d-2565-41a5-a289-2f03d2f6e256",
    "number": "3332ba32-a",
    "balance": 20.00,
    "customerId": "c28ecd31-189f-4b51-ab55-eadf7c85e1d8",
    "type": "CHECKING"
  },
  {
    "id": "ac59e405-b53d-418e-ae0b-fb7a6102055f",
    "number": "d3942fd2-1",
    "balance": 20.00,
    "customerId": "c28ecd31-189f-4b51-ab55-eadf7c85e1d8",
    "type": "CHECKING"
  }
]
```

---

## 🧑‍💻 Autor
Desenvolvido por **Anderson Souza** – Desenvolvedor Sênior em PHP & Java  
[LinkedIn: Anderson de Souza](https://www.linkedin.com/in/anderson-de-souza-9a6a2339/)
 
