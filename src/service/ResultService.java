package service;

import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Result;

public class ResultService {

        // Add Result
        public void addResult(Result result) {

                String query = "INSERT INTO results(student_name, subject1, subject2, subject3, total, percentage, grade) VALUES (?, ?, ?, ?, ?, ?, ?)";

                try {

                        Connection connection = DBConnection.getConnection();

                        PreparedStatement preparedStatement = connection.prepareStatement(query);

                        preparedStatement.setString(
                                        1,
                                        result.getStudentName());

                        preparedStatement.setDouble(
                                        2,
                                        result.getSubject1());

                        preparedStatement.setDouble(
                                        3,
                                        result.getSubject2());

                        preparedStatement.setDouble(
                                        4,
                                        result.getSubject3());

                        preparedStatement.setDouble(
                                        5,
                                        result.getTotal());

                        preparedStatement.setDouble(
                                        6,
                                        result.getPercentage());

                        preparedStatement.setString(
                                        7,
                                        result.getGrade());

                        int rows = preparedStatement.executeUpdate();

                        if (rows > 0) {

                                System.out.println(
                                                "Result Added Successfully!");
                        }

                } catch (Exception e) {

                        e.printStackTrace();
                }
        }

        // View Results
        public void viewResults() {

                String query = "SELECT * FROM results";

                try {

                        Connection connection = DBConnection.getConnection();
                        PreparedStatement preparedStatement = connection.prepareStatement(query);

                        ResultSet resultSet = preparedStatement.executeQuery();

                        System.out.println("\n========== RESULT LIST ==========");

                        while (resultSet.next()) {

                                System.out.println("Roll No: " +
                                                resultSet.getInt("roll_no"));

                                System.out.println("Student Name: " +
                                                resultSet.getString("student_name"));

                                System.out.println("Subject 1: " +
                                                resultSet.getDouble("subject1"));

                                System.out.println("Subject 2: " +
                                                resultSet.getDouble("subject2"));

                                System.out.println("Subject 3: " +
                                                resultSet.getDouble("subject3"));

                                System.out.println("Total: " +
                                                resultSet.getDouble("total"));

                                System.out.println("Percentage: " +
                                                resultSet.getDouble("percentage"));

                                System.out.println("Grade: " +
                                                resultSet.getString("grade"));

                                System.out.println("-------------------------");
                        }

                } catch (Exception e) {

                        e.printStackTrace();
                }
        }

        // Search Result By Roll No
        public void searchResultByRollNo(int rollNo) {

                String query = "SELECT * FROM results WHERE roll_no = ?";

                try {

                        Connection connection = DBConnection.getConnection();

                        PreparedStatement preparedStatement = connection.prepareStatement(query);

                        preparedStatement.setInt(1, rollNo);

                        ResultSet resultSet = preparedStatement.executeQuery();

                        if (resultSet.next()) {

                                System.out.println("\n========== RESULT DETAILS ==========");

                                System.out.println("Roll No: " +
                                                resultSet.getInt("roll_no"));

                                System.out.println("Student Name: " +
                                                resultSet.getString("student_name"));

                                System.out.println("Subject 1: " +
                                                resultSet.getDouble("subject1"));

                                System.out.println("Subject 2: " +
                                                resultSet.getDouble("subject2"));

                                System.out.println("Subject 3: " +
                                                resultSet.getDouble("subject3"));

                                System.out.println("Total: " +
                                                resultSet.getDouble("total"));

                                System.out.println("Percentage: " +
                                                resultSet.getDouble("percentage"));

                                System.out.println("Grade: " +
                                                resultSet.getString("grade"));

                        } else {

                                System.out.println("Result not found!");
                        }

                } catch (Exception e) {

                        e.printStackTrace();
                }
        }

        // Search Result By Name
        public void searchResultByName(String studentName) {

                String query = "SELECT * FROM results WHERE student_name LIKE ?";

                try {

                        Connection connection = DBConnection.getConnection();

                        PreparedStatement preparedStatement = connection.prepareStatement(query);

                        preparedStatement.setString(
                                        1,
                                        "%" + studentName + "%");

                        ResultSet resultSet = preparedStatement.executeQuery();

                        boolean found = false;

                        while (resultSet.next()) {

                                found = true;

                                System.out.println(
                                                "\n========== RESULT DETAILS ==========");

                                System.out.println(
                                                "Roll No: " +
                                                                resultSet.getInt("roll_no"));

                                System.out.println(
                                                "Student Name: " +
                                                                resultSet.getString("student_name"));

                                System.out.println(
                                                "Percentage: " +
                                                                resultSet.getDouble("percentage"));

                                System.out.println(
                                                "Grade: " +
                                                                resultSet.getString("grade"));
                        }

                        if (!found) {

                                System.out.println(
                                                "Result not found!");
                        }

                } catch (Exception e) {

                        e.printStackTrace();
                }
        }

