package org.example;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        StudentStack studentStack = new StudentStack();

        // Adding the first 8 students to the stack with valid phone numbers
        studentStack.push(new Student(1, "Alice", "0329912507", "HaNoi", "7.5", "Good"));
        studentStack.push(new Student(2, "Bob", "0974645356", "HaNoi", "8.0", "Very Good"));
        studentStack.push(new Student(3, "Charlie", "0326457356", "HaNoi", "6.5", "Medium"));
        studentStack.push(new Student(4, "Diana", "0943635464", "HaNoi", "9.0", "Excellent"));

        // Displaying all students in the stack
        studentStack.displayStudents();

        // Peeking at the top student
        System.out.println("Top student: " + studentStack.peek());

        // Popping a student from the stack
        System.out.println("Popped: " + studentStack.pop());

        // Displaying remaining students after pop
        studentStack.displayStudents();

        // Adding 4 more students to the stack with valid phone numbers
        studentStack.push(new Student(5, "Edward", "0327363434", "HaNoi", "5.0", "Fall"));
        studentStack.push(new Student(6, "Fiona", "0983635353", "HaNoi", "7.0", "Good"));
        studentStack.push(new Student(7, "George", "0321736353", "HaNoi", "8.5", "Very Good"));

        // Displaying all students after adding more
        studentStack.displayStudents();

        // Popping all students to demonstrate underflow condition
        studentStack.pop();
        studentStack.pop();
        studentStack.pop();
        studentStack.pop();

        // Attempting to display students after popping all
        studentStack.displayStudents();

        // Checking if the stack is empty
        System.out.println("Is stack empty? " + studentStack.isEmpty());

    }
}


