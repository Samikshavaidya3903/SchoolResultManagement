package util;

/*
 * Grade calculator class
 * Used to calculate student grade
 * based on marks
 */

public class GradeCalculator {

    // Method to calculate grade
    public static String calculateGrade(double marks) {

        if (marks >= 90) {
            return "A+";
        } else if (marks >= 75) {
            return "A";
        } else if (marks >= 60) {
            return "B";
        } else if (marks >= 40) {
            return "C";
        } else {
            return "F";
        }
    }
}