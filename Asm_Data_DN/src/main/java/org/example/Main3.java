package org.example;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        StudentManagement studentManagement = new StudentManagement();

        System.out.print("Enter the number of students to generate: ");
        int numStudents = readInteger(scanner); // Prompt user to input the number of students

        // Generate random students with increasing ID
        for (int i = 0; i < numStudents; i++) {
            String name = "Student" + i;
            String contactNumber = "ContactNumber" + (1000 + rand.nextInt(9000));
            String address = "Address " + (rand.nextInt(100) + 1);
            double marks = rand.nextDouble() * 100;
            String rank = "";
            // Create a new student with increasing ID
            Student student = new Student(i, name, contactNumber, address, marks, rank);
            // Set rank based on marks (this method should be defined in Student class)
            student.setRank();
            // Add student to the management system
            studentManagement.addStudent(student);
        }

        // You can now test student management, for example:
        studentManagement.displayAllStudents();

        // Menu chính
        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Display all students");
            System.out.println("2. Add a new student");
            System.out.println("3. Update a student");
            System.out.println("4. Delete a student");
            System.out.println("5. Quicksort");
            System.out.println("6. Bubble sort");
            System.out.println("7. Search student by ID");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    studentManagement.displayAllStudents();
                    break;
                case 2:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Contact Number: ");
                    String contactNumber = scanner.nextLine();
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = readDouble(scanner);
                    System.out.print("Enter Rank: ");
                    String rank = scanner.nextLine();
                    studentManagement.addStudent(new Student(id, name, contactNumber, address, marks, rank));
                    break;
                case 3:
                    System.out.print("Enter Student ID to update: ");
                    int updateId = readInteger(scanner);
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter new Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new Contact Number: ");
                    String newContactNumber = scanner.nextLine();
                    System.out.print("Enter new Address: ");
                    String newAddress = scanner.nextLine();
                    System.out.print("Enter new Marks: ");
                    double newMarks = readDouble(scanner);
                    System.out.print("Enter new Rank: ");
                    String newRank = scanner.nextLine();
                    studentManagement.updateStudent(updateId, newName, newContactNumber, newAddress, newMarks, newRank);
                    break;
                case 4:
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    studentManagement.deleteStudent(deleteId);
                    break;
                case 5:
                    studentManagement.quickSort();
                    break;
                case 6:
                    studentManagement.bubbleSort();
                    break;
                case 7:
                    System.out.print("Enter Student ID to search: ");
                    int searchId = readInteger(scanner);
                    studentManagement.searchStudentById(searchId);
                    break;
                case 8:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Helper method to safely read an integer from the user input
    private static int readInteger(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter an integer: ");
                scanner.next(); // Consume the invalid input
            }
        }
    }

    // Helper method to safely read a double from the user input
    private static double readDouble(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a valid number for marks: ");
                scanner.next(); // Consume the invalid input
            }
        }
    }
}
