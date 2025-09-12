# 🏋️ Java Practice Exercises – Level 2 Part 2

This repository contains intermediate-level Java exercises designed to practice core concepts like generics, enums, records, concurrency, file I/O, date/time API, JDBC, testing, design patterns, and a final challenge project.

📘 Exercises

### 6. JDBC Exercise
```java
// TODO: Connect to a database (H2, MySQL, or PostgreSQL)

// TODO: Create a table Students(id, name, grade)

// TODO: Insert some records

// TODO: Query all students and print results

// TODO: Use PreparedStatement to query by grade threshold
```
--- 
### 7. Testing Exercise (JUnit & Mockito)
```java
// TODO: Create Calculator class with add, subtract, multiply, divide

// TODO: Write JUnit tests for Calculator

// TODO: Create UserService that depends on UserRepository

// TODO: Use Mockito to mock UserRepository in tests
```
--- 
### 8. Design Pattern Exercise (Factory + Singleton)
```java
// TODO: Create interface Notification with method send(String message)

// TODO: Implement EmailNotification and SMSNotification

// TODO: Create NotificationFactory that returns correct type

// TODO: Implement Singleton Logger class


Test:

public class PatternTest {
    public static void main(String[] args) {
        Notification n = NotificationFactory.create("EMAIL");
        n.send("Hello from factory!");
        
        Logger logger = Logger.getInstance();
        logger.log("This is a log entry.");
    }
}
```
--- 
### 9. Challenge Project: To-Do List Manager

- Bring it all together in a mini-project:
- Store tasks (id, description, dueDate, completed) in a database.
- Provide CRUD methods: addTask, markCompleted, listTasks, deleteTask.
- Use Optional<Task> for lookups.
- Use Streams to filter tasks (e.g., overdue tasks).
- Implement concurrency: auto-save tasks every X seconds.
- Write JUnit tests for the service layer.
- Use design patterns: Factory for different storage backends (File vs DB).
