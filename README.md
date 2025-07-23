# Recap-Project-4-Java-TODO-Backend

## 🚀 Project Description

This project is the backend implementation of a Kanban-style ToDo application, developed with Spring Boot. The frontend was provided as part of the assignment and integrated into the project.\
The goal is to practice RESTful API development, CRUD operations, and advanced backend topics such as Undo/Redo and Monitoring.

---

## 🏗️ Setup & Running

1. **Java 17+ is required**
2. **Clone the repository:**
   ```bash
   git clone <repo-url>
   ```
3. **Frontend files are already included. No additional setup required.**
4. **Start the backend:**
   ```bash
   ./mvnw spring-boot:run
   ```
   or
   ```bash
   ./gradlew bootRun
   ```
5. **The application UI:**\
   [http://localhost:8080](http://localhost:8080)

---

## 🛠️ Technologies Used

- Java 17
- Spring Boot
- Spring Data (MongoDB or another database)
- Lombok
- JavaMelody (Monitoring)
- (Optional) JUnit, Mockito (for tests)

---

## 📚 API Endpoints

| Method | Endpoint         | Description                    |
| ------ | ---------------- | ------------------------------ |
| GET    | `/api/todo`      | Returns all todos              |
| POST   | `/api/todo`      | Adds a new todo                |
| GET    | `/api/todo/{id}` | Returns a todo by id           |
| PUT    | `/api/todo/{id}` | Updates a todo by id           |
| DELETE | `/api/todo/{id}` | Deletes a todo by id           |


---

## 🧪 Testing

- Integration and unit tests with JUnit and Mockito
- Bonus: Integration tests for the undo/redo endpoints

---

## 📈 Monitoring

- JavaMelody is integrated for backend monitoring.
- After starting the application, visit [http://localhost:8080/monitoring](http://localhost:8080/monitoring) for live metrics.

---

## 👤 Author

- Name: Emrullah Arac
- Date: 23.07.2025
- Bootcamp: Java Development (neuefische GmbH)

---

# Recap-Project-4-Java-TODO-Backend

## 🚀 Projektbeschreibung

Dieses Projekt ist die Backend-Implementierung einer Kanban-ähnlichen ToDo-Anwendung, entwickelt mit Spring Boot. Das Frontend wurde im Rahmen der Aufgabe bereitgestellt und in das Projekt integriert.\
Ziel ist es, RESTful API-Entwicklung, CRUD-Operationen sowie fortgeschrittene Backend-Themen wie Undo/Redo und Monitoring zu üben.

---

## 🏗️ Einrichtung & Ausführung

1. **Java 17+ wird benötigt**
2. **Repository klonen:**
   ```bash
   git clone <repo-url>
   ```
3. **Frontend-Dateien sind bereits enthalten. Keine zusätzliche Einrichtung notwendig.**
4. **Backend starten:**
   ```bash
   ./mvnw spring-boot:run
   ```
   oder
   ```bash
   ./gradlew bootRun
   ```
5. **Die Anwendungsoberfläche:**\
   [http://localhost:8080](http://localhost:8080)

---

## 🛠️ Verwendete Technologien

- Java 17
- Spring Boot
- Spring Data (MongoDB oder andere Datenbank)
- Lombok
- JavaMelody (Monitoring)
- (Optional) JUnit, Mockito (für Tests)

---

## 📚 API-Endpunkte

| Methode | Endpoint         | Beschreibung                                                |
| ------- | ---------------- | ----------------------------------------------------------- |
| GET     | `/api/todo`      | Gibt alle Todos zurück                                      |
| POST    | `/api/todo`      | Fügt ein neues Todo hinzu                                   |
| GET     | `/api/todo/{id}` | Gibt ein Todo nach ID zurück                                |
| PUT     | `/api/todo/{id}` | Aktualisiert ein Todo nach ID                               |
| DELETE  | `/api/todo/{id}` | Löscht ein Todo nach ID                                     |


---

## 🧪 Tests

- Integrations- und Unit-Tests mit JUnit und Mockito
- Bonus: Integrationstests für Undo/Redo-Endpunkte

---

## 📈 Monitoring

- JavaMelody ist für das Backend-Monitoring integriert.
- Nach dem Start der Anwendung können Live-Metriken unter [http://localhost:8080/monitoring](http://localhost:8080/monitoring) eingesehen werden.

---

## 👤 Autor

- Name: Emrullah Arac
- Datum: 23.07.2025
- Bootcamp: Java Development (neuefische GmbH)

