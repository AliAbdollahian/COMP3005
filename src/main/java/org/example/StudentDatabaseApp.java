package org.example;
import java.sql.*;

public class StudentDatabaseApp implements StudentDatabaseOperations {
    // JDBC URL, username, and password of PostgreSQL server
    private static final String URL = "jdbc:postgresql://localhost:5432/StudentDatabase";
    private static final String USER = "postgres";
    private static final String PASSWORD = "987654Aa@";

    public static void main(String[] args) {
        // Load the PostgreSQL JDBC driver
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            // Print the error if the JDBC driver is not found
            e.printStackTrace();
            return; // Exit the program if the driver is not found
        }

        // Establish connection to the database and perform operations
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Create an instance of the StudentDatabaseApp
            StudentDatabaseApp app = new StudentDatabaseApp();

            // Call methods to perform operations
            System.out.println("---- Current Students ----");
            app.getAllStudents(connection);

            System.out.println("\n---- Adding a New Student ----");
            app.addStudent(connection, "John", "Doe", "john.doe@example.com", "2023-09-01");

            System.out.println("\n---- Updated Students ----");
            app.getAllStudents(connection);

        /* Uncomment and modify as needed for other operations
        System.out.println("\n---- Updating Email ----");
        app.updateStudentEmail(connection, 1, "new.email@example.com");

        System.out.println("\n---- Deleting a Student ----");
        app.deleteStudent(connection, 2);
        */
        } catch (SQLException e) {
            // Print any SQL exceptions that occur during database operations
            e.printStackTrace();
        }
    }


    /**
     * Retrieves all students from the database and prints their details.
     *
     * @param connection the database connection
     * @throws SQLException if a database access error occurs
     */
    @Override
    public void getAllStudents(Connection connection) throws SQLException {
        // Define SQL query to retrieve all students from the database
        String query = "SELECT * FROM students";
        // Create a statement for executing SQL queries
        try (Statement statement = connection.createStatement();
             // Execute the SQL query and obtain the result set
             ResultSet resultSet = statement.executeQuery(query)) {
            // Iterate through the result set
            while (resultSet.next()) {
                // Print details of each student
                System.out.println("Student ID: " + resultSet.getInt("student_id") +
                        ", First Name: " + resultSet.getString("first_name") +
                        ", Last Name: " + resultSet.getString("last_name") +
                        ", Email: " + resultSet.getString("email") +
                        ", Enrollment Date: " + resultSet.getDate("enrollment_date"));
            }
        }
    }

    /**
     * Adds a new student to the database.
     *
     * @param connection     the database connection
     * @param firstName      the first name of the student
     * @param lastName       the last name of the student
     * @param email          the email address of the student
     * @param enrollmentDate the enrollment date of the student (format: "yyyy-MM-dd")
     * @throws SQLException if a database access error occurs
     */
    @Override
    public void addStudent(Connection connection, String firstName, String lastName, String email, String enrollmentDate) throws SQLException {
        // Define SQL query to insert a new student into the database
        String query = "INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES (?, ?, ?, ?)";

        // Create a prepared statement for executing parameterized SQL queries
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            // Set the parameters for the prepared statement
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            preparedStatement.setDate(4, Date.valueOf(enrollmentDate));

            // Execute the SQL update and get the number of rows affected
            int rowsAffected = preparedStatement.executeUpdate();

            // Print the number of rows affected by the SQL update
            System.out.println(rowsAffected + " row(s) affected.");
        }
    }


    /**
     * Updates the email address of a student in the database.
     *
     * @param connection the database connection
     * @param studentId  the ID of the student whose email is to be updated
     * @param newEmail   the new email address for the student
     * @throws SQLException if a database access error occurs
     */
    @Override
    public void updateStudentEmail(Connection connection, int studentId, String newEmail) throws SQLException {
        // Define SQL query to update the email address of a student
        String query = "UPDATE students SET email = ? WHERE student_id = ?";

        // Create a prepared statement for executing parameterized SQL queries
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            // Set the parameters for the prepared statement
            preparedStatement.setString(1, newEmail);
            preparedStatement.setInt(2, studentId);

            // Execute the SQL update and get the number of rows affected
            int rowsAffected = preparedStatement.executeUpdate();

            // Print the number of rows affected by the SQL update
            System.out.println(rowsAffected + " row(s) affected.");
        }
    }


    /**
     * Deletes a student from the database.
     *
     * @param connection the database connection
     * @param studentId  the ID of the student to be deleted
     * @throws SQLException if a database access error occurs
     */
    @Override
    public void deleteStudent(Connection connection, int studentId) throws SQLException {
        // Define SQL query to delete a student from the database
        String query = "DELETE FROM students WHERE student_id = ?";

        // Create a prepared statement for executing parameterized SQL queries
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            // Set the parameter for the prepared statement
            preparedStatement.setInt(1, studentId);

            // Execute the SQL update and get the number of rows affected
            int rowsAffected = preparedStatement.executeUpdate();

            // Print the number of rows affected by the SQL update
            System.out.println(rowsAffected + " row(s) affected.");
        }
    }
}