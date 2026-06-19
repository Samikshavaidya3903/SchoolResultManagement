package model;

public class Result {

    private int rollNo;
    private String studentName;
    private double subject1;
    private double subject2;
    private double subject3;
    private double total;
    private double percentage;
    private String grade;

    // Default Constructor
    public Result() {

    }

    // Constructor Without Roll Number
    public Result(
            String studentName,
            double subject1,
            double subject2,
            double subject3,
            double total,
            double percentage,
            String grade) {

        this.studentName = studentName;
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
        this.total = total;
        this.percentage = percentage;
        this.grade = grade;
    }

    // Constructor With Roll Number
    public Result(
            int rollNo,
            String studentName,
            double subject1,
            double subject2,
            double subject3,
            double total,
            double percentage,
            String grade) {

        this.rollNo = rollNo;
        this.studentName = studentName;
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
        this.total = total;
        this.percentage = percentage;
        this.grade = grade;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getSubject1() {
        return subject1;
    }

    public void setSubject1(double subject1) {
        this.subject1 = subject1;
    }

    public double getSubject2() {
        return subject2;
    }

    public void setSubject2(double subject2) {
        this.subject2 = subject2;
    }

    public double getSubject3() {
        return subject3;
    }

    public void setSubject3(double subject3) {
        this.subject3 = subject3;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}