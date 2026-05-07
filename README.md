# Gym Membership Management System

## How to Build and Run
1. **Prerequisites:** Java 17+ and Maven installed
2. **Build:** Run `mvn clean install` in the terminal
3. **Run:** Run `mvn spring-boot:run` or start the `GymmembershipApplication` class
4. **Database:** The application uses an H2 In-Memory database
    - Console URL: `http://localhost:8080/h2-console`
    - JDBC URL: `jdbc:h2:mem:gym`

## REST API Services & Sample Queries

### 1. Gyms
- **Create Gym:** `POST /api/gyms`
    - Body: `{"name": "Power House", "address": "Gdańsk", "phoneNumber": "123456789"}`
- **List Gyms:** `GET /api/gyms`

### 2. Memberships
- **Create Plan:** `POST /api/gyms/{gymId}/memberships`
    - Body: `{"name": "Gold", "amount": 99.99, "currency": "PLN", "durationMonths": 1, "maxMembers": 1}`
- **Cancel All for Plan:** `PATCH /api/gyms/{gymId}/memberships/{id}/cancel`

### 3. Members
- **Register Member:** `POST /api/members/plan/{planId}`
    - Body: `{"name": "Anna Smith", "email": "anna@example.com"}`
- **List All Members:** `GET /api/members` 

### 4. Report
- **Revenue Report:** `GET /api/gyms/report`
    - Displays total monthly revenue per gym grouped by currency