        // Update Result
        public void updateResult(Result result) {

                String query = "UPDATE results SET student_name=?, subject1=?, subject2=?, subject3=?, total=?, percentage=?, grade=? WHERE roll_no=?";

                try {

                        Connection connection = DBConnection.getConnection();

                        PreparedStatement preparedStatement = connection.prepareStatement(query);

                        preparedStatement.setString(1, result.getStudentName());
                        preparedStatement.setDouble(2, result.getSubject1());
                        preparedStatement.setDouble(3, result.getSubject2());
                        preparedStatement.setDouble(4, result.getSubject3());
                        preparedStatement.setDouble(5, result.getTotal());
                        preparedStatement.setDouble(6, result.getPercentage());
                        preparedStatement.setString(7, result.getGrade());
                        preparedStatement.setInt(8, result.getRollNo());

                        int rows = preparedStatement.executeUpdate();

                        if (rows > 0) {
                                System.out.println("Result updated successfully!");
                        } else {
                                System.out.println("Result not found!");
                        }

                } catch (Exception e) {

                        e.printStackTrace();
                }
        }

        // Delete Result
        public void deleteResult(int rollNo) {

                String query = "DELETE FROM results WHERE roll_no = ?";

                try {

                        Connection connection = DBConnection.getConnection();
                        PreparedStatement preparedStatement = connection.prepareStatement(query);

                        preparedStatement.setInt(1, rollNo);

                        int rows = preparedStatement.executeUpdate();

                        if (rows > 0) {
                                System.out.println("Result deleted successfully!");
                        } else {
                                System.out.println("Result not found!");
                        }

                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

        // Check If Result Exists
        public boolean resultExists(int rollNo) {

                String query = "SELECT * FROM results WHERE roll_no = ?";

                try {

                        Connection connection = DBConnection.getConnection();

                        PreparedStatement preparedStatement = connection.prepareStatement(query);

                        preparedStatement.setInt(1, rollNo);

                        ResultSet resultSet = preparedStatement.executeQuery();

                        return resultSet.next();

                } catch (Exception e) {

                        e.printStackTrace();
                }

                return false;
        }

        // Get Result By Roll No
        public Result getResultByRollNo(int rollNo) {

                String query = "SELECT * FROM results WHERE roll_no = ?";

                try {

                        Connection connection = DBConnection.getConnection();

                        PreparedStatement preparedStatement = connection.prepareStatement(query);

                        preparedStatement.setInt(1, rollNo);

                        ResultSet resultSet = preparedStatement.executeQuery();

                        if (resultSet.next()) {

                                return new Result(
                                                resultSet.getInt("roll_no"),
                                                resultSet.getString("student_name"),
                                                resultSet.getDouble("subject1"),
                                                resultSet.getDouble("subject2"),
                                                resultSet.getDouble("subject3"),
                                                resultSet.getDouble("total"),
                                                resultSet.getDouble("percentage"),
                                                resultSet.getString("grade"));
                        }

                } catch (Exception e) {

                        e.printStackTrace();
                }

                return null;
        }

        // Statistics Dashboard
        public void showStatistics() {

                String query = "SELECT COUNT(*) AS totalResults, " +
                                "AVG(percentage) AS averagePercentage, " +
                                "MAX(percentage) AS highestPercentage, " +
                                "MIN(percentage) AS lowestPercentage " +
                                "FROM results";

                try {

                        Connection connection = DBConnection.getConnection();

                        PreparedStatement preparedStatement = connection.prepareStatement(query);

                        ResultSet resultSet = preparedStatement.executeQuery();

                        if (resultSet.next()) {

                                System.out.println("\n========== STATISTICS ==========");

                                System.out.println(
                                                "Total Results: " +
                                                                resultSet.getInt("totalResults"));

                                System.out.println(
                                                "Average Percentage: " +
                                                                resultSet.getDouble("averagePercentage"));

                                System.out.println(
                                                "Highest Percentage: " +
                                                                resultSet.getDouble("highestPercentage"));

                                System.out.println(
                                                "Lowest Percentage: " +
                                                                resultSet.getDouble("lowestPercentage"));
                        }

                } catch (Exception e) {

                        e.printStackTrace();
                }
        }
}