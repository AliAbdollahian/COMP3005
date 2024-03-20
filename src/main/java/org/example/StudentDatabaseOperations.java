package org.example;
import java.sql.Connection;
import java.sql.SQLException;
/**
 * Interface for performing operations on a student database.
 */
public interface StudentDatabaseOperations {
    /**
     * Retrieves all students from the database.
     *
     * @param connection the database connection
     * @throws SQLException if a database access error occurs
     */
    void getAllStudents(Connection connection) throws SQLException;

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
    void addStudent(Connection connection, String firstName, String lastName, String email, String enrollmentDate) throws SQLException;

    /**
     * Updates the email address of a student in the database.
     *
     * @param connection the database connection
     * @param studentId  the ID of the student whose email is to be updated
     * @param newEmail   the new email address for the student
     * @throws SQLException if a database access error occurs
     */
    void updateStudentEmail(Connection connection, int studentId, String newEmail) throws SQLException;

    /**
     * Deletes a student from the database.
     *
     * @param connection the database connection
     * @param studentId  the ID of the student to be deleted
     * @throws SQLException if a database access error occurs
     */
    void deleteStudent(Connection connection, int studentId) throws SQLException;
}

