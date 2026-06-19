package main;

import java.util.Scanner;
import model.Result;
import service.ResultService;
import util.GradeCalculator;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ResultService service = new ResultService();

        int choice;

        do {

            System.out.println("\n========== SCHOOL RESULT MANAGEMENT ==========");
            System.out.println("1. Add Result");
            System.out.println("2. View Results");
            System.out.println("3. Search Result By Roll No");
            System.out.println("4. Search Result By Name");
            System.out.println("5. Update Result");
            System.out.println("6. Delete Result");
            System.out.println("7. Statistics");
            System.out.println("8. Exit");
            System.out.print("Enter Choice: ");

            try {

                choice = scanner.nextInt();
                scanner.nextLine();

            } catch (Exception e) {

                System.out.println("Invalid input! Enter numbers only.");
                scanner.nextLine();
                choice = 0;
                continue;
            }

            switch (choice) {

                case 1:

                    String studentName;

                    while (true) {

                        System.out.print("Enter Student Name: ");
                        studentName = scanner.nextLine();

                        if (studentName.matches("[a-zA-Z ]+")) {
                            break;
                        } else {
                            System.out.println("Invalid name! Only alphabets allowed.");
                        }
                    }

                    double subject1;

                    while (true) {

                        try {

                            System.out.print("Enter Subject 1 Marks: ");
                            subject1 = scanner.nextDouble();

                            if (subject1 >= 0 && subject1 <= 100) {
                                break;
                            } else {
                                System.out.println("Marks should be between 0 and 100.");
                            }

                        } catch (Exception e) {

                            System.out.println("Invalid input!");
                            scanner.nextLine();
                        }
                    }

                    double subject2;

                    while (true) {

                        try {

                            System.out.print("Enter Subject 2 Marks: ");
                            subject2 = scanner.nextDouble();

                            if (subject2 >= 0 && subject2 <= 100) {
                                break;
                            } else {
                                System.out.println("Marks should be between 0 and 100.");
                            }

                        } catch (Exception e) {

                            System.out.println("Invalid input!");
                            scanner.nextLine();
                        }
                    }

                    double subject3;

                    while (true) {

                        try {

                            System.out.print("Enter Subject 3 Marks: ");
                            subject3 = scanner.nextDouble();

                            if (subject3 >= 0 && subject3 <= 100) {
                                break;
                            } else {
                                System.out.println("Marks should be between 0 and 100.");
                            }

                        } catch (Exception e) {

                            System.out.println("Invalid input!");
                            scanner.nextLine();
                        }
                    }

                    scanner.nextLine();

                    double total = subject1 + subject2 + subject3;
                    double percentage = total / 3;

                    String grade = GradeCalculator.calculateGrade(percentage);

                    Result result = new Result(
                            studentName,
                            subject1,
                            subject2,
                            subject3,
                            total,
                            percentage,
                            grade);

                    service.addResult(result);

                    break;

                case 2:

                    service.viewResults();

                    break;

                case 3:

                    try {

                        System.out.print("Enter Roll No: ");

                        int rollNo = scanner.nextInt();
                        scanner.nextLine();

                        service.searchResultByRollNo(rollNo);

                    } catch (Exception e) {

                        System.out.println("Invalid input!");
                        scanner.nextLine();
                    }

                    break;

                case 4:

                    System.out.print("Enter Student Name: ");
                    String searchName = scanner.nextLine();

                    service.searchResultByName(searchName);

                    break;
                case 5:

                    try {

                        System.out.print("Enter Roll No: ");
                        int rollNo = scanner.nextInt();
                        scanner.nextLine();

                        Result resultToUpdate = service.getResultByRollNo(rollNo);

                        if (resultToUpdate == null) {

                            System.out.println("Result not found!");
                            break;
                        }

                        String answer;

                        System.out.print("Update Student Name? (yes/no): ");
                        answer = scanner.nextLine();

                        if (answer.equalsIgnoreCase("yes")) {

                            System.out.print("Enter New Student Name: ");
                            resultToUpdate.setStudentName(
                                    scanner.nextLine());
                        }

                        System.out.print("Update Subject 1 Marks? (yes/no): ");
                        answer = scanner.nextLine();

                        if (answer.equalsIgnoreCase("yes")) {

                            System.out.print("Enter New Subject 1 Marks: ");
                            resultToUpdate.setSubject1(
                                    scanner.nextDouble());

                            scanner.nextLine();
                        }

                        System.out.print("Update Subject 2 Marks? (yes/no): ");
                        answer = scanner.nextLine();

                        if (answer.equalsIgnoreCase("yes")) {

                            System.out.print("Enter New Subject 2 Marks: ");
                            resultToUpdate.setSubject2(
                                    scanner.nextDouble());

                            scanner.nextLine();
                        }

                        System.out.print("Update Subject 3 Marks? (yes/no): ");
                        answer = scanner.nextLine();

                        if (answer.equalsIgnoreCase("yes")) {

                            System.out.print("Enter New Subject 3 Marks: ");
                            resultToUpdate.setSubject3(
                                    scanner.nextDouble());

                            scanner.nextLine();
                        }

                        double updatedTotal = resultToUpdate.getSubject1()
                                + resultToUpdate.getSubject2()
                                + resultToUpdate.getSubject3();

                        double updatedPercentage = updatedTotal / 3;

                        String updatedGrade = GradeCalculator.calculateGrade(
                                updatedPercentage);

                        resultToUpdate.setTotal(updatedTotal);
                        resultToUpdate.setPercentage(updatedPercentage);
                        resultToUpdate.setGrade(updatedGrade);

                        service.updateResult(resultToUpdate);

                    } catch (Exception e) {

                        System.out.println("Invalid Input!");
                        scanner.nextLine();
                    }

                    break;
                case 6:

                    try {

                        System.out.print("Enter Roll No To Delete: ");

                        int rollNo = scanner.nextInt();
                        scanner.nextLine();

                        service.deleteResult(rollNo);

                    } catch (Exception e) {

                        System.out.println("Invalid input!");
                        scanner.nextLine();
                    }

                    break;

                case 7:

                    service.showStatistics();

                    break;

                case 8:

                    System.out.println("Exiting Program...");

                    break;

                default:

                    System.out.println("Invalid Choice!");
            }

        } while (choice != 8);

        scanner.close();
    }
}