# COMP3005
# Student Database Application

This Java application provides functionality to interact with a student database using JDBC (Java Database Connectivity) for PostgreSQL.

## Table of Contents
1. [Introduction](#introduction)
2. [Features](#features)
3. [Prerequisites](#prerequisites)
4. [How to Use](#how-to-use)
5. [Compilation and Execution](#compilation-and-execution)
6. [License](#license)

## Introduction

The Student Database Application allows you to perform basic CRUD (Create, Read, Update, Delete) operations on a PostgreSQL database containing student records. It demonstrates JDBC concepts and usage in Java to interact with a database.

## Features

- Retrieve all students from the database
- Add a new student to the database
- Update the email address of a student
- Delete a student from the database

## Prerequisites

Before running this application, ensure you have the following installed:

- Java Development Kit (JDK)
- PostgreSQL database server
- PostgreSQL JDBC driver

## How to Use

1. Clone this repository to your local machine:

    ```bash
    git clone https://github.com/your_username/student-database-app.git
    ```

2. Make sure your PostgreSQL database server is up and running.

3. Update the database connection details in the `StudentDatabaseApp.java` file:

    - URL: JDBC URL for connecting to your PostgreSQL server.
    - USER: Username for connecting to the database.
    - PASSWORD: Password for connecting to the database.

4. Compile the Java source code:

    ```bash
    javac -cp "path/to/postgresql.jar" org/example/StudentDatabaseApp.java
    ```

5. Run the compiled application:

    ```bash
    java -cp ".:path/to/postgresql.jar" org.example.StudentDatabaseApp
    ```

6. Follow the instructions in the application to perform various database operations.

## Compilation and Execution

- Compilation: Use `javac` to compile the Java source code.
- Execution: Use `java` to run the compiled Java application.

Make sure to include the PostgreSQL JDBC driver JAR file in the classpath during compilation and execution.
